package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

/**
 * This class makes a frame for a calculator
 * @author Melika
 * @version 2.0
 * @since 2020
 */
public class CalculatorGUI implements ActionListener {
    JFrame calcFrame;
    JTextField text;
    private boolean shiftKey;
    private double result;
    //private String s0,s1,s2;
    public char ch;


    public CalculatorGUI() {

        this.result = 0;
        this.text = new JTextField();
        this.shiftKey = true;
        calcFrame = new JFrame();
        calcFrame.setTitle("Calculator");
        calcFrame.setSize(700, 500);
        calcFrame.setLocation(200, 200);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
        keyHandling();
        addMenu();
        calcFrame.setVisible(true);
    }

    //draw claculator
    public void draw() {
        drawkeyboard();
        drawScreen();
    }

    //screen of calculator
    public void drawScreen() {
        text.setEditable(false);
        text.setFont(new Font("Arial", 14, 14));

        JScrollPane jScrollPane = new JScrollPane(text);
        jScrollPane.setSize(500, 70);
        jScrollPane.setLocation(160, 5);

        calcFrame.add(jScrollPane);
    }

    //keyboard of calculator
    public void drawkeyboard() {
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(5, 50, 670, 400);
        jTabbedPane.add("Standard", jPanel1);
        jTabbedPane.add("Scientific", jPanel2);

        calcFrame.add(jTabbedPane);

        jPanel1.setLayout(new GridLayout(4, 4));







        for (int i = 9; i >= 0; i--) {
            if (i == 6) {
                JButton divition = new JButton("/");
                jPanel1.add(divition);
                divition.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("/");
                            text.setText("");
                            ch = '/';
                        }
                    }
                });

            } else if (i == 3) {
                JButton multiplication = new JButton("*");
                jPanel1.add(multiplication);
                multiplication.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("*");
                            text.setText("");
                            ch = '*';
                        }
                    }
                });
            } else if (i == 0) {
                JButton remainder = new JButton("%");
                jPanel1.add(remainder);
                remainder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result += number;
                            text.setText("%");
                            text.setText("");
                            ch = '%';
                        }
                    }
                });


                JButton summation = new JButton("+");
                jPanel1.add(summation);
                summation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("+");
                            text.setText("");
                            ch = '+';
                        }
                    }
                });
            }
            JButton button = new JButton("" + i);
            jPanel1.add(button);
            button.addActionListener(this);
        }



        JButton substraction = new JButton("-");
        jPanel1.add(substraction);
        substraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number;
                    text.setText("-");
                    text.setText("");
                    ch = '-';
                }
            }
        });


        JButton calculation = new JButton("=");
        jPanel1.add(calculation);
        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp1 = text.getText();
                if (temp1.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp1);

                    switch (ch) {
                        case '+':
                            result = result + number;
                            break;
                        case '-':
                            result = result - number;
                            break;
                        case '/':
                            result = result / number;
                            break;
                        case '*':
                            result = result * number;
                            break;
                        case '%':
                            result = result % number;
                    }

                    String returner = String.valueOf(result);
                    text.setText(returner);

                }
            }
        });


        jPanel2.setLayout(new GridLayout(6, 4));

        for (int i = 9; i >= 0; i--) {
            if (i == 6) {
                JButton divition = new JButton("/");
                jPanel2.add(divition);
                divition.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("/");
                            text.setText("");
                            ch = '/';
                        }
                    }
                });
            } else if (i == 3) {
                JButton multiplication = new JButton("*");
                jPanel2.add(multiplication);
                multiplication.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("*");
                            text.setText("");
                            ch = '*';
                        }
                    }
                });
            } else if (i == 0) {
                JButton remainder = new JButton("%");
                jPanel2.add(remainder);
                remainder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result += number;
                            text.setText("%");
                            text.setText("");
                            ch = '%';
                        }
                    }
                });

                JButton summation = new JButton("+");
                jPanel2.add(summation);
                summation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = text.getText();
                        if (temp.equals("")) {
                            text.setText("");
                        } else {
                            double number = Double.parseDouble(temp);
                            result = result + number;
                            text.setText("+");
                            text.setText("");
                            ch = '+';
                        }
                    }
                });

            }

            JButton button = new JButton("" + i);
            jPanel2.add(button);
            button.addActionListener(this);
        }

        JButton substraction2 = new JButton("-");
        jPanel2.add(substraction2);
        substraction2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number;
                    text.setText("-");
                    text.setText("");
                    ch = '-';
                }
            }
        });

        JButton calculation2 = new JButton("=");
        jPanel2.add(calculation2);
        calculation2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp1 = text.getText();
                if (temp1.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp1);

                    switch (ch) {
                        case '+':
                            result = result + number;
                            break;
                        case '-':
                            result = result - number;
                            break;
                        case '/':
                            result = result / number;
                            break;
                        case '*':
                            result = result * number;
                            break;
                        case '%':
                            result = result % number;
                    }

                    String returner = String.valueOf(result);
                    text.setText(returner);

                }
            }
        });

        JButton exp = new JButton("exp");
        jPanel2.add(exp);
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number;
                    result = Math.exp(result);
                    text.setText("");
                    text.setText(text.getText() + result);
                }
            }
        });

        JButton log = new JButton("log");
        jPanel2.add(log);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number ;
                    result = Math.log(result);
                    text.setText("");
                    text.setText(text.getText() + result);

                }
            }
        });


        JButton pi = new JButton("pi");
        jPanel2.add(pi);
        pi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = 3.14;
                text.setText("");
                text.setText(String.valueOf(result));
            }
        });


        JButton ac = new JButton("AC");
        jPanel2.add(ac);
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = 0 ;
                    text.setText("");
                    text.setText(String.valueOf(result));

                }
            }
        });



        JButton neper = new JButton("e");
        jPanel2.add(neper);
        neper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = 2.71;
                text.setText("");
                text.setText(String.valueOf(result));
            }
        });

        JButton sincos = new JButton("sin/cos");
        jPanel2.add(sincos);
        sincos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number ;
                    if (shiftKey == true) {
                        result = Math.sin(result);
                        text.setText("");
                        text.setText(text.getText() + result);
                    }else {
                        result = Math.cos(result);
                        text.setText("");
                        text.setText(text.getText() + result);
                    }

                }
            }
        });

        JButton tancot = new JButton("tan/cot");
        jPanel2.add(tancot);
        tancot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text.getText();
                if (temp.equals("")) {
                    text.setText("");
                } else {
                    double number = Double.parseDouble(temp);
                    result = result + number ;
                    if (shiftKey == true) {
                        result = Math.tan(result);
                        text.setText("");
                        text.setText(text.getText() + result);
                    }else {
                        result = 1 / (Math.tan(result));
                        text.setText("");
                        text.setText(text.getText() + result);
                    }

                }
            }
        });

        JButton shift = new JButton("shift");

        shift.addActionListener(e -> {
            if (shiftKey == true) {
                sincos.setText("sin");
                tancot.setText("tan");
                shiftKey = false;
            } else {
                sincos.setText("cos");
                tancot.setText("cot");
                shiftKey = true;
            }
        });
        jPanel2.add(shift);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton jButton = (JButton) e.getSource();
        for (int i = 9; i >= 0; i--){
            if (jButton.getText().contains("" + i)){
                String temp = text.getText();
                temp += i;
                text.setText(temp);
            }
        }
       /*String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            text.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            text.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            text.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            text.setText(s0 + s1 + s2);
        }*/
    }


    //exit calcuator after pressing escape key
    public void keyHandling(){
        calcFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        });
        calcFrame.setFocusable(true);
    }

    //add menu
    public void addMenu(){
        JMenuBar jMenuBar = new JMenuBar();
        calcFrame.setJMenuBar(jMenuBar);

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');
        jMenuBar.add(menu);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setToolTipText("exit calculator");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);

        JMenuItem copy = new JMenuItem("Copy");
        copy.setToolTipText("copy text");
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String copytext = text.getText();
                StringSelection stringSelection = new StringSelection(copytext);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "copied!");
            }
        });
        menu.add(copy);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    }
}
