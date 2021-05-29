import {EventEmitter, Injectable, Output} from '@angular/core';
import {Auction} from '../models/auction';
import {UserAccount} from '../models/useraccount';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {



  @Output() _searchTagChanged: EventEmitter<string> = new EventEmitter();
  @Output() _categoryChanged: EventEmitter<string> = new EventEmitter();
  @Output() _auctionTabClicked: EventEmitter<any> = new EventEmitter();
  @Output() _categoryTabToggled: EventEmitter<any> = new EventEmitter();
  @Output() _categoryListChanged: EventEmitter<any> = new EventEmitter();

  constructor() { }

  searchTagChange(searchTag: string) {
    this._searchTagChanged.emit(searchTag);
  }

  categoryChange(category: string) {
    this._categoryChanged.emit(category);
  }

  clickAuctionTab() {
    this._auctionTabClicked.emit();
  }
  toggleCategoryTab() {
    this._categoryTabToggled.emit();
  }
  callCategoryChanging() {
    this._categoryListChanged.emit();
  }

}
