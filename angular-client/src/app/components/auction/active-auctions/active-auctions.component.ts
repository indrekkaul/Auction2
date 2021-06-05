import { Component, OnInit } from '@angular/core';
import { Auction} from "../../../models/auction";
import { AuctionService} from "../../../services/auction.service";

@Component({
  selector: 'app-active-auctions',
  templateUrl: './active-auctions.component.html',
  styleUrls: ['./active-auctions.component.css']
})
export class ActiveAuctionsComponent implements OnInit {

  auctions : Auction[];

  constructor(private auctionService: AuctionService) { }

  ngOnInit(): void {
    this.auctionService.getAll().subscribe(data =>{
      this.auctions = data;
    });
  }

}
