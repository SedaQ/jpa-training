package com.sedaq.training.jpa.dao.impl;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.model.Person;
import com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection;

import javax.persistence.EntityGraph;
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

    @Override
    public List<Person> findAllPersonsWithAddresses() {
        TypedQuery<Person> persons = em.createQuery("SELECT p FROM Person p JOIN FETCH p.address", Person.class);
        return persons.getResultList();
    }

    @Override
    public List<Person> findAllPersonsInfoWithEntityGraph() {
        EntityGraph entityGraph = em.getEntityGraph("person-with-address");
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
        return persons;
    }

    @Override
    public List<PersonIdEmailSurnameCityProjection> findAllPersonsEmailSurnameCityProjection() {
        List<PersonIdEmailSurnameCityProjection> persons =
                em.createQuery("SELECT new com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection(p.id, p.email, p.surname, p.address.city) FROM Person p " +
                        "JOIN p.address")
                        .getResultList();
        return persons;
    }
}
