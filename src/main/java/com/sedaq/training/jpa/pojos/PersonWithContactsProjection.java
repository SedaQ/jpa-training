package com.sedaq.training.jpa.pojos;

import java.util.Set;

/**
 * @author Pavel Seda
 */
public class PersonWithContactsProjection {
    private Long idPerson;
    private String email;
    private String surname;
    private Set<ContactProjection> contacts;

    public PersonWithContactsProjection(Long idPerson, String email, String surname, Set<ContactProjection> contacts) {
        this.idPerson = idPerson;
        this.email = email;
        this.surname = surname;
        this.contacts = contacts;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<ContactProjection> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactProjection> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "PersonWithContactsProjection{" +
                "idPerson=" + idPerson +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
