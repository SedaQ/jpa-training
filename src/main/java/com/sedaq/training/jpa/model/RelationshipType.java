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
@Table(name = "relationship_type")
public class RelationshipType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relationship_type", updatable = false, nullable = false)
    private Long idRelationshipType;
    @Column(nullable = false, unique = true)
    private String title;
    @OneToMany(targetEntity = Relationship.class, mappedBy = "relationshipType")
    private Set<Relationship> relationships = new HashSet<>();

    public RelationshipType() {
        // hibernate requires non-args constructor
    }

    public Long getIdRelationshipType() {
        return idRelationshipType;
    }

    public void setIdRelationshipType(Long idRelationshipType) {
        this.idRelationshipType = idRelationshipType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Relationship> getRelationships() {
        return Collections.unmodifiableSet(relationships);
    }

    public void setRelationships(Set<Relationship> relationships) {
        this.relationships = new HashSet<>(relationships);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationshipType)) return false;
        RelationshipType that = (RelationshipType) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getTitle());
    }

    @Override
    public String toString() {
        return "RelationshipType{" +
                "idRelationshipType=" + idRelationshipType +
                ", title='" + title + '\'' +
                ", relationships=" + relationships +
                '}';
    }
}
