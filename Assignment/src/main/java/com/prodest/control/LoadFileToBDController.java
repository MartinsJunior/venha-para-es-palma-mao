package com.prodest.control;

import com.prodest.model.Candidato;
import com.prodest.model.Concurso;
import com.prodest.model.DAO.CandidatoDAO;
import com.prodest.model.DAO.ConcursoDAO;
import com.prodest.model.DAO.ProfissaoDAO;
import com.prodest.model.Profissao;
import com.prodest.model.TIPOARQUIVO;

import javax.persistence.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadFileToBDController {
    List<String> cadastrados = new ArrayList<String>();
    public void loadFile(String path, TIPOARQUIVO tp, JProgressBar jProgressBar) {
        try {
            int z = 0;
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (br.ready()) {
                jProgressBar.setValue(z++);
                String linha = br.readLine();
                String[] textoSeparado = linha.split("\\[");
                String profissoes = textoSeparado[1].replaceAll("\\]", "");
                List<Profissao> listaProfissoes = getListaProfissoes(profissoes);
                if (tp.equals(TIPOARQUIVO.CANDIDATO)) {
                    CandidatoDAO candidatoDAO = new CandidatoDAO();
                    Candidato candidato = getCandidato(textoSeparado[0]);
                    candidato.setProfissoes(listaProfissoes);
                    candidatoDAO.salvar(candidato);
                }
                if(tp.equals(TIPOARQUIVO.CONCURSO)){
                    ConcursoDAO concursoDAO = new ConcursoDAO();
                    Concurso concurso = getConcurso(textoSeparado[0]);
                    concurso.setProfisoesconcurso(listaProfissoes);
                    concursoDAO.salvar(concurso);
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private Candidato getCandidato(String texto) {
        Candidato candidato = new Candidato();
        int tamanhoDaSobra = texto.length();
        int tamanhoCpf = 16;
        int tamanhoData = 10;
        String cpf = texto.substring(tamanhoDaSobra - tamanhoCpf).trim();
        String data = texto.substring(tamanhoDaSobra - (tamanhoCpf + tamanhoData), tamanhoDaSobra - tamanhoCpf).trim();
        String nomeCompleto = texto.substring(0, tamanhoDaSobra - (tamanhoCpf + tamanhoData));
        candidato.setNome(nomeCompleto);
        candidato.setDatanascimento(data);
        candidato.setCpf(cpf);
        return candidato;
    }

    private Concurso getConcurso(String texto){
//        SEDU 9/2016 61828450843 [carpinteiro, analista de sistemas, marceneiro]
        Concurso concurso = new Concurso();
        int tamanhoDaSobra = texto.length();
        int tamanhoCodigoConcurso = 12;
        int tamanhoEdital = 8;
        String codigoConcurso = texto.substring(tamanhoDaSobra - tamanhoCodigoConcurso).trim();
        String edital = texto.substring(tamanhoDaSobra - (tamanhoCodigoConcurso + tamanhoEdital), tamanhoDaSobra - tamanhoCodigoConcurso).trim();
        String orgao = texto.substring(0, tamanhoDaSobra - (tamanhoCodigoConcurso + tamanhoEdital));
        concurso.setOrgao(orgao);
        concurso.setEdital(edital);
        concurso.setCodigoConcurso(codigoConcurso);
        return concurso;
    }

    private List<Profissao> getListaProfissoes(String profissoes) {
        List<Profissao> listaProfissoes = new ArrayList<Profissao>();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        String[] profissoesSeparadas = profissoes.split(",");

        for (int i = 0; i < profissoesSeparadas.length; i++) {
            Profissao profissao = new Profissao();
            String novaProfisao = profissoesSeparadas[i].trim();
            if (cadastrados.contains(novaProfisao)) {
                int idProfissao = cadastrados.indexOf(novaProfisao);
                profissao.setId(idProfissao + 1);
                listaProfissoes.add(profissao);
            } else {
                Profissao p = new Profissao(novaProfisao);
                profissaoDAO.salvar(p);
                cadastrados.add(novaProfisao);
                int idProfissao = cadastrados.indexOf(novaProfisao);
                profissao.setId(idProfissao + 1);
                listaProfissoes.add(profissao);
            }
        }
        return listaProfissoes;
    }
}
