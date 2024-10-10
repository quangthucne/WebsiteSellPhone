USE master;
CREATE DATABASE sales_phone;
USE sell_phone;

CREATE TABLE role (
    id_role INT PRIMARY KEY IDENTITY(1,1),
    role_name VARCHAR(50)
);

INSERT INTO Role (role_name) VALUES ('ADMIN');
INSERT INTO Role (role_name) VALUES ('USER');
INSERT INTO Role (role_name) VALUES ('MODERATOR');

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
    category_name NVARCHAR(255),
    status BIT
);

CREATE TABLE product (
    id_product INT PRIMARY KEY IDENTITY(1,1),
    id_category INT,
    name_product NVARCHAR(255),
    short_desc NVARCHAR(255),
    detail NVARCHAR(255),
    quantity INT,
    price DECIMAL(19, 4),
    date_created DATE,
    status BIT,
    FOREIGN KEY (id_category) REFERENCES Category(id_category)
);
-- commit 2 product and image

CREATE TABLE cart (
    id_cart INT PRIMARY KEY IDENTITY(1,1),
    id_user INT,
    FOREIGN KEY (id_user) REFERENCES [User](id_user)
);

CREATE TABLE cart_detail (
    id_cart_detail INT PRIMARY KEY IDENTITY(1,1),
    id_cart INT,
    id_product INT,
    quantity_product INT,
    FOREIGN KEY (id_cart) REFERENCES Cart(id_cart),
    FOREIGN KEY (id_product) REFERENCES Product(id_product)
);
--
CREATE TABLE order (
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


-- select all product 
SELECT p.id AS product_id, p.name AS product_name, p.description AS description, p.price AS price, c.id AS category_id, c.name AS category_name, c.image AS category_image, img.name AS image_name
FROM products p JOIN categories c ON p.cat_id = c.id JOIN (SELECT prod_id, MIN(name) AS name
    FROM images
    GROUP BY prod_id) img ON p.id = img.prod_id



SELECT *
FROM Product p JOIN Category c on p.id_category = c.id_category JOIN (SELECT id_product, id_image, MIN(name_image) as name 
        FROM Image 
        GROUP BY id_product, id_image) Image on p.id_product = Image.id_product
