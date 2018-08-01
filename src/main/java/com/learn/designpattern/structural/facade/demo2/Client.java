package com.learn.designpattern.structural.facade.demo2;

public class Client {
    private BankingFacade facade;

    public Client(BankingFacade facade) {
        this.facade = facade;
    }

    public static void main(String args[]) {
        BankingFacade facade = new BankingFacade();
        facade.onlineTransfer("1001", "1002", 10000.00);
        facade.atmWithdrawal("1001", 1000.00);
        facade.issueFD("1002", 500.00);
    }
}