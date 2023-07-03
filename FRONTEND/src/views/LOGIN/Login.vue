<template>
  <div class="login-form">

    <form>


      <div class="row mb-3">
        <label for="inputEmail3" class="">Email</label>
        <div class="col-sm-10">
          <input type="email" class="form-control" id="inputEmail3">
        </div>
      </div>
      <div class="row mb-3">
        <label for="inputPassword3" class="">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="inputPassword3">
        </div>
      </div>
      <fieldset class="row mb-3">
        <div class="col-sm-10">

          <button type="submit" class="btn btn-primary">Sign in</button>


        </div>
      </fieldset>
    </form>
  </div>
</template>

<script lang="ts">
</script>

<style lang="css">
.login-form {
  display: flex;

  justify-content: center;
  margin-top: 25vh;

}
</style>