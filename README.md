# Valeu Motor Transportes

Sistema de **Gestão de Transporte Urbano** desenvolvido em **Java**, com foco em conceitos de **Programação Orientada a Objetos**, **reflexão**, **interfaces**, **herança** e **coleções**.

O sistema simula o cadastro e a operação de uma frota de transporte urbano, incluindo veículos, passageiros e outros recursos relacionados.

## Funcionalidades

* Cadastro dinâmico de recursos:

  * Ônibus
  * Metrô/Trem
  * Bicicleta Compartilhada
  * Passageiro
  * Rota
  * Horário
* Consulta de registros cadastrados no sistema
* Operação da frota (movimentação dos veículos)
* Cálculo de estatísticas do sistema:
  * Quantidade de veículos
  * Quantidade de passageiros
  * Tarifas médias
  * Saldo total dos clientes
* Interface de menu interativa via terminal

##  Conceitos Utilizados

* Programação Orientada a Objetos (POO)
* Interfaces (`Transportavel`)
* Classes abstratas
* Herança e polimorfismo

## Estrutura do Projeto

```
src/
└── br/
    └── ufc/
        └── transporte/
            ├── ValeuMotor.java
            ├── Transportavel.java
            ├── Veiculo.java
            ├── Onibus.java
            ├── Metro.java
            ├── BicicletaCompartilhada.java
            ├── Passageiro.java
            ├── Rota.java
            └── Horario.java
```


## Como Compilar e Executar

### Pré-requisitos

* Java JDK instalado (versão 8 ou superior)
* Terminal/Linux, macOS ou Windows (com terminal)


### Compilação

Acesse a pasta `src` do projeto e execute:

```bash
javac br/ufc/transporte/*.java
```



### Execução

Após compilar, execute:

```bash
java br.ufc.transporte.ValeuMotor
```

## Interface do Sistema

O sistema funciona totalmente via **terminal**, apresentando um menu com opções numeradas para facilitar a navegação do usuário.

Exemplo de menu:

```
1. cadastrar novo recurso
2. consultar registros
3. operar frota
4. estatísticas do sistema
5. encerrar sistema
```

## Objetivo Acadêmico

Este projeto foi desenvolvido com fins **educacionais**, visando a prática de conceitos fundamentais da linguagem Java e da orientação a objetos, sendo indicado para disciplinas introdutórias e intermediárias de programação.

---

## Autoria

Projeto desenvolvido pelo grupo **Allan Martins Gadelha**, **Gabriel Sampaio Santos**, **Sara de Sousa Magalhaes**
Curso: Engenharia da Computação
Instituição: Universidade Federal do Ceará (UFC)

---

*Valeu Motor Transportes — conectando pessoas e mobilidade urbana.*
