-- MySQL Script generated by MySQL Workbench
-- Wed May 15 22:39:11 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medellin_times
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `medellin_times` ;

-- -----------------------------------------------------
-- Schema medellin_times
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medellin_times` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `medellin_times` ;

-- -----------------------------------------------------
-- Table `medellin_times`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medellin_times`.`image` ;

CREATE TABLE IF NOT EXISTS `medellin_times`.`image` (
  `image_id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`image_id`),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medellin_times`.`news`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medellin_times`.`news` ;

CREATE TABLE IF NOT EXISTS `medellin_times`.`news` (
  `news_id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(50) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `subtitle` VARCHAR(250) NULL DEFAULT NULL,
  `content` VARCHAR(3000) NOT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  `updated_at` DATETIME NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`news_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medellin_times`.`image_news`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medellin_times`.`image_news` ;

CREATE TABLE IF NOT EXISTS `medellin_times`.`image_news` (
  `news_id` INT NOT NULL,
  `image_id` INT NOT NULL,
  PRIMARY KEY (`news_id`, `image_id`),
  INDEX `FK_imagenews_image_idx` (`image_id` ASC) VISIBLE,
  CONSTRAINT `FK_imagenews_image`
    FOREIGN KEY (`image_id`)
    REFERENCES `medellin_times`.`image` (`image_id`),
  CONSTRAINT `FK_imagenews_news`
    FOREIGN KEY (`news_id`)
    REFERENCES `medellin_times`.`news` (`news_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;