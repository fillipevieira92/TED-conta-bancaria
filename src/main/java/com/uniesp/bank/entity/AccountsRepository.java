package com.uniesp.bank.entity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<BankAccount, Long>{

    BankAccount findByCpf(String cpf);
    
}
