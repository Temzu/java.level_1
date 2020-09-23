package ru.geekbrains.student_project.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class MyWindow extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPlus, bMinus, bMultiplication, bDivision, bClear, bEqually;
    static TextField textField;
    Handler handler = new Handler();

    public MyWindow() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 280);
        setLocation(650, 200);
        setLayout(new FlowLayout());
        setResizable(false);
        initializeButtonsAndTextField();
        addButtonsAndTextField();
        addActionForButtons();
        setVisible(true);
    }

    //Производит инициализацию кнопок и текстового поля
    private void initializeButtonsAndTextField() {
        b0 = new JButton(" 0 ");
        b1 = new JButton(" 1 ");
        b2 = new JButton(" 2 ");
        b3 = new JButton(" 3 ");
        b4 = new JButton(" 4 ");
        b5 = new JButton(" 5 ");
        b6 = new JButton(" 6 ");
        b7 = new JButton(" 7 ");
        b8 = new JButton(" 8 ");
        b9 = new JButton(" 9 ");
        bPlus = new JButton(" + ");
        bMinus = new JButton(" - ");
        bMultiplication = new JButton(" * ");
        bDivision = new JButton(" / ");
        bClear = new JButton("                 CE                 ");
        bEqually = new JButton("                 =                 ");
        textField = new TextField(9);
        textField.setEditable(false);
    }

    //добавляет кнопки и текстовое поле в программу
    private void addButtonsAndTextField(){
        add(textField);
        add(bClear);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(bPlus);
        add(b0);
        add(bMinus);
        add(bMultiplication);
        add(bDivision);
        add(bEqually);
    }

    //Добавляет действия для кнопок
    private void addActionForButtons() {
        b0.addActionListener(handler);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b4.addActionListener(handler);
        b5.addActionListener(handler);
        b6.addActionListener(handler);
        b7.addActionListener(handler);
        b8.addActionListener(handler);
        b9.addActionListener(handler);
        bPlus.addActionListener(handler);
        bMinus.addActionListener(handler);
        bMultiplication.addActionListener(handler);
        bDivision.addActionListener(handler);
        bClear.addActionListener(handler);
        bEqually.addActionListener(handler);
    }

    public class Handler implements ActionListener {
        String numbers = "";
        double numberR = 0;
        double numberL = 0;
        double operatingNumbers = 0;
        boolean isSignPlus, isSignMinus, isSignMultiplication, isSignDivision;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (numberR > 99999999 || numberR < -99999999) {
                numbers = "";
                numberR = 0;
                textField.setText(numbers);
                JOptionPane.showMessageDialog(null, "Вы ввели слишком длинное число");
            }
            checkNumbersButtons(e);
            checkClearButton(e);
            checkOperatingButtons(e);
            checkEquallyButton(e);
        }

        //Проверяет нажатие номерных кнопок
        private void checkNumbersButtons(ActionEvent e) {
            if (e.getSource() == b0) {
                logicForNumbersButtons(0);
            }
            if (e.getSource() == b1) {
                logicForNumbersButtons(1);
            }
            if (e.getSource() == b2) {
                logicForNumbersButtons(2);
            }
            if (e.getSource() == b3) {
                logicForNumbersButtons(3);
            }
            if (e.getSource() == b4) {
                logicForNumbersButtons(4);;
            }
            if (e.getSource() == b5) {
                logicForNumbersButtons(5);
            }
            if (e.getSource() == b6) {
                logicForNumbersButtons(6);;
            }
            if (e.getSource() == b7) {
                logicForNumbersButtons(7);
            }
            if (e.getSource() == b8) {
                logicForNumbersButtons(8);
            }
            if (e.getSource() == b9) {
                logicForNumbersButtons(9);
            }
        }

        //Проверяет нажатие кнопки очистки
        private void checkClearButton(ActionEvent e) {
            if (e.getSource() == bClear) {
                numbers = "";
                numberR = 0;
                numberL = 0;
                operatingNumbers = 0;
                textField.setText(numbers);
                nullifyLogicVariables();
            }
        }

        //Проверяет нажатие кнопок-операций
        private void checkOperatingButtons(ActionEvent e) {
            if (e.getSource() == bPlus) {
                isSignPlus = true;
                isSignMinus = false;
                isSignDivision = false;
                isSignMultiplication = false;
                logicForOperatingButtons();

            }
            if (e.getSource() == bMinus) {
                isSignPlus = false;
                isSignMinus = true;
                isSignDivision = false;
                isSignMultiplication = false;
                logicForOperatingButtons();
            }
            if (e.getSource() == bMultiplication) {
                isSignPlus = false;
                isSignMinus = false;
                isSignDivision = false;
                isSignMultiplication = true;
                logicForOperatingButtons();

            }
            if (e.getSource() == bDivision) {
                isSignPlus = false;
                isSignMinus = false;
                isSignDivision = true;
                isSignMultiplication = false;
                logicForOperatingButtons();

            }
        }

        //Проверяет нажатие кнопки равенства
        private void checkEquallyButton(ActionEvent e) {
            if (e.getSource() == bEqually) {
                if (isSignPlus) {
                    operatingNumbers = numberL + numberR;
                    numbers = "";
                    numberR = 0;
                    numberL = 0;
                    textField.setText(Double.toString(operatingNumbers));
                    nullifyLogicVariables();
                }
                if (isSignMinus) {
                    operatingNumbers = numberL - numberR;
                    numbers = "";
                    numberR = 0;
                    numberL = 0;
                    textField.setText(Double.toString(operatingNumbers));
                    nullifyLogicVariables();
                }
                if (isSignMultiplication) {
                    operatingNumbers = numberL * numberR;
                    numbers = "";
                    numberR = 0;
                    numberL = 0;
                    textField.setText(Double.toString(operatingNumbers));
                    nullifyLogicVariables();
                }
                if (isSignDivision) {
                    operatingNumbers = numberL / numberR;
                    numbers = "";
                    numberR = 0;
                    numberL = 0;
                    textField.setText(Double.toString(operatingNumbers));
                    nullifyLogicVariables();
                }
            }
        }

        //Делает ложными логические переменные
        private void nullifyLogicVariables() {
            isSignPlus = false;
            isSignMinus = false;
            isSignDivision = false;
            isSignMultiplication = false;
        }

        //Проверяет были ли нажали кнопки операций, после возращает логическую переменную
        private boolean isOperatingNumbersTrue() {
            if (isSignPlus || isSignDivision || isSignMultiplication || isSignMinus) {
                return false;
            } else {
                return true;
            }
        }

        //Логика для каждой номерной кнопки в программе
        private void logicForNumbersButtons(int number) {
            if (isOperatingNumbersTrue()) {
                numbers = addTextInTextField(numbers, number);
                textField.setText(numbers);
                numberR = Double.parseDouble(textField.getText());
            } else {
                numbers = addTextInTextField(numbers, number);
                textField.setText(numbers);
                numberR = Double.parseDouble(textField.getText());
                operatingNumbers = 0;
            }
        }

        //Логика для каждой операционной кнопки в программе
        private void logicForOperatingButtons(){
            if (textField.getText().equals("") || textField.getText().equals("0")) {
                if (isSignMinus) {
                    textField.setText("-");
                } else {
                    numbers = addTextInTextField(numbers, 0);
                    textField.setText(numbers);
                }
            } else if (operatingNumbers != 0){
                numberL = operatingNumbers;
                numberR = 0;
                numbers = "";
                textField.setText("");
                operatingNumbers = 0;
            } else {
                numberL = numberR;
                numberR = 0;
                numbers = "";
                textField.setText("");
                operatingNumbers = 0;
            }
        }

        //Добавляет текст в текстовое поле
        private String addTextInTextField(String t, int number) {
            if (textField.getText().equals("-")){
                numbers = t;
                numbers += Integer.toString(-number);
            }
            else if (textField.getText().equals("0")) {
                numbers = t;
                numbers = Integer.toString(number);
            } else {
                numbers = t;
                numbers += Integer.toString(number);
            }
            return numbers;
        }
    }
}