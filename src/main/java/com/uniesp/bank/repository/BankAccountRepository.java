package com.uniesp.bank.repository;

import com.uniesp.bank.model.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findByCpf(String cpf);
    

}
