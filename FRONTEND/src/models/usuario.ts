import { AbstractEntity } from "./abstract.entity";

export class Usuario extends AbstractEntity {
    username!: string
    password!: string
    email!: string
    tipodeusuario!: string
}