package com.mortgagecalculator.ui;

import com.mortgagecalculator.Mortgage;
import com.mortgagecalculator.MortgageCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI implements  Runnable {

    @Override
    public void run() {
        // INITIAL PANEL AND FRAME SETUP FOR THE UI
        JPanel calculatorPanel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(calculatorPanel);
        calculatorPanel.setLayout(null);

        // SETS TITLE AT TOP CENTER
        JLabel title = new JLabel("Mortgage Calculator");
        title.setBounds(180, 0, 150, 25);
        calculatorPanel.add(title);

        // SETS LABEL AND FIELD FOR PRICE
        JLabel price = new JLabel("Price:");
        price.setBounds(10, 60, 50, 20);
        calculatorPanel.add(price);
        JTextField priceText = new JTextField();
        priceText.setBounds(125, 60, 80, 20);
        calculatorPanel.add(priceText);

        // SETS LABEL AND FIELD FOR DOWN PAYMENT
        JLabel downPayment = new JLabel("Down Payment:");
        downPayment.setBounds(10, 90, 100, 20);
        calculatorPanel.add(downPayment);
        JTextField downPaymentText = new JTextField();
        downPaymentText.setBounds(125, 90, 80, 20);
        calculatorPanel.add(downPaymentText);

        // SETS LABEL AND DROP DOWN MENU FOR LOAN LENGTH
        JLabel loanLength = new JLabel("Loan Length:");
        loanLength.setBounds(10, 120, 100, 20);
        calculatorPanel.add(loanLength);
        Integer[] loanLengths = {30, 15};
        JComboBox loanLengthsBox = new JComboBox(loanLengths);
        loanLengthsBox.setBounds(125, 120, 50, 20);
        calculatorPanel.add(loanLengthsBox);

        // SETS LABEL AND FIELD FOR INTEREST RATE
        JLabel interestRate = new JLabel("Interest Rate:");
        interestRate.setBounds(260, 60, 100, 20);
        calculatorPanel.add(interestRate);
        JTextField interestRateText = new JTextField();
        interestRateText.setBounds(350, 60, 80, 20);
        calculatorPanel.add(interestRateText);

        // SETS LABEL AND FIELD FOR PROPERTY TAX RATE
        JLabel propertyTaxRate = new JLabel("Property Tax Rate:");
        propertyTaxRate.setBounds(260, 90, 120, 20);
        calculatorPanel.add(propertyTaxRate);
        JTextField propertyTaxRateText = new JTextField();
        propertyTaxRateText.setBounds(370, 90, 60, 20);
        calculatorPanel.add(propertyTaxRateText);

        // SETS LABEL AND CHECK BOX FOR VA LOAN
        JLabel vaLoan = new JLabel("VA loan?");
        vaLoan.setBounds(260, 120, 50, 20);
        calculatorPanel.add(vaLoan);
        JCheckBox vaLoanBox = new JCheckBox();
        vaLoanBox.setBounds(320, 120, 20, 20);
        calculatorPanel.add(vaLoanBox);

        // PUTS IN PLACE A SEPARATOR BETWEEN THE INPUT AND OUTPUT FIELDS
        JSeparator inputToOutput = new JSeparator(0);
        inputToOutput.setForeground(Color.black);
        inputToOutput.setBounds(0, 240, 500, 10);
        calculatorPanel.add(inputToOutput);

        // SETS LABEL AND FIELD FOR MONTHLY PAYMENT
        JLabel monthlyPayment = new JLabel("Monthly Payment:");
        monthlyPayment.setBounds(140, 270, 120, 20);
        calculatorPanel.add(monthlyPayment);
        JTextField monthlyPaymentText = new JTextField();
        monthlyPaymentText.setBounds(245, 270, 80, 20);
        monthlyPaymentText.setEditable(false);
        calculatorPanel.add(monthlyPaymentText);

        // SETS LABEL AND FIELD FOR MONTHLY PRINCIPLE AND INTEREST
        JLabel monthlyPI = new JLabel("Principle & Interest:");
        monthlyPI.setBounds(10, 320, 120, 20);
        calculatorPanel.add(monthlyPI);
        JTextField monthlyPIText = new JTextField();
        monthlyPIText.setBounds(125, 320, 80, 20);
        monthlyPIText.setEditable(false);
        calculatorPanel.add(monthlyPIText);

        // SETS LABEL AND FIELD FOR MONTHLY PROPERTY TAX
        JLabel monthlyPropertyTax = new JLabel("Property Tax:");
        monthlyPropertyTax.setBounds(10, 360, 120, 20);
        calculatorPanel.add(monthlyPropertyTax);
        JTextField monthlyPropertyTaxText = new JTextField();
        monthlyPropertyTaxText.setBounds(125, 360, 80, 20);
        monthlyPropertyTaxText.setEditable(false);
        calculatorPanel.add(monthlyPropertyTaxText);

        // SETS LABEL AND FIELD FOR MONTHLY HOMEOWNERS INSURANCE
        JLabel monthlyHomeOwnersInsurance = new JLabel("Homeowners Insurance:");
        monthlyHomeOwnersInsurance.setBounds(220, 320, 140, 20);
        calculatorPanel.add(monthlyHomeOwnersInsurance);
        JTextField monthlyHomeOwnersInsuranceText = new JTextField();
        monthlyHomeOwnersInsuranceText.setBounds(365, 320, 65, 20);
        monthlyHomeOwnersInsuranceText.setEditable(false);
        calculatorPanel.add(monthlyHomeOwnersInsuranceText);

        // SETS LABEL AND FIELD FOR MONTHLY MORTGAGE INSURANCE
        JLabel monthlyMortgageInsurance = new JLabel("Mortgage Insurance:");
        monthlyMortgageInsurance.setBounds(220, 360, 140, 20);
        calculatorPanel.add(monthlyMortgageInsurance);
        JTextField monthlyMortgageInsuranceText = new JTextField();
        monthlyMortgageInsuranceText.setBounds(345, 360, 85, 20);
        monthlyMortgageInsuranceText.setEditable(false);
        calculatorPanel.add(monthlyMortgageInsuranceText);

        // ADDS CALCULATE BUTTON AND ADDS FUNCTIONALITY THROUGH AN ACTION LISTENER
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(195, 185, 90, 20);
        ActionListener handler = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = Double.parseDouble(priceText.getText());
                double downPayment = Double.parseDouble(downPaymentText.getText());
                int loanLength = (int)loanLengthsBox.getSelectedItem();
                float interestRate = Float.parseFloat(interestRateText.getText());
                float propertyTaxRate = Float.parseFloat(propertyTaxRateText.getText());
                boolean isVaLoan = vaLoanBox.isSelected();

                Mortgage mortgage = MortgageCalculator.getMortgage(price, downPayment, loanLength, interestRate,
                        propertyTaxRate, isVaLoan);

                monthlyPaymentText.setText(String.format("%.2f", mortgage.getMonthlyPayment()));
                monthlyPIText.setText(String.format("%.2f", mortgage.getMonthlyPrincipalInterest()));
                monthlyPropertyTaxText.setText(String.format("%.2f", mortgage.getMonthlyPropertyTax()));
                monthlyHomeOwnersInsuranceText.setText(String.format("%.2f", mortgage.getMonthlyHomeOwnersInsurance()));
                monthlyMortgageInsuranceText.setText(String.format("%.2f", mortgage.getMonthlyMortgageInsurance()));
            }
        };
        calculateButton.addActionListener(handler);
        calculatorPanel.add(calculateButton);

        frame.setVisible(true);
    }
}