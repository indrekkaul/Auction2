import {AccountStatus} from "./accountstatus";
import {AccountType} from "./account-type";
import {Address} from "./address";

export class UserAccount {
  constructor(private id: number,
              private accountName: string,
              private email: string,
              private password: string,
              private address: Address,
              private accountCreated: Date,
              private accountStatus: AccountStatus,
              private accountType: AccountType,
              private active: boolean) {
  }
}
