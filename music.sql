-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: music
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员名称',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `is_delete`, `name`, `password`, `create_time`, `update_time`) VALUES (1,0,'渊洁','123456','2022-02-02 01:40:44','2022-02-02 01:40:44');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collect` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  `type` tinyint unsigned NOT NULL COMMENT '收藏类型 0歌曲 1歌单',
  `song_id` int unsigned DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int unsigned DEFAULT NULL COMMENT '歌单id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` (`id`, `is_delete`, `user_id`, `type`, `song_id`, `song_list_id`, `create_time`, `update_time`) VALUES (1,0,1,0,1,NULL,'2022-02-21 12:19:30','2022-02-21 12:19:30'),(2,0,1,0,7,NULL,'2022-02-21 12:21:43','2022-02-21 12:21:43'),(3,0,1,0,12,NULL,'2022-02-21 12:30:41','2022-02-21 12:30:41'),(4,0,1,0,11,NULL,'2022-02-21 12:31:03','2022-02-21 12:31:03'),(5,0,1,0,13,NULL,'2022-02-21 13:03:07','2022-02-21 13:03:07'),(6,1,1,0,5,NULL,'2022-02-21 13:26:31','2022-02-21 21:28:04');
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  `type` tinyint unsigned NOT NULL COMMENT '评论类型 0歌曲 1歌单',
  `song_id` int unsigned DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int unsigned DEFAULT NULL COMMENT '歌单id',
  `up` int unsigned DEFAULT '0' COMMENT '评论点赞数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `is_delete`, `user_id`, `type`, `song_id`, `song_list_id`, `up`, `create_time`, `update_time`, `content`) VALUES (1,0,1,1,NULL,1,2,'2022-02-20 16:25:38','2022-02-20 18:00:29','无论前路多凶险，也无所畏惧！因为要做自己坚强的后盾！加油实现梦！'),(2,0,1,1,NULL,1,2,'2022-02-20 16:28:33','2022-02-20 18:00:24','未曾闻过的淡雅清香\n未曾识过的素洁姿色\n\n手中笔锋婉转\n却绘不了 \n你温柔的嘴角\n心中万事牵念\n却敌不过 \n你嫣然的轮廓\n\n你的美，耐人去寻味\n便是嵌入寂静深夜，人亦难寐\n你的笑，无人能忘掉\n便是越过万里烟波，依旧明曜\n\n我眼前的你\n婷婷玉立\n在我的思绪里\n渐渐隐去\n其实你也知道\n我等待的\n是你眼中的笑'),(3,0,2,1,NULL,1,1,'2022-02-20 16:55:02','2022-02-20 17:57:46','遇见是最美的故事，当你第一次听见她的声音就是一段人生奇遇的开始!\n\n这个声音可曾陪伴你走过日夜，\n这个声音可曾治愈了你的心情，\n当一段属于你与她共鸣的旋律响起，\n这是一场最美的时光旅行!'),(4,0,2,1,NULL,1,2,'2022-02-20 16:55:35','2022-02-20 18:00:28','This love is good,this love is bad\n这份爱诚然安好，诚然狼狈\nThis love is alive back from the dead\n然却涅槃重生，破蛹成蝶\nThese hands had to let it go free and\n妄想狠心放手，让爱自由\nThis love came back to me\n怎料爱意悱恻，仍上心头'),(5,0,3,1,NULL,1,0,'2022-02-20 17:58:40','2022-02-20 17:58:40','天哪 我刚想说这编曲太好听了！！宁静的夜晚坐在海边，柔和清凉的海风拂拂吹过，漫天的繁星，洁白冰轮的银光在海上，给人空灵的感觉，此时他在想念着她。');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_contain_song`
--

DROP TABLE IF EXISTS `list_contain_song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_contain_song` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `song_id` int unsigned NOT NULL COMMENT '歌曲id',
  `song_list_id` int unsigned NOT NULL COMMENT '歌单id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='歌单包含的歌曲';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_contain_song`
--

