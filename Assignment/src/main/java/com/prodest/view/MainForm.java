package com.prodest.view;

import javax.swing.*;

public class MainForm {


    private JPanel JMainPanel;

    public void run() {
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(this.JMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }



}
