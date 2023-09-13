package br.com.alura.screenmatcj.model;
import java.time.LocalDate;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numero;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numero = dadosEpisodio.numero();
        this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
    }

    //Setters
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = Double.valueOf(avaliacao);
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    //Getters
    public Integer getTemporada() {
        return temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numero=" + numero +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
