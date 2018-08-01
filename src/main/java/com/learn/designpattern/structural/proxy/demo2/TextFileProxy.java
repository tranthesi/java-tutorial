package com.learn.designpattern.structural.proxy.demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextFileProxy extends TextFile {
    private String fileNameWithPath;
    RealTextFile realTextFile = null;

    public TextFileProxy(String fileNameWithPath) {
        this.fileNameWithPath = fileNameWithPath;
    }

    public String getNameWithPath() {
        return this.fileNameWithPath;
    }

    public FileInputStream getFileContents() throws FileNotFoundException {
        this.realTextFile = new RealTextFile(this.fileNameWithPath);
        return realTextFile.getFileContents();
    }
}
