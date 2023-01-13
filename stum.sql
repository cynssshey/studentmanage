/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 5.7.19 : Database - stum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stum`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` char(10) NOT NULL COMMENT '学号',
  `sname` char(10) NOT NULL COMMENT '姓名',
  `sex` char(10) NOT NULL COMMENT '性别',
  `cid` char(10) NOT NULL COMMENT '班级',
  `college` char(10) NOT NULL COMMENT '学院',
  `major` char(10) NOT NULL COMMENT '专业',
  `inyear` year(4) NOT NULL COMMENT '入学年份',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`sex`,`cid`,`college`,`major`,`inyear`) values 
('200321111','陈七','男','032','数学与统计学院','统计学',2020),
('210127036','王五','男','012','电气工程与自动化学院','智能电气',2021),
('210416001','魏平','男','041','石油化工学院','石油',2021),
('220527045','洪思思','女','052','土木工程学院','建筑学',2022),
('220727161','方圆','女','072','经济与管理学院','信息管理与信息系统',2022),
('221010013','张三','男','101','计算机与大数据学院','人工智能',2022),
('221031111','修改1','女','103','梅努斯','会计',2022),
('221320018','王一','男','132','化学学院\r\n','应用化学',2022),
('221320028','刘二','男','132','化学学院','应用化学',2022),
('221827065','钟六六','女','182','材料科学与工程学院','材料力学',2022),
('221927095','李四','女','192','法学院','经济法',2022);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` char(10) NOT NULL COMMENT '用户名',
  `password` char(10) NOT NULL COMMENT '密码',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`username`,`password`) values 
('admin1','abcde'),
('admin2','12345');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
