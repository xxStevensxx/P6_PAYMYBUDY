package com.pay.my.budy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pay.my.budy.model.Bankaccount;

public interface BankaccountRepository extends JpaRepository<Bankaccount, Integer> {

}
