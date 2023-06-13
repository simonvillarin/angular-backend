DROP DATABASE IF EXISTS shopping_cart;
CREATE DATABASE shopping_cart;

\c shopping_cart

DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS checkout;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;

CREATE TABLE users(
	user_id serial PRIMARY KEY,
	first_name varchar(80),
	middle_name varchar(80),
	last_name varchar(80),
	birthdate date,
	list_of_interest text[],
	house varchar(250),
	building varchar(250),
	street varchar(250),
    barangay varchar(250),
	city varchar(250),
	province varchar(250),
	zipcode varchar(10),
	email varchar(80),
	phone_number varchar(80),
	username varchar(80),
	password varchar(80),
	role varchar(10),
	status boolean
);

CREATE TABLE products(
	product_id serial PRIMARY KEY,
	product_name text,
	brand varchar(80),
	category varchar(80),
	description text[],
	img varchar(255),
	quantity int,
	price numeric(12, 2),
	num_of_user_rated int,
	ratings numeric(12, 2),
	sold_items int,
	sold_price numeric(12, 2),
	available boolean
);

CREATE TABLE comments(
	comment_id serial PRIMARY KEY,
	user_id int,
	product_id int,
	commentator varchar(255),
	rating numeric(12, 2),
	comment_date date,
	comment text,
	FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade on update cascade,
	FOREIGN KEY (product_id) REFERENCES products(product_id) on delete cascade on update cascade
);

CREATE TABLE images(
	image_id serial PRIMARY KEY,
	filename varchar(255) unique,
	mime_type varchar(30),
	data bytea
);

CREATE TABLE cart_items(
	cart_id serial PRIMARY KEY,
	user_id int,
	product_id int,
	product_name text,
	category varchar(80),
	description text[],
	image varchar(255),
	quantity int,
	price numeric(12, 2),
	FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade on update cascade,
	FOREIGN KEY (product_id) REFERENCES products(product_id) on delete cascade on update cascade
);

CREATE TABLE orders(
	order_id serial PRIMARY KEY,
	order_tracking int,
	user_id int,
	product_id int,
	product_name text,
	category varchar(80),
	image varchar(255),
	description text[],
	quantity int,
	price numeric(12, 2),
	order_date date,
	total_quantity int,
	total_price numeric(12, 2),
	FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade on update cascade,
	FOREIGN KEY (product_id) REFERENCES products(product_id) on delete cascade on update cascade
);

CREATE TABLE checkout(
	checkout_id serial PRIMARY KEY,
	user_id int,
	product_id int,
	cart_id int,
	product_name text,
	category varchar(80),
	image varchar(255),
	description text[],
	quantity int,
	price numeric(12, 2),
	FOREIGN KEY (user_id) REFERENCES users(user_id) on delete cascade on update cascade,
	FOREIGN KEY (product_id) REFERENCES products(product_id) on delete cascade on update cascade,
	FOREIGN KEY (cart_id) REFERENCES cart_items(cart_id) on delete cascade on update cascade
);

CREATE TABLE categories(
	category_id serial PRIMARY KEY,
	category varchar(80)
);


CREATE TABLE brands(
	brand_id serial PRIMARY KEY,
	brand varchar(80)
);