LOCK TABLES `list_contain_song` WRITE;
/*!40000 ALTER TABLE `list_contain_song` DISABLE KEYS */;
INSERT INTO `list_contain_song` (`id`, `is_delete`, `song_id`, `song_list_id`, `create_time`, `update_time`) VALUES (1,1,1,1,'2022-02-09 20:25:54','2022-02-09 22:21:48'),(3,1,1,1,'2022-02-09 21:40:04','2022-02-09 22:21:48'),(5,0,1,1,'2022-02-18 18:46:51','2022-02-18 18:46:51'),(6,1,6,1,'2022-02-18 18:55:12','2022-02-18 19:57:48'),(7,0,13,1,'2022-02-18 19:33:06','2022-02-18 19:33:06'),(8,0,5,1,'2022-02-18 19:58:05','2022-02-18 19:58:05');
/*!40000 ALTER TABLE `list_contain_song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rank` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `score` int unsigned DEFAULT NULL COMMENT '评分',
  `song_list_id` int unsigned DEFAULT NULL COMMENT '歌单id',
  `user_id` int unsigned DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique` (`song_list_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='评价';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` (`id`, `is_delete`, `score`, `song_list_id`, `user_id`, `create_time`, `update_time`) VALUES (1,0,10,1,1,'2022-02-20 14:27:12','2022-02-20 14:27:12');
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `singer` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌手艺名',
  `gender` tinyint unsigned NOT NULL COMMENT '0女 1男',
  `birth` datetime NOT NULL COMMENT '生日',
  `location` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地区',
  `introduction` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个性签名',
  `avator` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='歌手';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
INSERT INTO `singer` (`id`, `is_delete`, `name`, `gender`, `birth`, `location`, `introduction`, `avator`, `create_time`, `update_time`) VALUES (12,0,'周杰伦',1,'1979-01-18 00:00:00','中国台湾','中国台湾流行乐男歌手、音乐人、演员、导演、编剧.毕业于淡江中学.','/singerImages/ZhouJieLun.png','2022-02-03 23:05:24','2022-02-08 16:12:19'),(13,0,'许嵩',1,'1986-05-14 00:00:00','中国大陆','中国内地流行乐男歌手、原创音乐人，毕业于安徽医科大学.','/singerImages/XuSong.png','2022-02-04 00:34:56','2022-02-05 11:30:08'),(14,0,'陈奕迅',1,'1974-07-27 00:00:00','中国香港','华语流行乐男歌手、演员、作曲人，毕业于英国金斯顿大学.','/singerImages/ChenYiXun.png','2022-02-04 00:36:37','2022-02-05 11:30:08'),(15,0,'华晨宇',1,'1990-02-07 00:00:00','中国大陆','中国内地流行乐男歌手、作曲人，毕业于武汉音乐学院.','/singerImages/HuaChenYu.png','2022-02-04 00:37:45','2022-02-05 11:30:08'),(16,0,'林宥嘉',1,'1987-07-01 00:00:00','中国台湾','中国台湾流行乐男歌手、音乐制作人、演员，毕业于国立东华大学运动与休闲学系。','/singerImages/LinYouJia.png','2022-02-05 10:09:00','2022-02-05 11:30:08'),(17,0,'邓紫棋',0,'1991-08-16 00:00:00','中国大陆','中国香港流行乐女歌手、词曲作者、音乐制作人。','/singerImages/DengZiQi.png','2022-02-05 10:15:51','2022-02-05 11:30:08'),(18,0,'Sasha Sloan',0,'1995-03-11 00:00:00','美国','细腻、忧郁、诚恳的新生代女唱作人.','/singerImages/SaSha.png','2022-02-05 10:19:32','2022-02-05 11:51:02'),(19,0,'李荣浩',1,'1985-07-11 00:00:00','中国大陆','中国内地流行乐男歌手、音乐人、演员。','/singerImages/LiRongHao.png','2022-02-05 10:26:07','2022-02-05 11:30:08'),(20,0,'Taylor Swift',0,'1989-12-13 00:00:00','美国宾夕法尼亚州','美国女歌手、词曲作者、音乐制作人、演员。','/singerImages/TaylorSwift.png','2022-02-05 11:02:57','2022-02-05 11:03:39'),(21,1,'张锐哲',1,'2022-02-01 00:00:00','中国大陆','说唱,摇滚新星','/singerImages/ZhouJieLun.png','2022-02-05 12:19:27','2022-02-05 12:19:34'),(22,1,'渊洁',1,'2022-02-01 00:00:00','中国大陆','啥都会','/singerImages/ZhouJieLun.png','2022-02-05 12:24:32','2022-02-05 12:24:39'),(23,1,'test1',3,'2022-02-01 00:00:00','1','1','/singerImages/ZhouJieLun.png','2022-02-05 12:27:45','2022-02-05 12:27:50'),(24,0,'林俊杰',1,'1981-03-27 00:00:00','中国福建','华语流行乐男歌手、音乐人、潮牌主理人。','/singerImages/85256e84-0bc7-46f0-b6ff-f7fa4a376ef4.png','2022-02-09 21:03:58','2022-02-09 21:06:45'),(25,1,'test',1,'2022-02-10 00:00:00','1','1','/singerImages/ZhouJieLun.png','2022-02-10 01:29:02','2022-02-10 01:29:06'),(26,1,'test',1,'2022-02-01 00:00:00','1','1','/singerImages/ZhouJieLun.png','2022-02-18 19:54:46','2022-02-18 19:54:50');
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `singer_id` int unsigned NOT NULL COMMENT '歌手id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌名',
  `introduction` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '歌曲简介',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '歌曲地址',
  `picture` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
  `lyric` text COLLATE utf8mb4_unicode_ci COMMENT '歌词',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='歌曲';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` (`id`, `is_delete`, `singer_id`, `name`, `introduction`, `url`, `picture`, `lyric`, `create_time`, `update_time`) VALUES (1,0,12,'周杰伦-青花瓷','我很忙','/song/3d43f243-b77a-4ba0-a137-8b078d90f24b.mp3','/songImages/music.png','[ti:青花瓷]\n[ar:周杰伦]\n[al:我很忙]\n[00:00.00]青花瓷 - 周杰伦\n[00:20.89]素胚勾勒出青花笔锋浓转淡\n[00:25.58]瓶身描绘的牡丹一如你初妆\n[00:29.96]冉冉檀香透过窗心事我了然\n[00:34.43]宣纸上 走笔至此搁一半\n[00:38.99]釉色渲染仕女图韵味被私藏\n[00:43.33]而你嫣然的一笑如含苞待放\n[00:47.80]你的美一缕飘散\n[00:50.27]去到我去不了的地方\n[00:56.40]天青色等烟雨 而我在等你\n[01:00.43]炊烟袅袅升起 隔江千万里\n[01:05.34]在瓶底书汉隶仿前朝的飘逸\n[01:09.37]就当我为遇见你伏笔\n[01:13.84]天青色等烟雨 而我在等你\n[01:18.49]月色被打捞起 晕开了结局\n[01:23.22]如传世的青花瓷自顾自美丽\n[01:27.15]你眼带笑意\n[01:49.75]色白花青的锦鲤跃然於碗底\n[01:54.19]临摹宋体落款时却惦记着你\n[01:58.72]你隐藏在窑烧里千年的秘密\n[02:03.25]极细腻 犹如绣花针落地\n[02:07.82]帘外芭蕉惹骤雨\n[02:10.07]门环惹铜绿\n[02:12.34]而我路过那江南小镇惹了你\n[02:16.69]在泼墨山水画里\n[02:19.25]你从墨色深处被隐去\n[02:25.13]天青色等烟雨 而我在等你\n[02:29.94]炊烟袅袅升起 隔江千万里\n[02:34.35]在瓶底书汉隶仿前朝的飘逸\n[02:38.23]就当我为遇见你伏笔\n[02:42.85]天青色等烟雨 而我在等你\n[02:47.51]月色被打捞起 晕开了结局\n[02:52.04]如传世的青花瓷自顾自美丽\n[02:56.17]你眼带笑意\n[03:01.42]天青色等烟雨 而我在等你\n[03:05.42]炊烟袅袅升起 隔江千万里\n[03:09.86]在瓶底书汉隶仿前朝的飘逸\n[03:14.17]就当我为遇见你伏笔\n[03:18.33]天青色等烟雨 而我在等你\n[03:23.21]月色被打捞起 晕开了结局\n[03:27.83]如传世的青花瓷自顾自美丽\n[03:31.80]你眼带笑意','2022-02-05 17:20:49','2022-02-07 19:29:02'),(2,1,12,'周杰伦-测试删除','测试删除','/song/f7d40273-3de3-4d0a-b1f0-b9190ffdc5a8.mp3','/songImages/music.png','[00:00:00]暂无歌词','2022-02-05 18:41:17','2022-02-05 18:53:45'),(5,0,12,'周杰伦-告白气球','周杰伦的床边故事','/song/b71c5eb3-480f-496e-8576-41bb601febec.mp3','/songImages/music.png','[ti:告白气球]\r\n[ar:周杰伦]\r\n[al:周杰伦的床边故事]\r\n[offset:0]\r\n[00:00.98]告白气球\r\n[00:04.19]词：方文山\r\n[00:06.29]曲：周杰伦\r\n[00:07.78]演唱：周杰伦\r\n[00:17.78]\r\n[00:23.65]塞纳河畔 左岸的咖啡\r\n[00:26.45]我手一杯 品尝你的美\r\n[00:28.94]\r\n[00:29.49]留下唇印的嘴\r\n[00:31.89]\r\n[00:34.42]花店玫瑰 名字写错谁\r\n[00:37.18]告白气球 风吹到对街\r\n[00:40.18]微笑在天上飞\r\n[00:42.59]\r\n[00:44.27]你说你有点难追 想让我知难而退\r\n[00:49.40]礼物不需挑最贵 只要香榭的落叶\r\n[00:54.67]喔 营造浪漫的约会 不害怕搞砸一切\r\n[01:00.01]拥有你就拥有 全世界\r\n[01:04.15]\r\n[01:05.13]亲爱的 爱上你 从那天起\r\n[01:11.48]甜蜜的很轻易\r\n[01:14.59]\r\n[01:15.70]亲爱的 别任性 你的眼睛\r\n[01:21.36]\r\n[01:22.08]在说我愿意\r\n[01:25.42]\r\n[01:49.14]塞纳河畔 左岸的咖啡\r\n[01:51.72]我手一杯 品尝你的美\r\n[01:54.20]\r\n[01:54.87]留下唇印的嘴\r\n[01:57.31]\r\n[01:59.81]花店玫瑰 名字写错谁\r\n[02:02.39]告白气球 风吹到对街\r\n[02:04.70]\r\n[02:05.44]微笑在天上飞\r\n[02:07.99]\r\n[02:09.61]你说你有点难追 想让我知难而退\r\n[02:14.78]礼物不需挑最贵 只要香榭的落叶\r\n[02:19.65]\r\n[02:20.18]喔 营造浪漫的约会 不害怕搞砸一切\r\n[02:25.40]拥有你就拥有 全世界\r\n[02:29.42]\r\n[02:30.46]亲爱的 爱上你 从那天起\r\n[02:36.87]甜蜜的很轻易\r\n[02:39.98]\r\n[02:41.01]亲爱的 别任性 你的眼睛\r\n[02:46.74]\r\n[02:47.33]在说我愿意\r\n[02:51.16]\r\n[02:51.85]亲爱的 爱上你 恋爱日记\r\n[02:57.46]\r\n[02:58.06]飘香水的回忆\r\n[03:01.49]\r\n[03:02.42]一整瓶 的梦境 全都有你\r\n[03:08.11]\r\n[03:08.82]搅拌在一起\r\n[03:12.29]\r\n[03:13.16]亲爱的别任性 你的眼睛\r\n[03:20.01]\r\n[03:21.37]在说我愿意','2022-02-17 16:58:48','2022-02-17 17:21:23'),(6,0,12,'周杰伦-烟花易冷','周杰伦的床边故事','/song/c47c641d-3f3b-4926-a88e-854faba2f7e3.mp3','/songImages/music.png','[ti:烟花易冷]\r\n[ar:周杰伦]\r\n[al:跨时代]\r\n[00:00.21]烟花易冷\r\n[00:03.02]作词：方文山 作曲：周杰伦\r\n[00:04.53]演唱：周杰伦\r\n[00:06.07]\r\n[00:11.90]繁华声 遁入空门\r\n[00:14.33]折煞了世人\r\n[00:18.06]梦偏冷 辗转一生\r\n[00:20.49]情债又几本\r\n[00:24.12]如你默认 生死枯等\r\n[00:30.35]枯等一圈 又一圈的\r\n[00:33.98]年轮\r\n[00:35.95]\r\n[00:36.58]浮图塔 断了几层\r\n[00:39.35]断了谁的魂\r\n[00:42.81]痛直奔 一盏残灯\r\n[00:45.47]倾塌的山门\r\n[00:49.15]容我再等 历史转身\r\n[00:55.65]等酒香醇 等你弹\r\n[00:58.27]一曲古筝\r\n[01:01.50]\r\n[01:01.92]雨纷纷 旧故里草木深\r\n[01:07.92]我听闻 你始终一个人\r\n[01:14.30]斑驳的城门 盘踞着老树根\r\n[01:20.57]石板上回荡的是 再等\r\n[01:26.34]\r\n[01:26.76]雨纷纷 旧故里草木深\r\n[01:33.02]我听闻 你仍守着孤城\r\n[01:39.29]城郊牧笛声 落在那座野村\r\n[01:45.60]缘份落地生根是 我们\r\n[01:51.30]\r\n[01:54.56]听青春 迎来笑声\r\n[01:57.14]羡煞许多人\r\n[02:00.87]那史册 温柔不肯\r\n[02:03.38]下笔都太狠\r\n[02:06.98]烟花易冷 人事易分\r\n[02:13.21]而你在问 我是否还\r\n[02:17.05]认真\r\n[02:18.87]\r\n[02:19.33]千年后 累世情深\r\n[02:22.22]还有谁在等\r\n[02:25.71]而青史 岂能不真\r\n[02:28.33]魏书洛阳城\r\n[02:32.05]如你在跟 前世过门\r\n[02:38.51]跟着红尘 跟随我\r\n[02:41.28]浪迹一生\r\n[02:43.86]\r\n[02:44.76]雨纷纷 旧故里草木深\r\n[02:50.99]我听闻 你始终一个人\r\n[02:57.31]斑驳的城门 盘踞着老树根\r\n[03:03.43]石板上回荡的是 再等\r\n[03:09.24]\r\n[03:09.62]雨纷纷 旧故里草木深\r\n[03:15.88]我听闻 你仍守着孤城\r\n[03:22.19]城郊牧笛声 落在那座野村\r\n[03:28.45]缘份落地生根是 我们\r\n[03:34.15]\r\n[03:35.12]雨纷纷 旧故里草木深\r\n[03:36.57]我听闻 你始终一个人\r\n[03:38.51]斑驳的城门 盘踞着老树根\r\n[03:40.41]石板上回荡的是 再等\r\n[03:41.70]\r\n[03:41.93]雨纷纷 雨纷纷\r\n[03:43.26]旧故里草木深\r\n[03:45.20]我听闻 我听闻\r\n[03:46.68]你仍守着孤城\r\n[03:48.14]城郊牧笛声\r\n[03:50.19]落在那座野村\r\n[03:53.34]缘份落地生根是 我们\r\n[03:59.65]缘份落地生根是 我们\r\n[04:05.76]伽蓝寺听雨声盼 永恒','2022-02-17 17:00:54','2022-02-17 17:21:23'),(7,0,12,'周杰伦-花海','魔羯座','/song/10e07768-e016-462a-bde4-2ef5ac3acb85.mp3','/songImages/music.png','[ti:花海]\r\n[ar:周杰伦]\r\n[al:]\r\n[by:]\r\n[offset:0]\r\n[00:04.41]☆花海 Jay Chou☆\r\n[00:07.72]☆JAY 魔杰座☆\r\n[00:10.22]☆永爱杰伦☆支持正版☆\r\n[00:14.28]☆Music...\r\n[00:27.10]静止了 所有的花开\r\n[00:33.28]遥远了 清晰的爱\r\n[00:40.10]天弥漫 爱却更喜欢\r\n[00:46.30]那时候 我不懂 这叫爱\r\n[00:52.79]你喜欢 站在那窗台\r\n[00:58.91]你好久 都没再来\r\n[01:04.67]彩色的 实际让人很空白\r\n[01:11.98]是你流的泪晕开\r\n[01:17.54]不要你离开 距离隔不开\r\n[01:23.79]思念变成海 在窗外进不来\r\n[01:30.23]原谅说太快 爱成了阻碍\r\n[01:36.48]手中的风筝放太快回不来\r\n[01:43.92]不要你离开 回忆花不开\r\n[01:49.67]请你等重来 我在等待重来\r\n[01:56.17]天空仍灿烂 她爱着大海\r\n[02:02.36]情歌被打败 爱已不存在\r\n[02:09.55]\r\n[02:11.48]☆曲周杰伦歌词提供再兴\r\n[02:13.23]永爱杰伦支持正版☆\r\n[02:20.30]\r\n[02:34.99]你喜欢 站在那窗台\r\n[02:41.36]你好久 都没再来\r\n[02:47.99]彩色的 实际让人很空白\r\n[02:55.12]是你流的泪晕开\r\n[03:00.12]不要你离开 距离隔不开\r\n[03:06.05]思念变成海 在窗外进不来\r\n[03:12.43]原谅说太快 爱成了阻碍\r\n[03:18.62]手中的风筝放太快回不来\r\n[03:24.56]不要你离开 回忆花不开\r\n[03:31.50]请你等重来 我在等待重来\r\n[03:37.81]天空仍灿烂 她爱着大海\r\n[03:44.62]情歌被打败 爱已不存在','2022-02-17 17:02:49','2022-02-17 17:21:23'),(8,0,12,'周杰伦-反方向的钟','jay','/song/3dbf8df8-6c64-442d-a170-7b38980a0ee9.mp3','/songImages/music.png','[ti:反方向的钟]\r\n[ar:周杰伦]\r\n[al: ]\r\n[by:mp3.5nd]\r\n[00:01.78]词:方文山\r\n[00:10.32]曲:周杰伦\r\n[00:15.45]mp3.5nd\r\n[00:43.52]\r\n[00:43.53]迷迷蒙蒙 你给的梦\r\n[00:45.54]出现裂缝 隐隐作痛\r\n[00:48.04]怎么沟通你都没空\r\n[00:50.47]说我不懂 说了没用\r\n[00:53.11]他的笑容 有何不同\r\n[00:55.47]在你心中 我不再受宠\r\n[00:58.15]我的天空 是雨是风 还是彩虹\r\n[01:01.58]你在操纵\r\n[01:02.80]\r\n[01:03.66]恨自己真的没用情绪激动\r\n[01:07.58] 一颗心到现在还在抽痛\r\n[01:12.22]还为分手前那句抱歉在感动\r\n[01:18.88]穿梭时间的画面的钟\r\n[01:27.19]从反方向 开始移动\r\n[01:31.78]回到当初爱你的时空\r\n[01:36.87]停格内容 不忠\r\n[01:40.92]\r\n[01:42.37]所有回忆对着我进攻\r\n[01:46.83]我的伤口 被你拆封\r\n[01:51.69]誓言太沉重泪被纵容\r\n[01:56.68]脸上汹涌 失控\r\n[01:58.73]\r\n[02:01.18]RAP~\r\n[02:11.75]城市霓虹 不安跳动\r\n[02:13.00]染红夜空 过去种种\r\n[02:14.29]像一场梦 不敢去碰\r\n[02:15.78] 一想就痛 心碎内容\r\n[02:17.07] 每一秒钟 都有不同\r\n[02:19.22] 你不懂 连一句珍重\r\n[02:20.17]也有苦衷 也不想送\r\n[02:21.17]寒风中 废墟烟囱\r\n[02:22.44]停止转动 一切落空\r\n[02:23.60] 在人海中盲目跟从\r\n[02:25.09] 别人的梦 全面放纵\r\n[02:26.41]恨没有用 疗伤止痛\r\n[02:27.59]不在感动 没有梦\r\n[02:28.65] 痛不知轻重\r\n[02:29.87]泪水鲜红 全面放纵\r\n[02:30.96]\r\n[02:41.30]恨自己真的没用情绪激动\r\n[02:46.04] 一颗心到现在还在抽痛\r\n[02:50.85]还为分手前那句抱歉在感动\r\n[02:59.87]穿梭时间的画面的钟\r\n[03:05.08]从反方向 开始移动\r\n[03:10.28]回到当初爱你的时空\r\n[03:14.92]停格内容 不忠\r\n[03:20.08]所有回忆对着我进攻\r\n[03:23.27]\r\n[03:24.90]我的伤口 被你拆封\r\n[03:29.59]誓言太沉重泪被纵容\r\n[03:34.63]脸上汹涌 失控\r\n[03:36.10]\r\n[03:39.81]穿梭时间的画面的钟\r\n[03:44.23]从反方向 开始移动\r\n[03:49.36]回到当初爱你的时空\r\n[03:54.01]停格内容 不忠\r\n[03:59.51]所有回忆对着我进攻','2022-02-17 17:04:34','2022-02-17 17:21:23'),(9,0,12,'周杰伦-七里香','七里香','/song/acb6a9ce-1813-49ac-b23f-92e1f75f885d.mp3','/songImages/music.png','[ti:七里香]\r\n[ar:周杰伦]\r\n[al:Initial J (日本版)]\r\n[by:MP3.5nd]\r\n[offset:500]\r\n[00:08.28]作词：方文山　作曲：周杰伦\r\n[00:21.33]制作：MP3.5nd\r\n[00:27.43]窗外的麻雀 在电线杆上多嘴\r\n[00:34.33]你说这一句 很有夏天的感觉\r\n[00:40.98]手中的铅笔 在纸上来来回回\r\n[00:47.30]我用几行字形容你是我的谁\r\n[00:54.03]秋刀鱼的滋味 猫跟你都想了解\r\n[01:01.10]初恋的香味就这样被我们寻回\r\n[01:07.40]那温暖的阳光 象刚摘的鲜艳草莓\r\n[01:14.14]你说你舍不得吃掉这一种感觉\r\n[02:14.66]\r\n[03:35.01][02:41.25][01:47.47][01:20.45]雨下整夜 我的爱溢出就象雨水\r\n[03:41.68][02:47.85][01:27.24]院子落叶 跟我的思念厚厚一叠\r\n[03:48.30][02:54.55][01:33.92]几句是非 也无法将我的热情冷却\r\n[03:55.90][03:02.15][01:41.51]你出现在我诗的每一页\r\n[03:07.79]\r\n[04:02.36]整夜 我的爱溢出就象雨水\r\n[04:08.52][01:54.12]窗台蝴蝶 象诗里纷飞的美丽章节\r\n[04:15.47][02:00.84]我接着写 把永远爱你写进诗的结尾\r\n[04:22.77][02:08.35]你是我唯一想要的了解\r\n[04:29.28]\r\n[03:08.51]那饱满的稻穗 幸福了这个季节\r\n[03:15.85]而你的脸颊象田里熟透的蕃茄\r\n[03:21.87]你突然对我说 七里香的名字很美\r\n[03:28.56]我此刻却只想亲吻你倔强的嘴5nd','2022-02-17 17:06:09','2022-02-17 17:21:23'),(10,0,12,'周杰伦-稻香','魔羯座','/song/506f7480-a51a-4059-b7bb-ee12b1a178c9.mp3','/songImages/music.png','[ti:稻香]\r\n[ar:周杰伦]\r\n[al:魔杰座]\r\n[by:]\r\n[offset:0]\r\n[00:02.54]词：周杰伦 曲：周杰伦\r\n[00:15.59]　　对这个世界如果你有太多的抱怨\r\n[00:18.73]　　跌倒了就不敢继续往前走\r\n[00:21.59]　　为什麽人要这麽的脆弱 堕落\r\n[00:25.78]　　请你打开电视看看\r\n[00:27.59]　　多少人为生命在努力勇敢的走下去\r\n[00:31.41]　　我们是不是该知足\r\n[00:33.28]　　珍惜一切 就算没有拥有\r\n[00:37.85]\r\n[03:45.65][02:58.78][00:38.66]　　还记得你说家是唯一的城堡 随着稻香河流继续奔跑\r\n[03:52.28][03:05.35][00:44.91]　　微微笑 小时候的梦我知道\r\n[03:10.47][00:50.42]　　不要哭让萤火虫带着你逃跑 乡间的歌谣永远的依靠\r\n[03:17.04]　　回家吧 回到最初的美好\r\n[01:48.97]　　不要这麽容易就想放弃 就像我说的\r\n[01:52.54]　　追不到的梦想 换个梦不就得了\r\n[01:55.35]　　为自己的人生鲜艳上色 先把爱涂上喜欢的颜色\r\n[02:01.29]　　笑一个吧 功成名就不是目的\r\n[02:03.62]　　让自己快乐快乐这才叫做意义\r\n[02:06.43][00:56.51]　　童年的纸飞机 现在终于飞回我手裡\r\n[02:12.21][01:01.97]　　所谓的那快乐 赤脚在田裡追蜻蜓追到累了\r\n[02:16.39][01:06.15]　　偷摘水果被蜜蜂给叮到怕了 谁在偷笑呢\r\n[02:21.09][01:10.60]　　我看着稻草人吹着风唱着歌睡着了\r\n[02:24.46][01:14.53]　　哦 哦 午后吉它在虫鸣中更清脆\r\n[02:27.33][01:17.09]　　哦 哦 阳光洒在路上就不怕心碎\r\n[02:30.52][01:20.15]　　珍惜一切 就算没有拥有\r\n[02:35.09][01:24.45]\r\n[03:22.19][02:35.37][01:25.26]　　还记得你说家是唯一的城堡 随着稻香河流继续奔跑\r\n[03:28.82][02:41.99][01:31.77]　　微微笑 小时候的梦我知道\r\n[03:33.89][02:47.13][01:36.90]　　不要哭让萤火虫带着你逃跑 乡间的歌谣永远的依靠\r\n[03:40.46][02:53.68][01:43.77]　　回家吧 回到最初的美好','2022-02-17 17:07:11','2022-02-17 17:21:23'),(11,0,12,'周杰伦-兰亭序','魔羯座','/song/14868e53-ab93-4794-939c-5ad04e1ada43.mp3','/songImages/music.png','[ti:兰亭序]\r\n[ar:周杰伦]\r\n[al:]\r\n[by:]\r\n[offset:0]\r\n[00:05.45]☆ JaY ChOu☆\r\n[00:07.39]☆魔杰座 JVR☆\r\n[00:09.40]☆词/方文山 曲/JAY☆\r\n[00:11.95]☆永爱杰伦☆支持正版☆\r\n[00:17.02]☆Music...\r\n[00:25.58]兰亭临帖 行书如行云流水\r\n[00:32.64]月下门推 心细如你脚步碎\r\n[00:38.14]忙不迭 千年碑易拓 却难拓你的美\r\n[00:45.96]奇珍缺页 真心能给谁\r\n[00:51.77]牧笛横吹 黄酒小菜有几碟\r\n[00:57.52]夕阳余晖 如你的羞怯似醉\r\n[01:04.02]摹本已写 而墨香不褪 淤泥都有余味\r\n[01:11.33]一杆朱砂 到底结了谁\r\n[01:16.83]无花风月 我啼血等一回\r\n[01:22.90]宣笔一撅 那岸边浪千叠\r\n[01:29.21]情字何解 怎落笔都不对\r\n[01:35.52]而我独缺 你一生的了解\r\n[01:41.77]\r\n[01:43.53]无花风月 我啼血等一回\r\n[01:46.34]宣笔一撅 那岸边浪千叠\r\n[01:49.52]情字何解 怎落笔都不对\r\n[01:52.53]而我独缺 你一生的了解\r\n[01:56.03]无花风月 我啼血等一回\r\n[01:59.15]宣笔一撅 那岸边浪千叠\r\n[02:02.15]情字何解 怎落笔都不对\r\n[02:05.88]而我独缺 你一生的了解\r\n[02:07.93]弹指岁月 情唱情歌情湮灭\r\n[02:13.25]情诗半解 回眸一笑你婉约\r\n[02:20.19]恨了没 你摇铜镜叹 谁让你蹙秀眉\r\n[02:27.13]而生回忆 徒留胭脂味\r\n[02:32.81]廊燕南飞 转身一别衣溅泪\r\n[02:39.01]菊已八月 收揽回忆怎么睡\r\n[02:45.07]又怎么会 心事蜜蜂嗅 花谢阵阵沿堆\r\n[02:52.32]若花怨蝶 你会怨着谁\r\n[02:57.82]无花风月 我啼血等一回\r\n[03:03.82]宣笔一撅 那岸边浪千叠\r\n[03:10.19]情字何解 怎落笔都不对\r\n[03:16.44]而我独缺 你一生的了解\r\n[03:23.01]无花风月 我啼血等一回\r\n[03:30.82]手书无愧 无惧人间是非\r\n[03:37.33]雨的娇艳 又潇潇了几夜\r\n[03:43.39]我等着泪 来提醒你爱谁\r\n[03:57.58]☆...','2022-02-17 17:08:09','2022-02-17 17:21:23'),(12,0,12,'周杰伦-菊花台','依然范特西','/song/0e037f64-ad2a-4334-b19c-5dd862e75af0.mp3','/songImages/music.png','[ti:菊花台]\r\n[ar:周杰伦]\r\n[al:依然范特西]\r\n[by:(5nd音乐网)5nd]\r\n[offset:500]\r\n[00:07.49]爱歌词 5nd☆\r\n[00:10.96]\r\n[00:13.61]☆永爱杰伦☆支持正版☆\r\n[00:36.09]你的泪光 柔弱中带伤\r\n[00:42.59]惨白的月儿弯弯 固住过往\r\n[00:49.92]夜太漫长 凝结成了霜\r\n[00:56.71]是谁在阁楼上冰冷地绝望\r\n[01:03.83]雨轻轻叹 朱红色的窗\r\n[01:10.87]我依身在纸上被风吹乱\r\n[01:17.93]梦在远方 化成一缕香\r\n[01:24.87]随风飘散你的模样\r\n[01:30.91]菊花灿烂地烧\r\n[01:37.58]你的笑容已泛黄\r\n[01:42.08]花落人断肠 我心事静静躺\r\n[01:48.20]被风乱 也微摇\r\n[01:51.77]你的影子剪不断\r\n[01:55.89]独留我孤单 在湖面神伤\r\n[02:06.81]☆歌词提供：再兴\r\n[02:09.74]\r\n[02:31.05]花已伤完 飘落了灿烂\r\n[02:38.00]凋谢的市道上 冥冥不堪\r\n[02:44.81]手摸独樵 愁心拆两半\r\n[02:51.72]他已上不了爱一辈子摇晃\r\n[02:58.97]谁的江山 马蹄声慌乱\r\n[03:05.98]我一身的戎装 呼啸沧桑\r\n[03:12.96]天微微亮 你轻声的叹\r\n[03:19.80]一夜惆怅如此委婉\r\n[03:28.15]菊花灿烂地烧 你的笑容已泛黄\r\n[03:37.04]花落人断肠 我心事静静躺\r\n[03:43.42]被风乱 也微摇\r\n[03:46.45]你的影子剪不断\r\n[03:50.92]独留我孤单 在湖面神伤\r\n[04:00.83]菊花灿烂地烧 你的笑容已泛黄\r\n[04:08.08]花落人断肠 我心事静静躺\r\n[04:14.64]被风乱 也微摇\r\n[04:18.28]你的影子剪不断\r\n[04:24.52]独留我孤单 在湖面神伤\r\n[04:34.55]END☆歌词吾爱☆','2022-02-17 17:09:24','2022-02-17 17:21:23'),(13,0,14,'陈奕迅-孤勇者','孤勇者','/song/d79ae6bd-f45d-4941-996b-2b6e0caf21fd.mp3','/songImages/music.png','[ar:陈奕迅]\r\n[ti:孤勇者]\r\n[by:p_pttzhang]\r\n[00:00.00]孤勇者 (《英雄联盟：双城之战》动画剧集中文主题曲) - 陈奕迅\r\n[00:07.43]词：唐恬\r\n[00:08.22]曲：钱雷\r\n[00:08.84]编曲：钱雷\r\n[00:09.55]吉他：高飞\r\n[00:10.35]人声录音师：利伟明\r\n[00:11.57]人声录音棚：雅旺录音室\r\n[00:12.83]Vocal edite：汝文博@SBMS Beijing\r\n[00:13.07]混音/母带：周天澈@Studio 21A\r\n[00:14.53]词版权管理方：北京梦织音传媒有限公司\r\n[00:15.40]曲版权管理方：索尼音乐版权代理（北京）有限公司\r\n[00:16.67]录音作品及MV版权：EAS MUSIC LTD\r\n[00:17.02]联合出品：腾讯游戏K6合作部/拳头游戏\r\n[00:18.32]联合出品监制：霍锦卢泓宇\r\n[00:19.43]制作人：钱雷\r\n[00:22.16]都是勇敢的\r\n[00:28.41]你额头的伤口你的不同你犯的错\r\n[00:36.96]都不必隐藏\r\n[00:43.41]你破旧的玩偶你的面具你的自我\r\n[00:51.57]他们说要带着光驯服每一头怪兽\r\n[00:58.74]他们说要缝好你的伤没有人爱小丑\r\n[01:05.76]为何孤独不可光荣\r\n[01:09.11]人只有不完美值得歌颂\r\n[01:13.35]谁说污泥满身的不算英雄\r\n[01:20.84]爱你孤身走暗巷\r\n[01:22.62]爱你不跪的模样\r\n[01:24.49]爱你对峙过绝望\r\n[01:26.33]不肯哭一场\r\n[01:28.23]爱你破烂的衣裳\r\n[01:29.99]却敢堵命运的枪\r\n[01:31.86]爱你和我那么像\r\n[01:33.76]缺口都一样\r\n[01:35.64]去吗 配吗 这褴褛的披风\r\n[01:39.39]战吗 战啊 以最卑微的梦\r\n[01:43.00]致那黑夜中的呜咽与怒吼\r\n[01:50.24]谁说站在光里的才算英雄\r\n[02:08.59]他们说要戒了你的狂\r\n[02:11.57]就像擦掉了污垢\r\n[02:16.15]他们说要顺台阶而上而代价是低头\r\n[02:23.45]那就让我不可乘风\r\n[02:26.52]你一样骄傲着那种孤勇\r\n[02:30.90]谁说对弈平凡的不算英雄\r\n[02:38.37]爱你孤身走暗巷\r\n[02:40.17]爱你不跪的模样\r\n[02:41.99]爱你对峙过绝望\r\n[02:43.93]不肯哭一场\r\n[02:45.75]爱你破烂的衣裳\r\n[02:47.56]却敢堵命运的枪\r\n[02:49.39]爱你和我那么像\r\n[02:51.33]缺口都一样\r\n[02:53.24]去吗 配吗 这褴褛的披风\r\n[02:56.83]战吗 战啊 以最卑微的梦\r\n[03:00.50]致那黑夜中的呜咽与怒吼\r\n[03:07.84]谁说站在光里的才算英雄\r\n[03:12.73]你的斑驳与众不同\r\n[03:19.88]你的沉默震耳欲聋\r\n[03:25.76]You Are The Hero\r\n[03:26.55]爱你孤身走暗巷\r\n[03:28.16]爱你不跪的模样\r\n[03:29.95]爱你对峙过绝望\r\n[03:31.83]不肯哭一场 (You Are The Hero)\r\n[03:33.90]爱你来自于蛮荒\r\n[03:35.48]一生不借谁的光\r\n[03:37.32]你将造你的城邦\r\n[03:39.22]在废墟之上\r\n[03:41.17]去吗 去啊 以最卑微的梦\r\n[03:44.78]战吗 战啊 以最孤高的梦\r\n[03:48.46]致那黑夜中的呜咽与怒吼\r\n[03:55.82]谁说站在光里的才算英雄','2022-02-17 17:11:46','2022-02-17 17:21:23'),(14,0,12,'周杰伦-暗号','八度空间','/song/250f72f9-2320-46c0-be57-1a802bfbcf9f.mp3','/songImages/music.png','[ti:暗号]\r\n[ar:周杰伦]\r\n[al:八度空间]\r\n[by:湃哥]\r\n[00:01.18]歌曲：暗号\r\n[00:02.19]专辑：八度空间\r\n[00:03.07]出版年代：2002年\r\n[00:05.72]歌手：周杰伦\r\n[00:07.70]词：许世昌 曲：周杰伦 编曲：林迈可\r\n[00:14.54]\r\n[00:15.86]我想要的想做的\r\n[00:17.95]你比谁都了\r\n[00:19.80]你想说的想给的\r\n[00:21.64]我全都知道\r\n[00:23.32]\r\n[00:23.67]未接来电没留言\r\n[00:25.66]一定是你孤单的想念\r\n[00:27.83]任何人都猜不到\r\n[00:29.77]这是我们的暗号\r\n[00:31.54]\r\n[01:47.93][00:31.97]他们猜随便猜不重要\r\n[01:51.14][00:35.02]连上彼此的讯号\r\n[01:53.18][00:36.89]才有个依靠\r\n[01:54.82][00:38.51]\r\n[01:55.06][00:38.81]有太多人太多事\r\n[01:56.88][00:40.65]夹在我们之间咆哮\r\n[01:59.48][00:42.88]杂讯太多讯号弱\r\n[02:01.12][00:44.99]就连风吹都要干扰\r\n[02:03.25][00:46.98]\r\n[02:03.42][00:47.26]可是你不想\r\n[02:06.40][00:50.07]一直走在黑暗地下道\r\n[02:10.01][00:53.76]想吹风想自由\r\n[02:12.01][00:55.74]想要一起手牵手\r\n[02:14.16][00:57.83]去看海绕世界流浪\r\n[04:19.67][04:04.59][03:26.30][02:17.50][01:01.36]\r\n[04:20.03][04:04.77][03:27.15][02:18.13][01:01.78]我害怕你心碎\r\n[04:21.70][04:06.29][03:29.55][02:20.79][01:04.90]没人帮你擦眼泪\r\n[04:23.45][04:08.37][03:33.98][02:25.29][01:09.08]别管那是非\r\n[04:25.11][04:10.06][03:37.91][02:29.06][01:12.93]只要我们感觉对\r\n[04:26.30][04:12.30][03:58.56][03:40.87][02:32.17][01:16.22]\r\n[04:13.23][03:59.00][03:41.80][02:32.89][01:16.84]我害怕你心碎\r\n[04:14.06][03:59.60][03:44.47][02:36.13][01:19.94]没人帮你擦眼泪\r\n[04:15.92][04:00.79][03:49.02][02:40.39][01:23.83]别离开身边\r\n[04:17.79][04:02.47][03:52.96][02:44.01][01:28.17]拥有你我的世界才能完美\r\n[02:50.21][01:33.35]\r\n[02:56.99]你说你想逃开松手\r\n[03:00.29]爱太累爱得不自由\r\n[03:03.97]因为我给不起最简单的承诺\r\n[03:09.85]\r\n[03:10.95]你停止收讯号\r\n[03:14.91]我开始搜寻不到\r\n[03:18.53]到底有谁知道\r\n[03:20.88]是几点钟方向\r\n[03:22.90]你才会收到暗号','2022-02-17 17:23:20','2022-02-17 17:23:20');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song_list`
--

DROP TABLE IF EXISTS `song_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song_list` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `style` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '风格',
  `introduction` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '歌单简介',
  `picture` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='歌单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song_list`
--

LOCK TABLES `song_list` WRITE;
/*!40000 ALTER TABLE `song_list` DISABLE KEYS */;
INSERT INTO `song_list` (`id`, `is_delete`, `title`, `style`, `introduction`, `picture`, `create_time`, `update_time`) VALUES (1,0,'心灵疗愈所','温柔','适合工作,难受时候听','/songListImages/363fb207-b0c3-4e9b-aa10-d897eaca3a6b.jpg','2022-02-08 14:12:44','2022-02-08 19:33:50'),(2,1,'','','','/songListImages/img.png','2022-02-08 18:16:18','2022-02-08 18:16:32'),(3,0,'每科都考100分!','华语','流行','/songListImages/img.png','2022-02-10 16:34:33','2022-02-10 16:34:33');
/*!40000 ALTER TABLE `song_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `gender` tinyint unsigned NOT NULL COMMENT '0女 1男',
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '电话号码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '电子邮件',
  `birth` datetime NOT NULL COMMENT '生日',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地区',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个性签名',
  `avator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建字段的时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改字段的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `is_delete`, `username`, `password`, `gender`, `phone_num`, `email`, `birth`, `location`, `introduction`, `avator`, `create_time`, `update_time`) VALUES (1,0,'渊洁','123456',1,'137xxxx8837','7823xxxx676@qq.com','2001-08-25 00:00:00','浙江杭州','最难不过坚持.','/userImages/飘渺.png','2022-02-10 01:15:22','2022-02-21 19:23:18'),(2,0,'莫佬','123456',1,'137xxxx2567','250xxxx332@qq.com','2001-08-24 00:00:00','中国','呵呵','/userImages/阿塞萝拉.png','2022-02-10 01:23:05','2022-02-21 19:18:52'),(3,0,'782353676','123456',1,'110','110@qq.com','2001-08-25 00:00:00','浙江','最难不过坚持','/userImages/卡哇伊.png','2022-02-18 14:35:15','2022-02-18 15:52:18'),(4,0,'test','123456',0,'110','110@qq.com','2022-02-01 00:00:00','北京','哈哈','/userImages/卡哇伊.png','2022-02-18 15:57:49','2022-02-21 19:09:30');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 11:10:06
