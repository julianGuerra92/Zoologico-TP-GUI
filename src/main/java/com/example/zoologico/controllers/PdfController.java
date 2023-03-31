package com.example.zoologico.controllers;

import com.example.zoologico.Zoologico;
import com.example.zoologico.models.AdoptionAnimal;
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
        document.add(new Paragraph("A continuación podrá observar una descripcion de lo que cada plan ofrece",
                FontFactory.getFont("arial", 12, Font.NORMAL)));

        //Tabla con Informe de ventas

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0F);
        table.setSpacingAfter(10.0F);
        table.setSpacingBefore(10.0F);
        PdfPCell cell1 = new PdfPCell(new PdfPCell(new Paragraph("Plan", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell2 = new PdfPCell(new PdfPCell(new Paragraph("Valor", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell3 = new PdfPCell(new PdfPCell(new Paragraph("Cantidad", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell4 = new PdfPCell(new PdfPCell(new Paragraph("Valor Total", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell5 = new PdfPCell(new PdfPCell(new Paragraph("Porcentaje Descuento", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell6 = new PdfPCell(new PdfPCell(new Paragraph("Total Descuento", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cell7 = new PdfPCell(new PdfPCell(new Paragraph("Total", FontFactory.getFont("arial", 12, Font.BOLD))));
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
        document.add(new Paragraph("En la siguiente tabla se muestra de forma mas detallada los totales de las ventas",
                FontFactory.getFont("arial", 12, Font.NORMAL)));

        PdfPTable tableT = new PdfPTable(2);
        tableT.setWidthPercentage(100.0f);
        tableT.setSpacingAfter(10.0f);
        tableT.setSpacingBefore(10.0f);
        PdfPCell cellT1 = new PdfPCell(new PdfPCell(new Paragraph("Plan", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cellT2 = new PdfPCell(new PdfPCell(new Paragraph("Total", FontFactory.getFont("arial", 12, Font.BOLD))));
        tableT.addCell(cellT1);
        tableT.addCell(cellT2);
        List<String[]> totales = obtenerTotales();
        Iterator i = totales.iterator();

        while (i.hasNext()){
            String[] total = (String[]) i.next();
            tableT.addCell(total[0]);
            tableT.addCell(total[1]);
        }
        document.add(tableT);

        //Tabla de adopción de mascotas
        document.add(new Paragraph("Dentro de las actividades adicionales que se realizan en el zoológico está el proceso de adopción" +
                " y actualmente contamos con la siguiente cifra", FontFactory.getFont("arial", 12, Font.NORMAL)));

        PdfPTable tableDispoMas = new PdfPTable(3);
        tableDispoMas.setWidthPercentage(100.0f);
        tableDispoMas.setSpacingAfter(10.0f);
        tableDispoMas.setSpacingBefore(10.0f);
        PdfPCell cellDispoMas1 = new PdfPCell(new PdfPCell(new Paragraph("Cantidad de animales en el refugio", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cellDispoMas2 = new PdfPCell(new PdfPCell(new Paragraph("Cantidad de animales disponibles", FontFactory.getFont("arial", 12, Font.BOLD))));
        PdfPCell cellDispoMas3 = new PdfPCell(new PdfPCell(new Paragraph("Cantidad de animales entregados en adopción", FontFactory.getFont("arial", 12, Font.BOLD))));
        tableDispoMas.addCell(cellDispoMas1);
        tableDispoMas.addCell(cellDispoMas2);
        tableDispoMas.addCell(cellDispoMas3);
        List<String[]> dattaAnimal = obtenerDatosAnimAdop();
        Iterator iAnimalDispoAdop = dattaAnimal.iterator();

        while (iAnimalDispoAdop.hasNext()){
            String[] dato = (String[])iAnimalDispoAdop.next();
            tableDispoMas.addCell(dato[0]);
            tableDispoMas.addCell(dato[1]);
            tableDispoMas.addCell(dato[2]);
        }
        document.add(tableDispoMas);

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

    public static List<String[]> obtenerDatosAnimAdop(){
        List<String[]> dattaAnimal = new ArrayList<>();
        dattaAnimal.add(new String[]{"175", "62", "35"});
        return dattaAnimal;
    }

    public static List<String[]> obtenerInfoAnimalesAdop(){
        List<String[]> infoAnimalAdop = new ArrayList<>();
        infoAnimalAdop.add(new String[]{"Perro", "Compañía", "12"});
        infoAnimalAdop.add(new String[]{"Gato", "Compañía", "5"});
        infoAnimalAdop.add(new String[]{"Cerdo", "Carne, cría", "23"});
        infoAnimalAdop.add(new String[]{"Vaca", "Leche, carne", "4"});
        return infoAnimalAdop;
    }

}
