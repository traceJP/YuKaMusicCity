/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : yuka_music

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/02/2021 12:03:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for music_comment
-- ----------------------------
DROP TABLE IF EXISTS `music_comment`;
CREATE TABLE `music_comment`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `music_id` int(0) NULL DEFAULT NULL COMMENT '歌曲或歌单id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户id',
  `comment_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `comment_datetime` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `comment_awesome` int(0) NULL DEFAULT NULL COMMENT '评论点赞数',
  `comment_oppose` int(0) NULL DEFAULT NULL COMMENT '评论反对数',
  `comment_id_type` int(0) NULL DEFAULT NULL COMMENT '评论来源类型（1为歌曲，2为歌单）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for music_list
-- ----------------------------
DROP TABLE IF EXISTS `music_list`;
CREATE TABLE `music_list`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `music_list_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌单名称',
  `music_list_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌单展示图片',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌单创建者用户id',
  `is_user_default` int(0) NULL DEFAULT NULL COMMENT '是否为用户默认歌单（我喜欢歌单）',
  `music_list_play_count` int(0) NULL DEFAULT NULL COMMENT '歌单被点开的次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for music_list_value
-- ----------------------------
DROP TABLE IF EXISTS `music_list_value`;
CREATE TABLE `music_list_value`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `music_list_id` int(0) NULL DEFAULT NULL COMMENT '歌单id',
  `music_id` int(0) NULL DEFAULT NULL COMMENT '歌曲id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_musiclistid_musicid`(`music_list_id`, `music_id`) USING BTREE COMMENT '一个歌单不能收藏两首一样的歌'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for music_resources
-- ----------------------------
DROP TABLE IF EXISTS `music_resources`;
CREATE TABLE `music_resources`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id（直接使用该自增id作为音乐资源的唯一标识）',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `music_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音乐名称',
  `music_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音乐展示图片',
  `music_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音乐本地保存路径',
  `music_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音乐作者（歌手）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `user_uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户唯一标识',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱（唯一）',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码（已加密）',
  `user_last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '用户最后一次登录时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_user_uid`(`user_uid`) USING BTREE COMMENT '用户唯一标识id',
  UNIQUE INDEX `only_user_email`(`user_email`) USING BTREE COMMENT '用户唯一标识邮箱'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_sex` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_birthday` date NULL DEFAULT NULL COMMENT '用户生日',
  `user_avatar_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像图片url',
  `user_introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户个人简介',
  `user_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在地区',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_user_uid`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_keep_comment
-- ----------------------------
DROP TABLE IF EXISTS `user_keep_comment`;
CREATE TABLE `user_keep_comment`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `comment_id` int(0) NULL DEFAULT NULL COMMENT '评论id',
  `upvote_oppose` int(0) NULL DEFAULT NULL COMMENT '当前操作的状态 1为点赞 2为点踩',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_uid_commentid`(`user_id`, `comment_id`) USING BTREE COMMENT '一个用户唯一标识对应一个评论唯一标识'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_keep_music_list
-- ----------------------------
DROP TABLE IF EXISTS `user_keep_music_list`;
CREATE TABLE `user_keep_music_list`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `music_list_id` int(0) NULL DEFAULT NULL COMMENT '收藏的歌单id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_uid_musiclistid`(`user_id`, `music_list_id`) USING BTREE COMMENT '一个用户唯一标识对应一个歌单唯一标识'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_level
-- ----------------------------
DROP TABLE IF EXISTS `user_level`;
CREATE TABLE `user_level`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `level_number` int(0) NULL DEFAULT NULL COMMENT '用户听歌等级',
  `user_song_number` int(0) NULL DEFAULT NULL COMMENT '用户听歌数量',
  `user_login_days` int(0) NULL DEFAULT NULL COMMENT '用户登录天数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_uid`(`user_id`) USING BTREE COMMENT '用户唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_song_leaderboard
-- ----------------------------
DROP TABLE IF EXISTS `user_song_leaderboard`;
CREATE TABLE `user_song_leaderboard`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `music_id` int(0) NULL DEFAULT NULL COMMENT '歌曲id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `broadcast_number_times` int(0) NULL DEFAULT NULL COMMENT '该歌曲的播放次数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `only_uid_musicid`(`music_id`, `user_id`) USING BTREE COMMENT '一个用户唯一标识对应一个歌曲唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '歌曲对应用户' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
