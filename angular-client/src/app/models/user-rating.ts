import {UserAccount} from "./useraccount";

export class UserRating {
  constructor(private id: number,
              private userAccount: UserAccount,
              private rating: number) {
  }
}
