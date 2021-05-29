import {Auction} from "./auction";
import {UserAccount} from "./useraccount";

export class Bidding {
  constructor(private id: number,
              private auction: Auction,
              private user: UserAccount,
              private price: number,
              private active: boolean) {
  }
}
