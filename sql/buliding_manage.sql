# --------------------------------------------------------
# Host:                         localhost
# Server version:               5.1.28-rc-community
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2017-11-07 08:36:52
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for buliding_manage
DROP DATABASE IF EXISTS `buliding_manage`;
CREATE DATABASE IF NOT EXISTS `buliding_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `buliding_manage`;


# Dumping structure for table buliding_manage.building
DROP TABLE IF EXISTS `building`;
CREATE TABLE IF NOT EXISTS `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `name` varchar(100) NOT NULL COMMENT '大楼名称',
  `number` varchar(100) NOT NULL COMMENT '大楼编号',
  `policy_id` int(11) NOT NULL COMMENT '开关功能id',
  PRIMARY KEY (`id`),
  KEY `FK_policy_id` (`policy_id`),
  CONSTRAINT `FK_policy_id` FOREIGN KEY (`policy_id`) REFERENCES `policy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大楼信息';

# Dumping data for table buliding_manage.building: ~0 rows (approximately)
DELETE FROM `building`;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
/*!40000 ALTER TABLE `building` ENABLE KEYS */;


# Dumping structure for table buliding_manage.dept
DROP TABLE IF EXISTS `dept`;
CREATE TABLE IF NOT EXISTS `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  `number` varchar(100) NOT NULL COMMENT '部门编号',
  `parent_id` int(11) NOT NULL COMMENT '父部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='部门信息';

# Dumping data for table buliding_manage.dept: ~2 rows (approximately)
DELETE FROM `dept`;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` (`id`, `name`, `number`, `parent_id`) VALUES
	(1, '总部', '001', 0),
	(2, '科研部', '1123', 1);
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;


# Dumping structure for table buliding_manage.device
DROP TABLE IF EXISTS `device`;
CREATE TABLE IF NOT EXISTS `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `imei` varchar(100) NOT NULL COMMENT 'imei',
  `imsi` varchar(100) NOT NULL COMMENT 'imsi',
  `imfi` varchar(100) NOT NULL COMMENT 'imfi',
  `phone` varchar(11) NOT NULL COMMENT '号码',
  `location_id` int(11) NOT NULL COMMENT '归属地id',
  PRIMARY KEY (`id`),
  KEY `FK_location_id` (`location_id`),
  CONSTRAINT `FK_location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机的一些信息';

# Dumping data for table buliding_manage.device: ~0 rows (approximately)
DELETE FROM `device`;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
/*!40000 ALTER TABLE `device` ENABLE KEYS */;


# Dumping structure for table buliding_manage.in_out_buliding
DROP TABLE IF EXISTS `in_out_buliding`;
CREATE TABLE IF NOT EXISTS `in_out_buliding` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `buliding_id` int(11) NOT NULL COMMENT '大楼id',
  `device_id` int(11) NOT NULL COMMENT '手机id',
  `in_time` bigint(20) NOT NULL COMMENT '进入大楼时间',
  `out_time` bigint(20) NOT NULL COMMENT '出大楼时间',
  `legal` int(1) NOT NULL DEFAULT '1' COMMENT '手机验证是否通过,1：合法，0：不合法',
  PRIMARY KEY (`id`),
  KEY `FK_device_id` (`device_id`),
  KEY `FK_buliding_id` (`buliding_id`),
  CONSTRAINT `FK_buliding_id` FOREIGN KEY (`buliding_id`) REFERENCES `building` (`id`),
  CONSTRAINT `FK_device_id` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录手机进出大楼的一些信息';

# Dumping data for table buliding_manage.in_out_buliding: ~0 rows (approximately)
DELETE FROM `in_out_buliding`;
/*!40000 ALTER TABLE `in_out_buliding` DISABLE KEYS */;
/*!40000 ALTER TABLE `in_out_buliding` ENABLE KEYS */;


# Dumping structure for table buliding_manage.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `name` varchar(100) NOT NULL COMMENT '归属地名称',
  `number` varchar(100) NOT NULL COMMENT '归属地编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='归属地信息';

# Dumping data for table buliding_manage.location: ~0 rows (approximately)
DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


# Dumping structure for table buliding_manage.manager
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `name` varchar(100) NOT NULL COMMENT '管理员名',
  `account` varchar(100) NOT NULL COMMENT '管理员账号',
  `password` varchar(100) NOT NULL COMMENT '管理员密码',
  `created_date` bigint(20) NOT NULL COMMENT '创建时间',
  `allow_deleted` int(1) DEFAULT '1' COMMENT '删除，1：允许，0：不允许',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(1) DEFAULT '1' COMMENT '状态，1：启用，2：冻结，3：删除',
  PRIMARY KEY (`id`),
  KEY `FK_manager_dept` (`dept_id`),
  CONSTRAINT `FK_manager_dept` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

# Dumping data for table buliding_manage.manager: ~1 rows (approximately)
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`id`, `name`, `account`, `password`, `created_date`, `allow_deleted`, `salt`, `dept_id`, `status`) VALUES
	(1, 'test1', 'test1', 'e10adc3949ba59abbe56e057f20f883e', 1111111, 0, '212', 1, 1);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;


# Dumping structure for table buliding_manage.manager_role
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE IF NOT EXISTS `manager_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `manager_id` int(11) NOT NULL COMMENT '管理员ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `FK_manager_role_role` (`role_id`),
  KEY `FK_manager_role_manager` (`manager_id`),
  CONSTRAINT `FK_manager_role_manager` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_manager_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员和角色关系';

