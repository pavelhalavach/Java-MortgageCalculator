package com.pavel;

import java.text.NumberFormat;

public class Credit {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int loan;
    private float rate;
    private byte years;

    public Credit(){
        setLoan();
        setRate();
        setYears();
    }
    public double calculateMortgage(){
        float rateMonthly = getRateMonthly();
        short numberOfPayments = getNumberOfPayments();
        return  loan * rateMonthly * Math.pow(1+ rateMonthly, numberOfPayments)
                / (Math.pow(1+ rateMonthly, numberOfPayments) - 1);
    }

    private void setLoan() {
        var setParam = new SetCreditParams("Principal ($1K - $1M): ", 1000, 1_000_000);
        this.loan = (int) setParam.returnParam();
    }

    private void setRate() {
        var setParam = new SetCreditParams("Annual interest rate (0-30): ", 0, 30);
        this.rate = (float) setParam.returnParam();

    }

    private void setYears() {
        var setParam = new SetCreditParams("Years (1-30): ", 1, 30);
        this.years = (byte) setParam.returnParam();
    }

    private short getNumberOfPayments(){
        return (short) (years*MONTHS_IN_YEAR);
    }
    private float getRateMonthly(){
        return rate / MONTHS_IN_YEAR / PERCENT;
    }
    private double getRemainingBalance(int month){
        float rateMonthly = getRateMonthly();
        short numberOfPayments = getNumberOfPayments();
        return this.loan * (Math.pow(1 + rateMonthly, numberOfPayments) - Math.pow(1 + rateMonthly, month))
                / (Math.pow(1 + rateMonthly, numberOfPayments) - 1);
    }

    public double[] getRemainingBalanceMonthly(){
        var balances = new double[getNumberOfPayments()];
        for(int month = 1; month <= balances.length; month++)
            balances[month-1] = getRemainingBalance(month);
        return balances;
    }
}
