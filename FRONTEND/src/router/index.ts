import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Contatos from '../views/contatos/contatos.view.vue';
import Carrinho from '../views/carrinho/carrinho.view.vue';
import ProductPage from '../views/produto/produto.view.vue';
import Login from '../views/LOGIN/Login.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/Contatos',
    name: 'Contatos',
    component: Contatos
  },
  {
    path: '/Carrinho',
    name: 'Carrinho',
    component: Carrinho
  },
  {
    path: '/ProductPage',
    name: 'ProductPage',
    component: ProductPage
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
