package com.rolan.examples.jpa;

import com.rolan.examples.jpa.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class App {

    public static void main(String... args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JpaBasicsTutorial");
        EntityManager em = emFactory.createEntityManager();

        Person person = new Person();
        em.getTransaction().begin();
        person.setName("Merry Jane");
        System.out.println("Before peprsist: " + person);
        em.persist(person);
        System.out.println("After peprsist: " + person);
        em.flush();
        System.out.println("After flush: " + person);
        em.getTransaction().commit();
        System.out.println("After commit: " + person);

        em.getTransaction().begin();
        person = em.find(Person.class, person.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        System.out.println("Founded person: " + person);
        em.getTransaction().commit();
        System.out.println("After commit: " + person);

        em.getTransaction().begin();
        person = em.find(Person.class, person.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        System.out.println("Founded person: " + person);
        em.flush();
        System.out.println("Founded person after flush: " + person);
        em.getTransaction().rollback();
        System.out.println("After rollback: " + person);

        em.getTransaction().begin();
        person = em.find(Person.class, person.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        System.out.println("Founded person: " + person);
        em.flush();
        System.out.println("Founded person after flush: " + person);
        em.getTransaction().commit();
        System.out.println("After flush and commit: " + person);
    }

}
