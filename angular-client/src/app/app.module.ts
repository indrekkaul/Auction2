import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AuctionComponent } from './components/auction/auction.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { AddAuctionComponent } from './components/auction/add-auction/add-auction.component';
import { ActiveAuctionComponent } from './components/auction/active-auction/active-auction.component';
import { ActiveAuctionsComponent } from './components/auction/active-auctions/active-auctions.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuctionComponent,
    AddAuctionComponent,
    ActiveAuctionComponent,
    ActiveAuctionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
