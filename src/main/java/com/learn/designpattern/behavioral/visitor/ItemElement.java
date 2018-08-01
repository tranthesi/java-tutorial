package com.learn.designpattern.behavioral.visitor;

public interface ItemElement {

    public int accept(ShoppingCartVisitor visitor);
}
