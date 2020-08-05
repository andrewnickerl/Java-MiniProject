package com.mortgagecalculator.test;

import com.mortgagecalculator.Mortgage;
import com.mortgagecalculator.MortgageCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MortgageCalculatorTest extends MortgageCalculator {
    Mortgage mortgage = null;

    @Before
    public void setUp() {
        mortgage = MortgageCalculator.getMortgage(200000.00, 20000.00, 15,
                                         (float) 3.5, (float) .953, false);

    }

    @Test
    public void getTotalMonthlyPayment_shouldReturnTotalMonthlyPayment() {
        assertEquals(1247.113, mortgage.getMonthlyPayment(), .001);
    }

    @Test
    public void getMonthlyPrincipalInterest_shouldReturnMonthlyPrincipalInterest() {

        assertEquals(808.28, mortgage.getMonthlyPrincipalInterest(), .001);
    }

    @Test
    public void getMonthlyMortgageInsurance_shouldReturnMonthlyMortgageInsurance() {
        assertFalse(mortgage.isVaLoan());
        assertEquals(180, mortgage.getMonthlyMortgageInsurance(), .001);
    }

    @Test
    public void getMonthlyMortgageInsurance_shouldReturnZeroMonthlyMortgageInsurance() {
        mortgage = MortgageCalculator.getMortgage(200000.00, 20000.00, 15,
                (float) 3.5, (float) .953, true);
        assertTrue( mortgage.isVaLoan());
        assertEquals(0.0, mortgage.getMonthlyMortgageInsurance(), .001);
    }

    @Test
    public void getMonthlyPropertyTax_shouldReturnMonthlyPropertyTax() {
        assertEquals(158.833, mortgage.getMonthlyPropertyTax(), .001);
    }

    @Test
    public void getMonthlyHomeOwnersInsurance_shouldReturnMonthlyHomeOwnersInsurance() {
        assertEquals(100, mortgage.getMonthlyHomeOwnersInsurance(), .001);
    }

    @Test
    public void getPrice_shouldReturnPrice() {
        assertEquals(200000.00, mortgage.getPrice(), .001);
    }

    @Test
    public void getDownPayment_shouldReturnDownPayment() {
        assertEquals(20000.00, mortgage.getDownPayment(), .001);
    }

    @Test
    public void getLoanLength_shouldReturnLoanLength() { assertTrue(mortgage.getLoanLength() == 15); }

    @Test
    public void getInterestRate_shouldReturnInterestRate() {
        assertEquals(3.5, mortgage.getInterestRate(), .001);
    }

    @Test
    public void getPropertyTaxRate_shouldReturnPropertyTaxRate() {
        assertEquals(.953, mortgage.getPropertyTaxRate(), .001);
    }
}