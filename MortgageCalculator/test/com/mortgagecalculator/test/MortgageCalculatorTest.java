package com.mortgagecalculator.test;

import com.mortgagecalculator.LoanType;
import com.mortgagecalculator.Mortgage;
import com.mortgagecalculator.MortgageCalculator;
import jdk.jfr.StackTrace;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MortgageCalculatorTest {

    @Before
    public void setUp() {
        Mortgage mortgage = new Mortgage(23.0, 32.0, LoanType.CONVENTIONAL15, (float) .5, 12);
    }

    @Test
    public void totalMonthlyPrice() {
        assertTrue();
    }
}