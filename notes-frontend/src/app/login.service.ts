import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

const baseUrl = "http://localhost:8080/user/login"

@Injectable({
  providedIn: 'root'
})
export class LoginService {  
  http: any;
  user!: User;

  constructor(private httpClient: HttpClient) { }

  loginUser(user: User):Observable<object>{
    return this.httpClient.post(`${baseUrl }`, user);
  }



}
