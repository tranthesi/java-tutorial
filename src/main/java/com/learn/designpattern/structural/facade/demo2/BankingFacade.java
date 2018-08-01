package com.learn.designpattern.structural.facade.demo2;

public class BankingFacade {
    AccountCreditor creditor = new AccountCreditor();
    AccountDebitor debitor = new AccountDebitor();
    FDIssuer fdIssuer = new FDIssuer();

    public void onlineTransfer(String fromAcc, String toAcc, Double amount) {
        debitor.debitAccount(fromAcc, amount);
        creditor.creditAccount(toAcc, amount);
    }

    public void atmWithdrawal(String fromAcc, Double amount) {
        debitor.debitAccount(fromAcc, amount);
    }

    public void issueFD(String fromAcc, Double amount) {
        debitor.debitAccount(fromAcc, amount);
        fdIssuer.issueFD(amount);
    }
}