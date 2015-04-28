/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : pigai

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-04-28 22:53:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `couserName` varchar(50) NOT NULL,
  `courseIntr` varchar(50) NOT NULL,
  `teacherId` varchar(50) NOT NULL,
  PRIMARY KEY (`courseId`),
  KEY `course_teacherId` (`teacherId`),
  CONSTRAINT `course_teacherId` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware` (
  `coursewareId` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `courseId` int(10) unsigned zerofill NOT NULL,
  `fileId` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`coursewareId`),
  KEY `courseware_courseId` (`courseId`),
  KEY `courseware_fileId` (`fileId`),
  CONSTRAINT `courseware_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `courseware_fileId` FOREIGN KEY (`fileId`) REFERENCES `file` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课件';

-- ----------------------------
-- Records of courseware
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fileId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) NOT NULL,
  `filePath` varchar(255) NOT NULL,
  `fileSize` double DEFAULT NULL,
  `fileType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上传文件';

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `homeworkId` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `introduction` varchar(50) NOT NULL,
  `courseId` int(11) unsigned zerofill NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`homeworkId`),
  KEY `homework_courseId` (`courseId`),
  CONSTRAINT `homework_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homework
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for selectcourse
-- ----------------------------
DROP TABLE IF EXISTS `selectcourse`;
CREATE TABLE `selectcourse` (
  `selectId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `courseId` int(32) unsigned zerofill NOT NULL,
  `studentId` varchar(50) NOT NULL,
  `grade` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`selectId`),
  KEY `select_courseId` (`courseId`),
  KEY `select_studentId` (`studentId`),
  CONSTRAINT `select_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `select_studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selectcourse
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '真实姓名',
  `school` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2141591', '王明月', '东华大学', '计算机科学与技术学院', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `student` VALUES ('2141604', '陆玉恒', '东华大学', '计算机科学与技术学院', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for submitrecord
-- ----------------------------
DROP TABLE IF EXISTS `submitrecord`;
CREATE TABLE `submitrecord` (
  `submitId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `homeworkId` int(32) unsigned zerofill NOT NULL,
  `fileId` int(32) unsigned zerofill NOT NULL,
  `studentId` varchar(50) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`submitId`),
  KEY `submit_homeworkId` (`homeworkId`),
  KEY `submit_fileId` (`fileId`),
  KEY `submit_studentId` (`studentId`),
  CONSTRAINT `submit_fileId` FOREIGN KEY (`fileId`) REFERENCES `file` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `submit_homeworkId` FOREIGN KEY (`homeworkId`) REFERENCES `homework` (`homeworkId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `submit_studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submitrecord
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `school` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `
telephone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
