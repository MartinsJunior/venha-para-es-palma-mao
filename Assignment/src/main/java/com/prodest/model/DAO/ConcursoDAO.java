package com.prodest.model.DAO;

import com.prodest.model.Candidato;
import com.prodest.model.Concurso;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAO {
    EntityManager em;
    public void salvar(Concurso c){
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch (RollbackException e){
            System.out.println("Candidato já está no BD");
        }finally {
            em.close();
        }
    }

    public Concurso findByCodigo(String codigo_id){
        Concurso concurso = new Concurso();
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            Query consulta = em.createQuery("select distinct con from Concurso con where con.codigoconcurso =:codigo", Concurso.class)
                    .setParameter("codigo", codigo_id);
            concurso = (Concurso) consulta.getSingleResult();
            em.getTransaction().commit();
        }catch (RollbackException ex){
            System.out.println("Concurso não encontrado");
        }finally {
            em.close();
            return concurso;

        }
    }

    public List<Concurso> findByProfissao(long id_p){
        List<Concurso> concursos = new ArrayList<Concurso>();
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            Query consulta = em.createQuery("select distinct c from Concurso c join c.profisoesconcurso p where p.id =:id_p", Concurso.class)
                    .setParameter("id_p", id_p);
            concursos = consulta.getResultList();
            em.getTransaction().commit();
        }catch (RollbackException ex){
            System.out.println("Profissao não cadastrada em concursos");
        }finally {
            em.close();
            return concursos;
        }
    }
}