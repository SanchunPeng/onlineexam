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

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) DEFAULT NULL,
  `score` varchar(64) DEFAULT NULL,
  `selectScore` varchar(64) DEFAULT NULL,
  `judge` varchar(64) DEFAULT NULL,
  `cloze` varchar(64) DEFAULT NULL,
  `program` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `score` */

insert  into `score`(`id`,`studentName`,`score`,`selectScore`,`judge`,`cloze`,`program`) values (1,'student1','80','26','24','25','5'),(2,'student2','72','24','24','20','5'),(3,'student3','58','18','21','15','4'),(4,'student4','95','30','30','30','5'),(5,'student5','41','21','15','5',NULL),(6,'student6','53','15','18','20',NULL),(7,'student7','65','24','21','20',NULL),(8,'student8','73','21','27','25',NULL),(9,'student9','62','18','24','20',NULL),(10,'student10','64','26','18','20',NULL),(11,'student11','83','27','30','25',NULL),(12,'student12','77','27','30','20',NULL),(16,'student13','6','6','0','0',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
