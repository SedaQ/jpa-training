package com.sedaq.training.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Pavel Šeda
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact", updatable = false, nullable = false)
    private Long idContact;
    @Column(nullable = false, length = 45)
    private String contact;
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "id_contact_type")
    private ContactType contactType;

    public Contact() {
        // hibernate requires non-args constructor
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact1 = (Contact) o;
        return Objects.equals(getContact(), contact1.getContact()) &&
                Objects.equals(getContactType(), contact1.getContactType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContact(), getContactType());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "idContact=" + idContact +
                ", contact='" + contact + '\'' +
                ", person=" + person +
                '}';
    }
}
