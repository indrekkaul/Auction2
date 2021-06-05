import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ConfigService} from "./config.service";
import {Auction} from "../models/auction";

//const auctions = 'http://localhost:8080/auctions'
//const create = 'http://localhost:8080/new_auctions'


@Injectable({
  providedIn: 'root'
})
export class AuctionService {

  private readonly auctionAddUrl: string;
  private readonly auctionAllUrl: string;


  constructor(private http: HttpClient) {
    this.auctionAddUrl = 'http://localhost:8080/auction';
      this.auctionAllUrl = 'http://localhost:8080/auction/all';
  }

  public getAll(): Observable<Auction[]> {
    return this.http.get<Auction[]>(this.auctionAllUrl);
  }


  public save(auction: Auction) {
    return this.http.post<Auction>(this.auctionAddUrl, auction);
  }



}

