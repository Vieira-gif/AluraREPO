package br.com.alura.screenmatcj;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        /*String ENDERECO = "https://www.omdbapi.com/?apikey=";
        String API_KEY = "ed389052";
        String nomeSerie;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da serie: ");
        nomeSerie = sc.nextLine();*/

        List<String> nomes = Arrays.asList("João", "Afonso", "Marcelo", "Nico");
        nomes.stream().limit(3).sorted().filter(n -> n.startsWith("J")).map(String::toUpperCase).forEach(System.out::println);
    }
}
