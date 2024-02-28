select 'initDb script started executing' AS '';

-- --------------------------------------
--        CREATE A DB IF NONE
-- --------------------------------------
CREATE DATABASE IF NOT EXISTS `pop_prod_db`;
USE `pop_prod_db`;

CREATE TABLE IF NOT EXISTS `product` (
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`created_date` datetime(6), 
	`code` varchar(15) NOT NULL,
	`name` varchar(255) NOT NULL,
	`price_eur` decimal NOT NULL,
	`price_usd` decimal NOT NULL,
	`description` varchar(255),
	UNIQUE (code)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `product` (
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`created_date` datetime(6),
    `reviewer` varchar(255) NOT NULL,
    `text` varchar(255),
    `rating` tinyint(1) NOT NULL,
    FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

select 'initDb script finished executing' AS '';
