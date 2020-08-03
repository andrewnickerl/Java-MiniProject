package com.mortgagecalculator;

public class Mortgage {

    // INSTANCE VARIABLES

    private double price;
    private double downPayment;
    private LoanType loanType;
    private float interestRate;
    private float propertyTaxRate;
    private String zip;
    private double monthlyPayment;
    private double monthlyPrincipleInterest;
    private double monthlyMortgageInsurance;
    private double monthlyPropertyTax;
    private double monthlyHomeOwnersInsurance;

    // CTOR
    public Mortgage(double price, double downPayment,
                    LoanType loanType, float interestRate,
                    float propertyTaxRate) {
        this.price = price;
        this.downPayment = downPayment;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.propertyTaxRate = propertyTaxRate;
    }

    // ACCESSORS

    // VARIABLES THAT WILL BE PASSED AND SET IN THE CONSTRUCTOR GET ONLY GETTERS
    public double getPrice() {
        return price;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public float getPropertyTaxRate() {
        return propertyTaxRate;
    }

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

    public double getMonthlyPrincipleInterest() {
        return monthlyPrincipleInterest;
    }

    public void setMonthlyPrincipleInterest(double monthlyPrincipleInterest) {
        this.monthlyPrincipleInterest = monthlyPrincipleInterest;
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
