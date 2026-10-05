package vehiculo;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;

    // Constructor 1: valores por defecto.
    public Vehiculo() { this("SIN-PLACA", "Desconocida", "Genérico"); }

    // Constructor 2: básico, solo la placa.
    public Vehiculo(String placa) { this(placa, "Desconocida", "Genérico"); }

    // Constructor 3: completo.
    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    /** @return placa del vehículo */
    public String getPlaca() { return placa; }

    /** @return marca del vehículo */
    public String getMarca() { return marca; }

    /** @return modelo del vehículo */
    public String getModelo() { return modelo; }

    /**
     * Mantenimiento solo por kilometraje (servicio preventivo).
     * @param km kilómetros recorridos
     * @return costo estimado en USD
     */
    public double calcularMantenimiento(double km) {
        return calcularMantenimiento(km, "preventivo");
    }

    /**
     * Mantenimiento por kilometraje y tipo de servicio.
     * @param km kilómetros recorridos
     * @param tipo "preventivo", "correctivo" o "completo"
     * @return costo estimado en USD
     */
    public double calcularMantenimiento(double km, String tipo) {
        // Cuánto multiplica el costo según el tipo de servicio.
        double factor = switch (tipo.toLowerCase()) {
            case "correctivo" -> 1.5;
            case "completo" -> 2.0;
            default -> 1.0;
        };
        return (50 + km * 0.02) * factor;
        // $50 base + $0.02 por km
    }

    /**
     * Mantenimiento por kilometraje, tipo de servicio y repuestos.
     * @param km kilómetros recorridos
     * @param tipo tipo de servicio
     * @param repuestos {@code true} si incluye repuestos (+30%)
     * @return costo estimado en USD
     */
    public double calcularMantenimiento(double km, String tipo, boolean repuestos) {
        return calcularMantenimiento(km, tipo) * (repuestos ? 1.3 : 1.0);
    }

    @Override
    public String toString() { return marca + " " + modelo + " [" + placa + "]"; }
}