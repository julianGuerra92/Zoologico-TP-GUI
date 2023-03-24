package com.example.zoologico.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

public class PdfController {

    public static void generatePdf() throws IOException, DocumentException {

        Document document = new Document(PageSize.A4, 50.0f, 50.0f, 50.0f, 50.0f);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("soportes/Prueba.pdf"));

        //Pie de Página
        writer.setPageEvent(new PdfFooter());

        document.open();

        //Encabezado
        Paragraph encabezado = new Paragraph("ZOOOSJUA", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        encabezado.setAlignment(Element.ALIGN_RIGHT);
        Paragraph subEncabezado = new Paragraph("Diversión y encanto a tu servicio", new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL));
        subEncabezado.setAlignment(Element.ALIGN_RIGHT);
        Paragraph subEncabezado1 = new Paragraph("Medellín, Antioquia. Crra5 #56-123", new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL));
        subEncabezado1.setAlignment(Element.ALIGN_RIGHT);
        Paragraph subEncabezado2 = new Paragraph("Contactos:", new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD));
        subEncabezado2.setAlignment(Element.ALIGN_RIGHT);
        Paragraph subEncabezado3 = new Paragraph("3216725142 - 2014587896", new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL));
        subEncabezado3.setAlignment(Element.ALIGN_RIGHT);

        PdfContentByte cb = writer.getDirectContent();
        Image image = Image.getInstance("src/main/resources/com/example/zoologico/images/portada.jpg");
        image.scaleToFit(250.0f, 250.0f);
        image.setAbsolutePosition(10.0f, 687.0f);
        cb.addImage(image);
        document.add(encabezado);
        document.add(subEncabezado);
        document.add(subEncabezado1);
        document.add(subEncabezado2);
        document.add(subEncabezado3);
        document.add(image);

        //Agregar parrafo de bienvenida
        document.add(new Paragraph("\nBienvenidos a todos, agradecemos ampliamente el que nos hallan" +
                " elegido como su lugar de confianza." +
                " Es por esta razon que nos esforzamos en brindarles la mejor experiencia a la hora" +
                " de divertirce y pasar un rato agradable." +
                "A continuación encontrarán información respecto a nuestro hermoso" +
                " y acogedor establecimiento." +
                " Esperamos que lo disfuten y tengan la major de sus experiencias.",
                FontFactory.getFont("arial", 12, Font.NORMAL)));

        //Agregar un titulo para el informe de ventas
        Font fontTitle2 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph title2 = new Paragraph("\nInforme de Ventas", fontTitle2);
        title2.setAlignment(Element.ALIGN_BASELINE);
        document.add(title2);

        //Agregar Intro para Informe de ventas
        document.add(new Paragraph("A continuación podrá observar una descripcion de lo que cada plan ofrece",
                FontFactory.getFont("arial", 12, Font.NORMAL)));

        //Tabla con Informe de ventas

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0F);
        table.setSpacingAfter(10.0F);
        table.setSpacingBefore(10.0F);
        PdfPCell cell1 = new PdfPCell(new PdfPCell(new Paragraph("Plan")));
        PdfPCell cell2 = new PdfPCell(new PdfPCell(new Paragraph("Valor")));
        PdfPCell cell3 = new PdfPCell(new PdfPCell(new Paragraph("Cantidad")));
        PdfPCell cell4 = new PdfPCell(new PdfPCell(new Paragraph("Valor Total")));
        PdfPCell cell5 = new PdfPCell(new PdfPCell(new Paragraph("Porcentaje Descuento")));
        PdfPCell cell6 = new PdfPCell(new PdfPCell(new Paragraph("Total Descuento")));
        PdfPCell cell7 = new PdfPCell(new PdfPCell(new Paragraph("Total")));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        List<String[]> planes = obtenerPlanes();
        Iterator var7 = planes.iterator();

        while (var7.hasNext()) {
            String[] plan = (String[]) var7.next();
            table.addCell(plan[0]);
            table.addCell(plan[1]);
            table.addCell(plan[2]);
            table.addCell(plan[3]);
            table.addCell(plan[4]);
            table.addCell(plan[5]);
            table.addCell(plan[6]);
        }
        document.add(table);

        Font fontTitle3 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph title3 = new Paragraph("\nVentas Totales", fontTitle3);
        title3.setAlignment(Element.ALIGN_BASELINE);
        document.add(title3);

        //Tabla para totales de las ventas
        PdfPTable tableT = new PdfPTable(2);
        table.setWidthPercentage(100.0F);
        table.setSpacingAfter(10.0F);
        table.setSpacingBefore(10.0F);
        PdfPCell cellT1 = new PdfPCell(new PdfPCell(new Paragraph("Plan")));
        PdfPCell cellT2 = new PdfPCell(new PdfPCell(new Paragraph("Total")));
        table.addCell(cellT1);
        table.addCell(cellT2);
        List<String[]> totales = obtenerTotales();
        for (String[] total : totales) {
            tableT.addCell(total[0]);
            tableT.addCell(total[1]);
        }
        document.add(tableT);
        document.close();

    }

    public static List<String[]> obtenerPlanes() {
        List<String[]> planes = new ArrayList();
        planes.add(new String[]{"Navegando con Caimanes", "3000", "3", "9000", "10%", "900", "8100"});
        planes.add(new String[]{"Navegando con Delfines", "4000", "6", "24000", "15%", "3600", "20400"});
        planes.add(new String[]{"Viajando entre familia de Felinos", "8500", "12", "102000", "21%", "21420", "80580"});
        planes.add(new String[]{"Mundo Acuatico", "2700", "5", "13500", "5%", "675", "12825"});
        planes.add(new String[]{"Lluvia de Reptiles", "7600", "4", "30400", "8%", "2432", "27968"});
        planes.add(new String[]{"Compañero Ideal", "2000", "17", "34000", "10%", "3400", "30600"});
        return planes;
    }

    public static List<String[]> obtenerTotales() {
        List<String[]> totales = new ArrayList<>();
        totales.add(new String[]{"Navegando con Caimanes", "8100"});
        totales.add(new String[]{"Navegando con Delfines", "20400"});
        totales.add(new String[]{"Viajando entre familia de Felinos", "80580"});
        totales.add(new String[]{"Mundo Acuatico", "12825"});
        totales.add(new String[]{"Lluvia de Reptiles", "27968"});
        totales.add(new String[]{"compañero Ideal", "30600"});
        totales.add(new String[]{"TOTAL:", "180473"});
        return totales;
    }

}
