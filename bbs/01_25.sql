CREATE TABLE shop_item(
    item_id number primary key,
    item_name VARCHAR2(100),
    item_desc varchar2(1000),
    like_it number(3,1),
    origin_price number,
    sale_price number,
    image varchar2(100)   
);

CREATE SEQUENCE shop_item_seq;

COMMIT;

insert into shop_item values(shop_item_seq.nextval,'coffee1','맛있는커피',4.5,6000,5000,'coffee1.png');
insert into shop_item values(shop_item_seq.nextval,'coffee2','맛있는커피',3.5,6000,5000,'coffee1.png');
insert into shop_item values(shop_item_seq.nextval,'coffee3','맛있는커피',1.5,6000,5000,'coffee3.png');

select * from shop_item;
