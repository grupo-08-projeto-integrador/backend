<template>
  <div>
    <header class="head1"></header>
    <header class="head2"></header>
    <div id="hamburguer">
      <div id="hamburguer-menu" @click="hamburguerOnClick">
        <div class="line" id="line1"></div>
        <div class="line" id="line2"></div>
        <div class="line" id="line3"></div>
      </div>

      <nav class="nav" id="nav">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">Carrinho</a></li>
          <li><a href="#">Contato</a></li>
          <li><a href="#">Camisetas</a></li>
          <li><a href="#">Calças</a></li>
          <li><a href="#">Tênis</a></li>
        </ul>
      </nav>
      <div class="menu-bg" id="menu-bg"></div>
    </div>

    <section class="checkout">
      <h1 id="eleven-checkout">ELEVEN</h1>
      <h2 id="carrinho-checkout">CARRINHO</h2>
      <div class="itens-checkout">
        <span v-for="produto in produtosCarrinho" :key="produto.id" class="item1 cont-item-checkout">
          <div class="check FGtam2"><input class="checkbox" type="checkbox" checked></div>
          <div class="item-valor-checkout FGtam3">
            <p id="produto-checkout">{{ produto.nome }}</p>
            <p id="valor-checkout">Subtotal: R$ {{ produto.subtotal }}</p>
          </div>
          <div class="qtde-checkout FGtam2">
            <button id="btnmenos-checkout" @click="decrementarQuantidade(produto)">-</button>
            <span id="qtdeitens-checkout">
              <p>Qt: </p>
              <input type="text" v-model="produto.quantidade" disabled id="counterValue">
            </span>
            <button id="btnmais-checkout" @click="incrementarQuantidade(produto)">+</button>
          </div>
          <button class="remover-checkout FGtam1" @click="removerDoCarrinho(produto.id)"><img src="./imagens/clear.png" alt="clear"></button>
        </span>
      </div>
      <div class="precototal-checkout">
        <div id="tpt-checkout">
          <p>TOTAL: R$ {{ calcularTotal() }}</p>
        </div>
      </div>
      <div class="divbtnpf-checkout">
        <div id="btnFP">
          <button class="btnFP-checkout">FINALIZAR PEDIDO</button>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  props: {
    produtosCarrinho: {
      type: Array,
      required: true
    }
  },
  methods: {
    hamburguerOnClick() {
      const menu = document.getElementById("nav");
      const menuBg = document.getElementById("menu-bg");
      const line1 = document.getElementById("line1");
      const line2 = document.getElementById("line2");
      const line3 = document.getElementById("line3");

      menu.classList.toggle("active");
      menuBg.classList.toggle("active");

      if (menu.classList.contains("active")) {
        line1.style.transform = "rotate(45deg) translate(4px, 4px)";
        line2.style.opacity = "0";
        line3.style.transform = "rotate(-45deg) translate(5px, -5px)";
      } else {
        line1.style.transform = "none";
        line2.style.opacity = "1";
        line3.style.transform = "none";
      }
    },
    incrementarQuantidade(produto) {
      produto.quantidade++;
    },
    decrementarQuantidade(produto) {
      if (produto.quantidade > 1) {
        produto.quantidade--;
      }
    },
    removerDoCarrinho(produtoId) {
      this.$emit('remover-do-carrinho', produtoId);
    },
    calcularTotal() {
      if (Array.isArray(this.produtosCarrinho)) {
        return this.produtosCarrinho.reduce((total, produto) => total + produto.subtotal, 0);
      } else {
        return 0;
      }
    }
  }
};
</script>

<style scoped>
@import './carrinho.css';
</style>
