/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.42-log : Database - oj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oj` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `oj`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL COMMENT '帖子id',
  `num` int(11) NOT NULL COMMENT '评论编号',
  `content` text NOT NULL COMMENT '评论内容',
  `formor_num` int(11) DEFAULT NULL COMMENT '回复评论的编号',
  PRIMARY KEY (`id`,`num`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论信息';

/*Data for the table `comment` */

/*Table structure for table `contest` */

DROP TABLE IF EXISTS `contest`;

CREATE TABLE `contest` (
  `id` bigint(20) NOT NULL COMMENT '比赛id',
  `title` varbinary(100) NOT NULL COMMENT '比赛名称',
  `description` text COMMENT '比赛描述',
  `start_time` datetime NOT NULL COMMENT '比赛开始时间',
  `end_time` datetime NOT NULL COMMENT '比赛结束时间',
  `user_id` bigint(20) NOT NULL COMMENT '比赛创建人id',
  `private` tinyint(4) NOT NULL COMMENT '比赛状态0-私有，1-公开，2-保护',
  `landmark` int(11) NOT NULL COMMENT '答题语言选择',
  `defunct` tinyint(4) NOT NULL COMMENT '题目是否公布',
  PRIMARY KEY (`id`),
  KEY `contest_user_u` (`user_id`),
  CONSTRAINT `contest_user_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛信息表';

/*Data for the table `contest` */

/*Table structure for table `contest_problem` */

DROP TABLE IF EXISTS `contest_problem`;

