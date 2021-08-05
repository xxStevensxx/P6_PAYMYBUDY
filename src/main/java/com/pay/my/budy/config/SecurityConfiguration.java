package com.pay.my.budy.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JpaConfig dataSource;

	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource.getDataSource())
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username, password, enabled from users where username = ?")
			.authoritiesByUsernameQuery("select username, role from users where username = ?");
				
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/", "/home", "/transfert", "/contact "," /logout ").authenticated()
			.and()
			.formLogin()
			.loginPage("/signin")
			.permitAll();

	}
	
	
	@Override
	public void configure(WebSecurity web) {
		
		web.ignoring().antMatchers("/resources/**");
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}
}
