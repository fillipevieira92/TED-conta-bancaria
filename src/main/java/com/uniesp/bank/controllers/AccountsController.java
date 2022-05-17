package com.uniesp.bank.controllers;

import java.util.List;

import com.uniesp.bank.model.BankAccount;
import com.uniesp.bank.repository.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class AccountsController {

    @Autowired
    BankAccountRepository repository;

    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    // Função para autenticar o login do usuário
    public boolean authenticate(String cpf, String senha) {

        List<BankAccount> usuarios = repository.findAll();
        for (BankAccount usuario : usuarios) {

            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }

    // Pesquisa por cpf
    public BankAccount getAccountByCPF(String cpf) {
        return repository.findByCpf(cpf);
    }

    // Depositar
    public BankAccount deposit(String cpf, double valor) {
        BankAccount conta = repository.findByCpf(cpf);
        conta.setSaldo(conta.getSaldo() + valor);
        repository.save(conta);
        return conta;
    }

    // Sacar
    public BankAccount withdraw(String cpf, double valor) {
        BankAccount conta = repository.findByCpf(cpf);
        conta.setSaldo(conta.getSaldo() - valor);
        repository.save(conta);
        
        return conta;
    }

    // Cadastra a conta.
    public BankAccount register(String nome, String cpf, String senha) {

        BankAccount conta = new BankAccount();

        conta.setCpf(cpf);
        conta.setNome(nome);
        conta.setSenha(senha);

        return repository.save(conta);
    }

}
