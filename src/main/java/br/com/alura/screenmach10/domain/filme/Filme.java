package br.com.alura.screenmach10.domain.filme;

public class Filme {

    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;

    public Filme(DadosCadastrosFilme dados){
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }
}
