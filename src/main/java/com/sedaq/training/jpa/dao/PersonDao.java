package com.sedaq.training.jpa.dao;

import com.sedaq.training.jpa.model.Person;

/**
 * @author Pavel Seda
 */
public interface PersonDao {

    Person getPersonById(Long id);
}