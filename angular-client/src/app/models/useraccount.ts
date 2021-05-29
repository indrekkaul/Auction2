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
