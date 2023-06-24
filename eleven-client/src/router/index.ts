import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import ContatosComponent from '../components/CONTATOS/ContatosComponent.vue';
import CarrinhoComponent from '../components/CARRINHO/CarrinhoComponent.vue';

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
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
