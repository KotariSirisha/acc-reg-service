package com.springboot.first.accregservice.controller;

import com.springboot.first.accregservice.entity.Account;
import com.springboot.first.accregservice.entity.Branch;
import com.springboot.first.accregservice.model.AccountDto;
import com.springboot.first.accregservice.model.BranchDto;
import com.springboot.first.accregservice.service.AccountService;
import com.springboot.first.accregservice.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchRegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(BranchRegistrationController.class);

    @Autowired
    private BranchService branchService;

    @GetMapping("/branches")
    public List<Branch> branches() {
        return branchService.getAllAccounts();
    }
    @PostMapping("/branches")
    public ResponseEntity<Branch> createBranch(@RequestBody BranchDto branchDto) {
        try {
            Branch branch = branchService.createBranch(branchDto);
            return new ResponseEntity<>(branch, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Exception occurred while creating Branch", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
