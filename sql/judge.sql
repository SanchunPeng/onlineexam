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

/*Table structure for table `judge` */

DROP TABLE IF EXISTS `judge`;

CREATE TABLE `judge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `answer` varchar(125) DEFAULT NULL,
  `chapter` varchar(128) DEFAULT NULL,
  `grade` varchar(64) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `judge` */

insert  into `judge`(`id`,`question`,`answer`,`chapter`,`grade`,`point`) values (1,'计算机的内存储器分为随机存储器（RAM）和只读存储器（ROM）两部分。','one','第一章','易',3),(2,'程序设计语言分为机器语言、汇编语言和高级语言三大类。','one','第一章','易',3),(3,'内存储器的ROM是读写存储器，而RAM是只读存储器，用户不能写入信息。','two','第一章','易',3),(4,'调试程序DEBUG中的T、P命令的功能没有区别。','two','第一章','易',3),(5,'DEBUG中所使用的数默认为十进制数，对十六进制数需要加H。','two','第一章','易',3),(6,'MUL指令和IMUL指令功能完全相同。','two','第二章','易',3),(7,'汇编语言中对无符号数和有符号数的判别指令是不同的。','one','第二章','易',3),(8,'LOOPE和LOOPZ的功能完全相同。','one','第二章','易',3),(9,'指令AAA必须紧跟在加法指令之后使用。','one','第二章','易',3),(10,'INC指令之后可以使用加法调整指令','two','第二章','易',3),(11,'AAD指令放在除法指令之后。','two','第三章','难',3),(12,'无条件转移指令对标志位无影响，而条件转移指令对标志位有影响。','two','第三章','难',3),(13,'间接转移指令都可以通过寄存器来寻址。','two','第三章','难',3),(14,'DS中的内容就是数据段的段地址','two','第三章','难',3),(15,'一个微机有640KB内存，指的是内存容量为640K个字节。','one','第三章','难',3),(16,'十进制数的8,写成二进制应该是1000。','one','第四章','难',3),(17,'寄存器SP和BP都可以用来访问堆栈内容。','one','第四章','难',3),(18,'结束DEBUG返回DOS的命令为Q','one','第四章','难',3),(19,'语句LENGTH=SIZE*TYPE是合法的','two','第四章','难',3),(20,'串操作指令中用DI作为目的变址寄存器时使用段寄存器ES','one','第四章','难',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
