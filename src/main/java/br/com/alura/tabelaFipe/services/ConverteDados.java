package br.com.alura.tabelaFipe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ConverteDados implements IConverteDados {
    // Instância de ObjectMapper, usada para converter JSON em objetos Java
    private ObjectMapper mapper = new ObjectMapper();

    // Converte um JSON em um objeto específico, como uma instância de uma classe
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Converte o JSON para o tipo especificado
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // Lança uma exceção caso ocorra erro ao processar o JSON
            throw new RuntimeException(e);
        }
    }

    // Converte um JSON em uma lista de objetos do tipo especificado
    @Override
    public <T> List<T> obterList(String json, Class<T> classe){
        // Cria um tipo de coleção (no caso, lista) para o ObjectMapper
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            // Converte o JSON para uma lista do tipo especificado
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            // Lança uma exceção caso ocorra erro ao processar o JSON
            throw new RuntimeException(e);
        }
    }
}