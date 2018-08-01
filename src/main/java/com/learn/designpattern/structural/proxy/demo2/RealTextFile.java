package com.learn.designpattern.structural.proxy.demo2;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class RealTextFile extends TextFile {
    private String fileNameWithPath;

    public RealTextFile(String fileNameWithPath) {
        this.fileNameWithPath = fileNameWithPath;
    }

    public String getNameWithPath() {
        return this.fileNameWithPath;
    }

    public FileInputStream getFileContents() throws FileNotFoundException {
        File file = new File(this.fileNameWithPath);
        return new FileInputStream(file);
    }
}
