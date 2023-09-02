package br.com.alura.screenmatcj;

import br.com.alura.screenmatcj.model.DadosSerie;
import br.com.alura.screenmatcj.services.ConsumoApi;
import br.com.alura.screenmatcj.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatcjApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(ScreenmatcjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?apikey=ed389052&i=tt1630029");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
