package br.com.alura.tabelaFipe.principal;

import br.com.alura.tabelaFipe.model.Dados;
import br.com.alura.tabelaFipe.model.Modelos;
import br.com.alura.tabelaFipe.model.Veiculo;
import br.com.alura.tabelaFipe.services.ConsumoApi;
import br.com.alura.tabelaFipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner sc = new Scanner(System.in); // Scanner para capturar entradas do usuário

    // URL base para a API da tabela FIPE
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    // Instâncias de classes de serviço
    private ConsumoApi consumo = new ConsumoApi(); // Serviço para consumir a API
    private ConverteDados dados = new ConverteDados(); // Serviço para converter dados

    // Método para exibir o menu e gerenciar as opções de consulta
    public void exibeMenu() {
        // Menu com opções disponíveis
        var menu = """
                **** OPÇÕES ****
                
                CARRO
                MOTO
                CAMINHÃO
                
                Digite uma das opções para consulta:
                """;
        System.out.println(menu);
        var opcao = sc.nextLine();
        String endereco;

        // Define a URL de acordo com a escolha do usuário
        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        // Consome a API para obter as marcas de veículos
        var json = consumo.obterDados(endereco);
        System.out.println(json);

        // Converte os dados JSON em uma lista de objetos Dados
        var marcas = dados.obterList(json, Dados.class);

        // Ordena e exibe as marcas disponíveis
        System.out.println("""
                Código Nome
                -----------
                """);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(m -> System.out.printf("%-8s %s%n", m.codigo(), m.nome()));


        // Captura o código da marca escolhido pelo usuário
        System.out.println("Informe o codigo da marca.");
        var codigoMarca = sc.nextLine();

        // Atualiza a URL para obter os modelos da marca selecionada
        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);

        // Converte os dados JSON em um objeto Modelos
        var modeloLista = dados.obterDados(json, Modelos.class);

        // Exibe os modelos disponíveis
        System.out.println("\nModelos: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(m -> System.out.printf("%-8s %s%n", m.codigo(), m.nome()));


        // Filtra os modelos com base no nome fornecido pelo usuário
        System.out.println("\nDigite um trecho do nome do carro.");
        var nomeVeiculo = sc.nextLine();
        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        // Exibe os modelos filtrados
        System.out.println("\nModelos: ");
        modelosFiltrados.forEach(m -> System.out.printf("%-8s %s%n", m.codigo(), m.nome()));

        // Captura o código do modelo escolhido pelo usuário
        System.out.println("\nDigite o código do modelo.");
        var codigoModelo = sc.nextLine();

        // Atualiza a URL para obter os anos do modelo selecionado
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);

        // Converte os dados JSON em uma lista de objetos Dados representando os anos
        List<Dados> anos = dados.obterList(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        // Para cada ano, consome a API para obter os dados completos do veículo
        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = dados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        // Exibe os dados de todos os veículos encontrados
        System.out.println("\nTodos os veiculos:");
        veiculos.forEach(m -> System.out.printf("%-8s %s%n %s%n %s%n %s%n", m.valor(), m.marca(), m.modelo(), m.ano(), m.tipoCombustivel()));
    }
}
