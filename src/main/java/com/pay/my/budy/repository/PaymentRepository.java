package com.pay.my.budy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pay.my.budy.model.Transactions;

public interface PaymentRepository extends JpaRepository<Transactions, Integer> {

}
