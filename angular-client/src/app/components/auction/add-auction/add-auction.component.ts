import {Component} from '@angular/core';
import {Auction} from "../../../models/auction";
import {ActivatedRoute, Router} from '@angular/router';
import {AuctionService} from "../../../services/auction.service";
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-add-auction',
  templateUrl: './add-auction.component.html',
  styleUrls: ['./add-auction.component.css']
})
export class AddAuctionComponent {

  model: NgbDateStruct;

  auction: Auction;



  constructor(private route: ActivatedRoute,
              private router: Router,
              private auctionService: AuctionService
  ) {
    this.auction = new Auction();
  }

  onSubmit() {
    this.auctionService.save(this.auction).subscribe(result => this.gotoAuctionList())
  }

  gotoAuctionList() {
    this.router.navigate(['/auctions'])
  }


  /*  saveAuction(): void {
      const data ={
        title: this.auction.title,
        description: this.auction.description,
      }
    }

    this.auctionService.create(data).subscribe(
      responce {
        console.log(responce);
        this.submitted =true;
    },
      error {
        console.log(error);
  }
    );

      newAuction(): void {
      this.submitted = false;
      this.auction = {
        title: '',
        description: '',
        seller: UserAccount,
        itemCategory: '',
        minimumPrice: '',
        buyNowPrice: '',
        userLocation: '',
        created: Date.now(),
        ending: '',
        active: true

      }
    }*/

}
