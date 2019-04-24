package com.sedaq.training.jpa.pojos;

import javax.persistence.Column;

/**
 * @author Pavel Seda
 */
public class ContactProjection {

    private Long idContact;
    private String contact;

    public ContactProjection(){

    }

    public ContactProjection(Long idContact, String contact) {
        this.idContact = idContact;
        this.contact = contact;
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

    @Override
    public String toString() {
        return "ContactProjection{" +
                "idContact=" + idContact +
                ", contact='" + contact + '\'' +
                '}';
    }
}
