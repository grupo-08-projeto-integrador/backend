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
  mounted() {
    const hamburguerMenu = document.getElementById("hamburguer-menu");
    const nav = document.getElementById("nav");
    const menuBg = document.getElementById("menu-bg");

    hamburguerMenu.addEventListener('click', () => {
      hamburguerMenu.classList.toggle("change");
      nav.classList.toggle("change");
      menuBg.classList.toggle("change-bg");
    });
  }
};
</script>

<style scoped>
@import url("./Login.css");
</style>
