package com.uniesp.bank.service;

import java.util.ArrayList;
import java.util.Map;

import com.uniesp.bank.controllers.AccountsController;
import com.uniesp.bank.dto.BankAccountDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    
    @Autowired
    AccountsController accountsController;
    
    // Serviço responsável por autorizar o login.
    public ArrayList<BankAccountDTO> auth(Map<String, String> body) {

        // Pegando os dados do form.
        String cpf = body.get("cpf");
        String senha = body.get("senha");
        
        ArrayList<BankAccountDTO> conta = new ArrayList<>();

        if (accountsController.authenticate(cpf, senha)) { 
            // Se estiver validado retorna a conta dentro da lista.
            conta.add(accountsController.getAccountByCPF(cpf));
        }

        return conta;
    }

    // Servico responsável por abrir uma conta no banco.
    public String openAccount(Map<String, String> body) {

        String msg;

        // Recebendo os dados do form registro.
        String nome = body.get("nome").toUpperCase();
        String cpf = body.get("cpf");
        String senha = body.get("senha");

        BankAccountDTO bankAccountDTO = accountsController.getAccountByCPF(cpf);

        if (bankAccountDTO.getNome() == null) {
            accountsController.register(nome, cpf, senha);
            msg = "Conta cadastrada com sucesso!";

        } else {

            msg = "CPF já possui cadastro.";

        }
        
        return msg;
    }

    // Serviço responsável por depositar dinheiro.
    public BankAccountDTO deposit(Map<String, String> body) {

        // Recebendo os dados do form deposito.
        String cpf = body.get("cpf");
        double valor = Double.parseDouble(body.get("valor"));

        return accountsController.deposit(cpf, valor);        
    }

    // Serviço responsável por sacar dinheiro.
    public BankAccountDTO withdraw(Map<String, String> body){

        // Recebendo os dados do form deposito.
        String cpf = body.get("cpf");
        double valor = Double.parseDouble(body.get("valor"));

        return accountsController.withdraw(cpf, valor);
    }

    // Serviço responsável por transferir dinheiro entre contas.
    public BankAccountDTO transfer(Map<String, String> body) {

        // Recebendo os dados do form deposito.
        String cpf = body.get("cpf");
        String cpfDestino = body.get("cpfDestino");
        double valor = Double.parseDouble(body.get("valor"));
        
        return accountsController.transfer(cpf, cpfDestino, valor);
    }

    // Serviço de busca por cpf ajax.
    public BankAccountDTO findCpf(Map<String, String> body) {

        // Recebendo os dados do ajax pesquisa por cpf.
        String cpf = body.get("cpf");
        
        return accountsController.getAccountByCPF(cpf);
    }
}
