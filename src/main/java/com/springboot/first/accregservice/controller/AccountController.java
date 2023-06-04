package com.springboot.first.accregservice.controller;

import com.springboot.first.accregservice.entity.Account;
import com.springboot.first.accregservice.model.AccountDto;
import com.springboot.first.accregservice.service.AccountService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> accounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto) {
        try {
            Account account1 = accountService.saveAccount(accountDto);
            return new ResponseEntity<>(account1, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Exception occurred while creating account", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accounts/activate/{accNum}")
    public ResponseEntity<Account> activateAccount(@PathVariable("accNum") long accNum) {
        try {
            Account account1 = accountService.activateAccount(accNum);
            return new ResponseEntity<>(account1, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while activating account", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/accounts/deactivate/{accNum}")
    public ResponseEntity<Account> deactivateAccount(@PathVariable("accNum") long accNum) {
        try {
            Account account1 = accountService.deactivateAccount(accNum);
            return new ResponseEntity<>(account1, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while activating account", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody AccountDto accountDto) {
        try {
            Account account1 = accountService.updateAccount(id, accountDto);
            return new ResponseEntity<>(account1, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while updating account", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
