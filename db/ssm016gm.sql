/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : 127.0.0.1:3306
 Source Schema         : ssm016gm

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 10/03/2024 23:02:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '用户id',
  `adminid` bigint NULL DEFAULT NULL COMMENT '管理员id',
  `ask` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '提问',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复',
  `isreply` int NULL DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1710069229218 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '客服聊天表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (81, '2022-04-11 15:25:38', 1, 1, '提问1', '回复1', 1);
INSERT INTO `chat` VALUES (82, '2022-04-11 15:25:38', 2, 2, '提问2', '回复2', 2);
INSERT INTO `chat` VALUES (83, '2022-04-11 15:25:38', 3, 3, '提问3', '回复3', 3);
INSERT INTO `chat` VALUES (84, '2022-04-11 15:25:38', 4, 4, '提问4', '回复4', 4);
INSERT INTO `chat` VALUES (85, '2022-04-11 15:25:38', 5, 5, '提问5', '回复5', 5);
INSERT INTO `chat` VALUES (86, '2022-04-11 15:25:38', 6, 6, '提问6', '回复6', 6);
INSERT INTO `chat` VALUES (1708246057862, '2024-02-18 16:47:37', 1707982501681, NULL, '你好', NULL, 0);
INSERT INTO `chat` VALUES (1710069183062, '2024-03-10 19:13:02', 1707982501681, NULL, '1312312312123', NULL, 0);
INSERT INTO `chat` VALUES (1710069229217, '2024-03-10 19:13:48', 1707982501681, 1, NULL, '我明白你的消息', NULL);

-- ----------------------------
-- Table structure for chongwudailiu
-- ----------------------------
DROP TABLE IF EXISTS `chongwudailiu`;
CREATE TABLE `chongwudailiu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `nowstatus` int NULL DEFAULT 0 COMMENT '0发布 1接单  2完成 3确认完成',
  `reciver` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接单用户',
  `reciverphone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接单人联系电话',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708229788459 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '宠物代遛' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chongwudailiu
-- ----------------------------
INSERT INTO `chongwudailiu` VALUES (41, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/chongwudailiu_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 10.00, 2, NULL, NULL, 1, 1);
INSERT INTO `chongwudailiu` VALUES (42, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/chongwudailiu_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 10.00, 3, NULL, NULL, 2, 2);
INSERT INTO `chongwudailiu` VALUES (43, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/chongwudailiu_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 10.00, 1, NULL, NULL, 3, 3);
INSERT INTO `chongwudailiu` VALUES (44, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/chongwudailiu_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 10.00, 2, NULL, NULL, 4, 4);
INSERT INTO `chongwudailiu` VALUES (45, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/chongwudailiu_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 10.00, 1, NULL, NULL, 5, 5);
INSERT INTO `chongwudailiu` VALUES (46, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/chongwudailiu_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 10.00, 2, NULL, NULL, 6, 6);
INSERT INTO `chongwudailiu` VALUES (1708178831070, '2024-02-17 22:07:10', '1708178729980', '待遛哮天犬', 'upload/1708178776857.png', '<p>天狗哮天犬，外貌动人</p>', '2024-02-17', 'user10', 'user10', '13480858984', 10.00, 0, NULL, NULL, 0, 0);
INSERT INTO `chongwudailiu` VALUES (1708224086073, '2024-02-18 10:41:27', '1708224051006', '行空', 'upload/1708224069676.png', '<p>行空</p>', '2024-02-18', '用户账号1', '用户姓名1', '13823888881', 10.00, 3, 'user10', '13480858984', 0, 0);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '配置文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/1710061440509.png');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/1710061452285.png');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/1710061461962.png');
INSERT INTO `config` VALUES (4, 'picture4', 'upload/1710061471930.png');
INSERT INTO `config` VALUES (5, 'picture5', 'upload/1710061485487.png');
INSERT INTO `config` VALUES (6, 'picture6', 'upload/1710061495519.png');
INSERT INTO `config` VALUES (7, 'picture7', 'upload/1710061508243.png');
INSERT INTO `config` VALUES (8, 'picture8', 'upload/1710061518945.png');
INSERT INTO `config` VALUES (9, 'picture9', 'upload/1710061530815.png');
INSERT INTO `config` VALUES (10, 'picture10', 'upload/1710061541797.png');

