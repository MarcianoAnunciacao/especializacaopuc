import { Title } from '@angular/platform-browser';
import { Component, OnInit, ViewChild } from '@angular/core';

import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { MessageService } from 'primeng/components/common/messageservice';

import { ProdutoService } from './../produto.service';

@Component({
  selector: 'app-produtos-pesquisa',
  templateUrl: './produtos-pesquisa.component.html',
  styleUrls: ['./produtos-pesquisa.component.css']
})
export class ProdutosPesquisaComponent implements OnInit {

  totalRegistros = 0;
  produtos = [];
  categorias: any[];
  cidadeSelecionado: number;
  @ViewChild('tabela') grid;

  constructor(
    private produtoService: ProdutoService,
    private confirmation: ConfirmationService,
    private messageService: MessageService,
    private title: Title
  ) { }

  ngOnInit() {

    this.title.setTitle('Pesquisa');
  }

  aoMudarPagina(event: LazyLoadEvent) {
    const pagina = event.first / event.rows;
    this.pesquisarProdutos(pagina);
  }

  pesquisarProdutos(pagina = 0) {

    this.produtoService.listarTodas()
      .then(resultado => {
        this.totalRegistros = resultado.total;
        this.produtos = resultado.produtos;
      })
      .catch(erro => alert('Erro'));
  }

}
