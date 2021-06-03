delete from bidding;
delete from transaction_evaluation;
delete from purchase;
delete from purchase_auctions;
delete from auction;
delete from user_account;
delete from category;
delete from address;


insert into auctiondb.address(id, active, city, country, state, street, zip)
VALUES('1',1,'Tallinn','Estonia','111','111','12345');
insert into auctiondb.address(id, active, city, country, state, street, zip)
VALUES('2',1,'Riga','Latvia','222','222','54321');
insert into auctiondb.address(id, active, city, country, state, street, zip)
VALUES('3',1,'Helsinki','Finland','333','333','547613');

insert into auctiondb.user_account(id, account_created, account_name, account_status, account_type, active, email, password, address_id)
values ('1','18.05.21','First Account','ACTIVE','PREMIUM',1,'firstaccount@test.com','111','1');
insert into auctiondb.user_account(id, account_created, account_name, account_status, account_type, active, email, password, address_id)
values ('2','19.05.21','Second Account','ACTIVE','PREMIUM',1,'second@test.com','222','2');
insert into auctiondb.user_account(id, account_created, account_name, account_status, account_type, active, email, password, address_id)
values ('3','21.05.21','Third Account','ACTIVE','PREMIUM',1,'third@test.com','333','3');

insert into auctiondb.category(id, active, description, name)
VALUES (1,1,'First of the Category','First Category');
insert into auctiondb.category(id, active, description, name)
VALUES (2,1,'Second of the Category','Second Category');
insert into auctiondb.category(id, active, description, name)
VALUES (3,1,'Third of the Category','Third Category');

insert into auctiondb.auction(id, active, buy_now_price, created, description, ending, is_promoted_to_premium, minimum_price, number_of_visits, title, item_category_id, user_account_id, user_location_id, seller_id)
VALUE (1,1,400,'20.05.21','First Auction','20.05.23',0,2,0,'Chek out First Auction',1,1,1,1);
insert into auctiondb.auction(id, active, buy_now_price, created, description, ending, is_promoted_to_premium, minimum_price, number_of_visits, title, item_category_id, user_account_id, user_location_id,seller_id)
VALUE (2,1,5000,'20.05.21','Second Auction','20.05.23',1,100,0,'Chek out Second Auction',2,2,2,2);
insert into auctiondb.auction(id, active, buy_now_price, created, description, ending, is_promoted_to_premium, minimum_price, number_of_visits, title, item_category_id, user_account_id, user_location_id,seller_id)
VALUE (3,1,100000,'20.05.21','Third Auction','20.05.26',1,5000,0,'Chek out Third Auction',3,3,3,3);
insert into auctiondb.auction(id, active, buy_now_price, created, description, ending, is_promoted_to_premium, minimum_price, number_of_visits, title, item_category_id, user_account_id, user_location_id,seller_id)
VALUES (4,0,500,'23.05.21','Old Car','26.05.21',1,100,100,'Very old Car',3,1,1,1);

insert into auctiondb.bidding(id, active, price, auction_id, user_id)
VALUES (1,1,300,1,1);
insert into auctiondb.bidding(id, active, price, auction_id, user_id)
VALUES (2,1,4000,2,2);
insert into auctiondb.bidding(id, active, price, auction_id, user_id)
VALUES (3,1,30000,3,3);
insert into auctiondb.bidding(id, active, price, auction_id, user_id)
VALUES (4,0,800,4,1);

insert into auctiondb.purchase(id, final_price, user_id, active)
VALUES (1,800,1,1);

insert into auctiondb.transaction_evaluation (id, buyer_rating, seller_comment, seller_rating, purchase_id, active)
VALUES (1,5,'NC sell',5,1,1);

insert into auctiondb.purchase_auctions(purchase_id, auctions_id)
VALUES (1,4);

insert into auctiondb.purchase(id, active, final_price, user_id, auction_id, buyer_id, seller_id)
VALUES (2,1,800,1,1,1,2);

