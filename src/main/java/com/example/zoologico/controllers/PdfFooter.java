package com.example.zoologico.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFooter extends PdfPageEventHelper {
    Phrase footerText = new Phrase("Información OODI ");
    Phrase footerText1 = new Phrase("Medellín Antioquia");
    Phrase footerText2 = new Phrase("Correo Electrónico: ZooOsJuaMedAnt@Gmail.com");

    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte pcb = writer.getDirectContent();
        Phrase footerPharse = new Phrase(footerText);
        Phrase footerPharse1 = new Phrase(footerText1);
        Phrase footerPharse2 = new Phrase(footerText2);
        ColumnText.showTextAligned(pcb, Element.ALIGN_CENTER, footerPharse,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
        ColumnText.showTextAligned(pcb, Element.ALIGN_CENTER, footerPharse1,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 20, 0);
        ColumnText.showTextAligned(pcb, Element.ALIGN_CENTER, footerPharse2,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 30, 0);
    }
}
