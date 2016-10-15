/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - payroll
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`payroll` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `payroll`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `name` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`name`) values ('CSE'),('ECE'),('MECH');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `EmpID` int(10) NOT NULL auto_increment,
  `Name` varchar(15) default NULL,
  `Contact` varchar(15) default NULL,
  `EmailID` varchar(50) default NULL,
  `Address` varchar(255) default NULL,
  `Qualification` varchar(255) default NULL,
  `DOB` varchar(50) default NULL,
  `DOJ` varchar(50) default NULL,
  `Department` varchar(50) default NULL,
  `Post` varchar(50) default NULL,
  `UserName` varchar(50) default NULL,
  `Password` varchar(50) default NULL,
  PRIMARY KEY  (`EmpID`)
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`EmpID`,`Name`,`Contact`,`EmailID`,`Address`,`Qualification`,`DOB`,`DOJ`,`Department`,`Post`,`UserName`,`Password`) values (123,'Akshit ','7727827113','akshitgupta29@gmail.com','JECRC','PH.D.','29/4/95','1/2/13','CSE','PROF','akshit.cse','1234'),(124,'harsha','8740956601','harshaharyani6@gmail.com','JECRC','B.Tech','6/1/96','1/8/13','CSE','LECTURER','harsha.cse','1234'),(431,'Abhishek','7062370187','a@a.com','BH1','PH.D.','29/4/96','29/4/2005','CSE','PROF','123','1234');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) default NULL,
  `usertype` varchar(15) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`username`,`password`,`usertype`) values ('akshit','akshit123','admin'),('abhishek','abhishek123','admin'),('test','test123','faculty');

/*Table structure for table `month` */

DROP TABLE IF EXISTS `month`;

CREATE TABLE `month` (
  `Month` varchar(25) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `month` */

insert  into `month`(`Month`) values ('Select'),('January'),('February'),('March'),('April'),('May'),('June'),('July'),('August'),('September'),('October'),('November'),('December');

/*Table structure for table `payroll` */

DROP TABLE IF EXISTS `payroll`;

CREATE TABLE `payroll` (
  `EmpID` varchar(255) NOT NULL,
  `Post` varchar(255) default NULL,
  `Month` varchar(50) default NULL,
  `Leave` int(10) default NULL,
  `Basic` int(10) default NULL,
  `HR` int(10) default NULL,
  `TA/DA` int(10) default NULL,
  `PF` int(10) default NULL,
  `Rate` int(10) default NULL,
  `Taxes` int(10) default NULL,
  `Gross` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payroll` */

insert  into `payroll`(`EmpID`,`Post`,`Month`,`Leave`,`Basic`,`HR`,`TA/DA`,`PF`,`Rate`,`Taxes`,`Gross`) values ('123','Professor','March',3,30000,7500,4500,3000,10,3000,36000),('125','Prof','May',3,10000,2500,1500,1000,10,1000,12000);

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `post` */

insert  into `post`(`post`) values ('PROF'),('LECTURER');

/*Table structure for table `searchby` */

DROP TABLE IF EXISTS `searchby`;

CREATE TABLE `searchby` (
  `search by` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `searchby` */

insert  into `searchby`(`search by`) values ('Name'),('Post'),('Department');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
