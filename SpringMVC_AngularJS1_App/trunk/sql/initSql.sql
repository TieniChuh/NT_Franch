-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: web_creation
-- ------------------------------------------------------
-- Server version	5.1.49-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acct_authority`
--

DROP TABLE IF EXISTS `acct_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_authority` (
  `id` varchar(36) NOT NULL COMMENT '权限Id',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_authority`
--

LOCK TABLES `acct_authority` WRITE;
/*!40000 ALTER TABLE `acct_authority` DISABLE KEYS */;
INSERT INTO `acct_authority` VALUES ('b6d3ceb9-eae9-43a6-9064-424db8c53208','查看用户'),('29a366b9-bbbf-47e4-a0c2-26eec58b1822','添加用户');
/*!40000 ALTER TABLE `acct_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acct_role`
--

DROP TABLE IF EXISTS `acct_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_role` (
  `id` varchar(36) NOT NULL COMMENT '角色Id',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_role`
--

LOCK TABLES `acct_role` WRITE;
/*!40000 ALTER TABLE `acct_role` DISABLE KEYS */;
INSERT INTO `acct_role` VALUES ('b432d31d-ebd2-4e91-9184-1b3769e6686b','admin');
/*!40000 ALTER TABLE `acct_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acct_role_authority`
--

DROP TABLE IF EXISTS `acct_role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_role_authority` (
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `authority_id` varchar(36) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`authority_id`),
  KEY `role_id` (`role_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `acct_role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`),
  CONSTRAINT `acct_role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `acct_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_role_authority`
--

LOCK TABLES `acct_role_authority` WRITE;
/*!40000 ALTER TABLE `acct_role_authority` DISABLE KEYS */;
INSERT INTO `acct_role_authority` VALUES ('b432d31d-ebd2-4e91-9184-1b3769e6686b','29a366b9-bbbf-47e4-a0c2-26eec58b1822'),('b432d31d-ebd2-4e91-9184-1b3769e6686b','b6d3ceb9-eae9-43a6-9064-424db8c53208');
/*!40000 ALTER TABLE `acct_role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acct_user`
--

DROP TABLE IF EXISTS `acct_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_user` (
  `id` varchar(36) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(255) NOT NULL COMMENT '昵称',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `nickName` varchar(255) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nick_name` (`nick_name`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_user`
--

LOCK TABLES `acct_user` WRITE;
/*!40000 ALTER TABLE `acct_user` DISABLE KEYS */;
INSERT INTO `acct_user` VALUES ('14ff5253-5912-4a3f-b51b-f50d9da0271d','zty','13022221111','2015-02-06 17:13:55',NULL,NULL),('2a610c3a-b845-40d8-9bbb-7f2725372b07','1','1','2017-03-15 12:57:24',NULL,NULL),('52a83f25-de64-430f-b65e-f6609f07bf52','John1','160333','2017-04-06 15:02:22',NULL,NULL),('6e5afb1d-50e1-45fe-b6fe-b9e399415387','andy','15147174722','2015-02-06 17:06:36',NULL,NULL),('7e3cdaa6-61b2-414d-badc-f8ddb18d6807','John111','16022222222','2017-03-15 13:19:52',NULL,NULL),('804b772e-59d7-4ef7-bd15-b974308aaeb1','andy','13022221111','2017-03-13 15:56:49',NULL,NULL);
/*!40000 ALTER TABLE `acct_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acct_user_role`
--

DROP TABLE IF EXISTS `acct_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_user_role` (
  `user_id` varchar(36) NOT NULL COMMENT '用户Id',
  `role_id` varchar(36) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `acct_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `acct_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_user_role`
--

LOCK TABLES `acct_user_role` WRITE;
/*!40000 ALTER TABLE `acct_user_role` DISABLE KEYS */;
INSERT INTO `acct_user_role` VALUES ('6e5afb1d-50e1-45fe-b6fe-b9e399415387','b432d31d-ebd2-4e91-9184-1b3769e6686b');
/*!40000 ALTER TABLE `acct_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'web_creation'
--

--
-- Dumping routines for database 'web_creation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-26 17:30:54
