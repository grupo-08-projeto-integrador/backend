import { AbstractEntity } from "./abstract.entity"
import { Produto } from "./produto"

export class ItemVenda extends AbstractEntity{
    quantidade! : number
    produto! : Produto
    precoUnit! : number
}