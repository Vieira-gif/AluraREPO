package br.com.alura.screenmatcj.principal;

import br.com.alura.screenmatcj.model.DadosEpisodio;
import br.com.alura.screenmatcj.model.DadosSerie;
import br.com.alura.screenmatcj.model.DadosTemporada;
import br.com.alura.screenmatcj.model.Episodio;
import br.com.alura.screenmatcj.service.ConsumoApi;
import br.com.alura.screenmatcj.service.ConverteDados;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ed389052";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        //System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i<=dados.totalTemporadas(); i++){
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        //temporadas.forEach(System.out::println);

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(
                        temporada -> temporada
                                .episodios()
                                .stream()
                )
                .collect(Collectors.toList());

        System.out.println("Melhores 5 episodios: ");
        dadosEpisodios.stream()
                .filter(episodio -> !episodio.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(
                        Comparator.comparing(DadosEpisodio::avaliacao)
                                .reversed()
                )
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)).collect(Collectors.toList()));

        episodios.forEach(System.out::println);
    }
}