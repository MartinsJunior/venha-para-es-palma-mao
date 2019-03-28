package com.prodest;

import com.prodest.control.LoadFileToBDController;
import com.prodest.model.Concurso;
import com.prodest.model.DAO.ConcursoDAO;
import com.prodest.model.DAO.EntityManegerDAO;
import com.prodest.model.DAO.ProfissaoDAO;
import com.prodest.model.Profissao;
import com.prodest.model.TIPOARQUIVO;
import com.prodest.view.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    private static EntityManager em;
    public static void main(String[] args) {
        EntityManegerDAO.create();
        LoadFileForm loadFileForm = new LoadFileForm();
        loadFileForm.run(TIPOARQUIVO.CANDIDATO);
        loadFileForm.run(TIPOARQUIVO.CONCURSO);
        MainFrameMenu mainFrameMenu = new MainFrameMenu();
        mainFrameMenu.setVisible(true);
    }
}
