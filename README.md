<h1>🚗 Projeto Tabela FIPE</h1>
<p>Este projeto é uma aplicação Java que consome a API da Tabela FIPE para realizar consultas sobre veículos, como carros, motos e caminhões. O sistema permite que o usuário navegue em um menu para buscar informações como marcas, modelos, anos e dados detalhados dos veículos.</p>
   
<h1>🛠️ Tecnologias Utilizadas</h1>
    <ul>
        <li><strong>Java 17</strong></li>
        <li><strong>Spring Boot</strong></li>
        <li><strong>HTTPClient</strong> para requisições HTTP</li>
        <li><strong>Jackson</strong> para manipulação de JSON</li>
   </ul>
    
   <h1>📋 Funcionalidades</h1>
    <ul>
        <li>Exibição de marcas de veículos (carros, motos ou caminhões).</li>
        <li>Consulta de modelos de uma marca selecionada.</li>
        <li>Filtragem de modelos por nome.</li>
        <li>Consulta detalhada de veículos por ano e modelo, incluindo preço, marca, modelo, ano e tipo de combustível.</li>
    </ul>
    
   <h1>📖 Como Usar</h1>
    <p>Após inicializar a aplicação, um menu interativo será exibido para o usuário:</p>
    <pre>
    **** OPÇÕES ****

  CARRO
  MOTO
  CAMINHÃO

  Digite uma das opções para consulta:
    </pre>
    <p>O usuário pode digitar "carro", "moto" ou "caminhão" para iniciar a consulta.</p>
        <h2>Fluxo de Uso</h2>
    <ol>
        <li>Selecione o tipo de veículo (carro, moto ou caminhão).</li>
        <li>Escolha a marca pelo código exibido na lista.</li>
        <li>Escolha o modelo pelo código exibido na lista.</li>
        <li>Digite o código do ano para obter informações detalhadas do veículo.</li>
    </ol>
        <h1>📦 Estrutura do Projeto</h1>
    <ul>
        <li><strong>TabelaFipeApplication</strong>: Classe principal que inicializa a aplicação.</li>
        <li><strong>Principal</strong>: Controla o menu e fluxo de interação com o usuário.</li>
        <li><strong>ConsumoApi</strong>: Classe responsável por consumir a API FIPE.</li>
        <li><strong>ConverteDados</strong>: Classe para conversão de JSON em objetos Java.</li>
        <li><strong>Modelos</strong>: Record que encapsula uma lista de modelos retornados pela API.</li>
        <li><strong>Veiculo</strong>: Record que armazena os detalhes de um veículo, como valor, marca, modelo, ano e combustível.</li>
    </ul>
    
  <h1>🌐 API Utilizada</h1>
    <p>A aplicação utiliza a <a href="https://deividfortuna.github.io/fipe/" target="_blank">API Tabela FIPE</a> para realizar todas as consultas de dados de veículos.</p>
    
  <h1>🤝 Contribuições</h1>
    <p>Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias ou novas funcionalidades.</p>
        <h1>📜 Licença</h1>
    <p>Este projeto é licenciado sob a <strong>MIT License</strong>.</p>
    
  <h1>🔗 Links</h1>
  <ul>
        <li><a href="https://github.com/seuusuario/tabelafipe" target="_blank">Repositório no GitHub</a></li>
        <li><a href="https://deividfortuna.github.io/fipe/" target="_blank">Documentação da API FIPE</a></li>
  </ul>
