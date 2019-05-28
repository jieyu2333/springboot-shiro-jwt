/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2019-05-28 20:02:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '编号',
  `parent_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) CHARACTER SET utf8 NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '链接',
  `target` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '图标',
  `show_mark` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'Y' COMMENT '是否在菜单中显示',
  `permission` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '创建者',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '更新者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注信息',
  `del_mark` char(1) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_menu_del_flag` (`del_mark`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '20', '0,1,2,13,20,', '查看', '30', null, null, null, '0', 'sys:user:view', '1', '2018-12-19 23:05:17', '1', '2018-12-19 23:05:17', null, '0');
INSERT INTO `sys_menu` VALUES ('2', '20', '0,1,2,13,20,', '修改', '40', null, null, null, '0', 'sys:user:edit', '1', '2018-12-19 23:05:21', '1', '2018-12-19 23:05:21', null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL COMMENT '角色主键',
  `name` varchar(10) DEFAULT NULL COMMENT '角色名',
  `role` varchar(32) DEFAULT NULL COMMENT '角色值',
  `use_mark` char(1) DEFAULT 'Y' COMMENT '使用标记，Y启用，N停用',
  `del_mark` char(1) DEFAULT '0' COMMENT '删除标记，1删除，0未删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '最高管理员', 'superadmin', 'Y', '0', '2018-12-07 15:04:50', '2018-12-07 15:04:50', '1', '1', null);
INSERT INTO `sys_role` VALUES ('2', '管理员', 'admin', 'Y', '0', '2018-12-07 15:04:55', '2018-12-07 15:04:55', '1', '1', null);
INSERT INTO `sys_role` VALUES ('3', '普通用户', 'user', 'Y', '0', '2018-12-07 17:17:25', '2018-12-07 17:17:25', '1', '1', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '角色编号',
  `menu_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色-菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `id_num` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `sex` char(1) DEFAULT NULL COMMENT '性别，1男2女3未知',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `use_mark` char(1) DEFAULT 'Y' COMMENT '使用标记,Y启用,N停用',
  `del_mark` char(1) DEFAULT '0' COMMENT '删除标记，1删除0未删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `last_login_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0b3c8b049eeb43a89769057bfca73405', 'jack0b3c8b049eeb43a89769057bfca73405', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:08', '2019-04-30 17:12:08', null, null, null, null);
INSERT INTO `sys_user` VALUES ('0db8c10fc96343eaa45ddc7fc1a11510', 'jack0db8c10fc96343eaa45ddc7fc1a11510', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:09', '2019-04-30 17:12:09', null, null, null, null);
INSERT INTO `sys_user` VALUES ('1', '11', '111', '1', '1', '11', null, '1', '1', '11', 'Y', '0', '2018-12-05 16:56:13', '2019-05-28 19:41:21', '1', '13dc0adc226d492e93a599bfdf90afa9', '2019-05-28 19:41:20', null);
INSERT INTO `sys_user` VALUES ('163c9ff990594931b8b927038f8778f6', 'jack163c9ff990594931b8b927038f8778f6', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:09', '2019-04-30 17:12:09', null, null, null, null);
INSERT INTO `sys_user` VALUES ('1b7ef7518c724f03b73a718dfcad5f6f', 'jack1b7ef7518c724f03b73a718dfcad5f6f', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:08', '2019-04-30 17:12:08', null, null, null, null);
INSERT INTO `sys_user` VALUES ('2', '22', '111', '1', '1', '1', null, '1', '2', '11', 'Y', '0', '2018-12-05 16:56:26', '2018-12-06 14:17:29', '1', '4', '2018-12-16 01:10:03', null);
INSERT INTO `sys_user` VALUES ('3', '33', '111', '1', '1', '1', null, '1', '1', '1', 'Y', '0', '2018-12-07 17:15:37', '2018-12-07 17:15:37', '1', '1', '2018-12-16 01:09:54', null);
INSERT INTO `sys_user` VALUES ('3c88e78f5341417894ac31afdaa98b44', 'jack3c88e78f5341417894ac31afdaa98b44', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:09', '2019-04-30 17:12:09', null, null, null, null);
INSERT INTO `sys_user` VALUES ('450229556d7a465f9b2848e10894f215', 'jack450229556d7a465f9b2848e10894f215', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:08', '2019-04-30 17:12:08', null, null, null, null);
INSERT INTO `sys_user` VALUES ('661e12156e0849d5a9b157c25a7b1818', 'jack661e12156e0849d5a9b157c25a7b1818', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:09', '2019-04-30 17:12:09', null, null, null, null);
INSERT INTO `sys_user` VALUES ('69e8c8268d2541fc99fc3b14ed5cacdc', 'jack69e8c8268d2541fc99fc3b14ed5cacdc', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:09', '2019-04-30 17:12:09', null, null, null, null);
INSERT INTO `sys_user` VALUES ('734b8a507ea845a3b02c5e9145f28c11', 'jack734b8a507ea845a3b02c5e9145f28c11', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:08', '2019-04-30 17:12:08', null, null, null, null);
INSERT INTO `sys_user` VALUES ('e206d22001b143c2984581f33c23724b', 'jacke206d22001b143c2984581f33c23724b', 'password', null, null, null, null, null, null, null, 'Y', '0', '2019-04-30 17:12:08', '2019-04-30 17:12:08', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(32) NOT NULL COMMENT '用户主键',
  `role_id` varchar(32) NOT NULL COMMENT '角色主键',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('13dc0adc226d492e93a599bfdf90afa9', '2');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('85b95619cce44034858d0f996a4132ec', '1');
