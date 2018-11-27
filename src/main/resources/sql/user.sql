/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.40-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` int (11),
	`name` varchar (150),
	`password` varchar (150),
	`email` varchar (765)
); 
insert into `user` (`id`, `name`, `password`, `email`) values('1','软件','123456','922341@qq.com');
insert into `user` (`id`, `name`, `password`, `email`) values('3','软件竞赛','swd2weee3','aahhhhh@163.com');
