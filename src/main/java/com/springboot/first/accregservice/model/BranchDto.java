package com.springboot.first.accregservice.model;

import com.springboot.first.accregservice.entity.Account;

import java.io.Serializable;

public class BranchDto implements Serializable {

    private String name;

    private String ifscCode;

    private String address;

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
