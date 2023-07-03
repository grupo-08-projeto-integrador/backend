<template>
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
        email: '',
        senha: ''
      };
    },
    methods: {
      acessar() {
       
      }
    }
  };
  </script>
  
  <style scoped>
 @import url('./Login.css');
  </style>
  