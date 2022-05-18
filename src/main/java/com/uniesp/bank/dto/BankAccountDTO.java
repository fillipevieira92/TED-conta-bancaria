package com.uniesp.bank.dto;

import com.uniesp.bank.model.BankAccount;


public class BankAccountDTO {    
    
    Long id;
    int numConta;
    String cpf;
    String nome;
    double saldo;

    public void setAccountOriginDTO(BankAccount conta) {
        
        this.numConta = conta.getNumConta();
        this.nome = conta.getNome();
        this.cpf = conta.getCpf();
        this.saldo = conta.getSaldo();

    }

    public void setAccountDestinyDTO(BankAccount conta) {
    
        this.numConta = conta.getNumConta();
        this.nome = conta.getNome();
        this.cpf = conta.getCpf();
        this.saldo = 0;

    }

    public int getNumConta(){
        return this.numConta;
    }

    public void setNumConta(int numConta){
        this.numConta = numConta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double valor){
        this.saldo = valor;        
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


}
