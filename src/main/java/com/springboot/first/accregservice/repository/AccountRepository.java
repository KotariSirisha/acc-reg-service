package com.springboot.first.accregservice.repository;

import com.springboot.first.accregservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByNameContaining(String name);

}
