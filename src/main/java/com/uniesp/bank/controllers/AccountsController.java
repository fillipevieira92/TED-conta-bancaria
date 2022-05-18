package com.uniesp.bank.controllers;

import java.util.List;

import com.uniesp.bank.dto.BankAccountDTO;
import com.uniesp.bank.model.BankAccount;
import com.uniesp.bank.repository.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountsController {

    @Autowired
    BankAccountRepository repository;

    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    // Função para autenticar o login do usuário.
    public boolean authenticate(String cpf, String senha) {
        
        // Pegando todos os usuarios e iterando.
        List<BankAccount> usuarios = repository.findAll();
        for (BankAccount usuario : usuarios) {
            // Procurando o usuario com cpf e senha igual aos dados de entrada.
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }

    // Pesquisa por cpf
    public BankAccountDTO getAccountByCPF(String cpf) {

        BankAccount conta = repository.findByCpf(cpf);

        // Preparando o DTO.
        BankAccountDTO contaDTO = new BankAccountDTO();

        if (!(conta == null)){
            contaDTO.setAccountOriginDTO(conta);
        }

        return contaDTO;
    }

    // Depositar
    public BankAccountDTO deposit(String cpf, double valor) {

        // Pegando a conta no banco de dados, alterando o saldo e salvando.
        BankAccount conta = repository.findByCpf(cpf);
        conta.setSaldo(conta.getSaldo() + valor);
        repository.save(conta);
        
        // Preparando o DTO.
        BankAccountDTO contaDTO = new BankAccountDTO();
        contaDTO.setAccountOriginDTO(conta);
        

        return contaDTO;
    }

    // Sacar
    public BankAccountDTO withdraw(String cpf, double valor) {

        // Pegando a conta no banco de dados alterando o saldo e salvando.
        BankAccount conta = repository.findByCpf(cpf);
        conta.setSaldo(conta.getSaldo() - valor);
        repository.save(conta);
        
        // Preparando o DTO.
        BankAccountDTO contaDTO = new BankAccountDTO();
        contaDTO.setAccountOriginDTO(conta);
        
        return contaDTO;
    }

    // Transferir
    public BankAccountDTO transfer(String cpf, String cpfDestino, double valor) {

        // Pegando as contas de origem e destino. e salvando.
        BankAccount contaOrigem = repository.findByCpf(cpf);
        BankAccount contaDestino = repository.findByCpf(cpfDestino);

        // Alterando o saldo com o valor.
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        // Salvando.
        repository.save(contaOrigem);
        repository.save(contaDestino);
        
        // Preparando o DTO.
        BankAccountDTO contaDTO = new BankAccountDTO();
        contaDTO.setAccountOriginDTO(contaOrigem);

        return contaDTO;
    }

    // Cadastra a conta.
    public void register(String nome, String cpf, String senha) {

        // Criando uma nova clase BankAccount
        BankAccount conta = new BankAccount();

        // Criando numero da conta.
        int numConta = generateAccountNumber();

        // Setando os valores
        conta.setCpf(cpf);
        conta.setNome(nome);
        conta.setSenha(senha);
        conta.setNumConta(numConta);

        // Salvando no banco.
        repository.save(conta);
    }

    public int generateAccountNumber(){
        
        int numConta;
        
        // Pegando todas as contas.
        List<BankAccount> contas = repository.findAll();
        if (!contas.isEmpty()){
            // Se existir conta, pegar o numero da ultima conta e incrementar mais um.
            numConta = (contas.get(contas.size()-1).getNumConta() + 1);

        } else {
            // Caso nao exista nenhuma conta, a primeira será de numero 1111.
            numConta = 1111;
        }
        
        return numConta;
    }

}
