package com.learn.designpattern.creational.prototype.demo2;

//Prototype.java
public interface Prototype extends Cloneable{
    public Prototype clone() throws CloneNotSupportedException;
}
