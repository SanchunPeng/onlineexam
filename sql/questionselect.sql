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

/*Table structure for table `questionselect` */

DROP TABLE IF EXISTS `questionselect`;

CREATE TABLE `questionselect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `answer` varchar(64) NOT NULL,
  `chapter` varchar(128) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `questionselect` */

insert  into `questionselect`(`id`,`question`,`optionA`,`optionB`,`optionC`,`optionD`,`answer`,`chapter`,`grade`,`point`) values (1,'CPU发出的访问存储器的地址是（）','A.物理地址','B.偏移地址','C.逻辑地址','D.段地址','A','第一章','易',3),(2,'DEC BYTE PTR［BX］中的操作数的数据类型是（）','A.字','B.双字','C.字节','D.四字','C','第一章','易',3),(3,'将高级语言的程序翻译成机器码程序的实用程序是（）','A.编译程序','B.汇编程序','C.解释程序','D.目标程序','A','第一章','易',3),(4,'在下列语句中，BUFFER称为（），BUFFER   DB     01H，0AH','A.符号','B.变量','C.助记符','D.标号','B','第一章','易',3),(5,'串操作指令中，源串操作数的段地址一定在（）寄存器中','A. CS','B. SS','C. DS','D. ES','C','第二章','易',3),(6,'使计算机执行某种操作的命令是（）','A.伪指令','B.指令','C.标号','D.助记符','B','第二章','易',3),(7,'将数据5618H存放在存储单元中的伪指令是（）','A. DATA1 DW 1856H','B. DATA1 DB 18H，56H','C. DATA1 EQU 5618H','D. DATA1 DB 18H，00H，56H，00H','B','第二章','易',3),(8,'若AX=3500H，CX=56B8H，当AND AX，CX指令执行后，AX=（）','A. 1400H','B. 77F8H','C. 0000H','D. 0FFFFH','A','第二章','易',3),(9,'计算机处理问题中会碰到大量的字符、符号，对此必须采用统一的二进制编码。目前，微机中普遍采用的是（）码。','A. BCD码','B.二进制码','C.ASCII码','D.十六进制码','C','第三章','易',3),(10,'用指令的助记符、符号地址、标号和伪指令、宏指令以及规定的格式书写程序的语言称为（）。','A.汇编语言','B.高级语言','C.机器语言','D.低级语言','A','第三章','易',3),(11,'有定义NUM  DB  \'12345\' ，汇编后，NUM占有（）字节存储单元','A.1','B.5','C.6','D.7','B','第三章','难',3),(12,'MOV  SP，3210H      PUSH  AX    执行上述指令序列后，SP寄存器的值是（）','A.3211H ','B.320EH','C.320FH','D.3212H','B','第三章','难',3),(13,'BUF  DW  10H  DUP（3 DUP（2，10H），3，5）语句汇编后，为变量BUF分配的存储单元字节数是（）。','A.80H','B.100H','C.124','D.192','A','第四章','难',3),(14,'下面指令序列执行后完成的运算，正确的算术表达式应是（）。     MOV AL，BYTE PTR  X     SHL AL，1     DEC AL \n    MOV BYTE PTR Y，AL ','A．Y=X*2+1','B．X=Y*2+1','C．X=Y*2-1','D．Y=X*2-1','D','第四章','难',3),(15,'对于下列程序段：AGAIN：MOV AL，[SI]                 MOV ES：[DI]，AL                 INC SI                 INC DI \n                LOOP AGAIN  也可用（）指令完成同样的功能。','A．REP MOVSB','B．REP LODSB','C．REP STOSB','D．REPE SCASB','A','第四章','难',3),(16,'设SP=1FFEH，执行下列指令后，SP寄存器的值是（）。     POPF     PUSH AX','A. 2000H','B. 2002H','C. 1FFCH','D. 1FFEH ','D','第四章','难',6),(17,'CPU发出的访问存储器的地址是（）','A.物理地址','B.偏移地址','C.逻辑地址','D.段地址','A','第四章','易',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
