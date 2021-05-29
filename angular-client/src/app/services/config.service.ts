import { Injectable } from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private BASE_HREF = 'http://localhost:4200/';
  private HEADERS = new HttpHeaders({
    'Content-type': 'application/json',
    'Accept': 'application/json'
  });

  constructor() { }

  getBase() {
    return this.BASE_HREF;
  }

  getApi() {
    return this.BASE_HREF + 'api/';
  }

  getHeaders() {
    return this.HEADERS;
  }

}
