/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-20 17:13:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
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
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注信息',
  `del_mark` char(1) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_menu_del_flag` (`del_mark`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '20', '0,1,2,13,20,', '查看', '30', null, null, null, '0', 'sys:user:view', '1', '2018-12-19 17:20:09', '1', '2018-12-19 17:20:09', null, '0');
INSERT INTO `sys_menu` VALUES ('2', '20', '0,1,2,13,20,', '修改', '40', null, null, null, '0', 'sys:user:edit', '1', '2018-12-19 17:20:26', '1', '2018-12-19 17:20:26', null, '0');

-- ----------------------------
-- Table structure for `sys_role`
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
-- Table structure for `sys_role_menu`
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
-- Table structure for `sys_user`
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'ee74a75f182c46effa1a4b350d537566', '1', '1', '11', null, '1', '1', '11', 'Y', '0', '2018-12-05 16:56:13', '2018-12-20 16:42:30', '1', '1', '2018-12-20 16:42:30');
INSERT INTO `sys_user` VALUES ('a351d57cc1e340d5a965145912d84d98', '1218', 'b3a67e61485ed524d00b42cd169fe0e0', null, null, null, null, null, null, null, 'Y', '0', '2018-12-18 10:38:36', '2018-12-20 16:40:08', 'a351d57cc1e340d5a965145912d84d98', null, '2018-12-20 16:40:08');
INSERT INTO `sys_user` VALUES ('c625d02f84e940ae919b627c305cbaf8', '1219', 'b31e97b16f7a8a0318dc081e41df5547', null, null, null, null, null, null, null, 'Y', '0', '2018-12-19 15:30:45', '2018-12-20 16:02:02', 'c625d02f84e940ae919b627c305cbaf8', null, '2018-12-20 16:02:03');
INSERT INTO `sys_user` VALUES ('f73d30daf47a43abba696d5e870c194f', 'qq957903902', 'db28cf75ceb2aed55b39d2389753491b', null, null, null, null, null, null, null, 'Y', '1', '2018-12-20 16:53:19', '2018-12-20 17:01:26', 'f73d30daf47a43abba696d5e870c194f', '1', '2018-12-20 17:01:26');

-- ----------------------------
-- Table structure for `sys_user_role`
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
INSERT INTO `sys_user_role` VALUES ('3c013550b994489ebfe09f9693aee452', '3');
INSERT INTO `sys_user_role` VALUES ('c625d02f84e940ae919b627c305cbaf8', '2');
INSERT INTO `sys_user_role` VALUES ('f73d30daf47a43abba696d5e870c194f', '3');
