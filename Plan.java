package telefonia;

/** Plan de telefonía: lo que incluye y lo que cobra por exceso. */
public class Plan {

    private int minutos;           // minutos incluidos
    private double datosGB;        // GB incluidos
    private double precio;         // precio mensual base
    private double tarifaMinuto;   // costo por minuto extra
    private double tarifaGB;       // costo por GB extra

    /**
     * Crea un plan.
     * @param minutos      minutos incluidos
     * @param datosGB      GB incluidos
     * @param precio       precio mensual
     * @param tarifaMinuto costo de cada minuto extra
     * @param tarifaGB     costo de cada GB extra
     */
    public Plan(int minutos, double datosGB, double precio, double tarifaMinuto, double tarifaGB) {
        this.minutos = minutos;
        this.datosGB = datosGB;
        this.precio = precio;
        this.tarifaMinuto = tarifaMinuto;
        this.tarifaGB = tarifaGB;
    }

    /** @return minutos incluidos */
    public int getMinutos() { return minutos; }

    /** @return GB incluidos */
    public double getDatosGB() { return datosGB; }

    /** @return precio mensual base */
    public double getPrecio() { return precio; }

    /** @return costo por minuto extra */
    public double getTarifaMinuto() { return tarifaMinuto; }

    /** @return costo por GB extra */
    public double getTarifaGB() { return tarifaGB; }
}