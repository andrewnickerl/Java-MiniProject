package com.mortgagecalculator;

public class MortgageCalculator {
    public static Mortgage getMortgage(double price, double downPayment,
                                       int loanLength, float interestRate,
                                       float propertyTaxRate, boolean isVaLoan) {
                                                                    /*I'm including property tax rate as an
                                                                    argument instead of zip until we can
                                                                    figure out how to implement a ZIP
                                                                    code/property tax API*/
        Mortgage mortgage = new Mortgage(price, downPayment, loanLength, interestRate, propertyTaxRate, isVaLoan);
        calculateMonthlyPayment(mortgage);
        calculateMonthlyPrincipalInterest(mortgage);
        calculateMonthlyMortgageInsurance(mortgage);
        calculateMonthlyPropertyTax(mortgage);
        calculateMonthlyHomeOwnersInsurance(mortgage);

        return mortgage;
    }

    // OVERLOADED GETMORTGAGE TO ALLOW PASSING A DOWN PAYMENT PERCENT AS WELL AS THE RAW DOLLAR FIGURE (ABOVE)
    public static Mortgage getMortgage(double price, float downPaymentPercent,
                                       int loanLength, float interestRate,
                                       float propertyTaxRate, boolean isVaLoan) {
                                                                    /*I'm including property tax rate as an
                                                                    argument instead of zip until we can
                                                                    figure out how to implement a ZIP
                                                                    code/property tax API*/
        Mortgage mortgage = new Mortgage(price, downPaymentPercent * price,
                loanLength, interestRate, propertyTaxRate, isVaLoan);
        calculateMonthlyPayment(mortgage);
        calculateMonthlyPrincipalInterest(mortgage);
        calculateMonthlyMortgageInsurance(mortgage);
        calculateMonthlyPropertyTax(mortgage);
        calculateMonthlyHomeOwnersInsurance(mortgage);

        return mortgage;
    }

    // example calculation method
    private static double calculateMonthlyPayment(Mortgage mortgage) {
        double monthlyPayment = calculateMonthlyPrincipalInterest(mortgage) + calculateMonthlyMortgageInsurance(mortgage)
                +  calculateMonthlyPropertyTax(mortgage) + calculateMonthlyHomeOwnersInsurance(mortgage);
        mortgage.setMonthlyPayment(monthlyPayment);
        return monthlyPayment;
    }

    // ONLY IMPLEMENT THIS METHOD ONCE WE'VE FIGURED OUT IF WE CAN DO A ZIP CODE -> PROPERTY TAX RATE CALCULATION
    // IF WE AREN'T GOING TO ADD THAT, WE CAN DELETE THIS METHOD
    private static double calculateMonthlyPropertyTaxRate(Mortgage mortgage) {
        double monthlyPropertyTaxRate = mortgage.getPropertyTaxRate() / 12;
        mortgage.setMonthlyPropertyTax(monthlyPropertyTaxRate);
        return monthlyPropertyTaxRate;
    }

    private static double calculateMonthlyPrincipalInterest(Mortgage mortgage) {
        double principal = mortgage.getPrice() - mortgage.getDownPayment();
        double interestRatePercent = mortgage.getInterestRate();
        double interestRateDecimal = interestRatePercent / 100;
        double monthlyInterestRate = interestRateDecimal / 12;
        double monthlyPI = principal * (monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), 360)) /
                (Math.pow((1 + monthlyInterestRate), 360) - 1));
        mortgage.setMonthlyPrincipalInterest(monthlyPI);
        return monthlyPI;
    }

    private static double calculateMonthlyMortgageInsurance(Mortgage mortgage) {
        if(mortgage.isVaLoan()) return 0;
        double principal = mortgage.getPrice() - mortgage.getDownPayment();
        double monthlyMortgageInsurance = principal * .012 / 12;
        mortgage.setMonthlyMortgageInsurance(monthlyMortgageInsurance);
        return monthlyMortgageInsurance;
    }

    private static double calculateMonthlyPropertyTax(Mortgage mortgage) {
        double propertyTaxDecimal = mortgage.getPropertyTaxRate() / 100;
        double monthlyPropertyTax = mortgage.getPrice() * propertyTaxDecimal / 12;
        mortgage.setMonthlyPropertyTax(monthlyPropertyTax);
        return monthlyPropertyTax;
    }

    private static double calculateMonthlyHomeOwnersInsurance(Mortgage mortgage) {
        double monthlyHomeOwnersInsurance = 100; //rough monthly average based on WA state
        mortgage.setMonthlyHomeOwnersInsurance(monthlyHomeOwnersInsurance);
        return monthlyHomeOwnersInsurance;
    }
}