package com.prodest.model;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {
    private static final long serialVersionUD1 = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "profissoes")
    private List<Candidato> candidatos = new ArrayList<Candidato>();

    @ManyToMany(mappedBy = "profisoesconcurso")
    private List<Concurso> concursos = new ArrayList<Concurso>();
//
        public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Profissao() {
    }


    public Profissao(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
