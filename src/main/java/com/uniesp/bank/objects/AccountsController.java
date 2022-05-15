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

    public boolean autenticar(String cpf, String senha) {

        List<BankAccounts> usuarios = repository.findAll();

        for (BankAccounts usuario : usuarios) {
            
            if (usuario.cpf.equals(cpf) && usuario.senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public BankAccounts getAccountByCPF(String cpf) {
        return repository.findByCpf(cpf);
    }

    public BankAccounts cadastrar(String nome, String cpf, String senha) {
        BankAccounts conta = new BankAccounts();
        conta.cpf = cpf;
        conta.nome = nome;
        conta.senha = senha;
        return repository.save(conta);
    }


}
