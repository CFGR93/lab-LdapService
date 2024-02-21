package com.LdapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
	public class LdapServiceApplication implements CommandLineRunner {
	@Autowired
	private LdapService ldapService;

	public static void main(String[] args) {
		SpringApplication.run(LdapServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			//ldapService.cnnLdapConnection();
			ldapService.auth();
			ldapService.findUser("test 1");
		}catch (Exception e) {
			System.err.println("Error al ejecutar la app: " + e.getMessage());
		}
	}
}