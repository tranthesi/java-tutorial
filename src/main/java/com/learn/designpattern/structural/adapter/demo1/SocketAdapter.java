package com.learn.designpattern.structural.adapter.demo1;

public interface SocketAdapter {

    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}