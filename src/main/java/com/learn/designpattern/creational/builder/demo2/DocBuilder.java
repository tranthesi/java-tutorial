package com.learn.designpattern.creational.builder.demo2;

//Abstract class - DocBuilder.java
public abstract class DocBuilder {
    public abstract void createDocument();

    public abstract void createText();

    public abstract void createImages();

    public abstract Document getDocument();
}
