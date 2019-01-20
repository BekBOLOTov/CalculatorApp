package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static com.company.Display.*;
import com.company.*;

import javax.swing.event.ChangeListener;

public class Action implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String t = actionEvent.getActionCommand();
        if (Character.isDigit(t.charAt(0))) {
            if (t.equals("0") && r.length() == 1 && r.charAt(0) == '0')
                return;
            if(r.length() == 1 && r.equals("0"))
                r = "";
            r += t;
        }
        if (t.equals("<")) {
            r = removeLast(r);
            if(r.length() == 0) r = "0";
        }
        if (t.equals("C")) {
            r = "0";
        }
        if (t.equals("+") || t.equals("-") || t.equals("/") || t.equals("x")) {
            if(r.charAt(r.length() - 1) == '+' || r.charAt(r.length() - 1) == '-' || r.charAt(r.length() - 1) == 'x' || r.charAt(r.length() - 1) == '/' || r.charAt(r.length() - 1) == '.')
                r = removeLast(r);
            r += t;
        }
        if (t.equals(".")) {
            int i = r.length() - 1;
            while (i > 0 && r.charAt(i) != '.' && r.charAt(i) != '+' && r.charAt(i) != 'x' && r.charAt(i) != '-' && r.charAt(i) != '/') i--;
            if(r.charAt(i) != '.' && Character.isDigit(r.charAt(r.length() - 1)))
                r += ".";
        }
        if (t.equals("=")) {
            r = calc(r);
        }

        label.setText(r);
    }
    String removeLast(String s) {
        String str = "";
        for (int i = 0; i < s.length() - 1; i++)
            str += s.charAt(i);
        return str;
    }
    String calc(String r) {
        List<Double> l = new ArrayList<>();
        List<Character> lC = new ArrayList<>();
        String t = "";
        Character c;
        if (!Character.isDigit(r.charAt(r.length() - 1)))
            r = removeLast(r);
        for(int i = 0; i < r.length(); i++) {
            if(Character.isDigit(r.charAt(i)) || r.charAt(i) == '.') {
                t += r.charAt(i);
            }
            else {
                l.add(Double.parseDouble(t));
                t = "";
                lC.add(r.charAt(i));
            }
        }
        l.add(Double.parseDouble(t));
        int i = 0;
        while (i < lC.size()) {
            for (i = 0; i < lC.size(); i++){
                if(lC.get(i) == '/')
                {
                    Double a = l.get(i);
                    Double b = l.get(i + 1);
                    l.remove(i + 1);
                    lC.remove(i);
                    l.set(i, a / b);
                    break;
                }
            }
        }
        i = 0;
        while (i < lC.size()) {
            for (i = 0; i < lC.size(); i++){
                if(lC.get(i) == 'x')
                {
                    Double a = l.get(i);
                    Double b = l.get(i + 1);
                    l.remove(i + 1);
                    lC.remove(i);
                    l.set(i, a * b);
                    break;
                }
            }
        }i = 0;
        while (i < lC.size()) {
            for (i = 0; i < lC.size(); i++){
                if(lC.get(i) == '+')
                {
                    Double a = l.get(i);
                    Double b = l.get(i + 1);
                    l.remove(i + 1);
                    lC.remove(i);
                    l.set(i, a + b);
                    break;
                }
            }
        }
        i = 0;
        while (i < lC.size()) {
            for (i = 0; i < lC.size(); i++){
                if(lC.get(i) == '-')
                {
                    Double a = l.get(i);
                    Double b = l.get(i + 1);
                    l.remove(i + 1);
                    lC.remove(i);
                    l.set(i, a - b);
                    break;
                }
            }
        }
        return l.get(0) + "";
    }
}
