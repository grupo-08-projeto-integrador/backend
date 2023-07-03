import { Checkout } from "@/models/checkout";
import axios, { AxiosInstance } from "axios";

class CheckoutClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: "http://localhost:5432/api/checkouts",
      headers: { "Content-type": "application/json" },
    });
  }

  public async findAll(): Promise<Checkout[]> {
    try {
      return (await this.axiosClient.get<Checkout[]>("/")).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async findById(id: number): Promise<Checkout> {
    try {
      return (await this.axiosClient.get<Checkout>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async create(checkout: Checkout): Promise<Checkout> {
    try {
      return (await this.axiosClient.post<Checkout>("/", checkout)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async update(id: number, checkout: Checkout): Promise<Checkout> {
    try {
      return (await this.axiosClient.put<Checkout>(`/${id}`, checkout)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async delete(id: number): Promise<void> {
    try {
      await this.axiosClient.delete(`/${id}`);
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }
}

export default new CheckoutClient();
