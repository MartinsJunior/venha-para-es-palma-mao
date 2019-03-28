package com.prodest.view;

import com.prodest.control.CadastrarProfissaoController;
import com.prodest.model.DAO.ProfissaoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarProfissao {
    private JPanel JMainPanel;
    private JTable table1;
    private JButton adicionarButton;
    private JTextField textField1;
    private JFrame frame;
    private CadastrarProfissaoController controller;
    private ProfissaoDAO profissaoDAO;


    public CadastrarProfissao() {
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText();
                controller.salvar(nome);
            }
        });
    }

    public void run() {
        frame = new JFrame("Cadastro de Profissões");
        frame.setContentPane(this.JMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        table1 = new JTable();
        controller = new CadastrarProfissaoController(table1);

    }
}
