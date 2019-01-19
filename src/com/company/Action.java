package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.company.Display.*;
import com.company.*;

import javax.swing.event.ChangeListener;

public class Action implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String t = actionEvent.getActionCommand();
        if (Character.isDigit(t.charAt(0))) {
            if (t.equals("0") && r.length() == 1)
                return;
            if(r.length() == 1 && r.equals("0"))
                r = "";
            r += t;
        }
        if (t.equals("C")) {
            String str = "";
            for (int i = 0; i < r.length() - 1; i++)
                str += r.charAt(i);
            r = str;
            if(r.length() == 0) r = "0";
        }
        label.setText(r);
    }
}
