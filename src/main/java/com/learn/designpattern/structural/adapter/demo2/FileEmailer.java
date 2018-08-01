package com.learn.designpattern.structural.adapter.demo2;

import java.io.File;

public class FileEmailer {
    public String emailAddress;

    public FileEmailer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void emailFile(File file) {
        //Logic for emailing the file goes here
    }
}
