package com.example.zoologico.controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

public class PdfHeader extends PdfPageEventHelper {
    Phrase headerText = new Phrase("ZOOOSJUA", new Font(Font.FontFamily.HELVETICA,14,Font.BOLD));
    Phrase headerText1 = new Phrase("Diversión y encanto a tu servicio");
    Phrase headerText2 = new Phrase("Contactos: 3125486899 - 3014578965");
    Phrase headerText3 = new Phrase("Dirección: Crra5 #567-129");

    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte pcb = writer.getDirectContent();
        Phrase headerPharse = new Phrase(headerText);
        Phrase headerPharse1 = new Phrase(headerText1);
        Phrase headerPharse2 = new Phrase(headerText2);
        Phrase headerPharse3 = new Phrase(headerText3);
        ColumnText.showTextAligned(pcb, Element.ALIGN_RIGHT, headerPharse,
                (document.right() - document.left()) + document.leftMargin(),
                document.bottom() + 780, 0);
        ColumnText.showTextAligned(pcb, Element.ALIGN_RIGHT, headerPharse1,
                (document.right() - document.left()) + document.leftMargin(),
                document.bottom() + 765, 0);
        ColumnText.showTextAligned(pcb, Element.ALIGN_RIGHT, headerPharse2,
                (document.right() - document.left()) + document.leftMargin(),
                document.bottom() + 750, 0);
        ColumnText.showTextAligned(pcb, Element.ALIGN_RIGHT, headerPharse3,
                (document.right() - document.left()) + document.leftMargin(),
                document.bottom() + 735, 0);

        PdfContentByte cb = writer.getDirectContent();
        Image image = null;
        try {
            image = Image.getInstance("src/main/resources/com/example/zoologico/images/portada.jpg");
        } catch (BadElementException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image.scaleToFit(100.0f, 100.0f);
        image.setAbsolutePosition(10.0f, 780.0f);
        try {
            cb.addImage(image);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
