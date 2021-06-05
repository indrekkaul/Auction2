import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActiveAuctionsComponent } from './components/auction/active-auctions/active-auctions.component';
import { CategoryComponent } from './components/category/category.component';
import { AddAuctionComponent } from './components/auction/add-auction/add-auction.component';

const routes: Routes = [

  {     path: 'auctions', component: ActiveAuctionsComponent  },
  {     path: 'addauction', component: AddAuctionComponent  },
  {     path: 'categorys', component: CategoryComponent  }
  //{     path: '', redirectTo: 'auctions' pathMatch 'full'  }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
