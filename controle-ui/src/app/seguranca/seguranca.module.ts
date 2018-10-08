import { Http, RequestOptions } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JwtModule } from '@auth0/angular-jwt';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';

import { CanActivateAuthGuard } from 'app/can-activate.authguard';


import { AuthService } from './auth.service';
import { SegurancaRoutingModule } from './seguranca-routing.module';
import { LoginFormComponent } from './login-form/login-form.component';

export function tokenGetter() {
  return localStorage.getItem('token');
}

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule,


    SegurancaRoutingModule
  ],
  declarations: [LoginFormComponent],
  providers: [
    CanActivateAuthGuard
  ]
})
export class SegurancaModule { }
