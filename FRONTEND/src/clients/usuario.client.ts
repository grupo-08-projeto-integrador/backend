import { Usuario } from "@/models/usuario";
import axios, { AxiosInstance } from "axios";

class UsuarioClient {
  private axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      baseURL: "http://localhost:5432/api/usuario",
      headers: { "Content-type": "application/json" },
    });
  }

  public async findAll(): Promise<Usuario[]> {
    try {
      return (await this.axiosClient.get<Usuario[]>("/")).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async findById(id: number): Promise<Usuario> {
    try {
      return (await this.axiosClient.get<Usuario>(`/${id}`)).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async authenticate(email: string, password: string): Promise<Usuario> {
    try {
      return (await this.axiosClient.get<Usuario>("/authenticate", {
        params: { email, password },
      })).data;
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async update(id: number, usuario: Usuario): Promise<string> {
    try {
      await this.axiosClient.put(`/${id}`, usuario);
      return "Usuário atualizado com sucesso";
    } catch (error: any) {
      return Promise.reject(error.response);
    }
  }

  public async cadastrar(usuario: Usuario): Promise<string> {
    try {
      await this.axiosClient.post("/", usuario);
      return "Cadastro efetuado com sucesso";
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

export default new UsuarioClient();
