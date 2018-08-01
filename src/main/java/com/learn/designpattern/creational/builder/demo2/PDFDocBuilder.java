package com.learn.designpattern.creational.builder.demo2;

//PDFDocBuilder.java
public class PDFDocBuilder extends DocBuilder {
    private PDFDocument pdfDoc;

    public void createDocument() {
        this.pdfDoc = new PDFDocument();
    }

    public void createText() {
        System.out.println("Creating text for PDF Document.");
    }

    public void createImages() {
        System.out.println("Creating images for PDF Document.");
    }

    public Document getDocument() {
        System.out.println("Fetching PDF Document.");
        return this.pdfDoc;
    }
}
