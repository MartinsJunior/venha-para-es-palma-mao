package com.prodest.view;

import com.prodest.control.BuscaCodigoController;
import com.prodest.control.BuscaCpfController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class BuscaPorCodigo {
    private JPanel JMainPanel;
    private  BuscaCodigoController controller;
    private JTextField codigoTextField;
    private JButton procurarButton;
    private JButton sairButton;
    private JTable table1;
    private JFrame frame;

    public BuscaPorCodigo() {
        procurarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoTextField.getText();
                controller.fillTable(codigo);
            }
        });
    }

    private void createUIComponents() {
        table1 = new JTable();
        controller = new BuscaCodigoController(table1);
    }
    public void run() {
        frame = new JFrame("MainFrame");
        frame.setContentPane(this.JMainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
