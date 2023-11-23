package principal;

import modelo.*;
import utils.GeneradorPDF;
import utils.ManejadorBiblioteca;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        ManejadorBiblioteca manejador = new ManejadorBiblioteca(biblioteca);

        // Cargar datos desde un archivo
        manejador.cargarDatosDesdeArchivo("datos.txt");

        // Agregar libro desde la consola
        manejador.agregarLibroDesdeConsola();

        // Guardar datos en un archivo
        manejador.guardarDatosEnArchivo("datos.txt");

        // Ejemplo de creación de un préstamo
        Bibliotecario bibliotecario = new Bibliotecario("Alexander", "12345678", "Dirección Bibliotecario", 1);
        Usuario usuario = new Usuario("Francisco", "87654321", "123456789");
        Libro libro = new Libro("Harry Potter", "Autor Ejemplo");
        LocalDate fechaInicio = LocalDate.now();
        int diasPrestamo = 14;
        LocalDate fechaTermino = ajustarFechaTermino(fechaInicio, diasPrestamo);

        // Convertir LocalDate a Date
        Date fechaInicioDate = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaTerminoDate = Date.from(fechaTermino.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Prestamo prestamo = biblioteca.generarPrestamo(bibliotecario, usuario, libro, fechaInicioDate, fechaTerminoDate);

        // Generar PDF para el préstamo
        GeneradorPDF.generarPDF(prestamo);
    }

    private static LocalDate ajustarFechaTermino(LocalDate fechaInicio, int dias) {
        return fechaInicio.plusDays(dias);
    }
}

