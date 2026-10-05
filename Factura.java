package telefonia;

/** Factura mensual: consumo real del cliente frente a su plan. */
public class Factura {

    private final Cliente cliente;
    private final int minutosUsados;
    private final double datosUsados;

    /**
     * Crea una factura.
     * @param cliente       cliente facturado
     * @param minutosUsados minutos consumidos
     * @param datosUsados   GB consumidos
     */
    public Factura(Cliente cliente, int minutosUsados, double datosUsados) {
        this.cliente = cliente;
        this.minutosUsados = minutosUsados;
        this.datosUsados = datosUsados;
    }

    /** @return cargo por minutos y GB que pasaron del plan (0 si no hay exceso) */
    public double calcularExtras() {
        Plan p = cliente.getPlan();
        double minExtra = Math.max(0, minutosUsados - p.getMinutos());
        double gbExtra = Math.max(0, datosUsados - p.getDatosGB());
        return minExtra * p.getTarifaMinuto() + gbExtra * p.getTarifaGB();
    }

    /** @return total a pagar = precio base + extras */
    public double calcularTotal() {
        return cliente.getPlan().getPrecio() + calcularExtras();
    }

    /** Imprime el resumen detallado de la factura. */
    public void generarFactura() {
        Plan p = cliente.getPlan();
        System.out.printf("Cliente: %s (%s)%n", cliente.getNombre(), cliente.getTelefono());
        System.out.printf("Minutos: %d usados / %d incluidos%n", minutosUsados, p.getMinutos());
        System.out.printf("Datos:   %.1f GB usados / %.1f GB incluidos%n", datosUsados, p.getDatosGB());
        System.out.printf("Base: $%.2f | Extras: $%.2f | TOTAL: $%.2f%n",
                p.getPrecio(), calcularExtras(), calcularTotal());
    }
}