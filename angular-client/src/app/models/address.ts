export class Address {
  constructor(private id: number,
              private street: string,
              private zip: string,
              private city: string,
              private state: string,
              private country: string,
              private active: boolean) {
  }
}
