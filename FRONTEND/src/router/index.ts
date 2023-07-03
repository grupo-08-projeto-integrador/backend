import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import Home from '../views/home/home.view.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/Contatos',
    name: 'Contatos',
    component: () => import ('../views/contatos/contatos.view.vue')
  },
  {
    path: '/Carrinho',
    name: 'Carrinho',
    component: () => import ('../views/carrinho/carrinho.view.vue')
  },
  {
    path: '/ProductPage',
    name: 'ProductPage',
    component: () => import ('../views/produto/produto.view.vue')
  },
  {
    path: '/Login',
    name: 'Login',
    component: () => import ('../views/login/Login.vue')
  }
  

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
