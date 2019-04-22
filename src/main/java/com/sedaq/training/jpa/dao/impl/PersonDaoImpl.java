package com.sedaq.training.jpa.dao.impl;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Pavel Seda
 */
public class PersonDaoImpl implements PersonDao {

    private EntityManager em;

    public PersonDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.em = entityManagerFactory.createEntityManager();
    }

    @Override
    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }
}
