package com.example.laborator5.repository;

import com.example.laborator5.exceptionhandling.BankAccountNotFoundException;
import com.example.laborator5.model.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BankAccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(BankAccountRepository.class);

    private List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccountRepository() {
//        BankAccount b1 = new BankAccount(1,"000000501c5", "BankAcc501", "Saving account", 2000, "$");
//        BankAccount b2 = new BankAccount(2,"000000502c5", "BankAcc502", "Checking account", 4000, "RON");
//
//        bankAccountList.add(b1);
//        bankAccountList.add(b2);
    }


    public BankAccount addNewBankAccount(BankAccount bankAccount){
//        bankAccountList.add(bankAccount);
//        return bankAccount;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            String sql = "INSERT INTO bank_account(accountNumber, accountName, accountType, currency, balance) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,bankAccount.getAccountNumber());
            preparedStatement.setString(2,bankAccount.getAccountName());
            preparedStatement.setString(3,bankAccount.getAccountType());
            preparedStatement.setString(4,bankAccount.getCurrency());
            preparedStatement.setLong(5,bankAccount.getBalance());
            return preparedStatement;
        }, keyHolder);
        int generatedId =  keyHolder.getKey().intValue();
        logger.info("A new account with id {}, was added.", generatedId);
        bankAccount.setId(generatedId);
        return bankAccount;
    }

    public BankAccount findBankAccountByName(String bankAccountName){

//        return bankAccountList.stream()
//                .filter(bankAccount -> bankAccount.getAccountName().equalsIgnoreCase(bankAccountName))
//                .findFirst()
//                .orElseThrow(() -> new BankAccountNotFoundException("Bank Account for the given name was not found"));

        String sql = " select * from bank_account where accountName = ?";

        BankAccount bankAccount = jdbcTemplate.queryForObject(sql,(rs, rowNum) ->
                    new BankAccount(rs.getInt("id"),
                            rs.getString("accountNumber"),
                            rs.getString("accountName"),
                            rs.getString("accountType"),
                            rs.getLong("balance"),
                            rs.getString("currency")
                    ), bankAccountName);
        return bankAccount;
    }

    public List<BankAccount> findAllBankAccounts() {
//        return bankAccountList;
        String sql = " select * from bank_account";
        List<BankAccount> bankAccountList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new BankAccount(
                        rs.getInt("id"),
                        rs.getString("accountNumber"),
                        rs.getString("accountName"),
                        rs.getString("accountType"),
                        rs.getLong("balance"),
                        rs.getString("currency")
                    );
        });
        return bankAccountList;
    }
}
