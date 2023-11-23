package modelo;
import java.util.Date;

public class Prestamo {
    private Bibliotecario bibliotecario;
    private Usuario usuario;
    private Libro libro;
    private Date fechaInicio;
    private Date fechaTermino;

    public Prestamo(Bibliotecario bibliotecario, Usuario usuario, Libro libro, Date fechaInicio, Date fechaTermino) {
        this.bibliotecario = bibliotecario;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
}
