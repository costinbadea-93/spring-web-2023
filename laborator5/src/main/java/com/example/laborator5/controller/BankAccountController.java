package com.example.laborator5.controller;

import com.example.laborator5.dto.BankAccountRequest;
import com.example.laborator5.mapper.BankAccountMapper;
import com.example.laborator5.model.BankAccount;
import com.example.laborator5.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    public final BankAccountService bankAccountService;
    public final BankAccountMapper bankAccountMapper;

    public BankAccountController(BankAccountService bankAccountService, BankAccountMapper bankAccountMapper) {
        this.bankAccountService = bankAccountService;
        this.bankAccountMapper = bankAccountMapper;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<BankAccount>> bankAccounts() {
        return ResponseEntity.ok().body(bankAccountService.retrieveAllBankAccounts());
    }

    @GetMapping("/byName/{bankAccName}")
    public ResponseEntity<?> bankAccountByName(@PathVariable String bankAccName) {
        return ResponseEntity.ok().body(bankAccountService.findBankAccountByName(bankAccName));
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccount> newBankAccount(@RequestBody @Valid BankAccountRequest bankAccount) {
            return ResponseEntity.ok().body(
                    bankAccountService.addNewBankAccount(bankAccountMapper.convertRequestToBankAccount(bankAccount))
            );
    }
}
