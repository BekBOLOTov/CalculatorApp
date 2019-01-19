package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class Display extends JFrame {
    private JButton[] buttons;
    static JLabel label, label2;
    private JButton buttonPoint, buttonPlus, buttonMin, buttonMult, buttonDiv, buttonDel, buttonRes;
    static String r = "0";
    private final Font F = new Font(Font.MONOSPACED, Font.BOLD, 25);
    private JButton cButton;

    Display() {
        super("Calculator");
        setSize(255, 345);
        setLocation(250, 250);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel(r);
        label.setBounds(10, 30, 230, 45);
        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        label.setBackground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Agency FB", Font.PLAIN, 30));
        label.setOpaque(true);

        buttonDel = new JButton( "<");
        buttonDel.setBounds(10, 90, 50, 40);
        buttonDel.setBorder(BorderFactory.createEtchedBorder());
        buttonDel.setFocusPainted(false);
        buttonDel.setFont(F);

        /*label2 = new JLabel("Bekbolotov");
        label2.setBounds(60, 90, 120, 40);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Algerian", Font.BOLD, 15));*/

        cButton = new JButton("C");
        cButton.setFont(F);
        cButton.setBounds( 70, 90, 110, 40);

        buttonDiv = new JButton("/");
        buttonDiv.setBounds(190, 90, 50, 40);
        buttonDiv.setBorder(BorderFactory.createEtchedBorder());
        buttonDiv.setFocusPainted(false);
        buttonDiv.setFont(F);

        buttonMult = new JButton("x");
        buttonMult.setBounds(190, 135, 50, 40);
        buttonMult.setBorder(BorderFactory.createEtchedBorder());
        buttonMult.setFocusPainted(false);
        buttonMult.setFont(F);

        buttonMin = new JButton("-");
        buttonMin.setBounds(190, 180, 50, 40);
        buttonMin.setBorder(BorderFactory.createEtchedBorder());
        buttonMin.setFocusPainted(false);
        buttonMin.setFont(F);

        buttonPlus = new JButton("+");
        buttonPlus.setBounds(190, 225, 50, 40);
        buttonPlus.setBorder(BorderFactory.createEtchedBorder());
        buttonPlus.setFocusPainted(false);
        buttonPlus.setFont(F);

        buttonPoint = new JButton(".");
        buttonPoint.setBounds(130, 270, 50, 40);
        buttonPoint.setBorder(BorderFactory.createEtchedBorder());
        buttonPoint.setFocusPainted(false);
        buttonPoint.setFont(F);

        buttonRes = new JButton("=");
        buttonRes.setBounds(190, 270, 50, 40);
        buttonRes.setBorder(BorderFactory.createEtchedBorder());
        buttonRes.setFocusPainted(false);
        buttonRes.setFont(F);

        buttons = new JButton[10];

        for(int i = 0; i < 10; i++){
            buttons[i] = new JButton(i + "");
            buttons[i].setFocusPainted(false);
            buttons[i].setBorder(BorderFactory.createEtchedBorder());
            buttons[i].setFont(F);
        }

        buttons[0].setBounds(10, 270, 110, 40);
        buttons[1].setBounds(10, 225, 50, 40);
        buttons[2].setBounds(70, 225, 50, 40);
        buttons[3].setBounds(130, 225, 50, 40);
        buttons[4].setBounds(10, 180, 50, 40);
        buttons[5].setBounds(70, 180, 50, 40);
        buttons[6].setBounds(130, 180, 50, 40);
        buttons[7].setBounds(10, 135, 50, 40);
        buttons[8].setBounds(70, 135, 50, 40);
        buttons[9].setBounds(130, 135, 50, 40);

        for(int i = 0; i < 10; i++) {
            buttons[i].addActionListener(new Action());
            add(buttons[i]);
        }

        cButton.addActionListener(new Action());

        add(cButton);
        add(label);
        add(buttonDel);
        //add(label2);
        add(buttonDiv);
        add(buttonMin);
        add(buttonMult);
        add(buttonPlus);
        add(buttonRes);
        add(buttonPoint);
        setVisible(true);
    }

}
public class Main {

    public static void main(String[] args) {

        new Display();
    }
}
