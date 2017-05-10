


CREATE TABLE `products` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `type` text NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `id` (`product_id`)
) AUTO_INCREMENT= 1  DEFAULT CHARSET=latin1;

CREATE TABLE `pallets` (
  `pallet_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `shelf_id` int(11) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`pallet_id`)
) AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `products` (`product_id`, `name`, `type`) VALUES
(1, 'Dreamzone', 'Pillow'),
(2, 'Classic', 'Pillow'),
(3, 'Modern', 'Pillow'),
(4, 'Comfort', 'Pillow'),
(5, 'Aliga', 'Chair'),
(6, 'Ninmtofte', 'Chair'),
(7, 'Aulum', 'Chair'),
(8, 'Austena', 'Chair'),
(9, 'Aloha', 'Chair'),
(10, 'Taps', 'Table'),
(11, 'Kanstrup', 'Table'),
(12, 'Uggerby', 'Table'),
(13, 'Hallund', 'Table'),
(14, 'Galsted', 'Sofa'),
(15, 'Gedser', 'Sofa'),
(16, 'Brande', 'Sofa'),
(17, 'Egholt', 'Sofa'),
(18, 'Davinde', 'Sofa'),
(19, 'Batum', 'Sofa'),
(20, 'Fastrup', 'Sofa');

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


select * from sdj3_warehouse.products;

select * from sdj3_warehouse.pallets;