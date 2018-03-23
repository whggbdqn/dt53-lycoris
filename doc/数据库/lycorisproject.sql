/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log : Database - lycorisproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lycorisproject` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lycorisproject`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `areainfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `area` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(45) NOT NULL,
  `companyemail` varchar(45) DEFAULT NULL,
  `companyinfo` text,
  `idarea` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

/*Table structure for table `companytoindex` */

DROP TABLE IF EXISTS `companytoindex`;

CREATE TABLE `companytoindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idindexes` int(11) DEFAULT NULL,
  `idcompany` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `companytoindex` */

/*Table structure for table `indexes` */

DROP TABLE IF EXISTS `indexes`;

CREATE TABLE `indexes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indexinfo` varchar(45) NOT NULL,
  `taglevel` int(11) NOT NULL,
  `indexclass` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `indexes` */

/*Table structure for table `originaldata` */

DROP TABLE IF EXISTS `originaldata`;

CREATE TABLE `originaldata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(45) NOT NULL,
  `companyinfo` text,
  `idarea` int(11) DEFAULT NULL,
  `companyemail` varchar(45) DEFAULT NULL,
  `otherinfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `originaldata` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `userlevel` int(11) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `idarea` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*Table structure for table `usertocompany` */

DROP TABLE IF EXISTS `usertocompany`;

CREATE TABLE `usertocompany` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `idcompany` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usertocompany` */

/*Table structure for table `usertoindex` */

DROP TABLE IF EXISTS `usertoindex`;

CREATE TABLE `usertoindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `idindexes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usertoindex` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
