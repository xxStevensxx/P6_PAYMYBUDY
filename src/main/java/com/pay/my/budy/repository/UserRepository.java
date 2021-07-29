package com.pay.my.budy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pay.my.budy.model.User;

public interface UserRepository extends JpaRepository<User, Integer > {
	
	User findByUserName(String username);

}
