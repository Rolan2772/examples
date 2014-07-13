SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `crud` DEFAULT CHARACTER SET utf8 ;
USE `crud` ;

-- -----------------------------------------------------
-- Table `crud`.`contacts`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crud`.`contacts` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `address` VARCHAR(255) NOT NULL ,
  `gender` VARCHAR(255) NULL DEFAULT NULL ,
  `dob` TIMESTAMP NULL DEFAULT NULL ,
  `email` VARCHAR(255) NULL DEFAULT NULL ,
  `mobile` VARCHAR(255) NULL DEFAULT NULL ,
  `phone` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `unique_data` (`name` ASC, `address` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crud`.`statuses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crud`.`statuses` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(64) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crud`.`addresses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crud`.`addresses` (
  `id` INT NOT NULL ,
  `house` VARCHAR(255) NOT NULL ,
  `flat` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crud`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crud`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(128) NOT NULL ,
  `status` INT NOT NULL ,
  `address_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `users_statuses_idx` (`status` ASC) ,
  UNIQUE INDEX `address_id_UNIQUE` (`address_id` ASC) ,
  CONSTRAINT `users_statuses`
    FOREIGN KEY (`status` )
    REFERENCES `crud`.`statuses` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `addresses`
    FOREIGN KEY (`address_id` )
    REFERENCES `crud`.`addresses` (`id` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `crud` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
