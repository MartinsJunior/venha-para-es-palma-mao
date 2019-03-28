package com.prodest.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManegerDAO {
    private static EntityManagerFactory emf = null;
    private static EntityManager        em  = null;
    private static EntityManegerDAO ourInstance = new EntityManegerDAO();

    public static EntityManegerDAO getInstance() {
        return ourInstance;
    }
    private EntityManegerDAO() {
        emf = Persistence.createEntityManagerFactory("prodest");
        System.out.println("Factory = "+emf);
    }

    public static EntityManager create(){
        try{
            em = emf.createEntityManager();
        }catch(Exception e){
            System.out.println("Não conseguiu acesar o Banco ");
        }
        return em;
    }
}
