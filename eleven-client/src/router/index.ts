import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import ContatosComponent from '../components/CONTATOS/ContatosComponent.vue';
import CarrinhoComponent from '../components/CARRINHO/CarrinhoComponent.vue';
import ProductPageComponent from '../components/PRODUCT/ProductPageComponent.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/ContatosComponent',
    name: 'ContatosComponent',
    component: ContatosComponent
  },
  {
    path: '/CarrinhoComponent',
    name: 'CarrinhoComponent',
    component: CarrinhoComponent
  },
  {
    path: '/ProductPageComponent',
    name: 'ProductPageComponent',
    component: ProductPageComponent
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