-- ----------------------------
-- Table structure for discusschongwudailiu
-- ----------------------------
DROP TABLE IF EXISTS `discusschongwudailiu`;
CREATE TABLE `discusschongwudailiu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '宠物代遛评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusschongwudailiu
-- ----------------------------
INSERT INTO `discusschongwudailiu` VALUES (121, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusschongwudailiu` VALUES (122, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusschongwudailiu` VALUES (123, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusschongwudailiu` VALUES (124, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusschongwudailiu` VALUES (125, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusschongwudailiu` VALUES (126, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discussqita
-- ----------------------------
DROP TABLE IF EXISTS `discussqita`;
CREATE TABLE `discussqita`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '其他评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discussqita
-- ----------------------------
INSERT INTO `discussqita` VALUES (141, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussqita` VALUES (142, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussqita` VALUES (143, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussqita` VALUES (144, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussqita` VALUES (145, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussqita` VALUES (146, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discussqushifenxiang
-- ----------------------------
DROP TABLE IF EXISTS `discussqushifenxiang`;
CREATE TABLE `discussqushifenxiang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 157 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '趣事分享评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discussqushifenxiang
-- ----------------------------
INSERT INTO `discussqushifenxiang` VALUES (151, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussqushifenxiang` VALUES (152, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussqushifenxiang` VALUES (153, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussqushifenxiang` VALUES (154, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussqushifenxiang` VALUES (155, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussqushifenxiang` VALUES (156, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discussshiwuzhaoling
-- ----------------------------
DROP TABLE IF EXISTS `discussshiwuzhaoling`;
CREATE TABLE `discussshiwuzhaoling`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1709998852474 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '失物招领评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discussshiwuzhaoling
-- ----------------------------
INSERT INTO `discussshiwuzhaoling` VALUES (111, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discussshiwuzhaoling` VALUES (112, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discussshiwuzhaoling` VALUES (113, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discussshiwuzhaoling` VALUES (114, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discussshiwuzhaoling` VALUES (115, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discussshiwuzhaoling` VALUES (116, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');
INSERT INTO `discussshiwuzhaoling` VALUES (1709998852473, '2024-03-09 23:40:52', 31, 1707982501681, 'user10', '1244124124', NULL);

-- ----------------------------
-- Table structure for discusstingcheweichuzu
-- ----------------------------
DROP TABLE IF EXISTS `discusstingcheweichuzu`;
CREATE TABLE `discusstingcheweichuzu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '停车位出租评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusstingcheweichuzu
-- ----------------------------
INSERT INTO `discusstingcheweichuzu` VALUES (131, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusstingcheweichuzu` VALUES (132, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusstingcheweichuzu` VALUES (133, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusstingcheweichuzu` VALUES (134, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusstingcheweichuzu` VALUES (135, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusstingcheweichuzu` VALUES (136, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discusswupingongxiang
-- ----------------------------
DROP TABLE IF EXISTS `discusswupingongxiang`;
CREATE TABLE `discusswupingongxiang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '宠物代遛评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusswupingongxiang
-- ----------------------------
INSERT INTO `discusswupingongxiang` VALUES (121, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusswupingongxiang` VALUES (122, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusswupingongxiang` VALUES (123, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusswupingongxiang` VALUES (124, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusswupingongxiang` VALUES (125, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusswupingongxiang` VALUES (126, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discusszufangxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discusszufangxinxi`;
CREATE TABLE `discusszufangxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租房信息评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusszufangxinxi
-- ----------------------------
INSERT INTO `discusszufangxinxi` VALUES (101, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusszufangxinxi` VALUES (102, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusszufangxinxi` VALUES (103, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusszufangxinxi` VALUES (104, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusszufangxinxi` VALUES (105, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusszufangxinxi` VALUES (106, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');

-- ----------------------------
-- Table structure for discusszuzhihuodong
-- ----------------------------
DROP TABLE IF EXISTS `discusszuzhihuodong`;
CREATE TABLE `discusszuzhihuodong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `nickname` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708519291008 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '其他评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discusszuzhihuodong
-- ----------------------------
INSERT INTO `discusszuzhihuodong` VALUES (141, '2022-04-11 15:25:38', 1, 1, '用户名1', '评论内容1', '回复内容1');
INSERT INTO `discusszuzhihuodong` VALUES (142, '2022-04-11 15:25:38', 2, 2, '用户名2', '评论内容2', '回复内容2');
INSERT INTO `discusszuzhihuodong` VALUES (143, '2022-04-11 15:25:38', 3, 3, '用户名3', '评论内容3', '回复内容3');
INSERT INTO `discusszuzhihuodong` VALUES (144, '2022-04-11 15:25:38', 4, 4, '用户名4', '评论内容4', '回复内容4');
INSERT INTO `discusszuzhihuodong` VALUES (145, '2022-04-11 15:25:38', 5, 5, '用户名5', '评论内容5', '回复内容5');
INSERT INTO `discusszuzhihuodong` VALUES (146, '2022-04-11 15:25:38', 6, 6, '用户名6', '评论内容6', '回复内容6');
INSERT INTO `discusszuzhihuodong` VALUES (1708519291007, '2024-02-21 20:41:30', 1708439700775, 1707982501681, 'user10', '6666', NULL);

-- ----------------------------
-- Table structure for group_msg_content
-- ----------------------------
DROP TABLE IF EXISTS `group_msg_content`;
CREATE TABLE `group_msg_content`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '消息内容编号',
  `from_id` bigint NULL DEFAULT NULL COMMENT '发送者的编号',
  `from_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发送者的昵称',
  `from_profile` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发送者的头像',
  `create_time` datetime NULL DEFAULT NULL COMMENT '消息发送时间',
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '消息内容',
  `message_type_id` int NULL DEFAULT NULL COMMENT '消息类型编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_ibfk_1`(`from_id` ASC) USING BTREE,
  INDEX `group_ibfk_2`(`message_type_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of group_msg_content
-- ----------------------------
INSERT INTO `group_msg_content` VALUES (102, 1, 'abo', 'upload/yonghu_touxiang6.jpg', '2024-03-03 15:17:18', '12454', 1);
INSERT INTO `group_msg_content` VALUES (103, 1, 'abo', 'upload/yonghu_touxiang6.jpg', '2024-03-03 15:18:07', '从百草园到三位书屋', 1);
INSERT INTO `group_msg_content` VALUES (104, 1, 'abo', 'upload/yonghu_touxiang6.jpg', '2024-03-03 19:40:38', '141', 1);
INSERT INTO `group_msg_content` VALUES (105, 1, 'abo', 'upload/yonghu_touxiang6.jpg', '2024-03-03 19:42:13', '4545', 1);
INSERT INTO `group_msg_content` VALUES (106, 1, 'abo', 'upload/yonghu_touxiang6.jpg', '2024-03-07 01:09:03', '111', 1);
INSERT INTO `group_msg_content` VALUES (107, 1707982501681, 'user10', 'upload/1708442719930.png', '2024-03-10 00:40:31', '1212', 1);
INSERT INTO `group_msg_content` VALUES (108, 1707982501681, 'user10', 'upload/1708442719930.png', '2024-03-10 00:43:45', '6666', 1);
INSERT INTO `group_msg_content` VALUES (109, 1707982501681, 'user10', 'upload/1708442719930.png', '2024-03-10 01:18:32', '2313', 1);

-- ----------------------------
-- Table structure for loufangxinxi
-- ----------------------------
DROP TABLE IF EXISTS `loufangxinxi`;
CREATE TABLE `loufangxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `loufangmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '楼房名称',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `loufangdizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '楼房地址',
  `loucengshu` int NULL DEFAULT NULL COMMENT '楼层数',
  `area` int NULL DEFAULT NULL COMMENT '占地面积（平方米）',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1709999289708 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租房信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of loufangxinxi
-- ----------------------------
INSERT INTO `loufangxinxi` VALUES (22, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/zufangxinxi_fengmian2.jpg', '<p>内容详情2</p>', '2022-04-11', '用户账号2', 12312, 311, 2, 2);
INSERT INTO `loufangxinxi` VALUES (23, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/zufangxinxi_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', NULL, NULL, 3, 3);
INSERT INTO `loufangxinxi` VALUES (24, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/zufangxinxi_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', NULL, NULL, 4, 4);
INSERT INTO `loufangxinxi` VALUES (25, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/zufangxinxi_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', NULL, NULL, 5, 5);
INSERT INTO `loufangxinxi` VALUES (26, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/zufangxinxi_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', NULL, NULL, 6, 6);
INSERT INTO `loufangxinxi` VALUES (1708002245305, '2024-02-15 21:04:04', '1708002151066', '靠海别墅01栋', 'upload/1708002208223.jpg', '<p>该栋豪华别墅！</p>', '2024-02-15', '金沙湾', 65, 107, 0, 0);
INSERT INTO `loufangxinxi` VALUES (1709999289707, '2024-03-09 23:48:08', '1709999244155', '靠海别墅100号楼', 'upload/1709999265781.jpg', '<p>高大</p>', '2024-03-09', '北海', 1000, 600, 0, 0);

-- ----------------------------
-- Table structure for qita
-- ----------------------------
DROP TABLE IF EXISTS `qita`;
CREATE TABLE `qita`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708260053809 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '其他' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qita
-- ----------------------------
INSERT INTO `qita` VALUES (61, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/qita_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 1, 1);
INSERT INTO `qita` VALUES (62, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/qita_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 2, 2);
INSERT INTO `qita` VALUES (63, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/qita_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 3, 3);
INSERT INTO `qita` VALUES (64, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/qita_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 4, 4);
INSERT INTO `qita` VALUES (65, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/qita_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 5, 5);
INSERT INTO `qita` VALUES (66, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/qita_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 6, 6);
INSERT INTO `qita` VALUES (1708260053808, '2024-02-18 20:40:53', '1708259991734', '头条新闻', 'upload/1708260021596.jpg', '<p>新年大头，请勿赌博</p>', '2024-02-18', 'user10', 'user10', '13480858984', 0, 0);

-- ----------------------------
-- Table structure for qushifenxiang
-- ----------------------------
DROP TABLE IF EXISTS `qushifenxiang`;
CREATE TABLE `qushifenxiang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '趣事分享' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qushifenxiang
-- ----------------------------
INSERT INTO `qushifenxiang` VALUES (71, '2022-04-11 15:25:38', '标题1', 'upload/qushifenxiang_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户1', '13823888881', 1, 1);
INSERT INTO `qushifenxiang` VALUES (72, '2022-04-11 15:25:38', '标题2', 'upload/qushifenxiang_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户2', '13823888882', 4, 2);
INSERT INTO `qushifenxiang` VALUES (73, '2022-04-11 15:25:38', '标题3', 'upload/qushifenxiang_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户3', '13823888883', 4, 3);
INSERT INTO `qushifenxiang` VALUES (74, '2022-04-11 15:25:38', '标题4', 'upload/qushifenxiang_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户4', '13823888884', 5, 4);
INSERT INTO `qushifenxiang` VALUES (75, '2022-04-11 15:25:38', '标题5', 'upload/qushifenxiang_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户5', '13823888885', 6, 5);
INSERT INTO `qushifenxiang` VALUES (76, '2022-04-11 15:25:38', '标题6', 'upload/qushifenxiang_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户6', '13823888886', 6, 6);

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '充值用户',
  `paymethod` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付方式',
  `paymoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `paydate` datetime NULL DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1759068566742679554 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES (1758801160493342721, 'abo', '微信支付', 10.00, '2024-02-17 18:30:47');
INSERT INTO `recharge` VALUES (1758806249266225154, 'abo', '微信支付', 100.00, '2024-02-17 18:51:02');
INSERT INTO `recharge` VALUES (1758806336419667969, 'abo', '微信支付', 100.00, '2024-02-17 18:51:22');
INSERT INTO `recharge` VALUES (1758807100265340930, 'abo', '微信支付', 10.00, '2024-02-17 18:54:24');
INSERT INTO `recharge` VALUES (1758807427723042818, 'abo', '微信支付', 10.00, '2024-02-17 18:55:43');
INSERT INTO `recharge` VALUES (1758807494785769473, 'abo', '微信支付', 10.00, '2024-02-17 18:55:58');
INSERT INTO `recharge` VALUES (1758811141565325313, 'abo', '微信支付', 10.00, '2024-02-17 19:10:28');
INSERT INTO `recharge` VALUES (1758829577779552258, 'abo', '微信支付', 10.00, '2024-02-17 20:23:43');
INSERT INTO `recharge` VALUES (1758829891249250306, 'abo', '微信支付', 40.00, '2024-02-17 20:24:58');
INSERT INTO `recharge` VALUES (1758830468884602882, 'abo', '微信支付', 10.00, '2024-02-17 20:27:16');
INSERT INTO `recharge` VALUES (1758830647306100738, 'abo', '微信支付', 10.00, '2024-02-17 20:27:58');
INSERT INTO `recharge` VALUES (1758851970535358466, 'user10', '微信支付', 100.00, '2024-02-17 21:52:42');
INSERT INTO `recharge` VALUES (1759043118562308098, '用户账号1', '微信支付', 10.00, '2024-02-18 10:32:15');
INSERT INTO `recharge` VALUES (1759066297196376065, '用户账号1', '微信支付', 10.00, '2024-02-18 12:04:21');
INSERT INTO `recharge` VALUES (1759066757227638785, '用户账号1', '微信支付', 10.00, '2024-02-18 12:06:11');
INSERT INTO `recharge` VALUES (1759068035190145025, '用户账号1', '微信支付', 10.00, '2024-02-18 12:11:16');
INSERT INTO `recharge` VALUES (1759068566742679553, '用户账号1', '微信支付', 100.00, '2024-02-18 12:13:23');

-- ----------------------------
-- Table structure for renkoudengjixinxi
-- ----------------------------
DROP TABLE IF EXISTS `renkoudengjixinxi`;
CREATE TABLE `renkoudengjixinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '等级编号',
  `dengjibiaoti` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '等级标题',
  `dengjileixing` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '等级类型',
  `dengjirenshu` int NULL DEFAULT NULL COMMENT '等级人数',
  `renyuanxingming` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '人员姓名',
  `renyuanguanxi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '人员关系',
  `loufangmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '楼房名称',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `loufangdizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '楼房地址',
  `zhanghao` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '账号',
  `xingming` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708002245306 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租房信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of renkoudengjixinxi
-- ----------------------------
INSERT INTO `renkoudengjixinxi` VALUES (1708002245305, '2024-02-15 21:04:04', '1708002151066', '房间登记', '住房人口登记', 10, '李小龙', '房主', '靠海别墅01栋', 'upload/1708002208223.jpg', '<p>该栋豪华别墅！</p>', '2024-02-15', '金沙湾', 'user10', 'user10', '靠海别墅01栋01房', 0, 0);

-- ----------------------------
-- Table structure for renkoutongjixinxi
-- ----------------------------
DROP TABLE IF EXISTS `renkoutongjixinxi`;
CREATE TABLE `renkoutongjixinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `loufangmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '楼房名称',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `loufangdizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '楼房地址',
  `xinzengrenkou` int NULL DEFAULT NULL COMMENT '新增人口',
  `siwangrenshu` int NULL DEFAULT NULL COMMENT '死亡人口',
  `qianrurenkou` int NULL DEFAULT NULL COMMENT '迁入人口',
  `qianchurenkou` int NULL DEFAULT NULL COMMENT '迁出人口',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708002245306 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租房信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of renkoutongjixinxi
-- ----------------------------
INSERT INTO `renkoutongjixinxi` VALUES (1708002245305, '2024-02-15 21:04:04', '1708002151066', '靠海别墅01栋', 'upload/1708002208223.jpg', '<p>该栋豪华别墅！</p>', '2024-02-15', '金沙湾', 66, 0, 1, 0, 0, 0);

-- ----------------------------
-- Table structure for shiwuzhaoling
-- ----------------------------
DROP TABLE IF EXISTS `shiwuzhaoling`;
CREATE TABLE `shiwuzhaoling`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '失物招领' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shiwuzhaoling
-- ----------------------------
INSERT INTO `shiwuzhaoling` VALUES (31, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/shiwuzhaoling_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 1, 1);
INSERT INTO `shiwuzhaoling` VALUES (32, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/shiwuzhaoling_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 2, 2);
INSERT INTO `shiwuzhaoling` VALUES (33, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/shiwuzhaoling_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 3, 3);
INSERT INTO `shiwuzhaoling` VALUES (34, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/shiwuzhaoling_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 4, 4);
INSERT INTO `shiwuzhaoling` VALUES (35, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/shiwuzhaoling_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 5, 5);
INSERT INTO `shiwuzhaoling` VALUES (36, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/shiwuzhaoling_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 6, 6);

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT '用户id',
  `refid` bigint NULL DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '收藏图片',
  `type` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩)',
  `inteltype` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '推荐类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708519300175 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '收藏表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1707067085972, '2024-02-05 01:18:05', 11, 75, 'qushifenxiang', '标题5', 'upload/qushifenxiang_fengmian5.jpg', '22', NULL);
INSERT INTO `storeup` VALUES (1708158428707, '2024-02-17 16:27:08', 1707982501681, 71, 'qushifenxiang', '标题1', 'upload/qushifenxiang_fengmian1.jpg', '1', NULL);
INSERT INTO `storeup` VALUES (1708224285596, '2024-02-18 10:44:45', 1707982501681, 1708223869457, 'chongwudailiu', '宠物猪', 'upload/1708223553347.png', '1', NULL);
INSERT INTO `storeup` VALUES (1708225648889, '2024-02-18 11:07:28', 1707982501681, 1708224086073, 'chongwudailiu', '行空', 'upload/1708224069676.png', '1', NULL);
INSERT INTO `storeup` VALUES (1708243455205, '2024-02-18 16:04:14', 1707982501681, 72, 'qushifenxiang', '标题2', 'upload/qushifenxiang_fengmian2.jpg', '21', NULL);
INSERT INTO `storeup` VALUES (1708243528758, '2024-02-18 16:05:28', 11, 72, 'qushifenxiang', '标题2', 'upload/qushifenxiang_fengmian2.jpg', '21', NULL);
INSERT INTO `storeup` VALUES (1708243548220, '2024-02-18 16:05:47', 11, 73, 'qushifenxiang', '标题3', 'upload/qushifenxiang_fengmian3.jpg', '21', NULL);
INSERT INTO `storeup` VALUES (1708243560281, '2024-02-18 16:05:59', 11, 74, 'qushifenxiang', '标题4', 'upload/qushifenxiang_fengmian4.jpg', '21', NULL);
INSERT INTO `storeup` VALUES (1708519300174, '2024-02-21 20:41:39', 1707982501681, 1708439700775, 'zuzhihuodong', '登峰活动', 'upload/1708439595379.png', '21', NULL);

-- ----------------------------
-- Table structure for tingcheweichuzu
-- ----------------------------
DROP TABLE IF EXISTS `tingcheweichuzu`;
CREATE TABLE `tingcheweichuzu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '停车位出租' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tingcheweichuzu
-- ----------------------------
INSERT INTO `tingcheweichuzu` VALUES (51, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/tingcheweichuzu_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 1, 1);
INSERT INTO `tingcheweichuzu` VALUES (52, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/tingcheweichuzu_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 2, 2);
INSERT INTO `tingcheweichuzu` VALUES (53, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/tingcheweichuzu_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 3, 3);
INSERT INTO `tingcheweichuzu` VALUES (54, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/tingcheweichuzu_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 4, 4);
INSERT INTO `tingcheweichuzu` VALUES (55, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/tingcheweichuzu_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 5, 5);
INSERT INTO `tingcheweichuzu` VALUES (56, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/tingcheweichuzu_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 6, 6);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'token表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'abo', 'users', '管理员', '2ny9mepivokkqyn74lg9naqidqiteuav', '2024-02-05 01:11:00', '2024-03-10 22:46:07');
INSERT INTO `token` VALUES (2, 11, '用户账号1', 'yonghu', '用户', 'nls3dkmfesd0e2bvzibz5hmiax2njcys', '2024-02-05 01:15:21', '2024-03-10 02:13:03');
INSERT INTO `token` VALUES (3, 1707982501681, 'user10', 'yonghu', '用户', 'op75bo2tk369286ehvrq9srr1hrychy3', '2024-02-15 17:18:06', '2024-03-10 20:17:04');
INSERT INTO `token` VALUES (4, 1709999221468, 'user11', 'yonghu', '用户', '4ulb05ty8yti8blxkr0tvnd81iqr47dh', '2024-03-10 01:33:27', '2024-03-10 02:38:49');

-- ----------------------------
-- Table structure for usermoney
-- ----------------------------
DROP TABLE IF EXISTS `usermoney`;
CREATE TABLE `usermoney`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号',
  `account` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1759043118633611267 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of usermoney
-- ----------------------------
INSERT INTO `usermoney` VALUES (1758801229368008706, 'abo', 320.00);
INSERT INTO `usermoney` VALUES (1758851970677964801, 'user10', 120.00);
INSERT INTO `usermoney` VALUES (1759043118633611266, '用户账号1', 100.00);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `touxiang` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `yonghuxingming` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `userStateId` int NULL DEFAULT NULL COMMENT '1在线 0下线',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'abo', 'upload/yonghu_touxiang6.jpg', 'abo', '管理员', '2022-04-11 15:25:38', 'abo', 1);

-- ----------------------------
-- Table structure for wupingongxiang
-- ----------------------------
DROP TABLE IF EXISTS `wupingongxiang`;
CREATE TABLE `wupingongxiang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `nowstatus` int NULL DEFAULT 0 COMMENT '0发布 1接单  2完成 3确认完成',
  `reciver` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接单用户',
  `reciverphone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接单人联系电话',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708252297848 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '宠物代遛' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wupingongxiang
-- ----------------------------
INSERT INTO `wupingongxiang` VALUES (41, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/chongwudailiu_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 10.00, 2, NULL, NULL, 1, 1);
INSERT INTO `wupingongxiang` VALUES (42, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/chongwudailiu_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 10.00, 3, NULL, NULL, 2, 2);
INSERT INTO `wupingongxiang` VALUES (43, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/chongwudailiu_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 10.00, 1, NULL, NULL, 3, 3);
INSERT INTO `wupingongxiang` VALUES (44, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/chongwudailiu_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 10.00, 2, NULL, NULL, 4, 4);
INSERT INTO `wupingongxiang` VALUES (45, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/chongwudailiu_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 10.00, 1, NULL, NULL, 5, 5);
INSERT INTO `wupingongxiang` VALUES (46, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/chongwudailiu_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 10.00, 2, NULL, NULL, 6, 6);
INSERT INTO `wupingongxiang` VALUES (1708252297847, '2024-02-18 18:31:37', '1708252147056', '免费租借扫把', 'upload/1708252225260.png', '<p>多功能扫把，刷锅洗菜扫地，集大成功能于一身</p>', '2024-02-19', 'user10', 'user10', '13480858984', 0.00, 2, '用户账号1', '13823888881', 0, 0);

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `mima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `touxiang` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `userStateId` int NULL DEFAULT NULL COMMENT '1在线  0下线',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1709999221469 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (11, '2022-04-11 15:25:38', '用户账号1', '用户姓名1', '123456', '男', '13823888881', 'upload/yonghu_touxiang1.jpg', '112', '1212@qq.com', 1);
INSERT INTO `yonghu` VALUES (12, '2022-04-11 15:25:38', '用户账号2', '用户姓名2', '123456', '男', '13823888882', 'upload/yonghu_touxiang2.jpg', NULL, NULL, 0);
INSERT INTO `yonghu` VALUES (13, '2022-04-11 15:25:38', '用户账号3', '用户姓名3', '123456', '男', '13823888883', 'upload/yonghu_touxiang3.jpg', NULL, NULL, 0);
INSERT INTO `yonghu` VALUES (14, '2022-04-11 15:25:38', '用户账号4', '用户姓名4', '123456', '男', '13823888884', 'upload/yonghu_touxiang4.jpg', NULL, NULL, 0);
INSERT INTO `yonghu` VALUES (15, '2022-04-11 15:25:38', '用户账号5', '用户姓名5', '123456', '男', '13823888885', 'upload/yonghu_touxiang5.jpg', NULL, NULL, 0);
INSERT INTO `yonghu` VALUES (16, '2022-04-11 15:25:38', '用户账号6', '用户姓名6', '123456', '男', '13823888886', 'upload/yonghu_touxiang6.jpg', NULL, NULL, 0);
INSERT INTO `yonghu` VALUES (1707982501681, '2024-02-15 15:35:01', 'user10', 'user10', 'user10', '男', '13480858984', 'upload/1708442719930.png', '雅苑10层101房101', '110@qq.com', 1);
INSERT INTO `yonghu` VALUES (1709999221468, '2024-03-09 23:47:01', 'user11', 'user11', 'user11', '男', '15789653205', 'upload/1709999220064.png', '110', '110@qq.com', 1);

-- ----------------------------
-- Table structure for zufangxinxi
-- ----------------------------
DROP TABLE IF EXISTS `zufangxinxi`;
CREATE TABLE `zufangxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `ruzhurenshu` int NULL DEFAULT NULL COMMENT '入住人数',
  `workspace` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作单位',
  `guanji` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `hukousuozaidi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '户口所在地',
  `beizhu` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `leixing` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '类型',
  `loufangdizhi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '楼房地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1708005215367 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租房信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zufangxinxi
-- ----------------------------
INSERT INTO `zufangxinxi` VALUES (21, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/zufangxinxi_fengmian1.jpg', '内容详情1', '2022-04-11', '用户账号1', '用户姓名1', '13823888881', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (22, '2022-04-11 15:25:38', '2222222222', '标题2', 'upload/zufangxinxi_fengmian2.jpg', '内容详情2', '2022-04-11', '用户账号2', '用户姓名2', '13823888882', 2, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (23, '2022-04-11 15:25:38', '3333333333', '标题3', 'upload/zufangxinxi_fengmian3.jpg', '内容详情3', '2022-04-11', '用户账号3', '用户姓名3', '13823888883', 3, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (24, '2022-04-11 15:25:38', '4444444444', '标题4', 'upload/zufangxinxi_fengmian4.jpg', '内容详情4', '2022-04-11', '用户账号4', '用户姓名4', '13823888884', 4, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (25, '2022-04-11 15:25:38', '5555555555', '标题5', 'upload/zufangxinxi_fengmian5.jpg', '内容详情5', '2022-04-11', '用户账号5', '用户姓名5', '13823888885', 5, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (26, '2022-04-11 15:25:38', '6666666666', '标题6', 'upload/zufangxinxi_fengmian6.jpg', '内容详情6', '2022-04-11', '用户账号6', '用户姓名6', '13823888886', 6, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zufangxinxi` VALUES (1708005215366, '2024-02-15 21:53:34', '1708005124004', '靠海别墅01栋', 'upload/1708005147306.jpg', '<p>风景真是美好</p>', '2024-02-15', 'user10', 'user10', '13480858984', 0, 0, '靠海别墅01栋01房', 6, '金沙湾守岗', '广东广州', '广东广州画画', '大好山河', '房主', '金沙湾');

-- ----------------------------
-- Table structure for zuzhihuodong
-- ----------------------------
DROP TABLE IF EXISTS `zuzhihuodong`;
CREATE TABLE `zuzhihuodong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '序号',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '封面',
  `neirongxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容详情',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `starttime` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `huodongdidian` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  `thumbsupnum` int NULL DEFAULT 0 COMMENT '赞',
  `crazilynum` int NULL DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuhao`(`xuhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1710062221236 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '其他' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zuzhihuodong
-- ----------------------------
INSERT INTO `zuzhihuodong` VALUES (61, '2022-04-11 15:25:38', '1111111111', '标题1', 'upload/qita_fengmian1.jpg', '内容详情1', '2022-04-11', '2024-02-20 21:12:04', '2024-02-20 21:12:09', '用户账号1', '用户姓名1', '13823888881', '上海植物园', 1, 1);
INSERT INTO `zuzhihuodong` VALUES (1708439700775, '2024-02-20 22:35:00', '1708439455683', '登峰活动', 'upload/1708439595379.png', '<h3>碧海潮涌浪花飞，</h3><h3>日月交替昼夜辉。</h3><h3>山川地势似青烟，</h3><h3>登临峰顶心旷神怡。</h3><h3>翠绿林海翠竹生，</h3><h3>凤鸟鸣啼送落霞。</h3><h3>风雨飘摇春秋变，</h3><h3>青山长在何处山？</h3><h3>风雨飘摇春秋变，</h3><h3>青山长在何处山？</h3><h3>山川地势似青烟，</h3><h3>登临峰顶心旷神怡。</h3>', '2024-02-20', '2024-02-23 06:00:00', '2024-02-23 18:00:00', 'abo', 'abo', '15475641058', '珠穆朗玛峰', 1, 0);
INSERT INTO `zuzhihuodong` VALUES (1710062221235, '2024-03-10 17:17:00', '1710062152495', '上海国际马拉松', 'upload/1710062186300.png', '<p>长途运动</p>', '2024-03-19', '2024-03-19 00:00:00', '2024-03-21 00:00:00', 'user10', 'user10', '13480858984', '上海灯塔地点', 0, 0);

-- ----------------------------
-- Table structure for zuzhihuodongrenyuan
-- ----------------------------
DROP TABLE IF EXISTS `zuzhihuodongrenyuan`;
CREATE TABLE `zuzhihuodongrenyuan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `lianxifangshi` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户联系方式',
  `zuzhihuodongid` bigint NULL DEFAULT NULL COMMENT '组织活动id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1760656062442229763 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '其他评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zuzhihuodongrenyuan
-- ----------------------------
INSERT INTO `zuzhihuodongrenyuan` VALUES (142, '2022-04-11 15:25:38', '2', '454', '2', 61);
INSERT INTO `zuzhihuodongrenyuan` VALUES (1760656062442229762, '2024-02-22 21:21:31', 'user10', 'user10', '13480858984', 1708439700775);

SET FOREIGN_KEY_CHECKS = 1;
