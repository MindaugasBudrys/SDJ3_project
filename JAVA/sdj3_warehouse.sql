


select * from sdj3_warehouse.products;
select * from sdj3_warehouse.pallets;

ALTER TABLE pallets AUTO_INCREMENT = 1;
ALTER TABLE products AUTO_INCREMENT = 1;

ALTER TABLE pallets MODIFY COLUMN shelf_id INT NOT NULL DEFAULT 0;


INSERT INTO `products` (`product_id`, `name`, `type`) VALUES
(1, 'Dreamzone', 'Pillow'),
(2, 'Classic', 'Pillow'),
(3, 'Modern', 'Pillow'),
(4, 'Comfort', 'Pillow'),
(5, 'Aliga', 'Chair'),
(6, 'Ninmtofte', 'Chair'),
(7, 'Aulum', 'Chair'),
(8, 'Austena', 'Chair'),
(9, 'Aloha', 'Chair');

INSERT INTO `pallets` (`product_id`, `quantity`) VALUES
('1', '200'),
('2', '200'),
('3', '200'),
('4', '200'),
('5', '200'),
('6', '200'),
('7', '200'),
('8', '200'),
('9', '200'),
('10', '200'),
('11', '200'),
('12', '200'),
('13', '200'),
('14', '200'),
('15', '200'),
('16', '200'),
('17', '200'),
('18', '200'),
('19', '200'),
('20', '200');