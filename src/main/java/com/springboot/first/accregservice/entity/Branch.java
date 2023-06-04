package com.springboot.first.accregservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BRANCH")
public class Branch implements Serializable {

    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 500, nullable = false)
    private String name;

    @Column(name = "IFSC_cODE", length = 500, nullable = false, unique = true)
    private String ifscCode;

    @Column(name = "ADDRESS", length = 1000)
    private String address;

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

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
