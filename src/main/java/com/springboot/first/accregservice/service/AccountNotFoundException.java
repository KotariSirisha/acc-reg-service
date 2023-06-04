package com.springboot.first.accregservice.service;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String s) {
        super(s);
    }
}
