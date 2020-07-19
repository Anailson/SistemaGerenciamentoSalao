package br.com.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.sistema.model")
@ComponentScan(basePackages = {"*br.*"})
public class SistemaGerenciamentoSalaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGerenciamentoSalaoApplication.class, args);
	}

}
