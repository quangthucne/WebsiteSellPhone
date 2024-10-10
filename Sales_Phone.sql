USE master;
CREATE DATABASE sales_phone;
USE sales_phone;

CREATE TABLE role (
    id_role INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(50)
);

INSERT INTO Role (name) VALUES ('ADMIN');
INSERT INTO Role (name) VALUES ('USER');
INSERT INTO Role (name) VALUES ('MODERATOR');

CREATE TABLE user (
    id_user INT PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(255),
    user_name VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    gender BIT,
    id_role INT,
    email VARCHAR(255),
    phone VARCHAR(12),
    date_created DATE,
    status BIT,
    FOREIGN KEY (id_role) REFERENCES Role(id_role)
);

CREATE TABLE address (
    id_address INT PRIMARY KEY IDENTITY(1,1),
    id_user INT,
    phone VARCHAR(12),
    address NVARCHAR(255),
    full_name NVARCHAR(255),
    FOREIGN KEY (id_user) REFERENCES [User](id_user)
);
-- commit 1
CREATE TABLE category (
    id_category INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255),
    status BIT
);

CREATE TABLE product (
    id_product INT PRIMARY KEY IDENTITY(1,1),
    id_category INT,
    name NVARCHAR(255),
    short_desc NVARCHAR(255),
    detail NVARCHAR(255),
    quantity INT,
    price DECIMAL(19, 4),
    date_created DATE,
    status BIT,
    FOREIGN KEY (id_category) REFERENCES Category(id_category)
);

CREATE TABLE cart (
    id_cart INT PRIMARY KEY IDENTITY(1,1),
    id_user INT,
    FOREIGN KEY (id_user) REFERENCES [User](id_user)
);

CREATE TABLE cartDetail (
    id_cart_detail INT PRIMARY KEY IDENTITY(1,1),
    id_cart INT,
    id_product INT,
    quantity_product INT,
    FOREIGN KEY (id_cart) REFERENCES Cart(id_cart),
    FOREIGN KEY (id_product) REFERENCES Product(id_product)
);

CREATE TABLE crder (
    id_order INT PRIMARY KEY IDENTITY(1,1),
    id_user INT,
    phone VARCHAR(12),
    address NVARCHAR(255),
    full_name NVARCHAR(255),
    date_created DATE,
    status BIT,
    total_amount DECIMAL(19, 4),
    FOREIGN KEY (id_user) REFERENCES [User](id_user)
);

CREATE TABLE order_detail (
    id_order_detail INT PRIMARY KEY IDENTITY(1,1),
    id_order INT,
    id_product INT,
    price DECIMAL(19, 4),
    quantity INT,
    FOREIGN KEY (id_order) REFERENCES [Order](id_order),
    FOREIGN KEY (id_product) REFERENCES Product(id_product)
);

CREATE TABLE image (
    id_image INT PRIMARY KEY IDENTITY(1,1),
    id_product INT,
    name_image VARCHAR(255),
    FOREIGN KEY (id_product) REFERENCES Product(id_product)
);


