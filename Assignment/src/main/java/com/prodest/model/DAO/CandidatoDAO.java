package com.prodest.model.DAO;
import com.prodest.model.Candidato;
import com.prodest.model.Concurso;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {
    EntityManager em;

    public CandidatoDAO() {
    }

    public Candidato findById(long id){
        Candidato c = new Candidato();
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            c = em.find(Candidato.class, id);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("Candidato não encontrado");
        } finally {
            em.close();
            return c;
        }
    }

    public void salvar(Candidato c){
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

    public Candidato findBycpf(String cpf){
        Candidato candidato = new Candidato();
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            Query consulta = em.createQuery("select distinct c from Candidato c where c.cpf =:cpf", Candidato.class)
                    .setParameter("cpf", cpf);
            candidato = (Candidato) consulta.getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException ex){
            System.out.println("Candidato não Encontrado");
            return null;
        }finally {
            em.close();
            return candidato;
        }
    }

    public List<Candidato> findByProfissao(long id_p){
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            em = EntityManegerDAO.getInstance().create();
            em.getTransaction().begin();
            Query consulta = em.createQuery("select distinct c from Candidato c join c.profissoes p where p.id =:id_p", Candidato.class)
                    .setParameter("id_p", id_p);
            candidatos = consulta.getResultList();
            em.getTransaction().commit();
        }catch (RollbackException ex){
            System.out.println("Candidato não existe");
        }
        finally {
            em.close();
            return candidatos;
        }
    }


}
