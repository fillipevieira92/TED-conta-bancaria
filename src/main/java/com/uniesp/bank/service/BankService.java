package com.uniesp.bank.service;

import java.util.ArrayList;

import com.uniesp.bank.controllers.AccountsController;
import com.uniesp.bank.model.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    
    @Autowired
    AccountsController accountsController;
    
    // Serviço responsável por autorizar o login.
    public ArrayList<BankAccount> auth(String cpf, String senha) {
        
        ArrayList<BankAccount> conta = new ArrayList<>();

        if (accountsController.authenticate(cpf, senha)) { 
            // Se estiver validado retorna a conta dentro da lista.
            conta.add(accountsController.getAccountByCPF(cpf));
        }

        return conta;
    }

    // Servico responsável por criar uma conta no banco.
    public void createAccount(String nome, String cpf, String senha) {
        accountsController.register(nome, cpf, senha);
    }

    // Serviço responsável por depositar dinheiro.

    // Serviço responsável por sacar dinheiro.

    // Serviço responsável por transferir dinheiro entre contas.

    // Serviço de busca por cpf ajax.

}
