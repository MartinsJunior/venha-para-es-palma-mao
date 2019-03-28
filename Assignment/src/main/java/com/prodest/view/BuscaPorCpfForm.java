package com.prodest.view;

import com.prodest.control.BuscaCpfController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class BuscaPorCpfForm {
    private BuscaCpfController controller;
    private JPanel JMainPanel;
    private JTable table1;
    private JButton button1;
    private JButton sairButton;
    private JFormattedTextField cpfTextField;
    private JPanel JTablePanel;
    private JFrame frame;
    private JScrollPane jScrollPane;


    public BuscaPorCpfForm() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfTextField.getText();
                controller.fillTable(cpf);
                }
        });
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void run() {
        frame = new JFrame("MainFrame");
        frame.setContentPane(this.JMainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        try{
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter(' ');
            cpfTextField = new JFormattedTextField(mascaraCpf);
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        table1 = new JTable();
        controller = new BuscaCpfController(table1);

    }
}
