package utils;

import modelo.Prestamo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneradorPDF {

    public static void generarPDF(Prestamo prestamo) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Detalle del Préstamo");
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            float yPosition = 730; // Ajusta la posición Y
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Bibliotecario: " + prestamo.getBibliotecario().getNombre());
            contentStream.newLine();
            yPosition -= 12; // Ajusta el espacio vertical
            contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Usuario: " + prestamo.getUsuario().getNombre());
            contentStream.newLine();
            yPosition -= 12; // Ajusta el espacio vertical
            contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Libro: " + prestamo.getLibro().getNombre());
            contentStream.newLine();
            yPosition -= 12; // Ajusta el espacio vertical
            contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Fecha Inicio: " + formatDate(prestamo.getFechaInicio()));
            contentStream.newLine();
            yPosition -= 12; // Ajusta el espacio vertical
            contentStream.newLineAtOffset(0, -12);
            contentStream.showText("Fecha Término: " + formatDate(prestamo.getFechaTermino()));

            contentStream.endText();
            contentStream.close();

            // Obtener la hora actual
            Date fechaActual = new Date();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HHmmss");
            String horaActual = formatoHora.format(fechaActual);

            // Crear el nombre del archivo PDF con la hora actual
            String nombreArchivo = "prestamo_" + horaActual + ".pdf";

            document.save(nombreArchivo);
            document.close();

            System.out.println("PDF creado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}





