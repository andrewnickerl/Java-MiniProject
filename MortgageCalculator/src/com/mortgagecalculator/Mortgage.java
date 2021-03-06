package com.mortgagecalculator;

public class Mortgage {

    // INSTANCE VARIABLES

    private double price;
    private double downPayment;
    private boolean isDownPaymentPercent;
    private int loanLength;
    private double interestRate;
    private double propertyTaxRate;
    private boolean isVaLoan;
    private String zip;
    private double monthlyPayment;
    private double monthlyPrincipalInterest;
    private double monthlyMortgageInsurance;
    private double monthlyPropertyTax;
    private double monthlyHomeOwnersInsurance;

    // CTOR
    public Mortgage(double price, double downPayment,
                    boolean isDownPaymentPercent, int loanLength,
                    double interestRate, double propertyTaxRate,
                    boolean isVaLoan) {
        this.price = price;
        this.downPayment = downPayment;
        this.isDownPaymentPercent = isDownPaymentPercent;
        this.loanLength = loanLength;
        this.interestRate = interestRate;
        this.propertyTaxRate = propertyTaxRate;
        this.isVaLoan = isVaLoan;
    }

    // ACCESSORS

    // VARIABLES THAT WILL BE PASSED AND SET IN THE CONSTRUCTOR GET ONLY GETTERS
    public double getPrice() {
        return price;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) { this.downPayment = downPayment; }

    public boolean isDownPaymentPercent() { return isDownPaymentPercent; }

    public int getLoanLength() { return loanLength; }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPropertyTaxRate() {
        return propertyTaxRate;
    }

    public boolean isVaLoan() { return isVaLoan; }

    // WE'LL IGNORE ZIP FOR NOW
    public String getZip() {
        return zip;
    }

    // VARIABLES THAT WILL BE CALCULATED GET BOTH GETTERS AND SETTERS
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPrincipalInterest() {
        return monthlyPrincipalInterest;
    }

    public void setMonthlyPrincipalInterest(double monthlyPrincipalInterest) {
        this.monthlyPrincipalInterest = monthlyPrincipalInterest;
    }

    public double getMonthlyMortgageInsurance() {
        return monthlyMortgageInsurance;
    }

    public void setMonthlyMortgageInsurance(double monthlyMortgageInsurance) {
        this.monthlyMortgageInsurance = monthlyMortgageInsurance;
    }

    public double getMonthlyPropertyTax() {
        return monthlyPropertyTax;
    }

    public void setMonthlyPropertyTax(double monthlyPropertyTax) {
        this.monthlyPropertyTax = monthlyPropertyTax;
    }

    public double getMonthlyHomeOwnersInsurance() {
        return monthlyHomeOwnersInsurance;
    }

    public void setMonthlyHomeOwnersInsurance(double monthlyHomeOwnersInsurance) {
        this.monthlyHomeOwnersInsurance = monthlyHomeOwnersInsurance;
    }
}
