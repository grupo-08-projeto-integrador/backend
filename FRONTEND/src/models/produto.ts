import { AbstractEntity } from "./abstract.entity"

export class Produto extends AbstractEntity{
    nome! : string
    descricao! : string
    preco! : number
    imagem! : string
    categoria! : string
}