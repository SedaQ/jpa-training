package com.sedaq.training.jpa;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.dao.impl.PersonDaoImpl;
import com.sedaq.training.jpa.model.Person;
import com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection;
import com.sedaq.training.jpa.pojos.PersonWithContactsProjection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PersonDao personDao = new PersonDaoImpl(entityManager);

        // find person by id
        app.findPersonByIdNamedQuery(personDao, 5L);
        // find all persons
        app.findAllPersonsInfoWithEntityGraph(personDao);

    }

    private void findPersonById(PersonDao personDao, Long id) {
        Person person = personDao.getPersonById(id);
        System.out.println(person);
    }

    private void findPersonByIdNamedQuery(PersonDao personDao, Long id) {
        Person person = personDao.getPersonByIdNamedQuery(id);
        System.out.println(person);
    }

    private void findAllNativeQuery(PersonDao personDao) {
        List<Person> persons = personDao.findAllNativeQuery();
        persons.forEach(p -> {
            System.out.println(p.getEmail() + ":  has an  " + p.getAddress());
        });
    }

    private void findAllPersonsInfoWithEntityGraph(PersonDao personDao) {
        List<Person> persons = personDao.findAllPersonsInfoWithEntityGraph();
        persons.forEach(p -> {
            System.out.println(p.getEmail() + ":  has an  " + p.getAddress());
        });
    }

    private void findAllPersonsEmailSurnameCityProjection(PersonDao personDao) {
        List<PersonIdEmailSurnameCityProjection> personsProjection = personDao.findAllPersonsEmailSurnameCityProjection();
        personsProjection.forEach(p -> {
            System.out.println(p.getEmail() + " lives in  " + p.getCity());
        });
    }

    private void findAllPersonsWithContacts(PersonDao personDao) {
        List<PersonWithContactsProjection> personsProjection = personDao.findAllPersonsWithContacts();
        personsProjection.forEach(p -> {
            System.out.println(p.getEmail() + " lives in  " + " and has contacts: " + p.getContacts());
        });
    }

    private void findAllPersonsWithAddressSelectively(PersonDao personDao) {
        List<Person> personsSelectResponse = personDao.findAllPersonsWithAddressSelectively();
        personsSelectResponse.forEach(p -> {
            System.out.println(p);
        });
    }


}
