package com.prodest.control;

import com.prodest.model.*;
import com.prodest.model.DAO.CandidatoDAO;
import com.prodest.model.DAO.ConcursoDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BuscaCodigoController {
CandidatoTableModel candidatoTableModel;
List<Concurso> concursos = new ArrayList<Concurso>();
CandidatoDAO candidatoDAO;
ConcursoDAO concursoDAO;

    public BuscaCodigoController(JTable table1) {
        candidatoDAO = new CandidatoDAO();
        concursoDAO = new ConcursoDAO();
        candidatoTableModel = new CandidatoTableModel();
        table1.setModel(candidatoTableModel);
    }

    public void fillTable(String codigo) {
        candidatoTableModel.clear();
        Concurso concurso = concursoDAO.findByCodigo(codigo);
        for (Profissao profissao :
                concurso.getProfisoesconcurso()) {
            List<Candidato> candidatos = candidatoDAO.findByProfissao(profissao.getId());
            for (Candidato candidato :
                    candidatos) {
                candidatoTableModel.adicionar(candidato);
            }
        }
    }
}
