<template>
  <div>
    <router-link to="/Home">Home</router-link> |
    <router-link to="/Contatos">Contatos</router-link> |
    <router-link to="/Carrinho">Carrinho</router-link> |
    <router-link to="/ProductPage">Produto</router-link> |
    <router-link to="/Login">Login</router-link> |
    <router-view></router-view>
    <div id="hamburguer1">
            <div id="hamburguer-menu1">
              <div class="line1" id="line11"></div>
              <div class="line1" id="line22"></div>
              <div class="line1" id="line33"></div>
            </div>
  
            <nav class="nav1" id="nav1">
              <ul>
                <router-link to="/Home"><a>Home</a></router-link>
                <li><a >Carrinho</a></li>
                <li><a >Contato</a></li>
                <li><a >Camisetas</a></li>
                <li><a >Calças</a></li>
                <li><a >Tênis</a></li>
              </ul>
            </nav>
          </div>
        </div>
        
</template>

<style lang="scss">
#hamburguer1 {
  z-index: 2;
  display: flex;
}
.menu-bg1 #hamburguer1 {
    top: 50px;
    left: 0;
    position: absolute;
  }

</style>
