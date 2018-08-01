package com.learn.designpattern.creational.builder.demo2;

//Client.java
public class Client {
    public static void main(String args[]) {
        DocCreationEngine engine = new DocCreationEngine();
        //Creating PDF Document
        PDFDocBuilder pdfDocBuilder = new PDFDocBuilder();
        engine.generateDocument(pdfDocBuilder);
        PDFDocument pdfDocument = (PDFDocument) pdfDocBuilder.getDocument();
        //Creating XML Document
        XMLDocBuilder xmlDocBuilder = new XMLDocBuilder();
        engine.generateDocument(xmlDocBuilder);
        XMLDocument xmlDocument = (XMLDocument) xmlDocBuilder.getDocument();
    }
}
