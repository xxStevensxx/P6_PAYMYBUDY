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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="users")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 6744559497724848173L;
	
	public User() {}
	
	
	public User(String username, String firstname, String name, LocalDate birthdate, String address, String email,
			String password, List<Relationship> friends, double moneyAvailable) {
		this.username = username;
		this.firstname = firstname;
		this.name = name;
		this.birthdate = birthdate;
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
	
	
	@Column(name="firstname")
	private String firstname;
	
	
	@Column(name="name")
	private String name;
	
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
	@Column(name="birthdate")
	private LocalDate birthdate;
	
	
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
	
	@OneToMany(mappedBy = "username")
	private List<Authority> authorities;

		 	
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

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}