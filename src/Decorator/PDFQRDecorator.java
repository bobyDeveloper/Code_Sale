/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

import Vista.Venta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ber
 */
public class PDFQRDecorator extends PDFDecorator {

    public PDFQRDecorator(PDFGenerator pdfGenerator) {
        super(pdfGenerator);
    }

    @Override
    public void generarFacturaPDF() {
        //super.generarFacturaPDF();

        String fechaActual = "";
        String nombreArchivoPDFVenta = "";

        try {
            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Venta" + "Id_" + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            // Agregamos la imagen de la tienda
            Image imagen = Image.getInstance("src/img/codesale.png");
            imagen.scaleToFit(150, 150);
            imagen.setAlignment(Element.ALIGN_CENTER);
            doc.add(imagen);

            // Agregamos la información de la tienda
            Font fontTienda = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph parTienda = new Paragraph("Code Sale", fontTienda);
            parTienda.setAlignment(Element.ALIGN_CENTER);
            parTienda.setSpacingBefore(2);
            doc.add(parTienda);
            Paragraph parFecha = new Paragraph("Fecha " + fechaActual, new Font(Font.FontFamily.HELVETICA, 12));
            parFecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(parFecha);
            Paragraph parDireccion = new Paragraph("Universidad Veracruzana", new Font(Font.FontFamily.HELVETICA, 12));
            parDireccion.setAlignment(Element.ALIGN_RIGHT);
            doc.add(parDireccion);
            // Agregamos la información del ticket
            Paragraph parTicket = new Paragraph("TICKET DE VENTA", new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD));
            parTicket.setAlignment(Element.ALIGN_CENTER);
            parTicket.setSpacingBefore(20);
            doc.add(parTicket);
            // Agregamos la tabla de productos
            PdfPTable tablaProductos = new PdfPTable(new float[]{2, 1, 1, 1});
            tablaProductos.getDefaultCell().setBorder(0);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setSpacingBefore(20);
            // Encabezado de la tabla
            PdfPCell celdaCantidad = new PdfPCell(new Phrase("Cantidad", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.CYAN)));
            celdaCantidad.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaCantidad.setBorder(0);
            celdaCantidad.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaProductos.addCell(celdaCantidad);
            PdfPCell celdaDescripcion = new PdfPCell(new Phrase("Descripcion", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.CYAN)));
            celdaDescripcion.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaDescripcion.setBorder(0);
            celdaDescripcion.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaProductos.addCell(celdaDescripcion);
            PdfPCell celdaPrecio = new PdfPCell(new Phrase("Precio Unitario", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.CYAN)));
            celdaPrecio.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaPrecio.setBorder(0);
            celdaPrecio.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaProductos.addCell(celdaPrecio);
            PdfPCell celdaTotal = new PdfPCell(new Phrase("Total", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.CYAN)));
            celdaTotal.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaTotal.setBorder(0);
            celdaTotal.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaProductos.addCell(celdaTotal);

            // Agregamos las filas de productos
            for (int i = 0; i < Venta.jTableVenta.getRowCount(); i++) {
                String producto = Venta.jTableVenta.getValueAt(i, 1).toString();
                String cantidad = Venta.jTableVenta.getValueAt(i, 2).toString();
                String precio = Venta.jTableVenta.getValueAt(i, 3).toString();
                String total = Venta.jTableVenta.getValueAt(i, 4).toString();
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(producto);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);
            }
            // Agregamos la tabla de totales
            PdfPTable tablaTotales = new PdfPTable(new float[]{2, 1});
            tablaTotales.getDefaultCell().setBorder(0);
            tablaTotales.setWidthPercentage(50);
            tablaTotales.setSpacingBefore(20);
            tablaTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);
            // Subtotal
            tablaTotales.addCell(new Phrase("Subtotal", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            tablaTotales.addCell(new Phrase(String.valueOf("$" + Venta.txtSubtotal.getText()), new Font(Font.FontFamily.HELVETICA, 12)));
            // IVA      
            tablaTotales.addCell(new Phrase("IVA ", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            tablaTotales.addCell(new Phrase(String.valueOf("$" + Venta.txtIva.getText()), new Font(Font.FontFamily.HELVETICA, 12)));
            // Total
            PdfPCell celdaTotal2 = new PdfPCell(new Phrase("Total", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            celdaTotal2.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaTotal2.setBorder(0);
            celdaTotal2.setPadding(10);
            tablaTotales.addCell(celdaTotal2);
            PdfPCell celdaTotalValor = new PdfPCell(new Phrase(String.valueOf("$" + Venta.txtTotal.getText()), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            celdaTotalValor.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaTotalValor.setPadding(10);
            celdaTotalValor.setBorder(0);
            tablaTotales.addCell(celdaTotalValor);
            doc.add(tablaProductos);
            doc.add(tablaTotales);
            // Obtener el detalle de la venta
            String detalleVenta = "";
            for (int i = 0; i < Venta.jTableVenta.getRowCount(); i++) {
                String producto = Venta.jTableVenta.getValueAt(i, 1).toString();
                String cantidad = Venta.jTableVenta.getValueAt(i, 2).toString();
                String precio = Venta.jTableVenta.getValueAt(i, 3).toString();
                String total = Venta.jTableVenta.getValueAt(i, 4).toString();
                detalleVenta += producto + " $" + precio + "x" + cantidad + " $" + total + "\n";
            }

            // Mensaje de agradecimiento
            String mensajeAgradecimiento = "Gracias por su compra.";

          // Contenido del codigo QR
            String contenidoCodigoQR = "Detalle de venta:\n" + detalleVenta +
                    "\n\nSubtotal: $" + Venta.txtSubtotal.getText() +
                    "\nIVA: $" + Venta.txtIva.getText() +
                    "\nTotal: $" + Venta.txtTotal.getText() +
                    "\n\n" + mensajeAgradecimiento;

            // Crear el codigo QR
            BarcodeQRCode codigoQR = new BarcodeQRCode(contenidoCodigoQR, 1000, 1000, null);
            Image imagenCodigoQR = codigoQR.getImage();
            imagenCodigoQR.setAlignment(Element.ALIGN_CENTER);
            imagenCodigoQR.scaleAbsolute(150, 150);

            // Agregar el codigo QR a la factura
            doc.add(imagenCodigoQR);
            // Cerramos el documento
            doc.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

}
