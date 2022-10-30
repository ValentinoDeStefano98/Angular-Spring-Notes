import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

 

@Injectable({
  providedIn: 'root'
})
export class LoginService {  
  http: any;
  user!: User[];
  baseUrl: string;

  constructor(private httpClient: HttpClient) {
    this.baseUrl = "http://localhost:8080/user/login"
   }

  loginUser(user: User):Observable<object>{
    return this.httpClient.post(`${this.baseUrl }`, user);
  }

}
