package com.pay.my.budy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.my.budy.model.Relationship;

@Repository
public interface RelationShipRepository extends JpaRepository<Relationship, Integer> {

}
