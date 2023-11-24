package com.example.laborator5.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//DTO => DATA TRANSFER OBJECT
//DAO => DATA ACCESS OBJECT

public class BankAccountRequest {

    @NotNull(message = "Account number name cannot be null!!")
    @NotBlank(message = "Account number name cannot be blank!!")
    private String accountNumber;
    @NotNull(message = "Bank Account name cannot be null!!")
    @NotBlank(message = "Bank Account name cannot be blank!!")
    private String accountName;
    @NotNull(message = "Bank Account type cannot be null!!")
    @NotBlank(message = "Bank Account type cannot be blank!!")
    private String accountType;
    @Min(message = "balance cannot be lower than 100", value = 100)
    private long balance;
    @NotNull(message = "Currency name cannot be null!!")
    @NotBlank(message = "Currency name cannot be blank!!")
    private String currency;

    public BankAccountRequest(String accountNumber, String accountName, String accountType, long balance, String currency) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
