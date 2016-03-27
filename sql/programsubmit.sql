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

/*Table structure for table `programsubmit` */

DROP TABLE IF EXISTS `programsubmit`;

CREATE TABLE `programsubmit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(258) DEFAULT NULL,
  `question` varchar(258) DEFAULT NULL,
  `studentAnswer` varchar(258) DEFAULT NULL,
  `getScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `programsubmit` */

insert  into `programsubmit`(`id`,`studentName`,`question`,`studentAnswer`,`getScore`) values (1,'student7','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H       该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','abc',NULL),(2,'student5','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','abc',NULL),(3,'student6','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','no answer',NULL),(4,'student8','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','no answer',NULL),(5,'student9','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','adfmnklASNDFAV',NULL),(6,'student10','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','no answer',NULL),(7,'student11','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','sfasdfvasdf',NULL),(8,'student12','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','wewwwwwwwwwwwwww',NULL),(9,'student13','输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','no answer',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