CREATE TABLE `contest_problem` (
  `contest_id` bigint(20) NOT NULL COMMENT '比赛id',
  `problem_id` bigint(20) NOT NULL COMMENT '比赛引用题目id',
  `title` varchar(100) DEFAULT NULL COMMENT '比赛中题目的标题',
  `num` int(11) DEFAULT NULL COMMENT '比赛中题目的编号',
  PRIMARY KEY (`contest_id`,`problem_id`),
  KEY `problem_id` (`problem_id`),
  CONSTRAINT `contest_problem_ibfk_1` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`),
  CONSTRAINT `contest_problem_ibfk_2` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛题目表';

/*Data for the table `contest_problem` */

/*Table structure for table `language` */

DROP TABLE IF EXISTS `language`;

CREATE TABLE `language` (
  `id` smallint(6) NOT NULL COMMENT '语言编号',
  `name` varchar(32) NOT NULL COMMENT '语言名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='可用语言表单';

/*Data for the table `language` */

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL COMMENT '权限id',
  `url` varchar(255) NOT NULL COMMENT 'url地址',
  `url_name` varchar(64) NOT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表单';

/*Data for the table `permission` */

/*Table structure for table `problem` */

DROP TABLE IF EXISTS `problem`;

CREATE TABLE `problem` (
  `id` bigint(20) NOT NULL COMMENT '题目id',
  `title` varchar(100) NOT NULL COMMENT '题目标题',
  `description` text NOT NULL COMMENT '题目描述',
  `input_description` text COMMENT '输入说明',
  `output_description` text COMMENT '输出说明',
  `input_sample` text COMMENT '输入样例',
  `output_sample` text COMMENT '输出样例',
  `hint` text COMMENT '特别提示',
  `input_data` text COMMENT '输入数据',
  `output_data` text NOT NULL COMMENT '输出数据',
  `source` varchar(100) DEFAULT NULL COMMENT '题目来源',
  `create_time` datetime NOT NULL COMMENT '加入时间',
  `defunct` tinyint(4) NOT NULL COMMENT '是否发布',
  `accepted` int(11) DEFAULT NULL COMMENT '通过次数',
  `submit` int(11) DEFAULT NULL COMMENT '提交次数',
  `time_limit_c` int(11) DEFAULT NULL COMMENT 'C/C++时间限制(ms)',
  `memory_limmit_c` int(11) DEFAULT NULL COMMENT 'C/C++空间限制(kb)',
  `time_limit_o` int(11) DEFAULT NULL COMMENT '其他语言时间限制(ms)',
  `memory_limmit_o` int(11) DEFAULT NULL COMMENT '其他语言空间限制(kb)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目信息表';

/*Data for the table `problem` */

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `id` smallint(6) NOT NULL COMMENT '结果编号',
  `name` varchar(32) NOT NULL COMMENT '结果名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运行结果列表';

/*Data for the table `result` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL COMMENT '角色id',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `memo` varchar(100) NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表单';

/*Data for the table `role` */

/*Table structure for table `role_permissiom` */

DROP TABLE IF EXISTS `role_permissiom`;

CREATE TABLE `role_permissiom` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `role_permissiom_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_permissiom_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色对应权限';

/*Data for the table `role_permissiom` */

/*Table structure for table `run` */

DROP TABLE IF EXISTS `run`;

CREATE TABLE `run` (
  `id` bigint(20) NOT NULL COMMENT '运行id',
  `time` int(11) NOT NULL COMMENT '运行所用时间',
  `memory` int(11) NOT NULL COMMENT '运行所用空间',
  `error` text COMMENT '错误原因记录',
  PRIMARY KEY (`id`),
  CONSTRAINT `run_ibfk_1` FOREIGN KEY (`id`) REFERENCES `solution` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录编译运行结果';

/*Data for the table `run` */

/*Table structure for table `solution` */

DROP TABLE IF EXISTS `solution`;

CREATE TABLE `solution` (
  `id` bigint(20) NOT NULL COMMENT '运行id',
  `problem_id` bigint(20) NOT NULL COMMENT '题目id',
  `user_id` bigint(20) NOT NULL COMMENT '提交用户id',
  `in_date` datetime NOT NULL COMMENT '提交时间',
  `language` smallint(6) NOT NULL COMMENT '提交语言',
  `result` smallint(6) NOT NULL COMMENT '运行结果',
  `contest_id` bigint(20) DEFAULT NULL COMMENT '隶属于比赛的id',
  `code_length` int(11) NOT NULL COMMENT '代码长度kb',
  `code` text NOT NULL COMMENT '源代码',
  `pass_rate` decimal(6,3) DEFAULT NULL COMMENT '数据通过比例',
  PRIMARY KEY (`id`),
  KEY `problem_id` (`problem_id`),
  KEY `user_id` (`user_id`),
  KEY `result` (`result`),
  KEY `contest_id` (`contest_id`),
  CONSTRAINT `solution_ibfk_1` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`),
  CONSTRAINT `solution_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `solution_ibfk_3` FOREIGN KEY (`result`) REFERENCES `result` (`id`),
  CONSTRAINT `solution_ibfk_4` FOREIGN KEY (`contest_id`) REFERENCES `contest` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提交记录';

/*Data for the table `solution` */

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL COMMENT '日志id',
  `username` varchar(50) NOT NULL COMMENT '操作用户id',
  `operation` text COMMENT '操作内容',
  `time` decimal(11,0) NOT NULL COMMENT '操作消耗时间',
  `method` text COMMENT '操作方法',
  `params` text COMMENT '方法参数',
  `ip` varchar(64) NOT NULL COMMENT '操作者ip地址',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `syslog` */

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL COMMENT '帖子id',
  `problem_id` bigint(20) NOT NULL COMMENT '问题id',
  `title` varchar(100) NOT NULL COMMENT '帖子标题',
  `user_id` bigint(20) NOT NULL COMMENT '发帖人id',
  `status` tinyint(4) NOT NULL COMMENT '帖子状态',
  `content` text NOT NULL COMMENT '帖子内容',
  `defunct` tinyint(4) NOT NULL COMMENT '是否隐藏',
  `time` datetime NOT NULL COMMENT '发帖时间',
  PRIMARY KEY (`id`),
  KEY `problem_id` (`problem_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`),
  CONSTRAINT `topic_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子信息';

/*Data for the table `topic` */

/*Table structure for table `topic_stow` */

DROP TABLE IF EXISTS `topic_stow`;

CREATE TABLE `topic_stow` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `topic_id` bigint(20) NOT NULL COMMENT '收藏帖子id',
  PRIMARY KEY (`user_id`,`topic_id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `topic_stow_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `topic_stow_ibfk_2` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子收藏';

/*Data for the table `topic_stow` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `school` varchar(100) DEFAULT NULL COMMENT '学校名',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像图片路径',
  `solved` int(11) NOT NULL COMMENT '解决问题的数量',
  `submit` int(11) NOT NULL COMMENT '提交过的问题数量',
  `submit_all` int(11) NOT NULL COMMENT '提交次数',
  `success` text COMMENT '成功通过的题',
  `fail` text COMMENT '提交未通过',
  `status` tinyint(4) NOT NULL COMMENT '0-锁定，1-有效',
  `c_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `user` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户对应角色';

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
