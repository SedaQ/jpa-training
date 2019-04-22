package com.sedaq.training.jpa;

import com.sedaq.training.jpa.dao.PersonDao;
import com.sedaq.training.jpa.dao.impl.PersonDaoImpl;
import com.sedaq.training.jpa.model.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-training");

        PersonDao personDao = new PersonDaoImpl(entityManagerFactory);
        Person person = personDao.getPersonById(5L);
        System.out.println(person);
    }
}
