package com.learn.designpattern.structural.proxy.demo2;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String args[]) {
        TextFile textFile = TextFile.getTextFileInstance("C:\\tests\\test1.txt");
        System.out.println("TextFile's name with path is->" + textFile.getNameWithPath());
        //Till here TextFileProxy instance is created with the realTextFile instance in it being null
        try {
            System.out.println("TextFile's content ->" + textFile.getFileContents());
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException exception thrown");
        }
        //At this point an instance of RealTextFile has been created
    }
}