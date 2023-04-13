-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema EventMarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema EventMarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EventMarket` DEFAULT CHARACTER SET utf8 ;
USE `EventMarket` ;

-- -----------------------------------------------------
-- Table `EventMarket`.`MARKET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EventMarket`.`MARKET` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `status` ENUM("0", "1") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EventMarket`.`MARKET_OUTCOME`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EventMarket`.`MARKET_OUTCOME` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `status` ENUM("0", "1") NOT NULL,
  `MARKET_id` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_MARKET_OUTCOME_MARKET1_idx` (`MARKET_id` ASC) VISIBLE,
  CONSTRAINT `fk_MARKET_OUTCOME_MARKET1`
    FOREIGN KEY (`MARKET_id`)
    REFERENCES `EventMarket`.`MARKET` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EventMarket`.`EVENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EventMarket`.`EVENT` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(70) NOT NULL,
  `starts_at` DATETIME NOT NULL,
  `status` ENUM("0", "1") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EventMarket`.`EVENT_MARKET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EventMarket`.`EVENT_MARKET` (
  `id` VARCHAR(45) NOT NULL,
  `status` ENUM("0", "1") NOT NULL,
  `market_id` VARCHAR(45) NOT NULL,
  `event_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EVENT_MARKET_MARKET1_idx` (`market_id` ASC) VISIBLE,
  INDEX `fk_EVENT_MARKET_EVENT1_idx` (`event_id` ASC) VISIBLE,
  CONSTRAINT `fk_EVENT_MARKET_MARKET1`
    FOREIGN KEY (`market_id`)
    REFERENCES `EventMarket`.`MARKET` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_MARKET_EVENT1`
    FOREIGN KEY (`event_id`)
    REFERENCES `EventMarket`.`EVENT` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EventMarket`.`EVENT_MARKET_OUTCOME`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EventMarket`.`EVENT_MARKET_OUTCOME` (
  `id` VARCHAR(45) NOT NULL,
  `odd` DOUBLE NOT NULL,
  `status` ENUM("0", "1") NOT NULL,
  `event_market_id` VARCHAR(45) NOT NULL,
  `market_outcome_id` VARCHAR(45) NOT NULL,
  INDEX `fk_EVENT_MARKET_OUTCOME_EVENT_MARKET1_idx` (`event_market_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_EVENT_MARKET_OUTCOME_MARKET_OUTCOME1_idx` (`market_outcome_id` ASC) VISIBLE,
  CONSTRAINT `fk_EVENT_MARKET_OUTCOME_EVENT_MARKET1`
    FOREIGN KEY (`event_market_id`)
    REFERENCES `EventMarket`.`EVENT_MARKET` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_MARKET_OUTCOME_MARKET_OUTCOME1`
    FOREIGN KEY (`market_outcome_id`)
    REFERENCES `EventMarket`.`MARKET_OUTCOME` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
