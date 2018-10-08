
export class Pessoa {
  codigo: number;
  nome: string;
}

export class Fornecedor {
  codigo: number;
  razaoSocial: string;
  nomeFantasia: string;
  ativo = true;
}

export class Produto {
  nome: string;
  descricao: string;
  valor: number;
}

export class Categoria {
  codigo: number;
  nome: string;
}
