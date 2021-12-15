CREATE DATABASE ShareAndBorrow
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

INSERT INTO `ShareAndBorrow`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');
INSERT INTO `ShareAndBorrow`.`role` (`id`, `name`) VALUES ('2', 'ROLE_ADMIN');

INSERT INTO `ShareAndBorrow`.`user` (`id`, `email`, `first_name`, `last_name`, `password`, `pesel`, `username`, `address_id`) VALUES ('1', 'admin@admin.com', 'Admin', 'Admin', '$2a$10$LUU.kNZFpqHWu4V9mvK0fOKeExZOHeh9U3pUZy060xUBpfOQ4uTKW', '81010673396', 'admin', '1');
INSERT INTO `ShareAndBorrow`.`user` (`id`, `email`, `first_name`, `last_name`, `password`, `pesel`, `username`, `address_id`) VALUES ('2', 'a@a.com', 'aaaa', 'aaaa', '$2a$10$LUU.kNZFpqHWu4V9mvK0fOKeExZOHeh9U3pUZy060xUBpfOQ4uTKW', '71051699972', 'aaaa', '2');

INSERT INTO `ShareAndBorrow`.`user_roles` VALUES ('1','1');
insert INTO `ShareAndBorrow`.`user_roles` values ('1','2');
INSERT INTO `ShareAndBorrow`.`user_roles` VALUES ('2','1');

INSERT INTO `ShareAndBorrow`.`address` (`id`, `city`, `country`, `flat_number`, `home_number`, `postal_code`, `street`, `user_name`, `voievodyship`) VALUES ('1', 'City', 'Polska', '1f', '1h', '00-999', 'Street', 'admin', 'mazowieckie');
INSERT INTO `ShareAndBorrow`.`address` (`id`, `city`, `country`, `flat_number`, `home_number`, `postal_code`, `street`, `user_name`, `voievodyship`) VALUES ('1', 'aCity', 'Polska', 'a1f', 'a1h', '00-999', 'aStreet', 'aaaa','mazowieckie');

/* 
login and password for main admin in database 
login: admin
password: admin1234 
*/
