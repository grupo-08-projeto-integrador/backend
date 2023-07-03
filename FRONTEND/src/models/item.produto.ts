import { AbstractEntity } from "./abstract.entity";

export class ItemProduto extends AbstractEntity{
    cor! :string
    tamanho! :string
    quantidade! :number
}