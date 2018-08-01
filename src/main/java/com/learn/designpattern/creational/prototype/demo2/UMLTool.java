package com.learn.designpattern.creational.prototype.demo2;

//UMLTool.java
public class UMLTool {
    public static void main(String args[]) {
        try {
            //Creating a Prototype of UMLClass
            UMLClass umlClass = (UMLClass) new PrototypeFactory().getPrototype("Class");
            System.out.println("Name in umlClass instance:" + umlClass.getClassName());
            //Creating a Prototype of UMLAttribute
            UMLAttribute umlAttrb = (UMLAttribute) new PrototypeFactory().getPrototype("Attribute");
            System.out.println("Name in umlAttrb instance:" + umlAttrb.getAttributeName());
            //Creating a Prototype of UMLAssociation
            UMLAssociation umlAssoc = (UMLAssociation) new PrototypeFactory().getPrototype("Association");
            System.out.println("Name in umlAssoc instance:" + umlAssoc.getAssociationName());
        } catch (CloneNotSupportedException cloningException) {
            System.out.println("error in cloning:");
            cloningException.printStackTrace();
        }
    }
}