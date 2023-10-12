package br.com.alura.screenmach10.controller;

import br.com.alura.screenmach10.domain.filme.DadosCadastrosFilme;
import br.com.alura.screenmach10.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    //GET
    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }

    @GetMapping("/listagem")
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", filmes);
        return "filmes/listagem";
    }

    //POST
    @PostMapping
    public String cadastraFilme(DadosCadastrosFilme dados){
        var filme = new Filme(dados);
        filmes.add(filme);

        return "redirect:/filmes/listagem";
    }


}
