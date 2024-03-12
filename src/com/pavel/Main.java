package com.pavel;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var credit = new Credit();
        var report = new CreditReport(credit);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
