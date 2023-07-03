import { ItemProduto } from "@/models/item.produto";
import axios, {AxiosInstance} from 'axios';


class ItemProdutoClient{
    private axiosClient: AxiosInstance;

    constructor(){
        this.axiosClient = axios.create({
            baseURL: "http://localhost:8080/api/itemproduto",
            headers: { "Content-type": "application/json"},
        });
    }

    public async getAll(): Promise<ItemProduto[]> {
        try
    }
}