-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: regustrationmanagementdb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `competition`
--

DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competition` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '比赛id',
  `name` varchar(50) NOT NULL COMMENT '比赛名称',
  `introduction` varchar(500) NOT NULL COMMENT '比赛简介',
  `sponsor` varchar(30) NOT NULL COMMENT '主办方',
  `type` varchar(10) NOT NULL COMMENT '类型 团体赛 or 个人赛',
  `entry_quota` int NOT NULL COMMENT '参赛名额',
  `registered_people` int DEFAULT NULL COMMENT '已报名人数',
  `start_time` date NOT NULL COMMENT '报名开始时间',
  `status` varchar(9999) DEFAULT '进行中' COMMENT '状态',
  `end_time` date NOT NULL COMMENT '报名截止时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `img` varchar(1000) DEFAULT NULL COMMENT '比赛图像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='比赛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition`
--

LOCK TABLES `competition` WRITE;
/*!40000 ALTER TABLE `competition` DISABLE KEYS */;
INSERT INTO `competition` VALUES (1,'足球联赛','足球联赛 多人竞技','体育协会','团体赛',11,1,'2023-07-01','已截止','2023-07-15','2023-12-07 20:22:28','2023-12-18 18:45:14',NULL),(2,'团体赛乒乓球大赛','团队对抗，尽享丝滑','乒乓球团队','团体赛',20,8,'2024-08-01','未开始','2024-08-10','2023-12-07 20:22:28','2023-12-07 20:22:28',NULL),(3,'团体赛排球比赛','团体赛排球比赛！','排球协会','团体赛',15,12,'2023-09-01','进行中','2024-01-01','2023-12-07 20:22:28','2023-12-07 20:22:28',NULL),(4,'个人赛篮球比赛','足球个人赛','篮球协会','个人赛',50,24,'2023-03-10','已截止','2023-03-20','2023-12-07 20:22:30','2023-12-07 20:22:30',NULL),(5,'团体赛足球联赛','团体赛足球联赛','体育协会','团体赛',10,3,'2023-12-30','未开始','2024-01-14','2023-12-14 22:25:29','2023-12-14 22:25:35','null'),(6,'个人赛跑步挑战赛','跑步个人赛','体育协会','个人赛',100,50,'2023-12-05','进行中','2023-12-30','2023-12-07 20:22:30','2023-12-07 20:22:30',NULL),(7,'漫画鉴赏大赛','一起鉴赏漫画','漫画协会','个人赛',12,10,'2023-12-15','进行中','2023-12-31','2023-12-15 17:17:43','2023-12-15 17:17:45',NULL),(8,'走路草大赛','一起研究走路草','走路草协会','个人赛',1000,105,'2023-12-16','进行中','2023-12-31','2023-12-16 17:40:07','2023-12-16 17:40:08',NULL),(9,'可爱伊布大赛','选出最可爱的伊布','伊布可爱协会','团队赛',30,3,'2023-12-16','进行中','2023-12-31','2023-12-16 16:41:54','2023-12-16 17:42:01',NULL),(10,'保龄球大赛','比比谁的得分高','保龄球协会','个人赛',77,7,'2023-12-16','进行中','2025-12-25','2023-12-16 17:44:37','2023-12-16 17:44:48',NULL),(11,'蛋糕制作大赛','比比谁制作的蛋糕好吃','美食协会','个人赛',88,10,'2023-12-16','进行中','2024-12-20','2023-12-16 17:46:19','2023-12-16 17:46:21',NULL),(12,'巧克力模型大赛','比赛谁制作的巧克力模型好看','美食协会','团队赛',50,1,'2023-12-18','进行中','2024-01-03','2023-12-18 16:34:17','2023-12-18 16:34:17',NULL),(13,'游泳大赛','比较谁游得快','游泳休会','个人赛',17,2,'2023-12-19','进行中','2023-12-31','2023-12-19 14:42:15','2023-12-19 14:42:20',NULL),(14,'冰淇淋大赛','制作冰淇淋','美食协会','团队赛',25,0,'2023-12-19','进行中','2024-01-05','2023-12-19 14:40:50','2023-12-19 14:40:50',NULL);
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_user` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
INSERT INTO `operate_log` VALUES (1,6,'2023-12-18 21:16:12','com.akck.controller.CompetitionConyroller','save','[Competition(id=0, name=冰淇淋大赛, img=, introduction=1, sponsor=美食协会, type=团队赛, entryQuota=25, registeredPeople=0, startTime=2023-12-18, status=正在报名, endTime=2023-12-28, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"权限不足\",\"msg\":\"success\"}',0),(2,6,'2023-12-19 11:32:17','com.akck.controller.CompetitionConyroller','Update','[Competition(id=13, name=cs竞技大赛, img=, introduction=cs团队竞技，谁才是最后的王者, sponsor=游戏协会, type=, entryQuota=49, registeredPeople=0, startTime=2023-12-18, status=正在报名, endTime=2023-12-27, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"权限不足\",\"msg\":\"success\"}',0),(3,13,'2023-12-19 14:37:29','com.akck.controller.CompetitionConyroller','save','[Competition(id=0, name=冰淇淋大赛, img=, introduction=比赛制作冰淇淋, sponsor=美食协会, type=团队赛, entryQuota=25, registeredPeople=0, startTime=2023-12-19, status=正在报名, endTime=2024-01-06, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"新增成功\",\"msg\":\"success\"}',14),(33,13,'2023-12-19 14:39:05','com.akck.controller.CompetitionConyroller','delete','[13]','{\"code\":1,\"data\":\"删除成功\",\"msg\":\"success\"}',8),(34,13,'2023-12-19 14:39:32','com.akck.controller.CompetitionConyroller','save','[Competition(id=0, name=冰淇淋大赛, img=undefined, introduction=比赛制作冰淇淋, sponsor=美食协会, type=团队赛, entryQuota=25, registeredPeople=0, startTime=2023-12-19, status=正在报名, endTime=2023-12-30, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"新增成功\",\"msg\":\"success\"}',7),(35,13,'2023-12-19 14:40:24','com.akck.controller.CompetitionConyroller','delete','[17]','{\"code\":1,\"data\":\"删除成功\",\"msg\":\"success\"}',14),(36,13,'2023-12-19 14:40:32','com.akck.controller.CompetitionConyroller','delete','[13]','{\"code\":1,\"data\":\"删除成功\",\"msg\":\"success\"}',10),(37,13,'2023-12-19 14:40:50','com.akck.controller.CompetitionConyroller','save','[Competition(id=0, name=冰淇淋大赛, img=undefined, introduction=制作冰淇淋, sponsor=美食协会, type=团队赛, entryQuota=25, registeredPeople=0, startTime=2023-12-19, status=正在报名, endTime=2024-01-05, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"新增成功\",\"msg\":\"success\"}',9),(38,6,'2023-12-25 12:51:33','com.akck.controller.CompetitionConyroller','save','[Competition(id=0, name=马拉松大赛, img=, introduction=全力奔跑, sponsor=体育协会, type=团队赛, entryQuota=20, registeredPeople=0, startTime=2023-12-20, status=正在报名, endTime=2024-01-07, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"新增成功\",\"msg\":\"success\"}',17),(39,6,'2023-12-25 12:51:51','com.akck.controller.CompetitionConyroller','Update','[Competition(id=15, name=马拉松大赛, img=undefined, introduction=全力奔跑, sponsor=体育协会, type=, entryQuota=20, registeredPeople=6, startTime=2023-12-20, status=进行中, endTime=2024-01-07, createTime=null, updateTime=null)]','{\"code\":1,\"data\":\"更新成功\",\"msg\":\"success\"}',31),(40,6,'2023-12-25 12:56:43','com.akck.controller.CompetitionConyroller','delete','[15]','{\"code\":1,\"data\":\"删除成功\",\"msg\":\"success\"}',8);
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_img` varchar(1000) DEFAULT NULL COMMENT '用户的头像',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `role` int DEFAULT NULL COMMENT '1 为普通用户 2为管理员',
  `name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `gender` enum('男性','女性') DEFAULT NULL COMMENT '性别',
  `password` varchar(100) NOT NULL DEFAULT '123456' COMMENT '密码 默认值为123456',
  `email` varchar(90) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `phonenumber` varchar(999) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'zhangsan',1,'赵四','男性','123456','123456@qq.com','2023-12-10 10:03:26','2023-12-18 12:55:38','15111111111'),(2,NULL,'lisi',1,'李四','女性','1234567','','2023-12-10 10:03:30','2023-12-10 10:03:31',NULL),(3,NULL,'wangwu',1,'王五','男性','1233344','','2023-12-10 10:03:34','2023-12-10 10:03:33',NULL),(4,NULL,'zhaoliu',1,'赵六','女性','1231233','','2023-12-10 10:03:35','2023-12-10 10:03:36',NULL),(5,NULL,'sudongpo',1,'苏东波','男性','1234566','','2023-12-10 10:03:37','2023-12-10 10:03:38',NULL),(6,NULL,'jojo',2,'迪奥布蓝度','男性','123456','123456@qq.com','2023-12-10 10:03:39','2023-12-19 11:35:14','19103487682'),(7,NULL,'dio',1,'李大胆','男性','1234567','123@qq.com','2023-12-10 10:09:11','2023-12-16 12:47:32',NULL),(8,NULL,'dioo',1,'迪奥1号',NULL,'1234567',NULL,'2023-12-10 10:41:55','2023-12-10 10:41:55',NULL),(9,NULL,'dio00',1,'迪奥2号',NULL,'1234567',NULL,'2023-12-10 10:44:09','2023-12-10 10:44:09',NULL),(10,NULL,'哆啦A梦',2,'叮当猫','男性','duolaameng','1234@qq.com','2023-12-14 19:01:03','2023-12-14 19:01:03',NULL),(11,NULL,'宇智波赵四',1,'赵四','男性','123456','123456@qq.com','2023-12-18 12:36:52','2023-12-18 12:38:13',NULL),(12,NULL,'wangzhoingwang',2,'王中王','男性','123456','1@qq.com','2023-12-18 17:48:48','2023-12-18 17:48:49','15111111111'),(13,NULL,'宇智波灰太狼',2,'灰太狼','男性','123456','123@qq.com','2023-12-18 13:27:20','2023-12-18 16:55:37','15111111111'),(14,NULL,'尼古拉斯丁赵四',2,'赵四','男性','123456','1@qq.com','2023-12-18 17:45:59','2023-12-18 17:45:59','15111111111');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_competition`
--

DROP TABLE IF EXISTS `user_competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_competition` (
  `user_id` int NOT NULL COMMENT '用户id',
  `competition_id` int NOT NULL COMMENT '比赛id',
  PRIMARY KEY (`user_id`,`competition_id`),
  KEY `competition_id` (`competition_id`),
  CONSTRAINT `user_competition_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_competition_ibfk_2` FOREIGN KEY (`competition_id`) REFERENCES `competition` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户参加比赛的关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_competition`
--

LOCK TABLES `user_competition` WRITE;
/*!40000 ALTER TABLE `user_competition` DISABLE KEYS */;
INSERT INTO `user_competition` VALUES (1,3),(7,3),(13,3),(1,6),(7,6),(1,7),(11,7),(1,8),(6,8),(1,9),(6,9),(6,12);
/*!40000 ALTER TABLE `user_competition` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-26 11:51:30
