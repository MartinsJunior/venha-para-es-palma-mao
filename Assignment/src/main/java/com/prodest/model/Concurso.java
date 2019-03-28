package com.prodest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concurso")
public class Concurso implements Serializable {
    private static final long serialVersionUD1 = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "orgao")
    private String orgao;
    @Column(name = "edital")
    private String edital;
    @Column(name = "codigoconcurso")
    private String codigoconcurso;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "concurso_profissao",
            joinColumns = @JoinColumn(name = "concurso_id"),
            inverseJoinColumns =@JoinColumn(name = "profissao_id"))
    private List<Profissao> profisoesconcurso = new ArrayList<Profissao>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public String getCodigoConcurso() {
        return codigoconcurso;
    }

    public void setCodigoConcurso(String codigoConcurso) {
        this.codigoconcurso = codigoConcurso;
    }

    public List<Profissao> getProfisoesconcurso() {
        return profisoesconcurso;
    }

    public void setProfisoesconcurso(List<Profissao> profisoesconcurso) {
        this.profisoesconcurso = profisoesconcurso;
    }
}
