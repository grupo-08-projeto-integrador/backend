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
  </div>
  <div class="caixa__login">
    <h2>Login</h2>
    <form>
      <div class="caixa__login-input">
        <input type="text" required v-model="email" />
        <label>Email</label>
      </div>
      <div class="caixa__login-input">
        <input type="password" required v-model="senha" />
        <label>Senha</label>
      </div>
      <button @click.prevent="acessar">Acessar</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      senha: "",
    };
  },
  methods: {
    acessar() {},
  },
};
</script>

<style scoped>
@import url("./Login.css");
</style>
