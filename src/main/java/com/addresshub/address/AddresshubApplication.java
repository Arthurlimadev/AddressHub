package com.addresshub.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AddresshubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddresshubApplication.class, args);
	}

}
