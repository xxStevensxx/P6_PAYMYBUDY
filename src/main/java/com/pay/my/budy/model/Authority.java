package com.pay.my.budy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String username;
	
	@Column
	private String authority;

	@Override
	public String getAuthority() {
		
		return  authority;
	}

}
