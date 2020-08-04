package com.mortgagecalculator.test;

import com.mortgagecalculator.LoanType;
import com.mortgagecalculator.Mortgage;
import com.mortgagecalculator.MortgageCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MortgageCalculatorTest {

    @Before
    public void setUp() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                         (float) .5, 12);
    }

    // TODO: REMOVE REDUNDANCIES

    @Test
    public void getTotalMonthlyPayment_shouldReturnTotalMonthlyPayment() { // TODO: Waiting for math
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        mortgage.setMonthlyPayment(3500.00);
        assertEquals(3500.00, mortgage.getMonthlyPayment(), .001);
    }

    @Test
    public void getMonthlyPrincipalInterest_shouldReturnMonthlyPrincipalInterest() { // TODO: Waiting for math
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        mortgage.setMonthlyPrincipalInterest(2.5);
        assertEquals(2.5, mortgage.getMonthlyPrincipalInterest(), .001);
    }

    @Test
    public void getMonthlyMortgageInsurance_shouldReturnMonthlyMortgageInsurance() { // TODO: Waiting for math
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        mortgage.setMonthlyMortgageInsurance(1000.00);
        assertEquals(1000.00, mortgage.getMonthlyMortgageInsurance(), .001);
    }

    @Test
    public void getMonthlyPropertyTax_shouldReturnMonthlyPropertyTax() { // TODO: Waiting for math
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        mortgage.setMonthlyPropertyTax(250.00);
        assertEquals(250.00, mortgage.getMonthlyPropertyTax(), .001);
    }

    @Test
    public void getMonthlyHomeOwnersInsurance_shouldReturnMonthlyHomeOwnersInsurance() { // TODO: Waiting for math
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        mortgage.setMonthlyHomeOwnersInsurance(250.00);
        assertEquals(250.00, mortgage.getMonthlyHomeOwnersInsurance(), .001);
    }

    @Test
    public void getPrice_shouldReturnPrice() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        assertEquals(200000.00, mortgage.getPrice(), .001);
    }

    @Test
    public void getDownPayment_shouldReturnDownPayment() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        assertEquals(20000.00, mortgage.getDownPayment(), .001);
    }

    @Test
    public void getLoanType_shouldReturnLoanType() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        assertTrue(mortgage.getLoanType() == LoanType.CONVENTIONAL15);
    }

    @Test
    public void getInterestRate_shouldReturnInterestRate() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        assertEquals(.5, mortgage.getInterestRate(), .001);
    }

    @Test
    public void getPropertyTaxRate_shouldReturnPropertyTaxRate() {
        Mortgage mortgage = new Mortgage(200000.00, 20000.00, LoanType.CONVENTIONAL15,
                                            (float) .5, 12);
        assertEquals(12, mortgage.getPropertyTaxRate(), .001);
    }
}