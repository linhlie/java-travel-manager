-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tour_manager
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(45) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'ha_noi_01.jpg','images/ha_noi_01.jpg'),(2,'ha_noi_02.jpg','images/ha_noi_02.jpg'),(3,'ha_noi_03.jpg','images/ha_noi_03.jpg'),(4,'ha_noi_04.jpg','images/ha_noi_04.jpg'),(5,'ha_noi_05.jpg','images/ha_noi_05.jpg'),(6,'ha_noi_06.jpg','images/ha_noi_06.jpg'),(7,'sa_pa_01.jpg','images/sa_pa_01.jpg'),(8,'sa_pa_02.jpg','images/sa_pa_02.jpg'),(9,'sa_pa_03.jpg','images/sa_pa_03.jpg'),(10,'sa_pa_04.jpg','images/sa_pa_04.jpg'),(11,'sa_pa_05.jpg','images/sa_pa_05.jpg'),(12,'sa_pa_06.jpg','images/sa_pa_06.jpg'),(13,'ha_long_01.jpg','images/ha_long_01.jpg'),(14,'ha_long_02.jpg','images/ha_long_02.jpg'),(15,'ha_long_03.jpg','images/ha_long_03.jpg'),(16,'ha_long_04.jpg','images/ha_long_04.jpg'),(17,'ha_long_05.jpg','images/ha_long_05.jpg'),(18,'ha_long_06.jpg','images/ha_long_06.jpg'),(19,'nhat_ban_01.jpg','images/nhat_ban_01.jpg'),(20,'nhat_ban_02.jpg','images/nhat_ban_02.jpg'),(21,'nhat_ban_03.jpg','images/nhat_ban_03.jpg'),(22,'nhat_ban_04.jpg','images/nhat_ban_04.jpg'),(23,'nhat_ban_05.jpg','images/nhat_ban_05.jpg'),(24,'nhat_ban_06.jpg','images/nhat_ban_06.jpg'),(25,'hy_lap_01.jpg','images/hy_lap_01.jpg'),(26,'hy_lap_02.jpg','images/hy_lap_02.jpg'),(27,'hy_lap_03.jpg','images/hy_lap_03.jpg'),(28,'hy_lap_04.jpg','images/hy_lap_04.jpg'),(29,'hy_lap_05.jpg','images/hy_lap_05.jpg'),(30,'hy_lap_06.jpg','images/hy_lap_06.jpg'),(31,'cate_01_01.jpg','images/cate_01_01.jpg'),(32,'cate_01_02.jpg','images/cate_01_02.jpg'),(33,'cate_01_03.jpg','images/cate_01_03.jpg'),(34,'cate_01_04.jpg','images/cate_01_04.jpg'),(35,'cate_01_05.jpg','images/cate_01_05.jpg'),(36,'cate_01_06.jpg','images/cate_01_06.jpg'),(37,'cate_02_01.jpg','images/cate_02_01.jpg'),(38,'cate_02_02.jpg','images/cate_02_02.jpg'),(39,'cate_02_03.jpg','images/cate_02_03.jpg'),(40,'cate_02_04.jpg','images/cate_02_04.jpg'),(41,'cate_02_05.jpg','images/cate_02_05.jpg'),(42,'cate_02_06.jpg','images/cate_02_06.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-10 19:23:42
