# Gerenciador de Veículos 🚗🏍️

Este projeto é um sistema simples para gerenciar uma frota de veículos. Ele permite adicionar carros e motos, calcular o valor do seguro de cada veículo e garantir que a manutenção periódica seja realizada. O sistema utiliza conceitos de **programação orientada a objetos (POO)**, incluindo herança, interfaces e abstração, além de permitir a interação com o usuário por meio de um menu.

---

## 📋 Funcionalidades

- **Adicionar Veículos:**  
  Adicione carros e motos fornecendo informações como placa, ano de fabricação, número de portas ou cilindrada.

- **Listar Veículos:**  
  Exiba todos os veículos cadastrados na frota com os seguintes detalhes:
  - Placa
  - Ano
  - Valor do seguro
  - Registro de manutenção

- **Cálculo de Seguro:**  
  - Para carros: Base fixa de R$ 500,00 + R$ 50,00 por porta.  
  - Para motos: Base fixa de R$ 300,00 + R$ 0,10 por cilindrada.

- **Registro de Manutenção:**  
  Cada veículo possui uma mensagem específica ao realizar a manutenção.

---

## 🛠️ Estrutura do Código

- **`Veiculo` (Classe Abstrata):**  
  Classe base com os atributos comuns aos veículos (`placa` e `ano`) e métodos para exibir detalhes e calcular o valor do seguro (abstrato).

- **`Carro` (Subclasse):**  
  Contém um atributo adicional `numeroPortas` e implementa o cálculo de seguro específico e o registro de manutenção.

- **`Moto` (Subclasse):**  
  Contém um atributo adicional `cilindrada` e implementa o cálculo de seguro específico e o registro de manutenção.

- **`Manutencao` (Interface):**  
  Define o método `realizarManutencao()` para ser implementado por carros e motos.

- **`GerenciadorVeiculos` (Classe Principal):**  
  Controla o menu interativo para manipulação da frota de veículos.

# 💡 Conceitos Utilizados

- **Herança e Polimorfismo:**  
  `Carro` e `Moto` herdam da classe abstrata `Veiculo`.
  
- **Interface:**  
  `Manutencao` define um comportamento comum implementado pelas subclasses.

- **Encapsulamento:**  
  Atributos protegidos e métodos públicos garantem controle sobre os dados.

- **ArrayList:**  
  Armazena os veículos da frota de forma dinâmica.

---

# 🛠️ Requisitos

- Java 8 ou superior

---


