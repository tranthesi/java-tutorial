package com.learn.designpattern.creational.builder.demo2;

//DocCreationEngine.java
public class DocCreationEngine {
    public void generateDocument(DocBuilder builder) {
        builder.createDocument();
        builder.createText();
        builder.createImages();
    }
}
