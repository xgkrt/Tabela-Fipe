package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// Ignora propriedades desconhecidas no JSON para evitar erros de mapeamento
@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<Dados> modelos) {
    // A classe `Modelos` encapsula uma lista de objetos `Dados`, representando os modelos
    // retornados pela API. Ela utiliza o recurso de `record` para imutabilidade e simplicidade.
}
