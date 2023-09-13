package br.com.alura.screenmatcj;

import br.com.alura.screenmatcj.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatcjApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatcjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
