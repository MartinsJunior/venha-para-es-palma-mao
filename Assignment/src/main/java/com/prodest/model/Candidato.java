package com.prodest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {
    private static final long serialVersionUD1 = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private String datanascimento;
    @Column(name = "cpf")
    private String cpf;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "candidato_profissao",
            joinColumns = @JoinColumn(name = "candidato_id"),
            inverseJoinColumns =@JoinColumn(name = "profissao_id"))
    List<Profissao> profissoes = new ArrayList<Profissao>();
//
    public List<Profissao> getProfissoes() {
        return profissoes;
    }

    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }

    public String getCpf() {
        return cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long idCandidato) {
        this.id = idCandidato;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
}
