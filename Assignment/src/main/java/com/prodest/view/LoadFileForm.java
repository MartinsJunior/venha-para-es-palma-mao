package com.prodest.view;

import com.prodest.control.LoadFileToBDController;
import com.prodest.model.TIPOARQUIVO;

import javax.swing.*;

public class LoadFileForm {
    private JPanel JMainPanel;
    private JProgressBar progressBar1;
    private JLabel jLabel1;
    private JFrame frame;
    private LoadFileToBDController loadFileToBDController;

    public LoadFileForm() {
        loadFileToBDController = new LoadFileToBDController();
    }

    private void loadFile(TIPOARQUIVO tp){
        if(tp.equals(TIPOARQUIVO.CANDIDATO)){
            jLabel1.setText("Carregando o arquivo de Candidatos...");
            progressBar1.setMaximum(9999);
            loadFileToBDController.loadFile("candidatos.txt",tp,progressBar1);
        }
        if(tp.equals(TIPOARQUIVO.CONCURSO)){
            jLabel1.setText("Carregando o arquivo de Concursos...");
            progressBar1.setMaximum(999);
            loadFileToBDController.loadFile("concursos.txt",tp,progressBar1);
        }
        frame.dispose();
    }
    public void run(TIPOARQUIVO tp) {
        frame = new JFrame("MainFrame");
        frame.setContentPane(this.JMainPanel);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(230,35);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loadFile(tp);
    }


}
