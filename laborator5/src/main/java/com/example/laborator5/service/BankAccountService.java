package com.example.laborator5.service;

import com.example.laborator5.model.BankAccount;
import com.example.laborator5.repository.BankAccountJpaRepository;
import com.example.laborator5.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private static final Logger logger = LoggerFactory.getLogger(BankAccountService.class);

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountJpaRepository bankAccountJpaRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, BankAccountJpaRepository bankAccountJpaRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountJpaRepository = bankAccountJpaRepository;
    }

    public List<BankAccount> retrieveAllBankAccounts() {
//        List<BankAccount> bankAccountList = bankAccountRepository.findAllBankAccounts();
        List<BankAccount> bankAccountList = bankAccountJpaRepository.findAll();
        logger.info("Retrieve from repository: {}", bankAccountList);
        return bankAccountList;
    }

    public BankAccount addNewBankAccount(BankAccount bankAccount){
        logger.info("A new bank account: {}, has been added", bankAccount);
//        if(Objects.isNull(bankAccount.getAccountName())){
//            throw new RuntimeException("Bank Account name cannot be null!!1");
//        }
//        return bankAccountRepository.addNewBankAccount(bankAccount);
        return bankAccountJpaRepository.save(bankAccount);
    }

    public BankAccount findBankAccountByName(String bankAccountName){
        logger.info("Retrieving from repository bank account with name : {}", bankAccountName);
//        return bankAccountRepository.findBankAccountByName(bankAccountName);
      return  bankAccountJpaRepository.findBankAccountByAccountName(bankAccountName);
    }
}
