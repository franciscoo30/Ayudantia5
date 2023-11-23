package modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();


    public void agregarLibro(Libro libro) {
        if (!libroExiste(libro)) {
            libros.add(libro);
            System.out.println("Libro agregado correctamente.");
        } else {
            System.out.println("El libro ya existe en la biblioteca.");
        }
    }


    public Libro buscarLibro(String nombreLibro) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                return libro;
            }
        }
        return null; // Libro no encontrado
    }


    public List<Libro> obtenerLibroPorAutor(String autor) {
        List<Libro> librosPorAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosPorAutor.add(libro);
            }
        }
        return librosPorAutor;
    }


    private boolean libroExiste(Libro libro) {
        return libros.contains(libro);
    }

    public Prestamo generarPrestamo(Bibliotecario bibliotecario, Usuario usuario, Libro libro, Date fechaInicio, Date fechaTermino) {
        return new Prestamo(bibliotecario, usuario, libro, fechaInicio, fechaTermino);
    }
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
