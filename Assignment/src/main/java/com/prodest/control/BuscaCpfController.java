package com.prodest.control;

import com.prodest.model.*;
import com.prodest.model.DAO.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BuscaCpfController {
ConcursoTableModel concursoTableModel;
List<Concurso> concursos = new ArrayList<Concurso>();
CandidatoDAO candidatoDAO;
ConcursoDAO concursoDAO;

    public BuscaCpfController(JTable table1) {
        candidatoDAO = new CandidatoDAO();
        concursoDAO = new ConcursoDAO();
        concursoTableModel = new ConcursoTableModel();
        table1.setModel(concursoTableModel);
    }

    public void fillTable(String cpf) {
        concursoTableModel.clear();
        Candidato candidato = candidatoDAO.findBycpf(cpf);
        for (Profissao profissao :
                candidato.getProfissoes()) {
            List<Concurso> concursos = concursoDAO.findByProfissao(profissao.getId());
            for (Concurso concurso :
                    concursos) {
                concursoTableModel.adicionar(concurso);
            }
        }
    }

    public void clearTable(){

    }
}
