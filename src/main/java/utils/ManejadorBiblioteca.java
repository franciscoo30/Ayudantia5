package utils;

import modelo.Biblioteca;
import modelo.Libro;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ManejadorBiblioteca {

    private Biblioteca biblioteca;

    public ManejadorBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cargarDatosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar la línea y agregar libros a la biblioteca
                String[] datosLibro = linea.split(",");
                if (datosLibro.length == 2) {
                    Libro libro = new Libro(datosLibro[0], datosLibro[1]);
                    biblioteca.agregarLibro(libro);
                }
            }
            System.out.println("Datos cargados correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al cargar datos desde el archivo: " + e.getMessage());
        }
    }

    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            List<Libro> libros = biblioteca.getLibros();
            for (Libro libro : libros) {
                bw.write(libro.getNombre() + "," + libro.getAutor());
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos en el archivo: " + e.getMessage());
        }
    }

    public void agregarLibroDesdeConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregar un nuevo libro:");
        System.out.print("Ingrese el nombre del libro: ");
        String nombreLibro = scanner.nextLine();

        System.out.print("Ingrese el nombre del autor: ");
        String autorLibro = scanner.nextLine();

        Libro nuevoLibro = new Libro(nombreLibro, autorLibro);
        biblioteca.agregarLibro(nuevoLibro);

        System.out.println("Libro agregado correctamente a la biblioteca.");
    }
}
