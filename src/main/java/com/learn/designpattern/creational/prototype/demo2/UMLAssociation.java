package com.learn.designpattern.creational.prototype.demo2;

//UMLAssociation.java
public class UMLAssociation implements Prototype {
    private String associationName = "Default Prototype Association Name";

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public String getAssociationName() {
        return this.associationName;
    }

    @Override
    public UMLAssociation clone() throws CloneNotSupportedException {
        System.out.println("Creating clone of UMLAssociation");
        return (UMLAssociation) super.clone();
    }
}