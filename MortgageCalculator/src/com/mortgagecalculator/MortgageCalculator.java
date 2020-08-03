package com.mortgagecalculator;

public class MortgageCalculator {
    public static Mortgage getMortgage(double price, double downPayment,
                                       LoanType loanType, float interestRate,
                                       float propertyTaxRate) {  /*I'm including property tax rate as an
                                                                    argument instead of zip until we can
                                                                    figure out how to implement a ZIP
                                                                    code/property tax API*/
        Mortgage mortgage = new Mortgage(price, downPayment, loanType, interestRate, propertyTaxRate);
        calculateMonthlyPayment(mortgage);
        calculateMonthlyPrincipalInterest(mortgage);
        calculateMonthlyMortgageInsurance(mortgage);
        calculateMonthlyPropertyTax(mortgage);
        calculateMonthlyHomeOwnersInsurance(mortgage);

        return mortgage;
    }

    // OVERLOADED GETMORTGAGE TO ALLOW PASSING A DOWN PAYMENT PERCENT AS WELL AS THE RAW DOLLAR FIGURE (ABOVE)
    public static Mortgage getMortgage(double price, float downPaymentPercent,
                                       LoanType loanType, float interestRate,
                                       float propertyTaxRate) {  /*I'm including property tax rate as an
                                                                    argument instead of zip until we can
                                                                    figure out how to implement a ZIP
                                                                    code/property tax API*/
        Mortgage mortgage = new Mortgage(price, downPaymentPercent * price, loanType, interestRate, propertyTaxRate);
        calculateMonthlyPayment(mortgage);
        calculateMonthlyPrincipalInterest(mortgage);
        calculateMonthlyMortgageInsurance(mortgage);
        calculateMonthlyPropertyTax(mortgage);
        calculateMonthlyHomeOwnersInsurance(mortgage);

        return mortgage;
    }

    // example calculation method
    private static double calculateMonthlyPayment(Mortgage mortgage) {

        //take this and put it into calculateMonthlyPrincipalInterest() :
        double principal = mortgage.getPrice() - mortgage.getDownPayment();
        double interestRate = mortgage.getInterestRate();
        double monthlyPI = principal * (interestRate * (Math.pow((1 + interestRate), 360)) /
                (Math.pow((1 + interestRate), 360) - 1));

        // take this and put it into calculateMonthlyPropertyTax() :
        double monthlyPropertyTax = mortgage.getPrice() * mortgage.getPropertyTaxRate() / 12;

        // take this and put it into calculateMonthlyMortgageInsurance() :
        double monthlyMortgageInsurance = principal * .12 / 12;

        // take this and put it into calculateMonthlyHomeOwnersInsurance() :
        double monthlyHomeOwnersInsurance = 100; //rough monthly average based on WA state

        // then, instead of the line below, do something like the comment underneath :
        double monthlyPayment = monthlyPI + monthlyPropertyTax + monthlyMortgageInsurance + monthlyHomeOwnersInsurance;
        /* double monthlyPayment = calculateMonthlyPrincipalInterest(mortgage) + calculateMonthlyMortgageInsurance(mortgage)
                +  calculateMonthlyPropertyTax(mortgage) + calculateMonthlyHomeOwnersInsurance(mortgage);
         */

        mortgage.setMonthlyPayment(monthlyPayment);
        return monthlyPayment;
    }

    // ONLY IMPLEMENT THIS METHOD ONCE WE'VE FIGURED OUT IF WE CAN DO A ZIP CODE -> PROPERTY TAX RATE CALCULATION
    // IF WE AREN'T GOING TO ADD THAT, WE CAN DELETE THIS METHOD
    private static double calculateMonthlyPropertyTaxRate(Mortgage mortgage) {
        return 0.0;
    }

    private static double calculateMonthlyPrincipalInterest(Mortgage mortgage) {
        return 0.0;
    }

    private static double calculateMonthlyMortgageInsurance(Mortgage mortgage) {
        return 0.0;
    }

    private static double calculateMonthlyPropertyTax(Mortgage mortgage) {
        return 0.0;
    }

    private static double calculateMonthlyHomeOwnersInsurance(Mortgage mortgage) {
        return 0.0;
    }
}