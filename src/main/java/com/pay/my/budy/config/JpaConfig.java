package com.pay.my.budy.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
	
	@Bean
	DataSource getDataSource() {
		
		DataSource dataSource = null;
		
		DataSourceBuilder builder = DataSourceBuilder.create();
		
			builder.url("jdbc:mysql://localhost:3306/paymybudy");
			builder.username("root");
			builder.password("");
			builder.driverClassName("com.mysql.cj.jdbc.Driver");
			
			dataSource = builder.build();
			
				return dataSource;
		
	}

}
