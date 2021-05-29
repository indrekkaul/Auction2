import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ConfigService} from "./config.service";
import {Auction} from "../models/auction";

const auctions = 'http://localhost:8080/auctions'

@Injectable({
  providedIn: 'root'
})
export class AuctionService {

  constructor(private http: HttpClient,
               private config: ConfigService) { }

  uri() {
    return this.config.getApi() + 'auctions'
  }

  findAll(): Observable<Auction[]> {
    return this.http.get<Auction[]>(this.uri());
  }

  // Optional<Auction> findOne(Long id);
findOne(id: number): Observable<Auction> {
    return this.http.get<Auction>(this.uri() + '/' + id);
  }


  // List<Auction> findAll();
  //
  // List<Auction> findByActive(boolean active);
  //
  // List<Auction> findByEndigIsGreaterTheCurrentDate();
  //
  // Auction save (Auction auction);
  //
  // Auction update(Long id, Auction newAuction);
  //
  // boolean delete (Long id);
  //
  // boolean promoteAuction (Long id);
  //
  // boolean demoteAuction (Long id);
  //
  // void restore (Long id);
}

