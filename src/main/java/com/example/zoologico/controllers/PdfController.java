package com.example.zoologico.controllers;

import com.example.zoologico.Zoologico;
import com.example.zoologico.models.*;
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

public class PdfController {

    public static void generatePdf() throws IOException, DocumentException {

        Document document = new Document(PageSize.A4, 50.0f, 50.0f, 50.0f, 50.0f);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("soportes/Prueba.pdf"));

        //Pie de Página y Encabezado
        writer.setPageEvent(new PdfFooter());
        writer.setPageEvent(new PdfHeader());

        document.open();

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
        document.add(new Paragraph("En la siguiente tabla se puede encontrar el informe de ventas del Zoológico",
                FontFactory.getFont("arial", 12, Font.NORMAL)));
        document.add(new Paragraph("\n"));

        //Tabla con Informe de ventas
        PdfPTable tableIV = new PdfPTable(3);
        tableIV.setWidthPercentage(100.0f);
        tableIV.setSpacingAfter(10.0f);
        tableIV.setSpacingBefore(10.0f);
        tableIV.addCell(new PdfPCell(new Phrase("Plan", FontFactory.getFont("arial", 12, Font.BOLD))));
        tableIV.addCell(new PdfPCell(new Phrase("Valor", FontFactory.getFont("arial", 12, Font.BOLD))));
        tableIV.addCell(new PdfPCell(new Phrase("Cantidad", FontFactory.getFont("arial", 12, Font.BOLD))));

        for (SalesInvoice salesInvoice : Zoologico.invoiceList){
            tableIV.addCell(new PdfPCell(new Phrase(PdfCalculoController.class.getName())));
            tableIV.addCell(new PdfPCell(Phrase.getInstance(String.valueOf(salesInvoice.getPlan().getPrice()))));
            tableIV.addCell(new PdfPCell(Phrase.getInstance(String.valueOf(salesInvoice.getPlan().getQuantity()))));
        }
        document.add(tableIV);

        //Tabla ventas totales
        Font fontTitleVt = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Paragraph titleVt = new Paragraph("\nFactura de Venta", fontTitleVt);
        titleVt.setAlignment(Element.ALIGN_BASELINE);
        document.add(titleVt);
        document.add(new Paragraph("En la siguiente tabla se muestra de forma mas detallada los totales de las ventas"));
        PdfPTable tableFV = new PdfPTable(6);
        tableFV.setWidthPercentage(100.0f);
        tableFV.setSpacingAfter(10.0f);
        tableFV.setSpacingBefore(10.0f);
        tableFV.addCell(new PdfPCell(new Phrase("Id",FontFactory.getFont("arial",12, Font.BOLD))));
        tableFV.addCell(new PdfPCell(new Phrase("Fecha",FontFactory.getFont("arial",12, Font.BOLD))));
        tableFV.addCell(new PdfPCell(new Phrase("Cliente",FontFactory.getFont("arial",12, Font.BOLD))));
        tableFV.addCell(new PdfPCell(new Phrase("Plan",FontFactory.getFont("arial",12, Font.BOLD))));
        tableFV.addCell(new PdfPCell(new Phrase("Tipo de Cliente",FontFactory.getFont("arial",12, Font.BOLD))));
        tableFV.addCell(new PdfPCell(new Phrase("Cantidad",FontFactory.getFont("arial",12, Font.BOLD))));
        ArrayList<SalesInvoice> invoiceList = Zoologico.invoiceList;
        for (SalesInvoice ventaTtl : invoiceList){
            tableFV.addCell(new PdfPCell(new Phrase(ventaTtl.getId())));
            tableFV.addCell(new PdfPCell(new Phrase(String.valueOf(ventaTtl.getDate()))));
            tableFV.addCell(new PdfPCell(new Phrase(String.valueOf(ventaTtl.getCustomer().getFullName()))));
            tableFV.addCell(new PdfPCell(new Phrase(String.valueOf(ventaTtl.getPlan().getName()))));
            tableFV.addCell(new PdfPCell(new Phrase(String.valueOf(ventaTtl.getCustomer().getCategory()))));
            tableFV.addCell(new PdfPCell(new Phrase(String.valueOf(ventaTtl.getQuantity()))));

        }
        document.add(tableFV);
        //Tabla de adopción de mascotas
        document.add(new Paragraph("Dentro de las actividades adicionales que se realizan en el zoológico está el proceso de adopción.", FontFactory.getFont("arial", 12, Font.NORMAL)));
        document.add(new Paragraph("En la siguiente tabla se puede observar de forma mas detallada los animales domesticos con los " +
                " que cuenta el Zoológico y cuales pueden ser adoptados sin ningun problema por familias con niños", FontFactory.getFont("arial", 12, Font.NORMAL)));
        document.add(new Paragraph("\n\n\n"));

        PdfPTable tableDomesticAni = new PdfPTable(new float[]{2,2,2});
        tableDomesticAni.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont("arial",12, Font.BOLD))));
        tableDomesticAni.addCell(new PdfPCell(new Phrase("Uso domestico", FontFactory.getFont("arial",12, Font.BOLD))));
        tableDomesticAni.addCell(new PdfPCell(new Phrase("Compatibilidad con niños", FontFactory.getFont("arial",12, Font.BOLD))));
        ArrayList<DomesticAnimal> inventoryDomesticAnimal = Zoologico.inventoryDomesticAnimal;
        for (DomesticAnimal animalD : inventoryDomesticAnimal){
            tableDomesticAni.addCell(new PdfPCell(new Phrase(animalD.getCommonName())));
            tableDomesticAni.addCell(new PdfPCell(new Phrase(animalD.getDomesticUso())));
            tableDomesticAni.addCell(new PdfPCell(new Phrase(animalD.isCompatibilityWithChildren() ? "Compatible" : "No compatible")));
        }
        document.add(tableDomesticAni);

        //tabla especifica de mascotas en adopción
        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph("En la siguiente tabla se encuentra información mas detallada de los animales" +
                " que se encuentran en adopción", FontFactory.getFont("arial", 12, Font.NORMAL)));
        document.add(new Paragraph("\n\n"));

        PdfPTable tablePets = new PdfPTable(new float[] { 2, 2, 2 });
        tablePets.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont("arial",12, Font.BOLD))));
        tablePets.addCell(new PdfPCell(new Phrase("Esterilidad", FontFactory.getFont("arial",12, Font.BOLD))));
        tablePets.addCell(new PdfPCell(new Phrase("Disponibilidad", FontFactory.getFont("arial",12, Font.BOLD))));
        ArrayList<AdoptionAnimal> inventoryAdoptionAnimal = Zoologico.inventoryAdoptionAnimal;
        for (AdoptionAnimal animal : inventoryAdoptionAnimal) {
            tablePets.addCell(new PdfPCell(new Phrase(animal.getName())));
            tablePets.addCell(new PdfPCell(new Phrase(animal.isSterilized() ? "Esterilizado" : "No esterilizado")));
            tablePets.addCell(new PdfPCell(new Phrase(animal.isAvailable() ? "Disponible" : "No disponible")));
        }
        document.add(tablePets);

        document.close();
    }
}
