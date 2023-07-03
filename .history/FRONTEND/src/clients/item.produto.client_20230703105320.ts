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
        try{
            return(await this.axiosClient.get<ItemProduto[]>("/")).data;
        }catch (error: any){
            return Promise.reject(error.response);
        }   
    }

    public async findById(id: number): Promise<ItemProduto>{
        try {
            return(await this.axiosClient.get<ItemProduto>(`/${id}`)).data;
        } catch (error: any) {
            return Promise.reject(error.response);
        }
    }

    public async create(itemproduto : ItemProduto): Promise<ItemProduto>{
        try {
            return(await this.axiosClient.post<ItemProduto>("/", ItemProduto)).data;
        } catch (error: any) {
            return Promise.reject(error.response);
        }
    }

    
}