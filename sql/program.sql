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

/*Table structure for table `program` */

DROP TABLE IF EXISTS `program`;

CREATE TABLE `program` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `chapter` varchar(128) DEFAULT NULL,
  `grade` varchar(64) DEFAULT NULL,
  `point` int(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `program` */

insert  into `program`(`id`,`question`,`answer`,`chapter`,`grade`,`point`) values (1,'输入一个字符的可使用DOS的1号功能实现：      MOV AH, 1      INT 21H  \n    该DOS调用执行完后，会将输入的字符的ASCII码值送入AL寄存器。','A中给定的数恰好是该数平方值在平方数表中的相对位置，因此，可通过换码指令XLAT来实现从表中求平方值：      MOV BX, OFFSET SQTAB      MOV AL, A      XLAT','第一章','易',10),(2,' 试编写一程序片段，不使用乘除法指令，实现（（AX）*5+14）/ 2的功能（AX中的数据 理解为补码）','MOV BX,AX  MOV CX,2  SAL   AX,CX  ADD  AX,BX  ADD  AX,14 SAR   AX,1','第二章','易',10),(3,'设在内存单元SQTAB首址开始存放了0～15的平方数表。要求用直接查表法编一程序，求出A单元中给定数（＜=15＝的平方值送B单元保存。',':DATA SEGMENT  \n    SQTAB DB 0，1，4，9，16，25，36，49，64，81      DB 100，121，144，169，196，225      A DB 12      B DB？  \n    DATA ENDS  \n    CODE SEGMENT  \n    ASSUME CS：CODE，DS：DATA      START PROC FAR      PUSH DX      XOR AX，AX      PUSH AX  \n    MOV AX，DATA  ','第三章','难',10),(4,'定义一个数据区，它包含有23H，24H，25H和26H四个字符数据，把这个数据区复制20次，并显\n示出复制结果。','.DATA SEGMENT \nPATTERN DB 23H，24H，25H，26H DISPLAY DB 80 DUP(\' \')，\'$\' DATE ENDS CODE SEGMENT ┇ CLD \nLEA SI，PATTERN LEA DI，DISPLAY MOV CX，80 REP MOVSB MOV AH，09H LEA DX，DISPLAY INT 21H RET CODE ENDS','第四章','难',10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
