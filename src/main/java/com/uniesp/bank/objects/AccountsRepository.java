package com.uniesp.bank.objects;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<BankAccounts, Long>{

    BankAccounts findByCpf(int cpf);
    
}
