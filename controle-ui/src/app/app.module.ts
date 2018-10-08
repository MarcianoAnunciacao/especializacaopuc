import { ProdutoService } from './produtos/produto.service';
import { ProdutosModule } from './produtos/produtos.module';
import { AuthService } from './seguranca/auth.service';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { MessageService } from 'primeng/components/common/messageservice';

import { HttpClientModule }    from '@angular/common/http';

import { AppComponent } from './app.component';
import { SegurancaModule } from './seguranca/seguranca.module';
import { AppRoutingModule } from './app-routing.module';
import { CanActivateAuthGuard } from './can-activate.authguard';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    SegurancaModule,
    AppRoutingModule,
    ProdutosModule
  ],
  providers: [AuthService,  CanActivateAuthGuard, ProdutoService, ConfirmationService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
