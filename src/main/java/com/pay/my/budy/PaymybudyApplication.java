package com.pay.my.budy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableAutoConfiguration
@EnableJdbcHttpSession
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PaymybudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymybudyApplication.class, args);
	}

}
