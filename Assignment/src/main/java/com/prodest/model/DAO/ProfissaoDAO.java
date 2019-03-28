package com.prodest.model.DAO;

import com.prodest.model.Profissao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDAO {
    EntityManagerFactory emf;
    EntityManager em;
    public ProfissaoDAO() {
        em = EntityManegerDAO.getInstance().create();
    }

    public void salvar(Profissao p){
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch (RollbackException e){
            System.out.println("Profissão já está no BD");
        }finally {
            em.close();
        }
    }

    public List<Profissao> getAll(){
        List<Profissao> profissoes = new ArrayList<Profissao>();
        try{
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            Query consulta = em.createQuery("Select p from Profissao p");
            em.getTransaction().commit();
            profissoes = consulta.getResultList();
        }catch (RollbackException ex){
            System.out.println("Nenhuma Profissão cadastrada");
        }finally {
            em.close();
            return profissoes;
        }
    }
}
