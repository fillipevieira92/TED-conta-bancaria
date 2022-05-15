package com.uniesp.bank.objects;

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
public class BankAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long conta;
    String nome;
    int cpf;
    double saldo;
    String senha;
    
}
