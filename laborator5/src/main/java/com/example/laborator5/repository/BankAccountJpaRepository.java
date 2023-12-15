package com.example.laborator5.repository;

import com.example.laborator5.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountJpaRepository extends JpaRepository<BankAccount, Integer> {
    BankAccount findBankAccountByAccountName(String accountName);
}
