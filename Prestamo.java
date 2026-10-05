
package biblioteca;

import java.time.LocalDate;

public class Prestamo {
      // Fecha en que se realizó el préstamo
    private final LocalDate fecha;
    //Usuario que recibe el libro
    private final Usuario usuario;
    //Libro prestado. 
    private final Libro libro;
    //Fecha de devolución code null mientras el préstamo siga activo.
    private LocalDate fechaDevolucion;

    
    public Prestamo(Usuario usuario, Libro libro) {
        this.fecha = LocalDate.now();
        this.usuario = usuario;
        this.libro = libro;
    }

    //return fecha del préstamo 
    public LocalDate getFecha() { return fecha; }

    // return usuario asociado 
    public Usuario getUsuario() { return usuario; }

    // return libro asociado 
    public Libro getLibro() { return libro; }

    // return @code true si el libro aún no ha sido devuelto 
    public boolean estaActivo() { return fechaDevolucion == null; }

    //egistra la devolución con la fecha actual. 
    public void registrarDevolucion() { this.fechaDevolucion = LocalDate.now(); }

    @Override
    public String toString() {
        return fecha + " | " + usuario.getNombre() + " -> " + libro.getTitulo()
                + (estaActivo() ? " (activo)" : " (devuelto " + fechaDevolucion + ")");
    }
}
