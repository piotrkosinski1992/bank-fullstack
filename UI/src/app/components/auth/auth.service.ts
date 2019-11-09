import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  register(email: string, password: string) {
    return this.http.post('api/users/register', {email: email, password: password}).subscribe()
  }
}
