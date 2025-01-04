package br.com.alura.tabelaFipe;

import br.com.alura.tabelaFipe.principal.Principal;
import br.com.alura.tabelaFipe.services.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marca a classe como uma aplicação Spring Boot
@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

	// Método principal que inicia a aplicação
	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

	// Método executado logo após a inicialização da aplicação
	@Override
	public void run(String... args) throws Exception {
		// Cria uma instância da classe Principal e exibe o menu
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
