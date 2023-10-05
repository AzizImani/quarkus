
package org.agoncal.fascicle.quarkus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(length = 100)
    protected String title;
    @Column(length = 3000)
    protected String description;
    @Column(name = "unit_cost")
    protected Float unitCost;
    // Constructors, getters, setters
}