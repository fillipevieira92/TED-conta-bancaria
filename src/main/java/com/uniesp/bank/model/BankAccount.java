package com.uniesp.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int numConta;
    String nome;
    String cpf;
    double saldo;
    String senha;

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

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

} 
