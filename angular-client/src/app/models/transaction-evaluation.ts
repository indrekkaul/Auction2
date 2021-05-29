import {Purchase} from "./purchase";

export class TransactionEvaluation {
  constructor(private id: number,
              private purchase: Purchase,
              private sellerRating: number,
              private sellerComment: string,
              private buyerRating: number,
              private active: boolean) {
  }
}
