
package biblioteca;


public class Libro {
     //Título del libro. 
    private String titulo;
    // Autor del libro.
    private String autor;
    // Código ISBN (identificador único del libro).
    
    private String isbn;
    /// Indica si el libro está disponible para préstamo.
    private boolean disponible;

    
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    //título del libro 
    public String getTitulo() { return titulo; }

    //autor del libro
    public String getAutor() { return autor; }

    // código ISBN
    public String getIsbn() { return isbn; }

    // Consulta si el libro puede prestarse.
     
     // return code true si está disponible
     
    public boolean consultarDisponibilidad() { return disponible; }

    //Marca el libro como prestado (no disponible)
    public void marcarPrestado() { this.disponible = false; }

    // Marca el libro como devuelto (disponible).
    public void marcarDisponible() { this.disponible = true; }

    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + autor + " (ISBN " + isbn + ") - "
                + (disponible ? "Disponible" : "Prestado");
    }
}

