package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankAccountApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BankAccountApplication.class, args);

	}

}
