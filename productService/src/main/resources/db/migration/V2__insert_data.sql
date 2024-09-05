-- Insert into category table
INSERT INTO category (id, name) VALUES
(1, 'Electronics'),
(2,  'Furniture'),
(3,  'Books');



INSERT INTO product (id, available_quantity, description, name, price, category_id) VALUES
    (gen_random_uuid(), 50, 'Smartphone with 6GB RAM and 128GB storage', 'Smartphone XYZ', 299.99, 1),
    (gen_random_uuid(), 100, 'Comfortable cotton t-shirt', 'Cotton T-Shirt',  19.99, 2),
    (gen_random_uuid(), 20, 'Non-stick cookware set', 'Cookware Set', 89.99, 3);
--