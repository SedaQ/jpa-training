package com.sedaq.training.jpa.dao.impl;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Pavel Seda
 */
public class PersonDaoImpl implements PersonDao {

    private EntityManager em;

    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAllPersons() {
        TypedQuery<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class);
        return persons.getResultList();
    }
}
