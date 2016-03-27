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

/*Table structure for table `cloze` */

DROP TABLE IF EXISTS `cloze`;

CREATE TABLE `cloze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `chapter` varchar(128) DEFAULT NULL,
  `grade` varchar(64) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `cloze` */

insert  into `cloze`(`id`,`question`,`answer`,`chapter`,`grade`,`point`) values (1,'通常所说的计算机系统包括________和________两大部分','硬件,软件','第一章','难',5),(2,'8086/8088存储器分四个段，这四个段的段名所对应的段寄存器分别是________、________、________、________。','CS,DS,ES,SS','第一章','难',5),(3,'PSW寄存器中共有______位条件状态位，有______位控制状态位。','6,3 ','第一章','易',5),(4,'已知（AX）=1234H，执行下述三条指令后，（AX）=________。','0000H','第二章','易',5),(5,'串指令中的目的操作数地址是由______提供','ES：[DI]','第二章','易',5),(6,'条件转移指令JNE的测试条件为________。','ZF=0','第二章','易',5),(7,'一个有128个字的数据区，它的起始地址为12ABH：00ABH，请给出这个数据区最末一个字单元的物理地址是________。','12C59H ','第三章','易',5),(8,'指令JMP FAR PTR DONE属于_______寻址','段间转移直接','第三章','易',5),(9,'若AX=2000H,CL=90H，则DIV CL执行后，AX=________。','8038H','第三章','易',5),(10,'若DX=1010H,则AND DX,DX的执行结果为________。','1010H','第四章','易',5),(11,'若BL=83H,CF=1,则ADC BL,90H执行后，BL=________。','14H','第四章','易',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
