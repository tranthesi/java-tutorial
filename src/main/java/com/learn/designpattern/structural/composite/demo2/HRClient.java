package com.learn.designpattern.structural.composite.demo2;

import javax.naming.OperationNotSupportedException;
public class HRClient {
    public static void main(String[] args) {
        Developer dev1 = new Developer();
        Developer dev2 = new Developer();
        Developer dev3 = new Developer();
        dev1.setName("tom hardy");
        dev2.setName("dick tracey");
        dev3.setName("harry ford");
        Manager manager = new Manager();
        manager.setName("Mike Mitchel");
        try {
            manager.addReportee(dev1);
            manager.addReportee(dev2);
            manager.addReportee(dev3);
        }catch (OperationNotSupportedException onse) {
            onse.printStackTrace();
        }
        manager.printName();
    }
}