# Dumping data for table buliding_manage.manager_role: ~1 rows (approximately)
DELETE FROM `manager_role`;
/*!40000 ALTER TABLE `manager_role` DISABLE KEYS */;
INSERT INTO `manager_role` (`id`, `manager_id`, `role_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `manager_role` ENABLE KEYS */;


# Dumping structure for table buliding_manage.permission
DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT 'url描述',
  `parent_id` int(11) NOT NULL COMMENT '父节点id',
  `per_url` varchar(256) DEFAULT NULL COMMENT '请求地址',
  `per_key` varchar(256) DEFAULT NULL COMMENT '权限key',
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='权限信息';

# Dumping data for table buliding_manage.permission: ~9 rows (approximately)
DELETE FROM `permission`;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `parent_id`, `per_url`, `per_key`, `type`) VALUES
	(1, '大楼管理', 0, '/buildingi/**', 'building', 1),
	(2, '部门管理', 0, '/dept/**', 'dept', 1),
	(3, '设备管理', 0, '/device/**', 'device', 1),
	(4, '进出大楼管理', 0, '/inOutBuliding/**', 'inOutBuliding', 1),
	(5, '归属地管理', 0, '/location/**', 'location', 1),
	(6, '管理员管理', 0, '/manager/**', 'manager', 1),
	(7, '权限管理', 0, '/permission/**', 'permission', 1),
	(8, '大楼策略管理', 0, '/policy/**', 'policy', 1),
	(9, '角色管理', 0, '/role/**', 'role', 1);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


# Dumping structure for table buliding_manage.policy
DROP TABLE IF EXISTS `policy`;
CREATE TABLE IF NOT EXISTS `policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `name` varchar(100) NOT NULL COMMENT '策略名称',
  `content` text NOT NULL COMMENT '开关功能',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进出大楼要开关的一些功能策略';

# Dumping data for table buliding_manage.policy: ~0 rows (approximately)
DELETE FROM `policy`;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;


# Dumping structure for table buliding_manage.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `allow_delete` int(1) NOT NULL DEFAULT '0' COMMENT '允许删除，0：不能删除，1：可以删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

# Dumping data for table buliding_manage.role: ~1 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `allow_delete`) VALUES
	(1, '超级管理员', 0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


# Dumping structure for table buliding_manage.role_permission
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE IF NOT EXISTS `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`),
  KEY `FK_role_permission_permission` (`permission_id`),
  KEY `FK_role_permission_role` (`role_id`),
  CONSTRAINT `FK_role_permission_permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_role_permission_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

# Dumping data for table buliding_manage.role_permission: ~4 rows (approximately)
DELETE FROM `role_permission`;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;


# Dumping structure for table buliding_manage.system_log
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE IF NOT EXISTS `system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `manager_id` int(11) NOT NULL COMMENT '管理员id',
  `manager_name` varchar(100) NOT NULL COMMENT '管理员名称',
  `manager_account` varchar(100) NOT NULL COMMENT '管理员账号',
  `description` varchar(256) NOT NULL COMMENT '日志描述',
  `created_date` bigint(20) NOT NULL COMMENT '创建时间',
  `client_ip` varchar(20) NOT NULL COMMENT '客户端IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统日志';

# Dumping data for table buliding_manage.system_log: ~1 rows (approximately)
DELETE FROM `system_log`;
/*!40000 ALTER TABLE `system_log` DISABLE KEYS */;
INSERT INTO `system_log` (`id`, `manager_id`, `manager_name`, `manager_account`, `description`, `created_date`, `client_ip`) VALUES
	(1, 1, 'test1', 'test1', '[类名]:com.dnp.bulidingmanage.controller.BuildingController,[方法]:findAll,[参数]:null,[ip]:0:0:0:0:0:0:0:1', 1509955295826, '0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `system_log` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
