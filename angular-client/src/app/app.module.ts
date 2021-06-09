import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AuctionComponent } from './components/auction/auction.component';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { CategoryComponent } from './components/category/category.component';
import { AddAuctionComponent } from './components/auction/add-auction/add-auction.component';
import { ActiveAuctionsComponent } from './components/auction/active-auctions/active-auctions.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { AuctionService } from "./services/auction.service";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuctionComponent,
    CategoryComponent,
    AddAuctionComponent,
    ActiveAuctionsComponent,
    LoginComponent,
    SignupComponent,
    ActiveAuctionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
  ],
  providers: [AuctionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
