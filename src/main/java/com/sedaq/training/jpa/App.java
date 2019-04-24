package com.sedaq.training.jpa;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.dao.impl.PersonDaoImpl;
import com.sedaq.training.jpa.model.Person;
import com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PersonDao personDao = new PersonDaoImpl(entityManager);

        // find person by id
        Person person = personDao.getPersonById(5L);
        System.out.println(person);

        // find all persons
//        List<Person> persons = personDao.findAllPersonsInfoWithEntityGraph();
//        persons.forEach(p -> {
//            System.out.println(p.getEmail() + ":  has an  " +  p.getAddress());
//        });

        List<PersonIdEmailSurnameCityProjection> personsProjection = personDao.findAllPersonsEmailSurnameCityProjection();
        personsProjection.forEach(p -> {
            System.out.println(p.getEmail() + " lives in  " + p.getCity());
        });

    }
}
