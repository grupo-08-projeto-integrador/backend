<template>
  <div class="product-page">
    <div id="topbar">
      <div id="divVoltar">
        <button id="botaoimg" @click="goBack">
          <img id="pngtop" src="imagens/LeftVoltar.png">
        </button>
      </div>
      <div id="divELEVEN">
        <h1 id="h1ELEVEN">ELEVEN</h1>
      </div>
      <div id="divCarrinho">
        <button id="botaoimg" @click="goToCart">
          <img id="pngtop" src="imagens/shoppingCarrinho.png">
        </button>
      </div>
    </div>
    <div id="line4"></div>
    <div id="divsearch">
      <input type="text" aria-label="Realizar Busca" autocomplete="off" name="Ntt" v-model="searchQuery" class="input" placeholder="O Que Você Procura ?">
      <button id="searchButton" @click="searchProduct">Buscar</button>
    </div>
    <div v-if="product">
      <div id="PRODUTO">
        <img :src="product.imagem" :alt="product.nome" id="imgproduto">
        <div id="descprod">
          <p id="pDesc">{{ product.descricao }}</p>
          <h2 id="h2Prod">{{ product.nome }}</h2>
          <h3 id="h3Preço">{{ product.preco }}</h3>
          <div class="containerquantidade">
            <h2 id="Quant">Quantidade</h2>
            <div id="subcont">
              <button id="buttonDecrement" @click="decrementCounter">-</button>
              <input type="text" :value="counterValue" disabled id="counterValue">
              <button id="buttonIncrement" @click="incrementCounter">+</button>
            </div>
          </div>
          <button id="botaoaddcar" @click="addToCart">ADICIONAR AO CARRINHO</button>
        </div>
      </div>
      <div class="imagens">
        <!-- Aqui você pode adicionar as imagens relacionadas a outros produtos -->
      </div>
    </div>
    <div v-else>
      <p>Nenhum produto encontrado.</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      searchQuery: '',
      product: null,
      counterValue: 1,
    };
  },
  methods: {
    goBack() {
      // Implemente a lógica para voltar à página anterior
    },
    goToCart() {
      // Implemente a lógica para ir para a página do carrinho
    },
    incrementCounter() {
      this.counterValue++;
    },
    decrementCounter() {
      if (this.counterValue > 1) {
        this.counterValue--;
      }
    },
    searchProduct() {
      // Realiza a requisição GET para obter os dados do produto
      axios.get(`http://localhost:8080/api/produto/1`)
        .then(response => {
          this.product = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    addToCart() {
      // Implemente a lógica para adicionar o produto ao carrinho
    },
  },
  mounted() {
    this.searchProduct(); // Realiza a busca do produto ao carregar a página
  },
};
</script>

<style>
@import url('./productpage.css');
</style>
