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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_news_id` int(11) DEFAULT NULL,
  `news_summary` varchar(500) DEFAULT NULL,
  `news_content` text,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  KEY `fk_news_category_idx` (`category_news_id`),
  CONSTRAINT `fk_news_category` FOREIGN KEY (`category_news_id`) REFERENCES `category_news` (`category_news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,1,'Cùng với việc đưa vào hoạt động Văn phòng Uông Bí, Vietravel Quảng Ninh hướng tới mở rộng điểm giao dịch, nâng cao chất lượng phục vụ, tiện ích, mang lại sự hài lòng cao nhất cho khách hàng địa phương; đây còn là bước tạo đột phá trong phát triển và đổi mới của Chi nhánh trong các năm tiếp theo.','<p>C&ugrave;ng với việc đưa v&agrave;o hoạt động Văn ph&ograve;ng U&ocirc;ng B&iacute;, Vietravel Quảng Ninh hướng tới mở rộng điểm giao dịch, n&acirc;ng cao chất lượng phục vụ, tiện &iacute;ch, mang lại sự h&agrave;i l&ograve;ng cao nhất cho kh&aacute;ch h&agrave;ng địa phương; đ&acirc;y c&ograve;n l&agrave; bước tạo đột ph&aacute; trong ph&aacute;t triển v&agrave; đổi mới của Chi nh&aacute;nh trong c&aacute;c năm tiếp theo.<br />','2019-12-10 10:57:52',NULL,'Vietravel Quảng Ninh khai trương văn phòng Uông Bí tạo đột phá trong phát triển và đổi mới'),(2,1,'Diễn ra từ ngày 29/11-1/12/2019 tại Trung tâm Xúc tiến Đầu tư Thương mại và Hội chợ Triển lãm Cần Thơ (108 Lê Lợi, P. Cái Khế, Q. Ninh Kiều, TP. Cần Thơ) - Hội chợ Du lịch quốc tế Cần Thơ 2019 (VITM Cần Thơ 2019) với quy mô có sự tham gia của trên 400 doanh nghiệp du lịch (lữ hành, khách sạn, hàng không, nhà hàng, quản lý điểm đến...) và cơ quan xúc tiến du lịch đến từ 6 quốc gia và trên 20 tỉnh/ thành phố, các hoạt động chuyên môn về du lịch, cùng các chương trình kích cầu du lịch, biểu diễn ng','<p>Theo đ&oacute;, trong khu&ocirc;n khổ Hội chợ sẽ diễn ra nhiều hoạt động điểm nhấn như:<br />','2019-12-10 10:59:16',NULL,'Vietravel đồng hành cùng Hội Chợ Du Lịch Quốc Tế VITM Cần Thơ 2019'),(3,2,'Vịnh Hạ Long được ví như thiên đường nơi hạ giới khi mang trong mình cả một “tác phẩm nghệ thuật” của tạo hoá. Mấy ai biết bên cạnh nét đẹp “trời phú” đó, Hạ Long còn có một nền văn hoá biển lâu đời mang tên Cửa Vạn. Nếu như vịnh Hạ Long là khu vườn của những lâu đài tạo hóa giữa trần gian, thì làng chài Cửa Vạn thực sự là một tác phẩm nghệ thuật do bàn tay con người tạo ra.','<p>1 trong 16 ng&ocirc;i l&agrave;ng cổ đẹp nhất thế giới<br />','2019-12-10 11:00:02',NULL,'Làng chài Cửa Vạn, ngôi làng cổ đẹp nhất thế giới ở Hạ Long'),(4,2,'Những ai đã đến với đất nước Canada một lần cũng đều muốn quay lại nơi đây nhiều lần hơn nữa, chính vì những cảnh đẹp nơi đây làm say mê. Vậy nên thanh xuân của bạn hãy đến với Canada một lần để được tự mình cảm nhận vẻ đẹp ấy nhé','<p>N&uacute;i đ&aacute; Rockies<br />','2019-12-10 11:01:34',NULL,'Cảnh đẹp Canada làm du khách phải nao lòng');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-10 19:23:43
