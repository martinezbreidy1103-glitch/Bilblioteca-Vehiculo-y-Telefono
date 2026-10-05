package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a una persona que usa la biblioteca y guarda sus libros prestados.
 */
public class Usuario {

    /** Límite de libros que una persona puede tener prestados a la vez. */
    private static final int MAX_PRESTAMOS = 3;

    /** Nombre de la persona. */
    private String nombre;

    /** Código único del usuario (no se puede cambiar). */
    private final String id;

    /** Libros que el usuario tiene ahora mismo. */
    private final List<Libro> librosPrestados;

    /** Registro de todos sus préstamos (activos y devueltos). */
    private final List<Prestamo> historial;

    /**
     * Crea un usuario nuevo sin libros ni historial.
     *
     * @param nombre nombre completo
     * @param id     código único del usuario
     */
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    /** @return nombre del usuario */
    public String getNombre() { return nombre; }

    /** @return ID del usuario */
    public String getId() { return id; }

    /** @return copia de la lista de libros prestados (así nadie la modifica desde fuera) */
    public List<Libro> getLibrosPrestados() { return new ArrayList<>(librosPrestados); }

    /** @return copia del historial de préstamos */
    public List<Prestamo> getHistorial() { return new ArrayList<>(historial); }

    /**
     * Presta un libro al usuario si está disponible y no superó el límite.
     *
     * @param libro libro que se quiere prestar
     * @return el {@link Prestamo} creado, o {@code null} si no se pudo
     */
    public Prestamo prestarLibro(Libro libro) {
        // Si el libro ya está prestado, no se puede dar.
        if (!libro.consultarDisponibilidad()) {
            System.out.println("No disponible: " + libro.getTitulo());
            return null;
        }
        // Si el usuario ya tiene 3 libros, no puede llevar más.
        if (librosPrestados.size() >= MAX_PRESTAMOS) {
            System.out.println(nombre + " alcanzó el límite de " + MAX_PRESTAMOS + " libros.");
            return null;
        }
        // El libro pasa a "prestado" y se guarda en la lista del usuario.
        libro.marcarPrestado();
        librosPrestados.add(libro);
        // Se crea el registro del préstamo y se agrega al historial.
        Prestamo prestamo = new Prestamo(this, libro);
        historial.add(prestamo);
        return prestamo;
    }

    /**
     * Devuelve a la biblioteca un libro que el usuario tenía prestado.
     *
     * @param libro libro que se devuelve
     * @return {@code true} si se devolvió, {@code false} si el usuario no lo tenía
     */
    public boolean devolverLibro(Libro libro) {
        // Si el usuario no tiene ese libro, no hay nada que devolver.
        if (!librosPrestados.remove(libro)) {
            System.out.println(nombre + " no tiene prestado: " + libro.getTitulo());
            return false;
        }
        // El libro vuelve a estar disponible para otros usuarios.
        libro.marcarDisponible();
        // Se busca el préstamo activo de ese libro y se marca como devuelto.
        for (Prestamo p : historial) {
            if (p.getLibro() == libro && p.estaActivo()) {
                p.registrarDevolucion();
                break; // ya lo encontramos, no hace falta seguir buscando
            }
        }
        return true;
    }
}