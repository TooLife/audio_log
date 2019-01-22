CREATE DATABASE audio_log;

USE audio_log;

CREATE TABLE `company` (
  `comp_num` int(11) NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(100) NOT NULL,
  `comp_addr` varchar(100) NOT NULL,
  PRIMARY KEY (`comp_num`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;


CREATE TABLE `plan` (
  `plan_num` int(11) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(100) NOT NULL,
  PRIMARY KEY (`plan_num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `sys_audio_log` (
  `log_num` int(11) NOT NULL AUTO_INCREMENT,
  `log_data` varchar(255) DEFAULT NULL,
  `create_dt` date DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`log_num`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;