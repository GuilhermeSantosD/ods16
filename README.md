<h1 align="center">
     🥣 <a href="#" alt=""> ODS 16 </a>
</h1>

<h3 align="center">
     App web/mobile de cardápio para restaurante que permite criar, atualizar e remover pratos, além de fazer pedidos 🍽️
</h3>

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/seu-usuario/ods16?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/seu-usuario/ods16">

  <a href="https://github.com/seu-usuario/ods16/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/seu-usuario/ods16">
  </a>

   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
   <a href="https://github.com/seu-usuario/ods16/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/seu-usuario/ods16?style=social">
  </a>
</p>

<h4 align="center">
	Em desenvolvimento 🚀
</h4>

Tabela de conteúdos
=================

* [Sobre o projeto](#sobre-o-projeto)
* [Funcionalidades](#funcionalidades)
* [Layout](#layout)
    * [Web](#layout-web)
    * [Mobile](#layout-mobile)
* [Como executar o projeto](#como-executar-o-projeto)
    * [Pré-requisitos](#pre-requisitos)
    * [Rodando a fake API](#rodando-o-backend)
    * [Rodando a aplicação web (Frontend)](#rodando-a-aplicacao-web-frontend)
    * [Rodando a aplicação mobile (Frontend)](#rodando-a-aplicacao-mobile)
* [Tecnologias](#tecnologias)
    * [Website](#tecnologias-website)
    * [Mobile](#tecnologias-mobile)
    * [Utilitários](#utilitarios)
* [Como contribuir no projeto](#como-contribuir)
* [Autor](#autor)
* [Licença](#licenca)



## 💻 Sobre o projeto <a name="sobre-o-projeto"></a>

🥣 O ODS 16 é um app de cardápio para restaurante com interface para web que permite a criação, remoção e atualização de pratos de comida, e interface mobile que permite a realização de pedidos e escolha de pratos favoritos.

---

## ⚙️ Funcionalidades <a name="funcionalidades"></a>

- [x] Restaurantes podem utilizar a plataforma web para:
    - [x] Cadastrar novos pratos
    - [x] Editar pratos
    - [x] Listar os pratos
    - [x] Remover pratos
    - [x] Alterar a disponibilidade dos pratos
- [x] Os usuários têm acesso ao app mobile, onde podem:
    - [x] Listar os pratos de comida e categorias
    - [x] Filtrar pratos de comida por busca ou por categorias
    - [x] Listar seus pratos favoritos
    - [x] Realizar um pedido

---

## 🎨 Layout <a name="layout"></a>

O layout da aplicação está disponível no Figma:

<a href="https://www.figma.com/file/SEU_LINK_DO_FIGMA">
  <img alt="Layout web no Figma" src="https://img.shields.io/badge/Acessar%20Web%20-Figma-%2304D361">
</a>

<a href="https://www.figma.com/file/SEU_LINK_DO_FIGMA">
  <img alt="Layout mobile no Figma" src="https://img.shields.io/badge/Acessar%20Mobile%20-Figma-%2304D361">
</a>

### Web <a name="layout-web"></a>

<p align="center" style="display: flex; align-items: flex-start; justify-content: center;">
  <img alt="Screenshot web 1" src="./assets/web-dashboard.svg" height="230px">

  <img alt="Screenshot web 2" src="./assets/web-prato.svg" width="400px">
</p>

### Mobile <a name="layout-mobile"></a>

<p align="center" style="display: flex; align-items: flex-start; justify-content: center;">
  <img alt="Screenshot mobile 1" src="./assets/mobile-splash.svg" width="200px">

  <img alt="Screenshot mobile 2" src="./assets/mobile-home.svg" width="200px">

  <img alt="Screenshot mobile 3" src="./assets/mobile-orders.svg" width="200px">

  <img alt="Screenshot mobile 4" src="./assets/mobile-favorites.svg" width="200px">
</p>

---

## 🚀 Como executar o projeto <a name="como-executar-o-projeto"></a>

Este projeto é dividido em duas partes:
1. Frontend Web (pasta web)
2. Frontend Mobile (pasta mobile)

💡 Tanto o Frontend Web quanto o Mobile utilizam uma fake API que roda na porta 3333

### Pré-requisitos <a name="pre-requisitos"></a>

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Node.js](https://nodejs.org/en/).
Além disso, é bom ter um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/).

#### 🎲 Rodando a fake API <a name="rodando-o-backend"></a>

```bash

# Clone este repositório
$ git clone git@github.com:seu-usuario/ods16.git

# Acesse a pasta do projeto no terminal/cmd
$ cd ods16

# Vá para a pasta do frontend
$ cd web

# Instale as dependências
$ npm install

# Execute o script da fake API
$ npm run json-server server.json -p 3333

# O servidor inciará na porta:3333 - acesse http://localhost:3333 

