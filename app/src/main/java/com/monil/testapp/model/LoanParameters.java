package com.monil.testapp.model;

/* Class to store all the loan parameters for mortgage calculations */
public class LoanParameters {
    // Labels table name
    public static final String TABLE = "Mortgage";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_monthlypayment = "monthlypayment";
    public static final String KEY_totalpayment = "totalpayment";
    public static final String KEY_payoffdate = "payoffdate";
    public static final String KEY_purchaseprice = "purchaseprice";
    public static final String KEY_downpayment = "downpayment";
    public static final String KEY_mortgageterm = "mortgageterm";
    public static final String KEY_interestrate = "interestrate";
    public static final String KEY_propertyinsurance = "propertyinsurance";
    public static final String KEY_propertytax = "propertytax";
    public static final String KEY_pmi = "pmi";
    public static final String KEY_zipcode = "zipcode";
    public static final String KEY_month = "month";
    public static final String KEY_year = "year";

    /* Parameters for mortgage calculations */
    private double purchaseprice;
    private double downpayment;
    private double mortgageterm;
    private double interestrate;
    private double propertytax;
    private double propertyinsurance;
    private double pmi;
    private int zipcode;
    private String month;
    private String year;
    private double loanamount;
    private double monthlypayment;
    private double totalpayment;
    private String payoffdate;

    /* Getters and Setters for all the parameters */
    public String getPayoffdate() {
        return payoffdate;
    }

    public void setPayoffdate(String payoffdate) {
        this.payoffdate = payoffdate;
    }

    public double getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(double totalpayment) {
        this.totalpayment = totalpayment;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public double getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(double downpayment) {
        this.downpayment = downpayment;
    }

    public double getMortgageterm() {
        return mortgageterm;
    }

    public void setMortgageterm(double mortgageterm) {
        this.mortgageterm = mortgageterm;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public double getPropertytax() {
        return propertytax;
    }

    public void setPropertytax(double propertytax) {
        this.propertytax = propertytax;
    }

    public double getPropertyinsurance() {
        return propertyinsurance;
    }

    public void setPropertyinsurance(double propertyinsurance) {
        this.propertyinsurance = propertyinsurance;
    }

    public double getPmi() {
        return pmi;
    }

    public void setPmi(double pmi) {
        this.pmi = pmi;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(double loanamount) {
        this.loanamount = loanamount;
    }

    public double getMonthlypayment() {
        return monthlypayment;
    }

    public void setMonthlypayment(double monthlypayment) {
        this.monthlypayment = monthlypayment;
    }

}

