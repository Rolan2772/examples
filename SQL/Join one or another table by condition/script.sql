SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `advanced_sql` ;
CREATE SCHEMA IF NOT EXISTS `advanced_sql` DEFAULT CHARACTER SET utf8 ;
USE `advanced_sql` ;

-- -----------------------------------------------------
-- Table `advanced_sql`.`legal_entity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `advanced_sql`.`legal_entity` ;

CREATE TABLE IF NOT EXISTS `advanced_sql`.`legal_entity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `advanced_sql`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `advanced_sql`.`profile` ;

CREATE TABLE IF NOT EXISTS `advanced_sql`.`profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `legal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `legal_fk1` (`legal_id` ASC),
  CONSTRAINT `legal_fk`
    FOREIGN KEY (`legal_id`)
    REFERENCES `advanced_sql`.`legal_entity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `advanced_sql`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `advanced_sql`.`team` ;

CREATE TABLE IF NOT EXISTS `advanced_sql`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `legal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `team_fk1` (`legal_id` ASC),
  CONSTRAINT `team_fk1`
    FOREIGN KEY (`legal_id`)
    REFERENCES `advanced_sql`.`legal_entity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `advanced_sql`.`team_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `advanced_sql`.`team_profile` ;

CREATE TABLE IF NOT EXISTS `advanced_sql`.`team_profile` (
  `team_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  INDEX `pk` (`profile_id` ASC, `team_id` ASC),
  INDEX `fk1_idx` (`team_id` ASC),
  INDEX `fk2_idx` (`profile_id` ASC),
  CONSTRAINT `tp_fk1`
    FOREIGN KEY (`team_id`)
    REFERENCES `advanced_sql`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tp_fk2`
    FOREIGN KEY (`profile_id`)
    REFERENCES `advanced_sql`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `advanced_sql`.`legal_entity`
-- -----------------------------------------------------
START TRANSACTION;
USE `advanced_sql`;
INSERT INTO `advanced_sql`.`legal_entity` (`id`, `name`) VALUES (1, 'Legal 1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `advanced_sql`.`profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `advanced_sql`;
INSERT INTO `advanced_sql`.`profile` (`id`, `name`, `legal_id`) VALUES (1, 'RU', 1);
INSERT INTO `advanced_sql`.`profile` (`id`, `name`, `legal_id`) VALUES (2, 'EN', 1);
INSERT INTO `advanced_sql`.`profile` (`id`, `name`, `legal_id`) VALUES (3, 'DE', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `advanced_sql`.`team`
-- -----------------------------------------------------
START TRANSACTION;
USE `advanced_sql`;
INSERT INTO `advanced_sql`.`team` (`id`, `name`, `legal_id`) VALUES (1, 'Team 1', 1);
INSERT INTO `advanced_sql`.`team` (`id`, `name`, `legal_id`) VALUES (2, 'Team 2', 1);
INSERT INTO `advanced_sql`.`team` (`id`, `name`, `legal_id`) VALUES (3, 'Team 3', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `advanced_sql`.`team_profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `advanced_sql`;
INSERT INTO `advanced_sql`.`team_profile` (`team_id`, `profile_id`) VALUES (2, 1);
INSERT INTO `advanced_sql`.`team_profile` (`team_id`, `profile_id`) VALUES (2, 2);
INSERT INTO `advanced_sql`.`team_profile` (`team_id`, `profile_id`) VALUES (3, 1);

COMMIT;

