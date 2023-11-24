package com.example.laborator5.service;

import com.example.laborator5.model.BankAccount;
import com.example.laborator5.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BankAccountService {
    private static final Logger logger = LoggerFactory.getLogger(BankAccountService.class);

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> retrieveAllBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAllBankAccounts();
        logger.info("Retrieve from repository: {}", bankAccountList);
        return bankAccountList;
    }

    public BankAccount addNewBankAccount(BankAccount bankAccount){
        logger.info("A new bank account: {}, has been added", bankAccount);
//        if(Objects.isNull(bankAccount.getAccountName())){
//            throw new RuntimeException("Bank Account name cannot be null!!1");
//        }
        return bankAccountRepository.addNewBankAccount(bankAccount);
    }

    public BankAccount findBankAccountByName(String bankAccountName){
        logger.info("Retrieving from repository bank account with name : {}", bankAccountName);
        return bankAccountRepository.findBankAccountByName(bankAccountName);
    }
}
