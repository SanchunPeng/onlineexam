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

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `uid` varchar(50) NOT NULL,
  `loginname` varchar(50) DEFAULT NULL,
  `loginpass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`uid`,`loginname`,`loginpass`) values ('201520602011','student1','123456'),('201520602012','student2','123456'),('201520602013','student3','123456'),('201520602014','student4','123456'),('201520602015','student5','123456'),('201520602016','student6','123456'),('201520602017','student7','123456'),('201520602018','student8','123456'),('201520602019','student9','123456'),('201520602020','student10','123456'),('201520602021','student11','123456'),('201520602022','student12','123456'),('201520602023','student13','123456'),('201520602024','student14','123456'),('201520602025','student15','123456'),('201520602026','student16','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
