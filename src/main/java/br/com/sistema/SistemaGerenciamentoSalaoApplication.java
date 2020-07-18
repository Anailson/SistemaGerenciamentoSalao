package br.com.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.sistema.model")
public class SistemaGerenciamentoSalaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGerenciamentoSalaoApplication.class, args);
	}

}
