import { Produto } from "@/models/produto";
import axios, { AxiosInstance } from "axios";

class ProdutoClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: "http://localhost:8090/api/produto",
      headers: { "Content-type": "application/json" },
    });
  }

  public async findById(id: number): Promise<Produto> {
    try {
      return (await this.axiosClient.get<Produto>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async findAll(): Promise<Produto[]> {
    try {
      return (await this.axiosClient.get<Produto[]>("/lista")).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async create(produto: Produto): Promise<string> {
    try {
      return (await this.axiosClient.post<string>("/", produto)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async update(id: number, produto: Produto): Promise<string> {
    try {
      return (await this.axiosClient.put<string>(`/${id}`, produto)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async delete(id: number): Promise<string> {
    try {
      return (await this.axiosClient.delete<string>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }
}

export default new ProdutoClient();