package com.ps.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoansApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoansApplication.class, args);
		System.out.println("Loans Application Running");
	}
}
