package com.mertkandemir.bank.controller;

import com.mertkandemir.bank.dto.AccountDto;
import com.mertkandemir.bank.dto.CreateAccountRequest;
import com.mertkandemir.bank.dto.UpdateAccountRequest;
import com.mertkandemir.bank.service.AccountService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;


    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String id ){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAnAccount(@RequestBody CreateAccountRequest request) {
        return new ResponseEntity<>(accountService.createAccount(request), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAnAccount(@PathVariable String id,@RequestBody UpdateAccountRequest request) {
        return new ResponseEntity<>(accountService.updateAccount(id, request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<AccountDto> withdrawMoney(@PathVariable String id,@PathVariable Double amount){
        return ResponseEntity.ok(accountService.withdrawMoney(id,amount));

    }
    @PutMapping("/add/{id}/{amount}")
    public ResponseEntity<AccountDto> addMoney(@PathVariable String id,@PathVariable Double amount){
        return ResponseEntity.ok(accountService.addMoney(id,amount));

    }



}
