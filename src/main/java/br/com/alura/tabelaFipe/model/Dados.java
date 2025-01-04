package br.com.alura.tabelaFipe.model;

// Define um registro (record) chamado Dados, introduzido no Java 14 como prévia e oficial no Java 16
public record Dados(String codigo, String nome) {

    // O record é uma forma concisa de declarar uma classe imutável com dois campos:
    // - codigo: Representa o código associado a um dado (por exemplo, marca ou modelo).
    // - nome: Representa o nome associado ao código (exemplo: "Fiat", "Uno").

    // Essa classe não precisa de construtores, getters, setters, equals, hashCode ou toString
    // porque tudo isso é gerado automaticamente pelo compilador.
}
