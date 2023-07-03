import { Carrinho } from "@/models/carrinho";
import axios, { AxiosInstance } from "axios";

class CarrinhoClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: "http://localhost:5432/api/carrinho",
      headers: { "Content-type": "application/json" },
    });
  }

  public async getAll(): Promise<Carrinho[]> {
    try {
      return (await this.axiosClient.get<Carrinho[]>("/lista")).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async findById(id: number): Promise<Carrinho> {
    try {
      return (await this.axiosClient.get<Carrinho>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async create(carrinho: Carrinho): Promise<Carrinho> {
    try {
      return (await this.axiosClient.post<Carrinho>("/", carrinho)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async update(id: number, carrinho: Carrinho): Promise<Carrinho> {
    try {
      return (await this.axiosClient.put<Carrinho>(`/${id}`, carrinho)).data;
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

export default new CarrinhoClient();
