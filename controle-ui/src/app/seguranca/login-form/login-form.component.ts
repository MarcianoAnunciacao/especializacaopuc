import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import {MatDialog} from '@angular/material';

import { AuthService } from './../auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  login(usuario: string, senha: string) {
    this.auth.login(usuario, senha)
      .then(() => {
        this.router.navigate(['/produtos']);
      })
      .catch(erro => {
        this.router.navigate(['/login']);
      });
  }

}
