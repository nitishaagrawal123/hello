package com.cg.wallet.wallet_by_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EntityScan("com.cg.wallet.beans")
public class WalletBySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletBySpringbootApplication.class, args);
	}

}
