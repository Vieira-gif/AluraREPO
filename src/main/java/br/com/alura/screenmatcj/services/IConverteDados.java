package br.com.alura.screenmatcj.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
