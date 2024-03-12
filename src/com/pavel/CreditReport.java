package com.pavel;

import java.text.NumberFormat;

public class CreditReport {
    private final NumberFormat  currency;
    private Credit credit;

    public CreditReport(Credit credit){
        this.credit = credit;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage(){
        System.out.println("MORTGAGE\n--------\nMonthly Payments: "
                +currency.format(credit.calculateMortgage()));
    }

    public void printPaymentSchedule(){
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for(double balance : credit.getRemainingBalanceMonthly())
            System.out.println(currency.format(balance));


    }
}
