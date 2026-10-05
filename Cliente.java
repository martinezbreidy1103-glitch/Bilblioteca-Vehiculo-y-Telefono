package telefonia;

/** Cliente de la empresa; tiene un plan contratado. */
public class Cliente {

    private String nombre;
    private String telefono;
    private Plan plan;

    /**
     * Crea un cliente con su plan.
     * @param nombre   nombre completo
     * @param telefono número telefónico
     * @param plan     plan contratado
     */
    public Cliente(String nombre, String telefono, Plan plan) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.plan = plan;
    }

    /** @return nombre del cliente */
    public String getNombre() { return nombre; }

    /** @return número telefónico */
    public String getTelefono() { return telefono; }

    /** @return plan del cliente */
    public Plan getPlan() { return plan; }
}