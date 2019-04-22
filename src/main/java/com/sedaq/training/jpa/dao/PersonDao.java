package com.sedaq.training.jpa.dao;

import com.sedaq.training.jpa.model.Person;

import java.util.List;

/**
 * @author Pavel Seda
 */
public interface PersonDao {

    Person getPersonById(Long id);

    List<Person> findAllPersons();
}
