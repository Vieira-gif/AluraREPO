package br.com.alura.screenmatcj.principal;

import br.com.alura.screenmatcj.model.DadosEpisodio;
import br.com.alura.screenmatcj.model.DadosSerie;
import br.com.alura.screenmatcj.model.DadosTemporada;
import br.com.alura.screenmatcj.services.ConsumoApi;
import br.com.alura.screenmatcj.services.ConverteDados;
import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String API_KEY = "&apikey=ed389052";
    private String nomeSerie;
    Scanner sc = new Scanner(System.in);
    public void exibeMenu(){
        System.out.println("Digite o nome da serie: ");
        nomeSerie = sc.nextLine();
        System.out.println(retornaDados());

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= retornaDados().totalTemporadas(); i++){
            var json = consumo.obterDados(ENDERECO + transformaURL() + API_KEY + "&season=" + i);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTOP 5 Episodios:");
        dadosEpisodios.stream()
                .filter(d -> !d.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

    }


    private DadosSerie retornaDados() {
        var json = consumo.obterDados(ENDERECO + transformaURL() + API_KEY);
        return conversor.obterDados(json, DadosSerie.class);
    }

    private String transformaURL (){
        return URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8);
    }

}
