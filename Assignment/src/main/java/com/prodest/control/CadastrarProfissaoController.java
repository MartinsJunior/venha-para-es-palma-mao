package com.prodest.control;

import com.prodest.model.DAO.ProfissaoDAO;
import com.prodest.model.Profissao;
import com.prodest.model.ProfissaoTableModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastrarProfissaoController {
    private ProfissaoTableModel profissaoTableModel;
    private ProfissaoDAO profissaoDAO;
    public CadastrarProfissaoController(JTable table1) {
        profissaoDAO = new ProfissaoDAO();
        profissaoTableModel = new ProfissaoTableModel();
        table1.setModel(profissaoTableModel);
        fillTable();
    }
    
    private void fillTable(){
        profissaoTableModel.clear();
        List<Profissao> profissoes = new ArrayList<Profissao>();
        profissoes = profissaoDAO.getAll();
        for (Profissao profissao :
                profissoes) {
            profissaoTableModel.adicionar(profissao);
        }
    }

    public void salvar(String nome) {
        Profissao profissao = new Profissao();
        profissao.setNome(nome);
        profissaoDAO.salvar(profissao);
        fillTable();
    }
}
