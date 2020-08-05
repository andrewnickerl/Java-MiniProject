package com.mortgagecalculator.ui;

import com.mortgagecalculator.Mortgage;
import com.mortgagecalculator.MortgageCalculator;

import javax.swing.*;

public class CalculatorUI {

    public static void main(String[] args) {

        JPanel calculatorPanel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(calculatorPanel);
        calculatorPanel.setLayout(null);

        JLabel title = new JLabel("Mortgage Calculator");
        title.setBounds(180, 0, 150, 25);
        calculatorPanel.add(title);

        JLabel price = new JLabel("Price:");
        price.setBounds(10, 40, 50, 20);
        calculatorPanel.add(price);
        JTextField priceText = new JTextField();
        priceText.setBounds(50, 40, 80, 20);
        calculatorPanel.add(priceText);

        JLabel downPayment = new JLabel("Down Payment:");
        price.setBounds(10, 80, 50, 20);
        calculatorPanel.add(downPayment);
        JTextField downPaymentText = new JTextField();
        priceText.setBounds(50, 80, 80, 20);
        calculatorPanel.add(downPaymentText);

        // double priceArg = Double.parseDouble(priceText.getText());

        // Mortgage mortgage = MortgageCalculator.getMortgage(priceArg, )

        frame.setVisible(true);
    }
}