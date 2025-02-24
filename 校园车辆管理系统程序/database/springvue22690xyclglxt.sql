/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : springvue22690xyclglxt

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2024-09-14 15:42:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cx` varchar(50) NOT NULL COMMENT '权限',
  `username` varchar(50) NOT NULL COMMENT '帐号',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(10) NOT NULL COMMENT '性别',
  `dianhua` varchar(50) NOT NULL COMMENT '电话',
  `beizhu` text NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', '超级管理员', 'admin', 'admin', '张德帅', '男', '13012054861', 'xxx');
INSERT INTO `admins` VALUES ('2', '管理员', '100', '100', '张三', '男', '13411111111', 'XXX');
INSERT INTO `admins` VALUES ('3', '管理员', '200', '200', '李四', '男', '13458621032', 'XXX');

-- ----------------------------
-- Table structure for `chelianglichang`
-- ----------------------------
DROP TABLE IF EXISTS `chelianglichang`;
CREATE TABLE `chelianglichang` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cheliangruchangid` int(10) unsigned NOT NULL COMMENT '车辆入场id',
  `ruchangbianhao` varchar(50) NOT NULL COMMENT '入场编号',
  `ruchangshijian` varchar(25) NOT NULL COMMENT '入场时间',
  `cheliangpaihao` varchar(50) NOT NULL COMMENT '车辆牌号',
  `chezhudianhua` varchar(50) NOT NULL COMMENT '车主电话',
  `lichangshijian` varchar(25) NOT NULL COMMENT '离场时间',
  `tingcheshichang` int(11) NOT NULL DEFAULT '0' COMMENT '停车时长',
  `lichangbeizhu` text NOT NULL COMMENT '离场备注',
  `jingshouren` varchar(50) NOT NULL COMMENT '经手人',
  PRIMARY KEY (`id`),
  KEY `chelianglichang_cheliangruchangid_index` (`cheliangruchangid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='车辆离场';

-- ----------------------------
-- Records of chelianglichang
-- ----------------------------
INSERT INTO `chelianglichang` VALUES ('1', '1', '091415003425', '2024-09-14 15:00:16', '京A*21052', '13450326580', '2024-09-14 17:04:27', '3', '111', '100');
INSERT INTO `chelianglichang` VALUES ('2', '3', '091415361966', '2024-09-14 15:36:14', '京A*12054', '13402359985', '2024-09-14 17:36:30', '3', '111', '200');

-- ----------------------------
-- Table structure for `cheliangruchang`
-- ----------------------------
DROP TABLE IF EXISTS `cheliangruchang`;
CREATE TABLE `cheliangruchang` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ruchangbianhao` varchar(50) NOT NULL COMMENT '入场编号',
  `ruchangshijian` varchar(25) NOT NULL COMMENT '入场时间',
  `cheliangpaihao` varchar(50) NOT NULL COMMENT '车辆牌号',
  `chezhudianhua` varchar(50) NOT NULL COMMENT '车主电话',
  `ruchangshuoming` varchar(255) NOT NULL COMMENT '入场说明',
  `zhuangtai` varchar(50) NOT NULL COMMENT '状态',
  `jingshouren` varchar(50) NOT NULL COMMENT '经手人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='车辆入场';

-- ----------------------------
-- Records of cheliangruchang
-- ----------------------------
INSERT INTO `cheliangruchang` VALUES ('1', '091415003425', '2024-09-14 15:00:16', '京A*21052', '13450326580', 'XXX', '已离场', '100');
INSERT INTO `cheliangruchang` VALUES ('2', '091415352308', '2024-09-14 15:35:54', '京A*0235', '13456820321', 'XXX', '已入场', '200');
INSERT INTO `cheliangruchang` VALUES ('3', '091415361966', '2024-09-14 15:36:14', '京A*12054', '13402359985', 'XXX', '已离场', '200');

-- ----------------------------
-- Table structure for `chewei`
-- ----------------------------
DROP TABLE IF EXISTS `chewei`;
CREATE TABLE `chewei` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(50) NOT NULL COMMENT '编号',
  `mingcheng` varchar(255) NOT NULL COMMENT '名称',
  `quyu` varchar(50) NOT NULL COMMENT '区域',
  `weizhi` varchar(50) NOT NULL COMMENT '位置',
  `beizhu` text NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='车位';

-- ----------------------------
-- Records of chewei
-- ----------------------------
INSERT INTO `chewei` VALUES ('1', '091414481726', '公共停车场A', 'A', 'XXX', 'XX');
INSERT INTO `chewei` VALUES ('2', '091414488737', '公共停车场B', 'B', 'XX', 'XX');
INSERT INTO `chewei` VALUES ('3', '091415345303', '公共停车场C', 'C', 'XXX', 'XXX');

-- ----------------------------
-- Table structure for `fangkeyonghu`
-- ----------------------------
DROP TABLE IF EXISTS `fangkeyonghu`;
CREATE TABLE `fangkeyonghu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) NOT NULL COMMENT '账号',
  `mima` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(10) NOT NULL COMMENT '性别',
  `lianxifangshi` varchar(50) NOT NULL COMMENT '联系方式',
  `gerenyouxiang` varchar(50) NOT NULL COMMENT '个人邮箱',
  `gerenjianjie` text NOT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='访客用户';

-- ----------------------------
-- Records of fangkeyonghu
-- ----------------------------
INSERT INTO `fangkeyonghu` VALUES ('1', '999', '999', '李毅', '男', '13485652012', '3250@qq.com', 'XXX');
INSERT INTO `fangkeyonghu` VALUES ('2', '666', '666', '王美丽', '女', '13452368541', '002@qq.com', 'XXX');

-- ----------------------------
-- Table structure for `fangwenshijian`
-- ----------------------------
DROP TABLE IF EXISTS `fangwenshijian`;
CREATE TABLE `fangwenshijian` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kaishi` varchar(25) NOT NULL COMMENT '开始',
  `jiezhi` varchar(25) NOT NULL COMMENT '截止',
  `shuoming` varchar(255) NOT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='访问时间';

-- ----------------------------
-- Records of fangwenshijian
-- ----------------------------
INSERT INTO `fangwenshijian` VALUES ('1', '09:00', '20:00', '其余时间访客不予登录');

-- ----------------------------
-- Table structure for `quxiao`
-- ----------------------------
DROP TABLE IF EXISTS `quxiao`;
CREATE TABLE `quxiao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `yuyueid` int(10) unsigned NOT NULL COMMENT '预约id',
  `bianhao` varchar(50) NOT NULL COMMENT '编号',
  `mingcheng` varchar(255) NOT NULL COMMENT '名称',
  `quyu` varchar(50) NOT NULL COMMENT '区域',
  `weizhi` varchar(50) NOT NULL COMMENT '位置',
  `riqi` varchar(25) NOT NULL COMMENT '日期',
  `yuyuebianhao` varchar(50) NOT NULL COMMENT '预约编号',
  `yuyueshijian` varchar(25) NOT NULL COMMENT '预约时间',
  `chepaihao` varchar(50) NOT NULL COMMENT '车牌号',
  `yuyuefangke` varchar(50) NOT NULL COMMENT '预约访客',
  `quxiaoyuanyin` text NOT NULL COMMENT '取消原因',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '取消时间',
  PRIMARY KEY (`id`),
  KEY `quxiao_yuyueid_index` (`yuyueid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='取消';

-- ----------------------------
-- Records of quxiao
-- ----------------------------
INSERT INTO `quxiao` VALUES ('1', '1', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '09141517303', '14:00', '京A*86352', '999', '11', '2024-09-14 15:18:24');
INSERT INTO `quxiao` VALUES ('2', '2', '091414488737', '公共停车场B', 'B', 'B2', '2024-09-21', '091415192013', '15:00', '京A*8220', '999', '11', '2024-09-14 15:20:10');
INSERT INTO `quxiao` VALUES ('3', '4', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '091415225722', '15:22', '234324', '999', '11', '2024-09-14 15:22:45');
INSERT INTO `quxiao` VALUES ('4', '5', '091415345303', '公共停车场C', 'C', 'XXX', '2024-09-20', '091415389832', '14:00', '京A*0009', '666', '111', '2024-09-14 15:39:05');

-- ----------------------------
-- Table structure for `shengyuchewei`
-- ----------------------------
DROP TABLE IF EXISTS `shengyuchewei`;
CREATE TABLE `shengyuchewei` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cheweiid` int(10) unsigned NOT NULL COMMENT '车位id',
  `bianhao` varchar(50) NOT NULL COMMENT '编号',
  `mingcheng` varchar(255) NOT NULL COMMENT '名称',
  `quyu` varchar(50) NOT NULL COMMENT '区域',
  `weizhi` varchar(50) NOT NULL COMMENT '位置',
  `riqi` varchar(25) NOT NULL COMMENT '日期',
  `shengyuchewei` int(11) NOT NULL DEFAULT '0' COMMENT '剩余车位',
  `shuoming` varchar(50) NOT NULL COMMENT '说明',
  PRIMARY KEY (`id`),
  KEY `shengyuchewei_cheweiid_index` (`cheweiid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='剩余车位';

-- ----------------------------
-- Records of shengyuchewei
-- ----------------------------
INSERT INTO `shengyuchewei` VALUES ('1', '2', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '100', '11');
INSERT INTO `shengyuchewei` VALUES ('2', '2', '091414488737', '公共停车场B', 'B', 'B2', '2024-09-21', '102', '11');
INSERT INTO `shengyuchewei` VALUES ('3', '1', '091414481726', '公共停车场A', 'A', 'A2', '2024-09-20', '100', '11');
INSERT INTO `shengyuchewei` VALUES ('4', '1', '091414481726', '公共停车场A', 'A', 'A1', '2024-09-20', '100', '11');
INSERT INTO `shengyuchewei` VALUES ('6', '3', '091415345303', '公共停车场C', 'C', 'XXX', '2024-09-20', '100', '1');

-- ----------------------------
-- Table structure for `teshufangxing`
-- ----------------------------
DROP TABLE IF EXISTS `teshufangxing`;
CREATE TABLE `teshufangxing` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fangxingbianhao` varchar(50) NOT NULL COMMENT '放行编号',
  `fangxingshijian` varchar(25) NOT NULL COMMENT '放行时间',
  `cheliangpaihao` varchar(50) NOT NULL COMMENT '车辆牌号',
  `chezhudianhua` varchar(50) NOT NULL COMMENT '车主电话',
  `chezhuxingming` varchar(50) NOT NULL COMMENT '车主姓名',
  `chezhushenfenzhenghao` varchar(50) NOT NULL COMMENT '车主身份证号',
  `fangxingshuoming` text NOT NULL COMMENT '放行说明',
  `jingshouren` varchar(50) NOT NULL COMMENT '经手人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='特殊放行';

-- ----------------------------
-- Records of teshufangxing
-- ----------------------------
INSERT INTO `teshufangxing` VALUES ('1', '091415064901', '2024-09-12 15:06:37', '京A*32250', '134023589562', '张鹏', '411281197704185460', 'XXX', '100');
INSERT INTO `teshufangxing` VALUES ('2', '091415368828', '2024-09-14 15:36:50', '京A*00125', '13458954521', '订单', '152224196701133425', 'XXX', '200');

-- ----------------------------
-- Table structure for `xiaoneicheliang`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoneicheliang`;
CREATE TABLE `xiaoneicheliang` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cheliangbianhao` varchar(50) NOT NULL COMMENT '车辆编号',
  `cheliangmingcheng` varchar(255) NOT NULL COMMENT '车辆名称',
  `cheliangpinpai` varchar(50) NOT NULL COMMENT '车辆品牌',
  `cheliangyanse` varchar(50) NOT NULL COMMENT '车辆颜色',
  `cheliangpaihao` varchar(50) NOT NULL COMMENT '车辆牌号',
  `cheliangjianjie` text NOT NULL COMMENT '车辆简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='校内车辆';

-- ----------------------------
-- Records of xiaoneicheliang
-- ----------------------------
INSERT INTO `xiaoneicheliang` VALUES ('1', 'A01', '商务大巴', 'BYD', '白色', '京A*888888', '111');
INSERT INTO `xiaoneicheliang` VALUES ('2', 'A02', '商务大巴2', 'BYD', '黑色', '京A*66666', 'XXX');

-- ----------------------------
-- Table structure for `xiaoneirenyuan`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoneirenyuan`;
CREATE TABLE `xiaoneirenyuan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) NOT NULL COMMENT '工号',
  `mima` varchar(50) NOT NULL COMMENT '密码',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `xingbie` varchar(10) NOT NULL COMMENT '性别',
  `lianxifangshi` varchar(50) NOT NULL COMMENT '联系方式',
  `youxiang` varchar(50) NOT NULL COMMENT '邮箱',
  `zhicheng` varchar(50) NOT NULL COMMENT '职称',
  `jianjie` text NOT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='校内人员';

-- ----------------------------
-- Records of xiaoneirenyuan
-- ----------------------------
INSERT INTO `xiaoneirenyuan` VALUES ('1', '001', '001', '蒋丽华', '女', '13458032542', '6523@qq.com', '教师', '111');

-- ----------------------------
-- Table structure for `yuyue`
-- ----------------------------
DROP TABLE IF EXISTS `yuyue`;
CREATE TABLE `yuyue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shengyucheweiid` int(10) unsigned NOT NULL COMMENT '剩余车位id',
  `bianhao` varchar(50) NOT NULL COMMENT '编号',
  `mingcheng` varchar(255) NOT NULL COMMENT '名称',
  `quyu` varchar(50) NOT NULL COMMENT '区域',
  `weizhi` varchar(50) NOT NULL COMMENT '位置',
  `riqi` varchar(25) NOT NULL COMMENT '日期',
  `yuyuebianhao` varchar(50) NOT NULL COMMENT '预约编号',
  `yuyueshijian` varchar(25) NOT NULL COMMENT '预约时间',
  `chepaihao` varchar(50) NOT NULL COMMENT '车牌号',
  `shenfenzhenghao` varchar(50) NOT NULL COMMENT '身份证号',
  `shoujihao` varchar(50) NOT NULL COMMENT '手机号',
  `xingming` varchar(50) NOT NULL COMMENT '姓名',
  `qitabeizhu` text NOT NULL COMMENT '其他备注',
  `yuyuefangke` varchar(50) NOT NULL COMMENT '预约访客',
  `zhuangtai` varchar(50) NOT NULL COMMENT '状态',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  PRIMARY KEY (`id`),
  KEY `yuyue_shengyucheweiid_index` (`shengyucheweiid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='预约';

-- ----------------------------
-- Records of yuyue
-- ----------------------------
INSERT INTO `yuyue` VALUES ('1', '1', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '09141517303', '14:00', '京A*86352', '429021196902144384', '13498565213', '李毅', '11', '999', '已取消', '2024-09-14 15:17:44');
INSERT INTO `yuyue` VALUES ('2', '2', '091414488737', '公共停车场B', 'B', 'B2', '2024-09-21', '091415192013', '15:00', '京A*8220', '429021196902144384', '13489503252', '李毅', '111', '999', '已取消', '2024-09-14 15:19:19');
INSERT INTO `yuyue` VALUES ('3', '1', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '091415204306', '15:00', '京A*5622', '429021196902144384', '13452365810', '李毅', '1111', '999', '已预约', '2024-09-14 15:20:54');
INSERT INTO `yuyue` VALUES ('4', '1', '091414488737', '公共停车场B', 'B', 'B1', '2024-09-20', '091415225722', '15:22', '234324', '429021196902144384', '13410235214', '11', '11', '999', '已取消', '2024-09-14 15:22:37');
INSERT INTO `yuyue` VALUES ('5', '6', '091415345303', '公共停车场C', 'C', 'XXX', '2024-09-20', '091415389832', '14:00', '京A*0009', '321100198506237142', '13466666666', '李丰收', 'XX', '666', '已取消', '2024-09-14 15:38:53');

-- ----------------------------
-- Table structure for `zhiliuquanchu`
-- ----------------------------
DROP TABLE IF EXISTS `zhiliuquanchu`;
CREATE TABLE `zhiliuquanchu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quanchubianhao` varchar(50) NOT NULL COMMENT '劝出编号',
  `cheliangpaihao` varchar(50) NOT NULL COMMENT '车辆牌号',
  `chezhuxingming` varchar(50) NOT NULL COMMENT '车主姓名',
  `chezhudianhua` varchar(50) NOT NULL COMMENT '车主电话',
  `ruchangshijian` varchar(25) NOT NULL COMMENT '入场时间',
  `quanchushijian` varchar(25) NOT NULL COMMENT '劝出时间',
  `zhiliushizhang` int(11) NOT NULL DEFAULT '0' COMMENT '滞留时长',
  `beizhushuoming` text NOT NULL COMMENT '备注说明',
  `jingshouren` varchar(50) NOT NULL COMMENT '经手人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='滞留劝出';

-- ----------------------------
-- Records of zhiliuquanchu
-- ----------------------------
INSERT INTO `zhiliuquanchu` VALUES ('1', '091415075543', '京A*02354', '李威', '13402365895', '2024-09-11 15:07:46', '2024-09-13 15:07:46', '49', '111', '100');
INSERT INTO `zhiliuquanchu` VALUES ('2', '091415375431', '京A*03368', '哈哈哈', '13456820236', '2024-09-10 15:37:14', '2024-09-12 15:37:14', '49', '111', '200');
