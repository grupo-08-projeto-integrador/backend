import { ItemProduto } from "@/models/item.produto";
import axios, {AxiosInstance} from 'axios';


class ItemProdutoClient{
    private axiosClient: AxiosInstance;

    constructor(){
        this.axiosClient = axios.create({
            baseURL: "http://localhost:5432/api/itemproduto",
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
            return(await this.axiosClient.post<ItemProduto>("/", itemproduto)).data;
        } catch (error: any) {
            return Promise.reject(error.response);
        }
    }

    public async update(id: number, itemproduto: ItemProduto): Promise<ItemProduto>{
        try {
            return(await this.axiosClient.put<ItemProduto>(`/${id}`, itemproduto)).data;
        } catch (error: any) {
            return Promise.reject(error.response);
        }
    }

    public async delete(id: number): Promise<void> {
        try {
            await this.axiosClient.delete<void>(`/${id}`);
        } catch (error: any) {
            return Promise.reject(error.response);
        }
    }
}

export default new ItemProdutoClient();