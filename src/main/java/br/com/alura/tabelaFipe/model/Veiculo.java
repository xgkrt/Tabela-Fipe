package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignora quaisquer propriedades desconhecidas presentes no JSON que não estão mapeadas no record
@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        // Mapeia o campo JSON "Valor" para o atributo "valor" do record
        @JsonAlias("Valor") String valor,

        // Mapeia o campo JSON "Marca" para o atributo "marca"
        @JsonAlias("Marca") String marca,

        // Mapeia o campo JSON "Modelo" para o atributo "modelo"
        @JsonAlias("Modelo") String modelo,

        // Mapeia o campo JSON "AnoModelo" para o atributo "ano"
        @JsonAlias("AnoModelo") Integer ano,

        // Mapeia o campo JSON "Combustivel" para o atributo "tipoCombustivel"
        @JsonAlias("Combustivel") String tipoCombustivel
) {

    // O uso de `record` torna o código conciso e imutável:
    // - Os campos são declarados diretamente no cabeçalho do record.
    // - Construtor, getters, equals, hashCode, e toString são gerados automaticamente.

}
