package com.sedaq.training.jpa.dao;

import com.sedaq.training.jpa.model.Person;
import com.sedaq.training.jpa.pojos.PersonIdEmailSurnameCityProjection;
import com.sedaq.training.jpa.pojos.PersonWithContactsProjection;

import java.util.List;

/**
 * @author Pavel Seda
 */
public interface PersonDao {

    Person getPersonById(Long id);

    List<Person> findAllPersons();

    List<Person> findAllPersonsWithAddresses();

    List<Person> findAllPersonsInfoWithEntityGraph();

    List<Person> findAllPersonsWithAddressSelectively();

    List<PersonIdEmailSurnameCityProjection> findAllPersonsEmailSurnameCityProjection();

    List<PersonWithContactsProjection> findAllPersonsWithContacts();
}
