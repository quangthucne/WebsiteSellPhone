USE master;
CREATE DATABASE sales_phone;
USE sales_phone;


CREATE TABLE [user] (
    id_user INT PRIMARY KEY IDENTITY(1,1),
    full_name NVARCHAR(255),
    username VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    gender BIT,
    role INT,
    email VARCHAR(255),
    phone VARCHAR(12),
    date_created DATE,
    status_user BIT
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
    name_category NVARCHAR(255),
    status_category BIT
);

CREATE TABLE product (
    id_product INT PRIMARY KEY IDENTITY(1,1),
    id_category INT,
    name_product NVARCHAR(255),
    short_desc NVARCHAR(255),
    detail NVARCHAR(255),
    quantity INT,
    price INT,
    date_created DATE,
    status_product BIT,
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
CREATE TABLE [order] (
    id_order INT PRIMARY KEY IDENTITY(1,1),
    id_user INT,
    phone VARCHAR(12),
    address NVARCHAR(255),
    full_name NVARCHAR(255),
    date_created DATE,
    status_order INT,
    FOREIGN KEY (id_user) REFERENCES [User](id_user)
);

CREATE TABLE order_detail (
    id_order_detail INT PRIMARY KEY IDENTITY(1,1),
    id_order INT,
    id_product INT,
    price INT,
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



-- data

-- Insert data for user table (Admin user)
INSERT INTO [user] (full_name, username, password, gender, role, email, phone, date_created, status_user)
VALUES ('Admin', 'admin', '12345678', 1, 1, 'admin@phoneweb.com', '1234567890', GETDATE(), 1);





-- select all product 
SELECT p.id AS product_id, p.name AS product_name, p.description AS description, p.price AS price, c.id AS category_id, c.name AS category_name, c.image AS category_image, img.name AS image_name
FROM products p JOIN categories c ON p.cat_id = c.id JOIN (SELECT prod_id, MIN(name) AS name
    FROM images
    GROUP BY prod_id) img ON p.id = img.prod_id



SELECT p.id_product, c.id_category, p.name, p.short_desc, p.detail, p.quantity, p.price, p.date_created, p.status, c.name, IMAGE.name 
FROM Product p JOIN Category c on p.id_category = c.id_category JOIN (SELECT id_product, id_image, MIN(name_image) as name 
        FROM Image 
        GROUP BY id_product, id_image) Image on p.id_product = Image.id_product

SELECT *
FROM product p JOIN category c on p.id_category = c.id_category JOIN (SELECT id_product, id_image, MIN(name_image) as name 
        FROM image 
        GROUP BY id_product, id_image) image on p.id_product = image.id_product


SELECT p.%s , c.%s, p.%s, p.%s, p.%s, p.%s, p.%s, p.%s, p.%s, c.%s, IMAGE.%s 
FROM Product p 
JOIN Category c on p.id_category = c.id_category 
JOIN (SELECT id_product, id_image, MIN(name_image) as name 
    FROM Image 
    GROUP BY id_product, id_image) Image on p.id_product = Image.id_product



SELECT DISTINCT * from [Order] o INNER join  [User] u on o.id_user = u.id_user

SELECT * FROM category

SELECT * FROM product
SELECT * FROM IMAGE



SELECT product.id_product , product.id_category, product.name_product, product.short_desc, product.detail, product.quantity, product.price, product.date_created, product.status_product, category.name_category, [image].name_image FROM product INNER JOIN category  ON product.id_category = category.id_category INNER JOIN (SELECT id_product, id_image, MIN(name_image) as name_image FROM [image] GROUP BY id_product, id_image ) [image]  ON product.id_product = [image].id_product 


SELECT product.id_product, product.id_category, product.name_product, product.short_desc, product.detail, product.quantity, product.price, product.date_created, product.status_product, category.name_category, img.name_image FROM product 
INNER JOIN category ON product.id_category = category.id_category 
INNER JOIN (SELECT id_product, name_image, ROW_NUMBER() OVER (PARTITION BY id_product ORDER BY id_image) AS row_num FROM [image]) AS img ON product.id_product = img.id_product AND img.row_num = 1 INNER JOIN cart_detail cd ON cd.id_product = product.id_product WHERE cd.id_cart = 1


SELECT product.id_product , product.id_category, product.name_product, product.short_desc, product.detail, product.quantity, product.price, product.date_created, product.status_product, category.name_category, img.name_image FROM product INNER JOIN category  ON product.id_category = category.id_category INNER JOIN (SELECT id_product, name_image, ROW_NUMBER() OVER (PARTITION BY id_product ORDER BY name_image) AS row_num FROM [image]) as img on product.id_product = [img].id_product AND img.row_num = 1

SELECT * FROM Product WHERE id_product = 14
SELECT * FROM [image]

DELETE from product WHERE id_product =

SELECT * FROM [user]
SELECT * FROM cart

SELECT * FROM address

SELECT * FROM [order]

SELECT * FROM order_detail

SELECT * FROM [orderd]


SELECT * FROM cart_detail WHERE id_cart = 2

delete from [user] WHERE id_user = 33

SELECT COUNT(*) FROM [user] WHERE email = 'quangthucdz@gmail.com'

SELECT product.id_product , product.id_category, product.name_product, product.short_desc, product.detail, product.quantity, product.price, product.date_created, product.status_product, category.name_category, img.name_image FROM product INNER JOIN category  ON product.id_category = category.id_category INNER JOIN (SELECT id_product, name_image, ROW_NUMBER() OVER (PARTITION BY id_product ORDER BY name_image) AS row_num FROM [image]) AS img ON product.id_product = img.id_product AND img.row_num = 1 INNER JOIN cart_detail cd ON cd.id_product = product.id_product WHERE cd.id_cart = 2;



SELECT 
    o.phone,
    o.address,
    o.full_name,
    od.id_product,
    od.price,
    od.quantity,
    o.date_created,
    o.status_order,
    (od.quantity * od.price) AS total_price
FROM 
    [order] o
JOIN 
    order_detail od ON o.id_order = od.id_order;



SELECT 
    o.*,
    od.id_product,
    od.price,
    od.quantity,
    (od.quantity * od.price) AS total_price
FROM 
    [order] o
JOIN 
    order_detail od ON o.id_order = od.id_order;

    SELECT 
    o.id_order,
    o.phone,
    o.address,
    o.full_name,
    o.date_created,
    o.status_order,
    SUM(od.quantity * od.price) AS total_price
FROM 
    [order] o
JOIN 
    order_detail od ON o.id_order = od.id_order
GROUP BY 
    o.id_order, 
    o.phone, 
    o.address, 
    o.full_name, 
    o.date_created, 
    o.status_order;



SELECT p.id_product, 
       p.name_product, 
       p.short_desc, 
       p.detail, 
       p.quantity, 
       p.price, 
       p.date_created, 
       p.status_product,
       img.name_image
FROM product p
LEFT JOIN (
    SELECT i.id_product, i.name_image,
           ROW_NUMBER() OVER (PARTITION BY i.id_product ORDER BY i.id_image DESC) AS rn
    FROM image i
) img ON p.id_product = img.id_product
WHERE p.id_product = ? 
  AND img.rn = 1;

  CREATE TRIGGER trg_update_product_quantity
ON order_detail
AFTER INSERT
AS
BEGIN
    -- Update the product quantity
    UPDATE product
    SET product.quantity = product.quantity - inserted.quantity
    FROM product
    INNER JOIN inserted ON product.id_product = inserted.id_product
    WHERE product.quantity >= inserted.quantity;
    
    -- Optional: Check if the product quantity becomes negative
    IF EXISTS (
        SELECT 1
        FROM product
        INNER JOIN inserted ON product.id_product = inserted.id_product
        WHERE product.quantity < 0
    )
    BEGIN
        -- If the quantity becomes negative, rollback the operation
        RAISERROR ('Not enough product quantity available for this order.', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;
