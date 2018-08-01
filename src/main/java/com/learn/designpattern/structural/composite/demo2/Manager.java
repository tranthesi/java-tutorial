package com.learn.designpattern.structural.composite.demo2;

public class Manager extends Employee {
    public void printName() {
        //prints own name
        System.out.println("Manager\n-------------");
        super.printName();
        //prints all reportees names
        System.out.println("Reportees\n-------------");
        reportees.forEach(employee -> employee.printName());
    }
}
