package org.driftprogramming.efficientsave.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BizOrder implements Serializable {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Id
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoSeqGen")
    //    @SequenceGenerator(name = "todoSeqGen", sequenceName = "todoSeq", initialValue = 1, allocationSize = 100000)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

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