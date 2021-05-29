import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Category} from '../models/category';
import {ConfigService} from './config.service'

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient,
              private config: ConfigService) { }

  uri() {
    return this.config.getApi() + 'allCategorys';
  }

  findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.uri());
  }

  save(category: Category): Observable<Category> {
    return this.http.post<Category>(this.uri(), category);
  }

  // delete(category: Category) {
  //   return this.http.delete(this.uri(), {
  //     params: new HttpParams().set('delete', category.name)
  //   });
  // }

}
