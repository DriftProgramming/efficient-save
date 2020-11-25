package org.driftprogramming.efficientsave.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    //Accessors...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
