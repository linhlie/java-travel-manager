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
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_name` varchar(45) DEFAULT NULL,
  `place_summary` text,
  `place_content` text,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'Hà Nội','Hà Nội là thủ đô ngàn năm văn hiến, còn lưu dấu nhiều di tích Hồ Gươm, Cầu Thê Húc, Chùa Quán Sứ, Hồ Tây, 36 phố phường. Hà Nội có bốn mùa, luôn mang đến nhiều hoài niệm khó phai, mỗi mùa một vẻ, xuân lễ hội, hạ tươi thắm, thu quyến rũ và đông ấn tượng. Món ngon có Phở, Chả cá Lã Vọng, bánh tôm Hồ Tây.','<p>H&agrave; Nội được biết đến như l&agrave; thủ đ&ocirc; của Việt Nam, H&agrave; Nội cũng l&agrave; một trong những trung t&acirc;m văn ho&aacute;, ch&iacute;nh trị, thương mại v&agrave; du lịch quan trọng tr&ecirc;n cả nước. Trải qua hơn một ngh&igrave;n năm lịch sử, H&agrave; Nội đ&atilde; v&agrave; đang trở th&agrave;nh điểm đến du lịch nổi tiếng khắp thế giới.</p>'),(2,'Sa Pa','Cảnh đẹp Du Lich Sapa mùa hè thơ mộng, núi rừng nguyên sơ như tranh vẽ, thời tiết đặc trưng mùa đông trên ngọn núi fansipang kỳ vĩ hứa hẹn một Tour du lịch khám phá.Phong cảnh thiên nhiên của Sa Pa được kết hợp với sức sáng tạo của con người cùng với địa hình của núi đồi, màu xanh của rừng, như bức tranh có sự sắp xếp theo một bố cục hài hoà tạo nên một vùng có nhiều cảnh sắc thơ mộng hấp dẫn ..','<p>Sa Pa l&agrave; một điểm du lịch c&aacute;ch trung t&acirc;m th&agrave;nh phố L&agrave;o Cai khoảng hơn 30 km. Nằm ở độ cao trung b&igrave;nh 1500 &ndash; 1800 m so với mặt nước biển,&nbsp;<a href=\"https://dulichsapa.org.vn/diem-du-lich/thi-tran-sapa-lao-cai/\" target=\"_blank\" title=\"Thị trấn Sapa\">Thị Trấn Sapa</a>&nbsp;lu&ocirc;n ch&igrave;m trong l&agrave;n m&acirc;y bồng bềnh, tạo n&ecirc;n một bức tranh huyền ảo đẹp đến kỳ lạ. Nơi đ&acirc;y, c&oacute; thứ t&agrave;i nguy&ecirc;n v&ocirc; gi&aacute; đ&oacute; l&agrave; kh&iacute; hậu quanh năm trong l&agrave;nh m&aacute;t mẻ, với nhiệt độ trung b&igrave;nh 15-18&deg;C.</p>'),(3,'Hạ Long','Vịnh Hạ Long nơi rồng đáp xuống, là danh thắng quốc gia được xếp hạng từ năm 1962. Hạ Long có 1.969 hòn đảo, lô nhô trên mặt biển, nổi tiếng nhất là các hòn Lư Hương, Gà Chọi, Cánh Buồm, Mâm Xôi, đảo Ngọc Vừng, Ti Tốp, Tuần Châu. Hạ Long như bức tranh thủy mặc khổng lồ, tuyệt đẹp, xứng đáng là biểu tượng du lịch Việt Nam.','<h3>Tổng quan về du lịch Mộc <p>Vịnh Hạ Long &ndash; được Unesco nhiều lần c&ocirc;ng nhận l&agrave; di sản thi&ecirc;n nhi&ecirc;n của thế giới với h&agrave;ng ngh&igrave;n h&ograve;n đảo được l&agrave;m n&ecirc;n bởi tạo ho&aacute; kỳ vĩ v&agrave; sống động. Vịnh Hạ Long c&oacute; phong cảnh tuyệt đẹp n&ecirc;n nơi đ&acirc;y l&agrave; một điểm du lịch rất hấp dẫn với du kh&aacute;ch trong nước v&agrave; quốc tế.</p>'),(4,'Nhật Bản','Nhật Bản, xứ sở hoa anh đào, vẫn luôn là nơi thu hút rất nhiều khách du lịch trên thế giới. Đến Nhật Bản, bạn có thể ghé thăm những thành phố hiện đại, sầm uất như Tokyo, Yokohama hay tham quan những vùng đất đậm nét truyền thống, cổ kính như Kyoto, Nagoya; hoặc đắm mình giữa cảnh sắc thiên nhiên xinh đẹp của núi Phú Sĩ và các suối nước nóng ở Noboribetsu… Bên cạnh đó, bạn còn được thưởng thức những món ăn ngon, độc đáo của đất nước này và tham gia các lễ hội văn hóa đậm đà bản sắc dân tộc nơi đây.','<p>Được mệnh danh l&agrave; đất nước mặt trời mọc, Nhật Bản thực sự l&agrave; một trong những điểm du lịch cực k&igrave; nổi tiếng tr&ecirc;n to&agrave;n thế giới với những cảnh quan xinh đẹp v&agrave; nền văn h&oacute;a hấp dẫn. C&ugrave;ng&nbsp;<strong>VietAIR</strong>&nbsp;t&igrave;m hiểu du lịch Nhật qua b&agrave;i viết &ldquo;<strong>Giới thiệu chung về du lịch Nhật Bản</strong>&rdquo; dưới đ&acirc;y nh&eacute;.</p>'),(5,'Hy Lạp','Hy Lạp luôn là một điểm nổi tiếng của du khách khi đến Châu Âu. Với 53 vùng miền khác nhau, đất nước này mang đến cho du khách tham quan sự đa dạng lớn về địa điểm thú vị, văn hóa và lối sống sôi nổi. Hy Lạp có đến 1167 thành phố thú vị để cho bạn khám phá, ví dụ như Athens, Santorini, Mykonos.','<p>Hy Lạp nổi tiếng thế giới với nền văn minh cổ đại rực rỡ, truyền thuyết c&aacute;c vị thần tr&ecirc;n đỉnh Olympus. Tuy nhi&ecirc;n, đến Hy Lạp với&nbsp;<a href=\"https://www.vietnambooking.com/visa/dich-vu-lam-visa-di-hy-lap.html\"><strong><em>visa đi Hy Lạp</em></strong></a>&nbsp;c&ograve;n cho bạn cơ hội được rong chơi ở quần đảo Santorini xinh đẹp, chi&ecirc;m ngưỡng k&igrave; quan đền Parthenon hay lạc giữa m&acirc;y trời với quần thể tu viện Meteora cheo leo v&aacute;ch n&uacute;i.</p>');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
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
