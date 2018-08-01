package com.learn.designpattern.behavioral.chainofres;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
