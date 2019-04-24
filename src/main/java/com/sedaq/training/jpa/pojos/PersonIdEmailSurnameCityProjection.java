package com.sedaq.training.jpa.pojos;

/**
 * @author Pavel Seda
 */
public class PersonIdEmailSurnameCityProjection {

    private Long idPerson;
    private String email;
    private String surname;
    private String city;

    public PersonIdEmailSurnameCityProjection(Long idPerson, String email, String surname, String city) {
        this.idPerson = idPerson;
        this.email = email;
        this.surname = surname;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonIdEmailSurnameCityProjection{" +
                "idPerson=" + idPerson +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
