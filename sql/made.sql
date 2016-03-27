/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - onlineexam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineexam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `onlineexam`;

/*Table structure for table `made` */

DROP TABLE IF EXISTS `made`;

CREATE TABLE `made` (
  `type` varchar(255) NOT NULL,
  `idString` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `made` */

insert  into `made`(`type`,`idString`) values ('cloze','5,6,7,8,9,10'),('judge','1,2,3,4,5,6,7,8,9,10'),('program','1'),('select','1,2,3,4,5,6,7,8,9,10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
