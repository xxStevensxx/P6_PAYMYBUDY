package com.pay.my.budy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="users")
public class User implements UserDetails {
	

	public User() {}
	
	public User(String username, String name, LocalDate birthdate, String address, String email,
			String password, List<Relationship> friends, double moneyAvailable) {
		this.username = username;
		this.name = name;
		this.birthDate = birthdate;
		this.address = address;
		this.email = email;
		this.password = password;
		this.friends = friends;
	}
	

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
  

	@Column(name="username")
	private String username;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="birthdate")
	private LocalDate birthDate;
	
	
	@Column(name="address")
	private String address;
	
	
	@Email
	@Column(name="email")
	private String email;
	

	@Size(min = 2, max = 350, message = "Password must be between 2 and * caracteres")
	@Column(name="password")
	private String password;
		
	
	@OneToMany(cascade = CascadeType.ALL, 
							orphanRemoval = true,
							fetch = FetchType.EAGER,
							targetEntity = Relationship.class)
	@JoinColumn(name = "friend")
	private List<Relationship> friends = new ArrayList<Relationship>();


	private int active;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setFisrtName(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Relationship> getFriends() {
		return friends;
	}

	public void setFriends(List<Relationship> friends) {
		this.friends = friends;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}