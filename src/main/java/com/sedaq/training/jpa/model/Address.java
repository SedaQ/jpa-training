package com.sedaq.training.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pavel Šeda
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", updatable = false, nullable = false)
    private Long idAddress;
    @Column(nullable = false, length = 45)
    private String city;
    @Column(nullable = false, length = 45)
    private String street;
    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;
    @Column(name = "zip_code", nullable = true, length = 45)
    private String zipCode;
    @OneToMany(targetEntity = Person.class, mappedBy = "address")
    private Set<Person> persons = new HashSet<>();

    public Address() {
        //hibernate requires non-args constructor
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Person> getPersons() {
        return Collections.unmodifiableSet(persons);
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getHouseNumber(), getStreet(), getZipCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getHouseNumber(), address.getHouseNumber()) &&
                Objects.equals(getZipCode(), address.getZipCode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", zipCode='" + zipCode + '\'' +
                ", persons=" + persons +
                '}';
    }
}
