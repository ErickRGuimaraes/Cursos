package com.aplicacacao;

import javax.swing.text.html.parser.Entity;

import com.dominio.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p1 = new Pessoa(null, "Maria", "maria@gmail.com");

        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        Pessoa p = em.find(Pessoa.class, 2);
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto! ");
        
        em.close();
        emf.close();
    }
}
