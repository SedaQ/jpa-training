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
@Table(name = "contact_type")
public class ContactType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact_type", updatable = false, nullable = false)
    private Long idContactType;
    @Column(nullable = false, length = 45, unique = true)
    private String title;
    @OneToMany(targetEntity = Contact.class, mappedBy = "contactType")
    private Set<Contact> contacts = new HashSet<>();

    public ContactType() {
        // hibernate requires non-args constructor
    }

    public Long getIdContactType() {
        return idContactType;
    }

    public void setIdContactType(Long idContactType) {
        this.idContactType = idContactType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Contact> getContacts() {
        return Collections.unmodifiableSet(contacts);
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = new HashSet<>(contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ContactType))
            return false;
        ContactType other = (ContactType) obj;
        return Objects.equals(title, other.getTitle());
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "idContactType=" + idContactType +
                ", title='" + title + '\'' +
                '}';
    }
}
