import { Component, OnInit } from '@angular/core';
import { Router} from "@angular/router";
import { Auction } from "../../../models/auction";
import { AuctionService } from "../../../services/auction.service";
import { UserAccount } from "../../../models/useraccount";
import { Category } from "../../../models/category";
import { Address } from "../../../models/address";
// import { LoginService } from

@Component({
  selector: 'app-add-auction',
  templateUrl: './add-auction.component.html',
  styleUrls: ['./add-auction.component.css']
})
export class AddAuctionComponent implements OnInit {
  // auction: Auction ={
  //   title: '',
  //   description: '',
  //   seller: UserAccount
  //   itemCategory: Category,
  //   minimumPrice: 0,
  //   buyNowPrice: 0,
  //   isPromotedToPremium: false,
  //   userLocation: Address,
  //   created: Date,
  //   ending: Date
  //
  // }

  constructor() { }

  ngOnInit(): void {
  }

}
