package com.cognizant.designpatterns.factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {

    @Test
    public void testWordDocumentCreation() {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc, "Document should not be null");
        assertTrue(doc instanceof WordDocument, "Document should be an instance of WordDocument");
        doc.open();
        doc.close();
    }

    @Test
    public void testPdfDocumentCreation() {
        DocumentFactory factory = new PdfDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc, "Document should not be null");
        assertTrue(doc instanceof PdfDocument, "Document should be an instance of PdfDocument");
        doc.open();
        doc.close();
    }

    @Test
    public void testExcelDocumentCreation() {
        DocumentFactory factory = new ExcelDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull(doc, "Document should not be null");
        assertTrue(doc instanceof ExcelDocument, "Document should be an instance of ExcelDocument");
        doc.open();
        doc.close();
    }
}
