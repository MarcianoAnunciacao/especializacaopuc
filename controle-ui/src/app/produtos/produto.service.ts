  import { HttpParams, HttpHeaders } from '@angular/common/http';
  import { Injectable } from '@angular/core';
  import { AuthService } from 'app/seguranca/auth.service';
  import { HttpClient, HttpHandler } from '@angular/common/http';

  import 'rxjs/add/operator/toPromise';

  import { Produto, Categoria } from './../core/model';

  export class ProdutoFiltro {
    nome: string;
  }

  @Injectable()
  export class ProdutoService {

    produtoUrl: string;

    constructor(private http: HttpClient, private authService : AuthService) {
      this.produtoUrl = 'http://localhost:9093/produtos';
    }

    listarTodas(): Promise<any> {

      const headers = new HttpHeaders()
      .append('Content-Type', 'application/json')
      .append('Authorization', 'Bearer ' + this.authService.getToken());

      return this.http.get<any>(this.produtoUrl, {headers})
        .toPromise()
        .then(response => response.content);
    }

    buscarPorCodigo(codigo: number): Promise<Produto> {
      return this.http.get<Produto>(`${this.produtoUrl}`)
        .toPromise();
    }

  }
