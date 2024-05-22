package org.sopt.cgv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "https://www.now-sopt-cgv.n-e.kr/")})
@SpringBootApplication
public class CgvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgvApplication.class, args);
	}

}
