package com.uniesp.bank.objects;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class AccountsController {

    
    AccountsRepository repository;
        
    public List<BankAccounts> getAllAccounts() {
        return repository.findAll();
    }

    public BankAccounts getAccountByCPF(int cpf) {
        return repository.findByCpf(cpf);
    }

    public BankAccounts cadastrar(BankAccounts conta) {
        return repository.save(conta);
    }


}
