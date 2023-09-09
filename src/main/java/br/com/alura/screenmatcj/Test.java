package br.com.alura.screenmatcj;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        String ENDERECO = "https://www.omdbapi.com/?apikey=";
        String API_KEY = "ed389052";
        String nomeSerie;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da serie: ");
        nomeSerie = sc.nextLine();
        System.out.println( URLEncoder.encode(nomeSerie, StandardCharsets.UTF_8));
    }
}
