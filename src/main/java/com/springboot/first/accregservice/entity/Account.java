package com.springboot.first.accregservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ACC_NAME", length = 500, nullable = false)
    private String name;

    @Column(name = "ACC_ADDRESS", length = 1000)
    private String address;

    @Column(name = "ACC_BRANCH", length = 100, nullable = false)
    private String branch;

    @Column(name = "ACC_EMAIL", length = 200)
    private String email;

    @Column(name = "IS_ACTIVATED")
    private Boolean isactivated;

    public Account() {
    }

    public Account(Long accNum) {
        this.id = accNum;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Boolean getIsactivated() {
        return isactivated;
    }

    public void setIsactivated(Boolean isactivated) {
        this.isactivated = isactivated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
