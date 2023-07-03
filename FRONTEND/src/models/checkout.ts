import { AbstractEntity } from "./abstract.entity";
import { ItemVenda } from "./item.venda";

export class Checkout extends AbstractEntity {
    precoTotal! : number
    comprar! : string
    ItemVenda! : ItemVenda
}