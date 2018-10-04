drop database if exists ww_shop;
create database ww_shop  default charset utf8;
GRANT ALL ON  ww_shop.* TO 'wangyang'@'localhost' IDENTIFIED BY '123456';
use ww_shop;
create table t_user(
	id int(11) primary key auto_increment,
	username varchar(100),
	nickname varchar(100),
	password varchar(100),
	type int(11)
);
create table t_address(
	id int(11) primary key auto_increment,
	name varchar(255),
	phone varchar(100),
	postcode varchar(100),
	user_id int(11),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES t_user(id)
);
create table t_orders(
	id int(11) primary key auto_increment,
	buyDate datetime,
	payDate datetime,
	confirmDate datetime,
	status int(11),
	user_id int(11),
	address_id int(11),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES t_user(id),
	CONSTRAINT FOREIGN KEY (address_id) REFERENCES t_address(id)
);
create table t_category(
	id int(11) primary key auto_increment,
	name varchar(100)
);
create table t_goods(
	id int(11) primary key auto_increment,
	name varchar(100),
	price double,
	intor text,
	img varchar(100),
	stock int (11),
	category_id int(11),
	CONSTRAINT FOREIGN KEY (category_id) REFERENCES t_category(id)
);
create table t_goods_orders(
	id int(11) primary key auto_increment,
	orders_id int(11),
	goods_id int(11),
	CONSTRAINT FOREIGN KEY (orders_id) REFERENCES t_orders(id),
	CONSTRAINT FOREIGN KEY (goods_id) REFERENCES t_goods(id)
);

