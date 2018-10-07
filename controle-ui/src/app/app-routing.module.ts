import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProdutosPesquisaComponent } from './produtos/produtos-pesquisa/produtos-pesquisa.component';
import { CanActivateAuthGuard } from './can-activate.authguard';

const routes: Routes = [
  { path: 'produtos', component: ProdutosPesquisaComponent },
  { path: '*', component: ProdutosPesquisaComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
