package br.com.alura.tabelaFipe.services;

import java.util.List;

// Interface que define os métodos para converter JSON em objetos Java
public interface IConverteDados {
    // Converte um JSON em um objeto do tipo especificado
    <T> T obterDados(String json, Class<T> classe);

    // Converte um JSON em uma lista de objetos do tipo especificado
    <T> List<T> obterList(String json, Class<T> classe);
}