import {UserAccount} from "./useraccount";
import {Category} from "./category";
import {Address} from "./address";

export class Auction {
  constructor(private id: number,
    private title: string,
    private description: string,
    private seller: UserAccount,
    private itemCategory: Category,
    private minimumPrice: number,
    private buyNowPrice: number,
    private isPromotedToPremium: boolean,
    private userLocation: Address,
    private created: Date,
    private ending: Date,
    private numberOfVisits: number,
    private active: boolean) { }
}
