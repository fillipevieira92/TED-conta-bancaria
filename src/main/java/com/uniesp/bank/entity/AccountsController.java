package com.uniesp.bank.entity;



import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class AccountsController {

    AccountsRepository repository;    
        
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    // Função para autenticar o login do usuário
    public boolean autenticar(String cpf, String senha) {
        
        List<BankAccount> usuarios = repository.findAll();
        for (BankAccount usuario : usuarios) {
            
            if (usuario.cpf.equals(cpf) && usuario.senha.equals(senha)) {
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
    public BankAccount depositar(String cpf, double valor) {
        BankAccount conta = repository.findByCpf(cpf);
        conta.saldo+=valor;
        repository.save(conta);        
        return conta;
    }

    // Sacar
    public BankAccount sacar(String cpf, double valor) {
        BankAccount conta = repository.findByCpf(cpf);
        conta.saldo-=valor;
        repository.save(conta);        
        return conta;
    }
    
    // Cadastra a conta.
    public BankAccount cadastrar(String nome, String cpf, String senha) {

        BankAccount conta = new BankAccount();

        conta.cpf = cpf;
        conta.nome = nome;
        conta.senha = senha;

        return repository.save(conta);
    }


}
