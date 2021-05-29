import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ConfigService} from "./config.service";
import {UserAccount} from "../models/useraccount";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,
              private config: ConfigService) { }

  uri() {
    return this.config.getApi() + 'admin/users';
  }


  // UserAccount findOne(Long id);
  //
  // void save(UserAccount userAccount);
  save(user: UserAccount): Observable<UserAccount> {
    const options = {headers: this.config.getHeaders()};
    return this.http.post<UserAccount>(this.uri(), user, options);
  }
  // void update (Long id, UserAccount userAccount);
  //
  // void delete(Long id); params string
  deleteUser(username: string) {
    const options = {
      headers: this.config.getHeaders(),
      params: new HttpParams().set('delete', username)
    };
    return this.http.delete(this.uri(), options);
  }

  // void restore(Long id);
}
