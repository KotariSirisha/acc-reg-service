package com.springboot.first.accregservice.service;

import com.springboot.first.accregservice.entity.Account;
import com.springboot.first.accregservice.model.AccountDto;
import com.springboot.first.accregservice.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAllAccountsByName(String name) {
        return accountRepository.findByNameContaining(name);
    }


    public Account saveAccount(final AccountDto accountDto) {
        Account account = new Account(generateAccountNumber());
        account.setAddress(accountDto.getAddress());
        account.setBranch(accountDto.getBranch());
        account.setEmail(accountDto.getEmail());
        account.setName(accountDto.getName());
        account.setIsactivated(false);
        Account account1 = accountRepository.save(account);
        logger.debug("Account created successfully => {}", account.getId());
        return account1;
    }

    public static Long generateAccountNumber() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return new Long(String.format("%06d", number));
    }


    public Account activateAccount(long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            account.get().setIsactivated(true);
            accountRepository.save(account.get());
        } else {
            throw new AccountNotFoundException("Account not found with ID" + id);
        }
        return account.get();
    }

    public Account updateAccount(long id, AccountDto accountDto) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            account.get().setEmail(accountDto.getEmail());
            account.get().setAddress(accountDto.getAddress());
            accountRepository.save(account.get());
        } else {
            throw new AccountNotFoundException("Account not found with ID" + id);
        }
        return account.get();
    }

    public Account deactivateAccount(long accNum) {
        Optional<Account> account = accountRepository.findById(accNum);
        if (account.isPresent()) {
            account.get().setIsactivated(false);
            accountRepository.save(account.get());
        } else {
            throw new AccountNotFoundException("Account not found with ID" + accNum);
        }
        return account.get();
    }
}
