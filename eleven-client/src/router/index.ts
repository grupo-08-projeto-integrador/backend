import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import ContatosComponent from '../components/CONTATOS/ContatosComponent.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/ContatosComponent',
    name: 'ContatosComponent',
    component: ContatosComponent
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
