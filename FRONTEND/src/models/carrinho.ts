import { AbstractEntity } from "./abstract.entity"
import { ItemVenda } from "./item.venda"

export class Carrinho extends AbstractEntity{
    ItemVenda!: ItemVenda
    precoTotal!: number
    comprar!: string
    formaPagamento!: string
    comprovantePagagamento!: string
}