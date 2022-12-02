/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : logistics

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2022-12-02 16:34:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'password');
INSERT INTO `admin` VALUES ('2', 'test1', '1234');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `cat_name` varchar(255) DEFAULT NULL,
  `car_brand` varchar(255) DEFAULT NULL,
  `car_region` varchar(255) DEFAULT NULL,
  `car_del` int(11) DEFAULT '0',
  `car_repair` int(11) DEFAULT '0',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '驾驶员', '品牌', '配送路线', '0', '0');
INSERT INTO `car` VALUES ('1001', '公师傅', '北汽', '临沂至德州', '0', '0');
INSERT INTO `car` VALUES ('1002', '姬师傅', '大众', '临沂至济南', '0', '0');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `order_number` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `custumer_id` int(11) DEFAULT NULL,
  `deleted` int(11) DEFAULT '0',
  `sex` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `get_name` varchar(255) DEFAULT NULL,
  `get_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '客户姓名', '客户邮箱', '客户电话', '地区', '配送地址', '1', '0', '0', '2022-11-30 18:03:43', null, null);
INSERT INTO `client` VALUES ('44635556', null, null, '12345678901', null, '临沂————青岛', '1002', '0', '0', '2022-11-30 09:30:34', null, null);
INSERT INTO `client` VALUES ('194358827', '客户姓名', null, '客户电话', null, '临沂————德州', '1001', '0', '0', '2022-11-29 15:12:05', null, null);
INSERT INTO `client` VALUES ('221252447', '客户姓名', null, '客户电话', null, '临沂————德州', '1001', '1', '0', '2022-11-29 15:12:07', null, null);
INSERT INTO `client` VALUES ('226144000', '小帅', null, 'qweqwe', null, 'wqwq--------ewew', '1002', '1', '0', '2022-11-30 11:20:35', null, null);
INSERT INTO `client` VALUES ('333641740', '小帅', null, '12345678901', null, 'gg————gg', '1002', '0', '0', '2022-11-30 11:58:12', 'gg', 'gg');
INSERT INTO `client` VALUES ('383517766', '客户姓名', null, '客户电话', null, '临沂————德州', '1001', '0', '0', '2022-11-29 15:12:06', null, null);
INSERT INTO `client` VALUES ('438862905', null, null, '12345678901', null, '临沂————德州', '1002', '0', '0', '2022-11-30 06:51:05', null, null);
INSERT INTO `client` VALUES ('665686851', '小帅', null, '12345678901', null, 'gg————gg', '1002', '0', '1', '2022-11-30 12:14:25', 'gg', 'gg');
INSERT INTO `client` VALUES ('667876057', null, null, '12345678901', null, '临沂————青岛', '1002', '0', '1', '2022-11-30 09:30:33', null, null);
INSERT INTO `client` VALUES ('778568956', '小帅', null, '12345678901', null, '22————22', '1002', '0', '0', '2022-11-30 12:19:21', '11', '11');
INSERT INTO `client` VALUES ('886948477', null, null, '12345678901', null, '临沂————青岛', '1002', '1', '0', '2022-11-30 09:30:32', null, null);
INSERT INTO `client` VALUES ('930672213', '小帅', null, '12345678901', null, 'gg————gg', '1002', '1', '0', '2022-11-30 11:57:32', 'gg', 'gg');
INSERT INTO `client` VALUES ('1042082960', '小帅', null, '12345678901', null, 'jinan————qingdao', '1002', '1', '0', '2022-11-30 11:52:27', 'jjkk', '121212');
INSERT INTO `client` VALUES ('1113168479', '小帅', null, '12345678901', null, 'gg————gg', '1002', '1', '0', '2022-11-30 12:03:44', 'gg', 'gg');
INSERT INTO `client` VALUES ('1218577762', null, null, '12345678901', null, '临沂————青岛', '1002', '1', '0', '2022-11-30 09:30:31', null, null);
INSERT INTO `client` VALUES ('1230920214', '客户姓名', null, '客户电话', null, '德州————济南', '1001', '0', '0', '2022-11-29 14:37:12', null, null);
INSERT INTO `client` VALUES ('1350733612', null, null, '12345678901', null, '临沂————青岛', '1002', '0', '0', '2022-11-30 09:30:34', null, null);
INSERT INTO `client` VALUES ('1411282163', '小帅', null, '12345678901', null, 'gg————gg', '1002', '0', '0', '2022-11-30 12:05:21', 'gg', 'gg');
INSERT INTO `client` VALUES ('1430553414', null, null, '12345678901', null, '临沂————青岛', '1002', '0', '0', '2022-11-30 09:30:33', null, null);
INSERT INTO `client` VALUES ('1603650647', '小帅', null, '12345678901', null, 'gg————gg', '1002', '0', '0', '2022-11-30 12:04:29', 'gg', 'gg');
INSERT INTO `client` VALUES ('1804229241', '客户姓名', null, '客户电话', null, '临沂————德州', '1001', '0', '0', '2022-11-29 15:12:08', null, null);
INSERT INTO `client` VALUES ('1956324155', '小帅', null, '12345678901', null, 'qq————qq', '1002', '0', '0', '2022-11-30 12:25:02', 'qq', 'qq');
INSERT INTO `client` VALUES ('1998576738', '客户姓名', null, '客户电话', null, '临沂————德州', '1001', '0', '0', '2022-11-29 15:12:04', null, null);
INSERT INTO `client` VALUES ('2002744785', '小帅', null, '12345678901', null, '临沂德州', '1002', '0', '0', '2022-11-30 11:21:48', null, null);
INSERT INTO `client` VALUES ('2096402201', '小帅', null, '12345678901', null, 'qq————qq', '1002', '0', '0', '2022-11-30 12:07:24', 'qq', 'qq');

-- ----------------------------
-- Table structure for custumer
-- ----------------------------
DROP TABLE IF EXISTS `custumer`;
CREATE TABLE `custumer` (
  `custumer_id` int(11) NOT NULL AUTO_INCREMENT,
  `custumer_name` varchar(255) DEFAULT NULL,
  `custumer_password` varchar(255) DEFAULT NULL,
  `custumer_tel` varchar(255) DEFAULT NULL,
  `custumer_address` varchar(255) DEFAULT NULL,
  `custumer_del` int(1) DEFAULT '0',
  PRIMARY KEY (`custumer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custumer
