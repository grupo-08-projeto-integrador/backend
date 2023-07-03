<template>
    <div>
      <section class="home">
        <!--PRIMEIRA PÁGINA-->
      </section>
      <section class="productPage">
        <!--PÁGINA DO PRODUTO SELECIONADO-->
      </section>
      <section class="carrinho">
        <!--PÁGINA DO CHECK-OUT DOS PRODUTOS-->
      </section>
      <section class="register">
        <!--PÁGINA DE REGISTRO-->
      </section>
      <section class="contatos">
        <!--PÁGINA DE CONTATO-->
        <div class="mobiletable">
          <div class="head">
            <h1 class="titu">ELEVEN</h1>
          </div>
          <div id="hamburguer1">
            <div id="hamburguer-menu1" @click="hamburguerOnClick1">
              <div class="line1" id="line11"></div>
              <div class="line1" id="line22"></div>
              <div class="line1" id="line33"></div>
            </div>
  
            <nav class="nav1" id="nav1">
              <ul>
                <li><router-link to="../home/home.view.vue"><a>Home</a></router-link></li>
                <li><a>Carrinho</a></li>
                <li><a>Contato</a></li>
                <li><a >Camisetas</a></li>
                <li><a >Calças</a></li>
                <li><a >Tênis</a></li>
              </ul>
            </nav>
            <div class="menu-bg1" id="menu-bg1"></div>
          </div>
          <div class="slider">
            <ul id="ulimg">
              <li>
                <img class="Emporio" src="./imgContato/emporio.png" alt="emporio">
              </li>
              <li>
                <img class="Givenchy" src="./imgContato/givenchy.png" alt="givenchy">
              </li>
              <li>
                <img class="Hugo" src="./imgContato/hugoboss.png" alt="hugoboss">
              </li>
            </ul>
          </div>
          <h1 id="titulo2">Contatos</h1>
          <div class="boxes">
            <a id="boxtx1">
              <button id="box1">
                <img class="insta" src="./imgContato/insta.png" alt="Instagram">
                Instagram
              </button>
            </a>
            <p></p>
            <a id="boxtx1">
              <button id="box2" href="">
                <img class="loc" src="./imgContato/loc.png" alt="Localização">
                Localização
              </button>
            </a>
            <p></p>
            <a id="boxtx1">
              <button id="box3">
                <img class="email" src="./imgContato/email.png" alt="Email">
                E-Mail
              </button>
            </a>
            <p></p>
            <a id="boxtx1">
              <button id="box4">
                <img class="zap" src="./imgContato/zap.png" alt="Whats">
                WhatsApp
              </button>
            </a>
          </div>
        </div>
        <div class="Desktop">
          <div id="faixa1"></div>
          <div id="faixa2"></div>
          <div id="hamburguer">
            <div id="hamburguer-menu" @click="hamburguerOnClick">
              <div class="line" id="line1"></div>
              <div class="line" id="line2"></div>
              <div class="line" id="line3"></div>
            </div>
  
            <nav class="nav" id="nav">
              <ul>
                <li><router-link to="/"><a>Home</a></router-link></li>
                <li><router-link to="/Carrinho"><a>Carrinho</a></router-link></li>
                <li><a href="#">Contato</a></li>
                <li><a href="#">Camisetas</a></li>
                <li><a href="#">Calças</a></li>
                <li><a href="#">Tênis</a></li>
              </ul>
            </nav>
            <div class="menu-bg" id="menu-bg"></div>
          </div>
          <div class="dropdown-container">
            <div class="dropdown-menu">
              <div class="dropdown-hover">ELEVEN</div>
              <div class="linha"></div>
              <div class="menu2">
                <a href="#" class="img-marca">
                  <img class="HugoD" src="./imgContato/hugoboss.png" alt="marca1">
                </a>
                <a href="#" class="img-marca">
                  <img src="./imgContato/emporio.png" alt="marca2" class="EmporioD">
                </a>
                <a href="#" class="img-marca">
                  <img src="./imgContato/Giorgio_Armani.png" alt="marca3" class="GiorgioA">
                </a>
                <a href="#" class="img-marca">
                  <img src="./imgContato/ArmaniEx.png" alt="marca4" class="ArmaniEx">
                </a>
              </div>
            </div>
          </div>
          <div class="contatoD">
            <div class="boxesD">
              <a id="boxtxD" href="">
                <button id="box1">
                  <img class="insta" src="./imgContato/insta.png" alt="Instagram">
                  Instagram
                </button>
              </a>
              <p></p>
              <a id="boxtxD" href="">
                <button id="box2" href="">
                  <img class="loc" src="./imgContato/loc.png" alt="Localização">
                  Localização
                </button>
              </a>
              <p></p>
              <a id="boxtxD" href="">
                <button id="box3">
                  <img class="email" src="./imgContato/email.png" alt="Email">
                  E-Mail
                </button>
              </a>
              <p></p>
              <a id="boxtxD" href="">
                <button id="box4">
                  <img class="zap" src="./imgContato/zap.png" alt="Whats">
                  WhatsApp
                </button>
              </a>
            </div>
            <img class="fundolojaD" src="./imgContato/fundoloja.png" alt="Loja">
          </div>
        </div>
      </section>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
        hamburguerOnClick1() {
    document.getElementById("hamburguer-menu1").classList.toggle("change");
    document.getElementById("nav1").classList.toggle("change");
    document.getElementById("menu-bg1").classList.toggle("change-bg");
},
hamburguerOnClick() {
    document.getElementById("hamburguer-menu").classList.toggle("change");
    document.getElementById("nav").classList.toggle("change");
    document.getElementById("menu-bg").classList.toggle("change-bg");
},
    },
  };
  </script>


<style>
@import url('./index.css');

</style>