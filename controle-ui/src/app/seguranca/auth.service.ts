import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class AuthService {

  authUrl: string ;


  constructor( private http: HttpClient) {
    this.authUrl = 'http://localhost:9092/oauth/token';
  }

  login(username: string, password: string): Promise<void>{
    const headers = new HttpHeaders()
    .append('Content-Type', 'application/x-www-form-urlencoded')
    .append('Authorization', 'Basic Y29kZXJlZjokMmEkMTAkcDlQazBmUU5BUVNlc0k0dnV2S0EwT1phbkREMg==');

    const body = `username=${username}&password=${password}&grant_type=password`;

    return this.http.post<any>(this.authUrl, body,
      { headers, withCredentials: true })
    .toPromise()
    .then(response => {
      localStorage.setItem('token', response.access_token);
    })
    .catch(response => {
      if (response.status === 400) {
        if (response.error === 'invalid_grant') {
          return Promise.reject('Usuário ou senha inválida!');
        }
      }

      return Promise.reject(response);
    });

  }

  getToken(): String {
    var token = localStorage.getItem('token');
    return token ? token : "";
  }

  logout(): void {
      // clear token remove user from local storage to log user out
      localStorage.removeItem('token');
  }

  isLoggedIn(): boolean {
    var token: String = this.getToken();
    return token && token.length > 0;
  }

}
