package br.com.alura.screenmatcj;

import br.com.alura.screenmatcj.model.DadosEpisodio;
import br.com.alura.screenmatcj.model.DadosSerie;
import br.com.alura.screenmatcj.model.DadosTemporada;
import br.com.alura.screenmatcj.principal.Principal;
import br.com.alura.screenmatcj.services.ConsumoApi;
import br.com.alura.screenmatcj.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatcjApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(ScreenmatcjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibeMenu();



	}
}
