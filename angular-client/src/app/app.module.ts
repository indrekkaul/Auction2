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
// import { ActiveAuctionComponent } from './components/auction/active-auction/active-auction.component';
import { ActiveAuctionsComponent } from './components/auction/active-auctions/active-auctions.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuctionComponent,
    CategoryComponent,
    AddAuctionComponent,
    // ActiveAuctionComponent,
    ActiveAuctionsComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
