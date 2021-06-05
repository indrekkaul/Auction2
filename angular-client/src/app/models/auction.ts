import {UserAccount} from "./useraccount";
import {Category} from "./category";
import {Address} from "./address";

export class Auction {
    id: number;
    title: string;
    description: string;
    seller: UserAccount;
    itemCategory: Category;
    minimumPrice: number;
    buyNowPrice: number;
    isPromotedToPremium: boolean;
    userLocation: Address;
    created: Date;
    ending: Date;
    numberOfVisits: number;
    active: boolean;
}
