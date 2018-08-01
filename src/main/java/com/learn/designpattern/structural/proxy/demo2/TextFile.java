package com.learn.designpattern.structural.proxy.demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
public abstract class TextFile{
    public abstract String getNameWithPath();
    public abstract FileInputStream getFileContents() throws java.io.FileNotFoundException;
    public static TextFile getTextFileInstance(String fileNameWithPath){
        return new TextFileProxy(fileNameWithPath);
    }
}
