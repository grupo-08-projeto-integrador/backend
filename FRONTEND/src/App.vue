<template>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <ul class="nav justify-content-center">
    <li class="nav-item">
      <RouterLink to="/">
        <a class="nav1 text-white">Home</a>
      </RouterLink>
    |
    </li>
    <li class="nav-item">

      <RouterLink to="/Login">
        <a class="nav1 text-white">Login</a>
      </RouterLink>
    |
    </li>
    <li class="nav-item">

      <RouterLink to="/Carrinho">
        <a class="nav1 text-white">Carrinho</a>
      </RouterLink>
    </li>
    |
    <li class="nav-item">

      <RouterLink to="/Produto">
        <a class="nav1 text-white">Produto</a>
      </RouterLink>
    </li>
  </ul>
  <RouterView></RouterView>

</template>

<script lang="ts">


</script>

<style lang="scss">

body{
  background-image: linear-gradient(to right, gray , white);

}

.nav-item{
  display: flex;
  justify-content: space-evenly ;
}
</style>