-- ----------------------------
INSERT INTO `custumer` VALUES ('1001', '客户姓名', '客户密码', '客户电话', '客户地址', '0');
INSERT INTO `custumer` VALUES ('1002', '小帅', '1234', '12345678901', '山东临沂', '0');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `order_number` int(11) NOT NULL DEFAULT '0',
  `evaluate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('44635556', null);
INSERT INTO `evaluate` VALUES ('194358827', null);
INSERT INTO `evaluate` VALUES ('221252447', null);
INSERT INTO `evaluate` VALUES ('226144000', null);
INSERT INTO `evaluate` VALUES ('287590394', '五星');
INSERT INTO `evaluate` VALUES ('333641740', null);
INSERT INTO `evaluate` VALUES ('383517766', null);
INSERT INTO `evaluate` VALUES ('391676284', null);
INSERT INTO `evaluate` VALUES ('429084869', null);
INSERT INTO `evaluate` VALUES ('438862905', null);
INSERT INTO `evaluate` VALUES ('665686851', null);
INSERT INTO `evaluate` VALUES ('667876057', null);
INSERT INTO `evaluate` VALUES ('778568956', null);
INSERT INTO `evaluate` VALUES ('799619737', null);
INSERT INTO `evaluate` VALUES ('803698168', '五星好评');
INSERT INTO `evaluate` VALUES ('886948477', null);
INSERT INTO `evaluate` VALUES ('930672213', null);
INSERT INTO `evaluate` VALUES ('1033781703', null);
INSERT INTO `evaluate` VALUES ('1042082960', null);
INSERT INTO `evaluate` VALUES ('1113168479', null);
INSERT INTO `evaluate` VALUES ('1218577762', null);
INSERT INTO `evaluate` VALUES ('1230920214', null);
INSERT INTO `evaluate` VALUES ('1350733612', null);
INSERT INTO `evaluate` VALUES ('1411282163', null);
INSERT INTO `evaluate` VALUES ('1419488781', null);
INSERT INTO `evaluate` VALUES ('1430553414', null);
INSERT INTO `evaluate` VALUES ('1603650647', null);
INSERT INTO `evaluate` VALUES ('1701608549', '五星');
INSERT INTO `evaluate` VALUES ('1731122624', null);
INSERT INTO `evaluate` VALUES ('1804229241', null);
INSERT INTO `evaluate` VALUES ('1956324155', null);
INSERT INTO `evaluate` VALUES ('1998576738', null);
INSERT INTO `evaluate` VALUES ('2002744785', null);
INSERT INTO `evaluate` VALUES ('2096402201', null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_amount` varchar(255) DEFAULT NULL,
  `goods_del` int(11) DEFAULT '0',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '货物名称', '货物数量', '0');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `brith` varchar(255) DEFAULT NULL,
  `card_id` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '员工姓名', '1', '生日', '身份证号', '电话号码', '1', '部门', '地址');

-- ----------------------------
-- Table structure for step_list
-- ----------------------------
DROP TABLE IF EXISTS `step_list`;
CREATE TABLE `step_list` (
  `order_number` int(11) DEFAULT NULL,
  `state_name` varchar(255) DEFAULT NULL,
  `address_at` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step_list
-- ----------------------------
INSERT INTO `step_list` VALUES ('438862905', '快递发出', '辽宁省大连市甘井子区中转站', '2022-11-30 08:12:17', '3');
INSERT INTO `step_list` VALUES ('438862905', '快递发出', '辽宁省大连市甘井子区中转站', '2022-11-30 08:12:18', '4');
INSERT INTO `step_list` VALUES ('438862905', '快递发出', '辽宁省大连市甘井子区中转站', '2022-11-30 08:12:19', '5');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:16:38', '6');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:16:57', '7');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:16:57', '8');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:16:58', '9');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:17:00', '10');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:17:00', '11');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:18:05', '12');
INSERT INTO `step_list` VALUES ('44635556', '快递发出', null, '2022-11-30 12:18:06', '13');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouse_id` int(11) NOT NULL,
  `warehouse_address` varchar(255) DEFAULT NULL,
  `warehouse_region` varchar(255) DEFAULT NULL,
  `warehouse_adname` varchar(255) DEFAULT NULL,
  `warehouse_adtel` varchar(255) DEFAULT NULL,
  `warehouse_del` int(11) DEFAULT NULL,
  `warehouse_repertory` int(11) DEFAULT NULL,
  `warehouse_goods` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '仓库地址', '仓库区域', '仓库管理员姓名', '仓库管理员电话号码', '0', '0', '仓库货物名称');
