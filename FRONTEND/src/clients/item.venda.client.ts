import { ItemVenda } from "@/models/item.venda";
import axios, { AxiosInstance } from "axios";

class ItemVendaClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: "http://localhost:5432/api/ItemVenda",
      headers: { "Content-type": "application/json" },
    });
  }

  public async findById(id: number): Promise<ItemVenda> {
    try {
      return (await this.axiosClient.get<ItemVenda>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async findAll(): Promise<ItemVenda[]> {
    try {
      return (await this.axiosClient.get<ItemVenda[]>("/lista")).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async cadastrar(itemVenda: ItemVenda): Promise<string> {
    try {
      return (await this.axiosClient.post<string>("", itemVenda)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async editar(id: number, itemVenda: ItemVenda): Promise<string> {
    try {
      return (await this.axiosClient.put<string>(`?id=${id}`, itemVenda)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async excluir(id: number): Promise<string> {
    try {
      return (await this.axiosClient.delete<string>(`?id=${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }
}

export default new ItemVendaClient();
