package com.springboot.first.accregservice.service;

import com.springboot.first.accregservice.entity.Branch;
import com.springboot.first.accregservice.model.BranchDto;
import com.springboot.first.accregservice.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllAccounts() {
        return branchRepository.findAll();
    }

    public Branch createBranch(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setAddress(branchDto.getAddress());
        branch.setIfscCode(branchDto.getIfscCode());
        branch.setName(branchDto.getName());
        Branch branch1 = branchRepository.save(branch);
        logger.info("Account created successfully => {}", branchDto.getIfscCode());
        return branch1;
    }
}
