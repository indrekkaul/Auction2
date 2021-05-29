import {UserAccount} from "./useraccount";
import {Auction} from "./auction";

export class Purchase {
  constructor(private id: number,
              private auction: Auction,
              private seller: UserAccount,
              private buyer: UserAccount,
              private finalPrice: number,
              private active: boolean) {
  }
}
