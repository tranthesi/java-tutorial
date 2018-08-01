package com.learn.designpattern.structural.adapter.demo2;

import java.io.File;

public class FileCommiter {
    String diskLocation;

    public FileCommiter() {
        //default constructor
    }

    public FileCommiter(String diskLocation) {
        this.diskLocation = diskLocation;
    }

    public void saveFile(File file) {
        //Logic for saving the file at the diskLocation goes here
    }
}
