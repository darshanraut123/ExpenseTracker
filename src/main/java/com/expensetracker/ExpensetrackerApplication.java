package com.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.expensetracker.controller","com.expensetracker.model","com.expensetracker.repository","com.expensetracker.security","com.expensetracker.service","com.expensetracker.dto"})
public class ExpensetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}


}
