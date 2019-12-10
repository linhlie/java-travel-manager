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
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `tour_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_tour_id` int(11) DEFAULT NULL,
  `departure_date` varchar(255) DEFAULT NULL,
  `discount` float NOT NULL,
  `place_id` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `total_member` int(11) NOT NULL,
  `tour_content` varchar(255) DEFAULT NULL,
  `tour_name` varchar(255) DEFAULT NULL,
  `tour_summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tour_id`),
  KEY `fk_places_idx` (`place_id`),
  KEY `fk_category_tours_idx` (`category_tour_id`),
  CONSTRAINT `fk_category_tours` FOREIGN KEY (`category_tour_id`) REFERENCES `catergory_tour` (`catergory_tour_id`),
  CONSTRAINT `fk_places` FOREIGN KEY (`place_id`) REFERENCES `place` (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,1,'2019-12-03',0.1,1,1500,10,'<p>H&agrave;nh hương về ch&ugrave;a Hương, miền đất linh thi&ecirc;ng của Phật Gi&aacute;o lu&ocirc;n l&agrave; h&agrave;nh tr&igrave;nh hấp dẫn với nhiều du kh&aacute;ch. Chuyến đi kh&ocirc;ng chỉ d&agrave;nh cho những Phật tử muốn tỏ l&ograve;ng th&agra','Du lịch Hà Nội Chùa Hương','Hành hương về chùa Hương, miền đất linh thiêng của Phật Giáo luôn là hành trình hấp dẫn với nhiều du khách. Chuyến đi không chỉ dành cho những Phật tử muốn tỏ lòng thành kính, dâng lên Trời Phật lời nguyện cầu an lành, vượt qua những sóng gió và tai qua n'),(2,1,'2019-12-15',0,1,1300,8,'<p><strong>Chương tr&igrave;nh thăm quan H&agrave; Nội&nbsp;</strong></p>','Thăm quan Hà Nội','Thủ đô Hà Nội với lịch sử ngàn năm dựng nước và giữ nước cùng nền văn hóa phong phú đã giúp Hà Nội có được kiến trúc đa dạng và dấu ấn riêng góp phần phát triển nền du lịch nước nhà. Đến với thủ đô Hà Nội trong hành trình tour du lịch du khách sẽ được khá'),(3,1,'2020-01-01',0.3,2,2000,12,'<p>H&agrave;nh hương về ch&ugrave;a Hương, miền đất linh thi&ecirc;ng của Phật Gi&aacute;o lu&ocirc;n l&agrave; h&agrave;nh tr&igrave;nh hấp dẫn với nhiều du kh&aacute;ch. Chuyến đi kh&ocirc;ng chỉ d&agrave;nh cho những Phật tử muốn tỏ l&ograve;ng th&agra','Tour Sapa 2 ngày 1 đêm','Du lịch Sapa vào bất kỳ thời điểm nào trong năm bạn đều có thể cảm nhận được vẻ đẹp, lãng mạn nơi đây với: bản Cát Cát, Cầu Mây, thác Bạc, đỉnh Phanxipang, những ruộng bậc thang tầng tầng lớp lớp, mây vờn núi với những bản, thôn đã được quy hoạch để đón k'),(4,1,'2020-02-03',0.1,2,1800,5,'<p><strong>COMBO SAPA KH&Aacute;CH SẠN 5 SAO CHỈ TỪ 1.450.000VNĐ</strong></p>','COMBOO SAPA 2 NGÀY 1 ĐÊM - TRẢI NGHIỆM 5*','Du lịch Sapa vào bất kỳ thời điểm nào trong năm bạn đều có thể cảm nhận được vẻ đẹp, lãng mạn nơi đây với: bản Cát Cát, Cầu Mây, thác Bạc, đỉnh Phanxipang, những ruộng bậc thang tầng tầng lớp lớp, mây vờn núi với những bản, thôn đã được quy hoạch để đón k'),(5,1,'2020-03-05',0,3,2200,9,'<p>Vịnh Hạ Long nơi rồng đ&aacute;p xuống,&nbsp;l&agrave; danh thắng quốc gia được xếp hạng từ năm 1962. Hạ Long c&oacute; 1.969 h&ograve;n đảo, l&ocirc; nh&ocirc; tr&ecirc;n mặt biển, nổi tiếng nhất l&agrave; c&aacute;c&nbsp;h&ograve;n Lư Hương, G&agrave','2N1Đ Trên Du Thuyền Margaret Hạ Long 5 Sao','Vịnh Hạ Long nơi rồng đáp xuống, là danh thắng quốc gia được xếp hạng từ năm 1962. Hạ Long có 1.969 hòn đảo, lô nhô trên mặt biển, nổi tiếng nhất là các hòn Lư Hương, Gà Chọi, Cánh Buồm, Mâm Xôi, đảo Ngọc Vừng, Ti Tốp, Tuần Châu. Hạ Long như bức tranh thủ'),(6,1,'2020-03-03',0.1,3,2500,12,'<p><strong>Chương tr&igrave;nh chi tiết :</strong></p>','Du lịch Hạ Long Tuần Châu 3 ngày 2 đêm','Vịnh Hạ Long nơi rồng đáp xuống, là danh thắng quốc gia được xếp hạng từ năm 1962. Hạ Long có 1.969 hòn đảo, lô nhô trên mặt biển, nổi tiếng nhất là các hòn Lư Hương, Gà Chọi, Cánh Buồm, Mâm Xôi, đảo Ngọc Vừng, Ti Tốp, Tuần Châu. Hạ Long như bức tranh thủ'),(7,2,'2020-04-01',0.5,4,5000,5,'<h1><strong>TOKYO-PH&Uacute; SỸ-NARA-KYOTO-OSAKA</strong></h1>','Tour Nhật Bản Mùa Hoa Anh Đào Giá Rẻ Nhất','Hoa anh đào Nhật Bản (hay sakura) được nhiều người trên khắp thế giới yêu thích. Đó là biểu tượng của sự tái sinh, vẻ đẹp và sức sống. Vào mùa hoa hàng năm có hàng nghìn lượt khách tới Nhật Bản để chiêm ngưỡng vẻ đẹp của các loại hoa anh đào bung nở.'),(8,2,'2020-04-20',0.1,4,4800,10,'<p><strong>OSAKA -KAWAGUCHIKO- N&Uacute;I PH&Uacute; SĨ-NAGOYA - NARA</strong></p>','Tour du lịch Nhật Bản 4 ngày','Không còn những con đường phủ đầy anh đào như những ngày đầu xuân. Không có những con đường lá đỏ rơi đầy như mùa thu lãng mạn. Và càng không phải sắc trắng tràn ngập không gian như khi mùa đông ngự trị. Mùa hè ở xứ sở mặt trời mọc lại hút hồn khách du lị'),(9,2,'2020-05-01',0.2,5,5500,15,'<p><strong>C&Aacute;C ĐIỂM ĐẾN NỔI BẬT TRONG CHƯƠNG TR&Igrave;NH:</strong></p>','Du lịch Hy Lạp-Hành trình Nổi Bật: ATHENS-SOUNION-SANTORINI-LIMASSOL-LIMASSOL-NICOSIA','Hy Lạp nằm ở phía Nam bán đảo Balkan của Châu Âu, là một trong những điểm du lịch nổi tiếng nhất Thế giới. Hy Lạp vốn là đất nước của các vị thần. Chúng ta sẽ được tận mắt chiêm ngưỡng những đền thờ cổ kính, trang nghiêm như đền Parthenon với lối kiến trú');
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-10 19:23:44
