CREATE SCHEMA `user-realm` ;

CREATE TABLE `user-realm`.`realm` (
  `id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL,
  `description` VARCHAR(255) NULL,
  `realm_key` VARCHAR(32) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));