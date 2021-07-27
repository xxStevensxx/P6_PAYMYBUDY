package com.pay.my.budy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pay.my.budy.model.User;

public interface UserRepository extends JpaRepository<User, Integer > {
	
	User findByUserName(String username);

}
