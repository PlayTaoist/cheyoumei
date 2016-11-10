/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - cheyoumei
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cheyoumei` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cheyoumei`;

/*Table structure for table `carbrand` */

DROP TABLE IF EXISTS `carbrand`;

CREATE TABLE `carbrand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `logoUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `carbrand` */

insert  into `carbrand`(`id`,`brand`,`logoUrl`) values (1,'宝马','upload/images/carBrand/1/BMW.png'),(2,'奔驰','upload/images/carBrand/2/Mercedes.png'),(3,'大众','upload/images/carBrand/3/Volkswagen.png'),(4,'路虎','upload/images/carBrand/4/Land_Rover.png'),(5,'雷克萨斯','upload/images/carBrand/5/Lexus.png'),(6,'奇瑞','upload/images/carBrand/6/qirui.png'),(7,'奥迪','upload/images/carBrand/7/Audi.png'),(8,'标致','upload/images/carBrand/8/Peugeot.png'),(9,'福特','upload/images/carBrand/9/Ford.png'),(10,'本田','upload/images/carBrand/10/Honda.png'),(11,'现代','upload/images/carBrand/11/HYUNDAI.png'),(12,'别克','upload/images/carBrand/12/Buick.png'),(13,'雪佛兰','upload/images/carBrand/13/Chevrolet.png'),(14,'长安','upload/images/carBrand/14/changan.png'),(15,'比亚迪','upload/images/carBrand/15/biyadi.png'),(16,'长城','upload/images/carBrand/16/changcheng.png'),(17,'日产','upload/images/carBrand/17/Nisan.png'),(18,'马自达','upload/images/carBrand/18/Mazda.png'),(19,'保时捷','upload/images/carBrand/19/Porsche.png'),(20,'铃木','upload/images/carBrand/20/lingmu.png'),(21,'江淮','upload/images/carBrand/21/jianghuai.png'),(22,'雪铁龙','upload/images/carBrand/22/xuetielong.png'),(23,'吉普','upload/images/carBrand/23/Jeep.png'),(24,'吉利','upload/images/carBrand/24/jili.png'),(25,'五菱','upload/images/carBrand/25/wuling.png'),(26,'三菱','upload/images/carBrand/26/sanling.png'),(27,'兰博基尼','upload/images/carBrand/27/Lamborghini.png'),(28,'东风','upload/images/carBrand/28/fengshen.png'),(29,'凯迪拉克','upload/images/carBrand/29/Cadillac.png'),(30,'海马','upload/images/carBrand/30/haima.png'),(31,'宝骏','upload/images/carBrand/31/baojun.png'),(32,'斯柯达','upload/images/carBrand/32/Skoda.png'),(33,'玛莎拉蒂','upload/images/carBrand/33/Maserati.png'),(34,'法拉利','upload/images/carBrand/34/Ferrari.png'),(35,'众泰','upload/images/carBrand/35/zhongtai.png'),(36,'捷豹','upload/images/carBrand/36/Jaguar.png'),(37,'荣威','upload/images/carBrand/37/rongwei.png'),(38,'奔腾','upload/images/carBrand/38/benteng.png'),(39,'帝豪','upload/images/carBrand/39/dihao.png'),(40,'英菲尼迪','upload/images/carBrand/40/Infinity.png'),(41,'北汽','upload/images/carBrand/41/beiqi.png'),(42,'特斯拉','upload/images/carBrand/42/tesila.png'),(43,'纳智捷','upload/images/carBrand/43/nazhijie.png'),(44,'斯巴鲁','upload/images/carBrand/44/Subaru.png'),(45,'道奇','upload/images/carBrand/45/daoqi.png'),(46,'启辰','upload/images/carBrand/46/qichen.png'),(47,'宾利','upload/images/carBrand/47/Bentley.png'),(48,'阿斯顿·马丁','upload/images/carBrand/48/asiduanmading.png'),(49,'宝马迷你','upload/images/carBrand/49/baomamini.png'),(50,'布加迪','upload/images/carBrand/50/bujiadi.png'),(51,'丰田','upload/images/carBrand/51/fengtian.png'),(52,'广汽','upload/images/carBrand/52/guangqi.png'),(53,'雷诺','upload/images/carBrand/53/leinuo.png'),(54,'力帆','upload/images/carBrand/54/lifang.png'),(55,'起亚','upload/images/carBrand/55/qiya.png'),(56,'沃尔沃','upload/images/carBrand/56/woerwo.png'),(57,'菲亚特','upload/images/carBrand/57/feiyate.png'),(58,'中兴','upload/images/carBrand/58/zhongxing.png'),(59,'红旗','upload/images/carBrand/59/hongqi.png'),(60,'讴歌','upload/images/carBrand/60/ouge.png'),(61,'华普','upload/images/carBrand/61/huapu.png'),(62,'五十铃','upload/images/carBrand/62/wushiling.png'),(63,'金龙','upload/images/carBrand/63/jinlong.png'),(64,'劳斯莱斯','upload/images/carBrand/64/laosilaisi.png'),(65,'莲花','upload/images/carBrand/65/lianhua.png'),(66,'林肯','upload/images/carBrand/66/linken.png'),(67,'名爵','upload/images/carBrand/67/mg.png'),(68,'摩根','upload/images/carBrand/68/mogen.png'),(69,'欧宝','upload/images/carBrand/69/oubao.png'),(70,'smart','upload/images/carBrand/70/smart.png');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `rasePoint` int(11) NOT NULL DEFAULT '3',
  `remoteIp` varchar(255) DEFAULT NULL,
  `remoteMac` varchar(255) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `valid` tinyint(1) DEFAULT NULL,
  `goodsId_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nbgdho8152qjdc4hogd050eno` (`goodsId_id`),
  KEY `FK_jhvt6d9ap8gxv67ftrmshdfhj` (`user_id`),
  KEY `FK_7e1st09cnb2yellvivicys8l3` (`orders_id`),
  CONSTRAINT `FK_7e1st09cnb2yellvivicys8l3` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_jhvt6d9ap8gxv67ftrmshdfhj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_nbgdho8152qjdc4hogd050eno` FOREIGN KEY (`goodsId_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`createdAt`,`message`,`rasePoint`,`remoteIp`,`remoteMac`,`updatedAt`,`valid`,`goodsId_id`,`user_id`,`orders_id`) values (1,'2015-06-07 14:28:19','这个店不行，是真不行！',3,NULL,NULL,NULL,1,2,5,1),(2,'2015-06-16 08:47:40','真是太烂了',4,'0:0:0:0:0:0:0:1',NULL,NULL,0,2,2,2),(3,'2015-06-16 08:49:14','真是好啊啊',4,'0:0:0:0:0:0:0:1',NULL,NULL,0,3,3,3),(4,'2015-06-16 08:52:25','真是烂的稀巴烂啊！',4,'172.16.23.183',NULL,NULL,0,4,4,4),(5,'2015-06-16 08:59:13','iiiiiiiihe heheh',4,'172.16.23.230',NULL,NULL,0,4,4,5),(6,'2015-06-16 08:59:58','真是烂的稀巴烂啊！',4,'172.16.23.230',NULL,NULL,0,4,4,6),(7,'2015-06-16 14:52:36','烂烂烂烂烂烂烂烂烂',4,'0:0:0:0:0:0:0:1',NULL,NULL,0,2,2,7),(9,'2015-06-17 18:52:37','恢复然后黄花岗',4,'172.16.23.213',NULL,NULL,0,2,2,8),(10,'2015-06-17 18:54:43','好地方丰富多彩',3,'172.16.23.213',NULL,NULL,0,2,2,9),(11,'2015-06-18 18:55:26','提升规范VV',3,'172.16.23.44',NULL,NULL,0,2,2,NULL),(12,'2015-06-18 18:55:35','辅导班方法',2,'172.16.23.44',NULL,NULL,0,2,2,11),(13,'2015-06-18 18:59:47','广泛后果',3,'172.16.23.44',NULL,NULL,0,2,2,NULL),(14,'2015-06-18 22:08:06','这个已经评论过了',4,'0:0:0:0:0:0:0:1',NULL,NULL,0,2,2,NULL),(15,'2015-06-19 08:29:28','这个已经评论过了',4,'0:0:0:0:0:0:0:1',NULL,NULL,0,2,2,NULL);

/*Table structure for table `commentgallery` */

DROP TABLE IF EXISTS `commentgallery`;

CREATE TABLE `commentgallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actived` tinyint(1) NOT NULL,
  `cover` tinyint(1) NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jti6p1tmiqxipd06ebn0u5ub4` (`comment_id`),
  CONSTRAINT `FK_jti6p1tmiqxipd06ebn0u5ub4` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `commentgallery` */

/*Table structure for table `coupon` */

DROP TABLE IF EXISTS `coupon`;

CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `beforAt` datetime DEFAULT NULL,
  `couponCode` varchar(255) DEFAULT NULL,
  `isUsed` int(11) NOT NULL DEFAULT '1',
  `useAt` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ofp1mpbsm0oq422g8n5m7wio6` (`user_id`),
  CONSTRAINT `FK_ofp1mpbsm0oq422g8n5m7wio6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `coupon` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discPrice` double NOT NULL,
  `discount` double NOT NULL DEFAULT '1',
  `name` varchar(255) DEFAULT NULL,
  `origPrice` double NOT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `used` tinyint(1) NOT NULL DEFAULT '1',
  `goodsCat_id` int(11) DEFAULT NULL,
  `shopInfo_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `critical` tinyint(1) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_amxlb3e665fvsid7vudxya71o` (`goodsCat_id`),
  KEY `FK_8673x63pb6nqmpsp63v0kx9g6` (`shopInfo_id`),
  KEY `FK_aogggjcusncr7d9js8ov81952` (`user_id`),
  CONSTRAINT `FK_8673x63pb6nqmpsp63v0kx9g6` FOREIGN KEY (`shopInfo_id`) REFERENCES `shopinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_amxlb3e665fvsid7vudxya71o` FOREIGN KEY (`goodsCat_id`) REFERENCES `goodscat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_aogggjcusncr7d9js8ov81952` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`createdAt`,`description`,`discPrice`,`discount`,`name`,`origPrice`,`updatedAt`,`used`,`goodsCat_id`,`shopInfo_id`,`user_id`,`critical`,`type`) values (1,'2015-06-07 14:28:19','11111',11,1,'产品01',11,'2015-06-08 14:28:19',1,5,1,2,1,0),(2,'2015-06-07 14:28:19','22222',22,1,'产品02',22,'2015-06-08 14:28:19',1,5,2,2,1,0),(3,'2015-06-07 14:28:19','33333',33,1,'产品03',33,'2015-06-08 14:28:19',1,6,2,2,1,0),(4,'2015-06-07 14:28:19','44444',44,1,'产品04',44,'2015-06-08 14:28:19',1,6,3,2,1,0),(5,'2015-06-07 14:28:19','55555',55,1,'产品05',55,'2015-06-08 14:28:19',1,1,3,2,1,0),(6,'2015-06-07 14:28:19','66666',66,1,'产品06',66,'2015-06-08 14:28:19',1,1,4,2,1,0),(7,'2015-06-07 14:28:19','77777',77,1,'产品07',77,'2015-06-08 14:28:19',1,2,4,2,1,0),(8,'2015-06-07 14:28:19','88888',88,1,'产品08',88,'2015-06-08 14:28:19',1,2,5,2,0,0),(9,'2015-06-07 14:28:19','99999',99,1,'产品09',99,'2015-06-08 14:28:19',1,6,5,2,1,0),(10,'2015-06-07 14:28:19','10000',100,1,'产品10',100,'2015-06-08 14:28:19',1,5,10,3,0,0),(11,'2015-06-07 14:28:19','99999',99,1,'产品11',23,'2015-06-08 14:28:19',1,6,10,3,1,0),(12,'2015-06-07 14:28:19','2123',88,1,'产品12',88,'2015-06-08 14:28:19',1,2,10,4,0,0),(13,'2015-06-07 14:28:19','test',34,1,'产品13',5,'2015-06-08 14:28:19',1,3,6,2,0,0),(14,'2015-06-07 14:28:19','test',32,1,'产品14',4,'2015-06-08 14:28:19',1,6,6,5,1,0);

/*Table structure for table `goodscat` */

DROP TABLE IF EXISTS `goodscat`;

CREATE TABLE `goodscat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `displayorder` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `goodscat` */

insert  into `goodscat`(`id`,`displayorder`,`title`,`parent_id`,`level`) values (1,0,'洗车',1,0),(2,0,'汽车美容类',2,0),(3,1,'车表护理',2,1),(4,0,'汽车装饰类',3,0),(5,1,'普通洗车',1,1),(6,2,'精致洗车',1,1),(7,2,'漆面美容',2,1),(8,1,'外部装饰',3,1),(9,2,'内部装饰',3,1),(10,1,'汽车贴膜类',10,0),(11,0,'汽车养护类',11,0),(12,1,'常规养护',11,1),(13,2,'高级养护',11,1),(14,0,'汽车改装',14,0),(15,1,'外观改装',14,1),(16,2,'性能提升',14,1);

/*Table structure for table `goodscatrel` */

DROP TABLE IF EXISTS `goodscatrel`;

CREATE TABLE `goodscatrel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `child_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ah0hptid04m4w873as6q4n28i` (`child_id`),
  KEY `FK_8llj8ndq3q0mg3wn42q850c72` (`parent_id`),
  CONSTRAINT `FK_8llj8ndq3q0mg3wn42q850c72` FOREIGN KEY (`parent_id`) REFERENCES `goodscat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ah0hptid04m4w873as6q4n28i` FOREIGN KEY (`child_id`) REFERENCES `goodscat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `goodscatrel` */

insert  into `goodscatrel`(`id`,`level`,`child_id`,`parent_id`) values (1,0,1,1),(2,1,5,1),(3,1,5,5),(4,1,6,1),(5,1,6,6),(6,0,2,2),(7,1,3,2),(8,1,3,3),(9,1,7,2),(10,1,7,7),(11,0,4,4),(12,1,8,4),(13,1,8,8),(14,1,9,4),(15,1,9,9);

/*Table structure for table `goodsgallery` */

DROP TABLE IF EXISTS `goodsgallery`;

CREATE TABLE `goodsgallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actived` tinyint(1) NOT NULL,
  `cover` tinyint(1) NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4nwnd0t32a7c1np9r0kbeb8bh` (`goods_id`),
  KEY `FK_4vug9nn4agfysretpp2n00owe` (`user_id`),
  CONSTRAINT `FK_4nwnd0t32a7c1np9r0kbeb8bh` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_4vug9nn4agfysretpp2n00owe` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsgallery` */

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `rank` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountRecv` double NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `couponCode` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `customerConfirm` tinyint(1) NOT NULL DEFAULT '0',
  `discount` double NOT NULL DEFAULT '1',
  `fromAccount` varchar(255) DEFAULT NULL,
  `orderCode` varchar(255) DEFAULT NULL,
  `orderStatus` int(11) NOT NULL,
  `payAt` datetime DEFAULT NULL,
  `payStatus` int(11) NOT NULL,
  `point` int(11) NOT NULL,
  `scheduleAt` datetime DEFAULT NULL,
  `servicedAt` datetime DEFAULT NULL,
  `shopConfirm` tinyint(1) NOT NULL DEFAULT '0',
  `totalRecv` double NOT NULL,
  `totalReturn` double NOT NULL,
  `tradeNum` varchar(255) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `paymentForm_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `userByUpdatedBy_id` int(11) NOT NULL DEFAULT '1',
  `serverType` int(11) NOT NULL,
  `shopName` varchar(255) DEFAULT NULL,
  `serviceName` varchar(255) DEFAULT NULL,
  `shopGalleryUrl` varchar(255) DEFAULT NULL,
  `iscomment` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_hi1sbt52iwcwwk2g3bck4hekx` (`customer_id`),
  KEY `FK_7odqjwxqh1x288woldba7cpm5` (`goods_id`),
  KEY `FK_kdsoexg7a0i3jiyrcc3d5vfbu` (`paymentForm_id`),
  KEY `FK_sq9sh3hkav8u5ujm48o489ng4` (`seller_id`),
  KEY `FK_ne5gxvmvsrl86j59dkqii86jd` (`userByUpdatedBy_id`),
  CONSTRAINT `FK_7odqjwxqh1x288woldba7cpm5` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_hi1sbt52iwcwwk2g3bck4hekx` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_kdsoexg7a0i3jiyrcc3d5vfbu` FOREIGN KEY (`paymentForm_id`) REFERENCES `paymentform` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ne5gxvmvsrl86j59dkqii86jd` FOREIGN KEY (`userByUpdatedBy_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_sq9sh3hkav8u5ujm48o489ng4` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`accountRecv`,`address`,`couponCode`,`createdAt`,`customerConfirm`,`discount`,`fromAccount`,`orderCode`,`orderStatus`,`payAt`,`payStatus`,`point`,`scheduleAt`,`servicedAt`,`shopConfirm`,`totalRecv`,`totalReturn`,`tradeNum`,`updatedAt`,`customer_id`,`goods_id`,`paymentForm_id`,`seller_id`,`userByUpdatedBy_id`,`serverType`,`shopName`,`serviceName`,`shopGalleryUrl`,`iscomment`) values (1,100,'海南省海口市中兴路231号','1',NULL,1,1,'3939939@qq.com','201506111535',7,NULL,1,22,NULL,'2015-06-18 18:55:16',1,100,0,'201506111535','2015-06-18 18:55:16',2,2,6,2,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(2,67,'海口省海口市龙华区山高小学二年级一班','1',NULL,1,1,'434234234qq.com','201506111542',7,NULL,1,32,NULL,'2015-06-18 18:54:59',1,67,0,'201506111542','2015-06-18 18:54:59',2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(3,0,NULL,NULL,'2015-06-13 12:29:38',0,0,NULL,'20150613000006',0,NULL,0,1,NULL,'2015-06-13 12:29:38',0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(4,0,NULL,NULL,'2015-06-13 12:53:36',0,0,NULL,'20150613000017',0,NULL,0,1,NULL,'2015-06-13 12:29:38',0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(5,22,NULL,NULL,'2015-06-13 12:54:53',0,0,NULL,'20150613000018',0,NULL,0,1,NULL,'2015-06-13 12:29:38',0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(6,22,NULL,NULL,'2015-06-15 09:19:34',0,0,NULL,'20150615000001',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(7,22,NULL,NULL,'2015-06-15 09:43:41',0,0,NULL,'20150615000002',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(8,22,NULL,NULL,'2015-06-15 10:33:40',0,0,NULL,'20150615000007',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(9,22,NULL,NULL,'2015-06-15 10:35:00',0,0,NULL,'20150615000008',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(10,22,NULL,NULL,'2015-06-15 10:36:28',0,0,NULL,'20150615000009',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(11,22,NULL,NULL,'2015-06-15 10:42:22',0,0,NULL,'20150615000010',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',1),(12,22,NULL,NULL,'2015-06-15 10:42:52',0,0,NULL,'20150615000011',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(13,22,NULL,NULL,'2015-06-15 10:45:46',0,0,NULL,'20150615000012',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(14,22,NULL,NULL,'2015-06-15 10:45:57',0,0,NULL,'20150615000013',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(15,22,NULL,NULL,'2015-06-15 10:50:08',0,0,NULL,'20150615000015',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(16,22,NULL,NULL,'2015-06-15 10:46:24',0,0,NULL,'20150615000014',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(21,22,NULL,NULL,'2015-06-15 11:48:13',0,0,NULL,'20150615000016',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(22,22,NULL,NULL,'2015-06-15 11:48:15',0,0,NULL,'20150615000017',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(23,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-15 16:53:41',0,0,NULL,'20150615000018',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(24,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:05:50',0,0,NULL,'20150616000001',7,NULL,0,1,NULL,'2015-06-18 23:12:11',0,0,0,NULL,'2015-06-18 23:12:11',2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(25,33,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:09:15',0,0,NULL,'20150616000002',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,3,6,4,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(26,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:15:02',0,0,NULL,'20150616000003',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(27,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:22:07',0,0,NULL,'20150616000004',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(28,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:22:47',0,0,NULL,'20150616000005',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,2,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(29,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:23:59',0,0,NULL,'20150616000006',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(30,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:27:39',0,0,NULL,'20150616000007',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(31,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-16 16:31:44',0,0,NULL,'20150616000008',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(32,11,'海南省海口市龙华区府城镇凤翔路321号',NULL,'2015-06-16 18:03:59',0,0,NULL,'20150616000009',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,1,6,1,1,0,'车信达洗车店1','产品01','image/url/log1.png',0),(33,11,'海南省海口市龙华区府城镇凤翔路321号',NULL,'2015-06-17 16:10:41',0,0,NULL,'20150617000001',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,13,1,6,1,1,0,'车信达洗车店1','产品01','image/url/log1.png',0),(36,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-17 19:00:57',0,0,NULL,'20150617000004',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品01','image/url/log1.png',0),(37,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-18 15:54:52',0,0,NULL,'20150618000002',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品02','image/url/log2.png',0),(38,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-18 22:53:33',0,0,NULL,'20150618000003',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品02','image/url/log2.png',0),(39,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-18 22:55:26',0,0,NULL,'20150618000004',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,-1,'车信达洗车店2','产品02','image/url/log2.png',0),(40,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-18 22:56:47',0,0,NULL,'20150618000005',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,-1,'车信达洗车店2','产品02','image/url/log2.png',0),(41,22,'海南省海口市美兰区府城镇凤翔路322号',NULL,'2015-06-18 23:05:13',0,0,NULL,'20150618000006',0,NULL,0,1,NULL,NULL,0,0,0,NULL,NULL,2,2,6,3,1,0,'车信达洗车店2','产品02','image/url/log2.png',0);

/*Table structure for table `paymentform` */

DROP TABLE IF EXISTS `paymentform`;

CREATE TABLE `paymentform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `form` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `paymentform` */

insert  into `paymentform`(`id`,`description`,`form`) values (1,'支付宝支付','支付宝'),(2,'微信支付','微信'),(3,'银联支付','银联'),(4,'平台余额宝','余额宝'),(5,'代金券','代金券'),(6,'未选择','未选择');

/*Table structure for table `phonecode` */

DROP TABLE IF EXISTS `phonecode`;

CREATE TABLE `phonecode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beforeAt` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `mobliePhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `phonecode` */

insert  into `phonecode`(`id`,`beforeAt`,`code`,`createdAt`,`mobliePhone`) values (1,'2015-06-07 14:28:19','8515','2015-06-07 14:26:19','18789018987'),(2,'2015-06-08 17:23:34','6102','2015-06-08 17:21:34','18689876160'),(3,'2015-06-11 09:03:50','8074','2015-06-11 09:01:50','22222222222'),(4,'2015-06-11 10:27:48','4502','2015-06-11 10:25:48','13036092110'),(5,'2015-06-17 11:40:55','5476','2015-06-17 11:38:55','11111111111'),(6,'2015-06-15 14:28:43','8706','2015-06-15 14:26:43','18089785333'),(7,'2015-06-18 14:57:23','8333','2015-06-18 14:55:23','2222222'),(8,'2015-06-18 17:32:41','9497','2015-06-18 17:30:41','13076922820');

/*Table structure for table `promotion` */

DROP TABLE IF EXISTS `promotion`;

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `awardType` int(11) NOT NULL,
  `awardValue` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endAt` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `requirement` int(11) NOT NULL,
  `startAt` datetime DEFAULT NULL,
  `type` int(11) NOT NULL,
  `used` bit(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2ec1g6q6mi7w4clckcfchcdfv` (`user_id`),
  CONSTRAINT `FK_2ec1g6q6mi7w4clckcfchcdfv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `promotion` */

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `resourceType` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `expanded` bit(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  `leaf` bit(1) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `resource` */

insert  into `resource`(`resourceType`,`id`,`description`,`name`,`url`,`expanded`,`icon`,`ids`,`leaf`,`text`) values ('resource',1,'首页','管理首页','/manager/main',NULL,NULL,NULL,NULL,NULL),('resource',2,'获取菜单','获取菜单','/manager/getMenu',NULL,NULL,NULL,NULL,NULL),('resource',3,'用户设置','用户设置','/manager/systemManage/userSetting',NULL,NULL,NULL,NULL,NULL),('resource',4,'角色管理','角色管理','/manager/systemManage/roleManage',NULL,NULL,NULL,NULL,NULL),('resource',5,'获取角色列表','获取角色列表','/manager/systemManage/roleManage/getRoleList',NULL,NULL,NULL,NULL,NULL),('resource',6,'获取对应角色的资源列表','资源选择列表','/manager/systemManage/roleManage/getResourceListByRoleId',NULL,NULL,NULL,NULL,NULL),('resource',7,'增加角色','自定义角色','/manager/systemManage/roleManage/addRole',NULL,NULL,NULL,NULL,NULL),('resource',8,'删除角色','删除角色','/manager/systemManage/roleManage/deleteRole',NULL,NULL,NULL,NULL,NULL),('resource',9,'编辑角色','编辑角色','/manager/systemManage/roleManage/editRole',NULL,NULL,NULL,NULL,NULL),('resource',10,'资源管理','资源管理','/manager/systemManage/resourceManage',NULL,NULL,NULL,NULL,NULL),('resource',11,'获取资源列表','获取资源列表','/manager/systemManage/resourceManage/getResourceList',NULL,NULL,NULL,NULL,NULL),('resource',12,'增加资源','增加资源','/manager/systemManage/resourceManage/addResource',NULL,NULL,NULL,NULL,NULL),('resource',29,'删除资源','删除资源','/manager/systemManage/resourceManage/deleteResource',NULL,NULL,NULL,NULL,NULL),('resource',30,'编辑资源','编辑资源','/manager/systemManage/resourceManage/editResource',NULL,NULL,NULL,NULL,NULL),('resource',34,'111','用户管理','/manager/systemManage/userManage',NULL,NULL,NULL,NULL,NULL),('resource',35,'获取用户列表','获取用户列表','/manager/systemManage/userManage/getUserList',NULL,NULL,NULL,NULL,NULL),('resource',36,'在添加用户和修改用户中，用于获取角色列表数据的权限','角色选择列表','/manager/systemManage/userManage/getRoleListByUserId',NULL,NULL,NULL,NULL,NULL),('resource',37,'xxx','xxx','xxx',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `resource_resource` */

DROP TABLE IF EXISTS `resource_resource`;

CREATE TABLE `resource_resource` (
  `Resource_id` int(11) NOT NULL,
  `childMenu_id` int(11) NOT NULL,
  PRIMARY KEY (`Resource_id`,`childMenu_id`),
  UNIQUE KEY `UK_gvxtgui70uctg83m2stl8m9sr` (`childMenu_id`),
  CONSTRAINT `FK_damhc64svytqjyej71042k2bb` FOREIGN KEY (`Resource_id`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_gvxtgui70uctg83m2stl8m9sr` FOREIGN KEY (`childMenu_id`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resource_resource` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`description`,`name`) values (1,'具备系统所有权限','超级管理员'),(2,'对系统账户权限进行管理','用户管理员'),(3,'对日志信息进行查看和管理','审计管理员'),(4,'对系统的策略进行配置','配置管理员'),(5,'普通商户','商户'),(6,'普通用户','普通用户');

/*Table structure for table `role_resource` */

DROP TABLE IF EXISTS `role_resource`;

CREATE TABLE `role_resource` (
  `roles_id` int(11) NOT NULL,
  `resources_id` int(11) NOT NULL,
  PRIMARY KEY (`roles_id`,`resources_id`),
  KEY `FK_sei0loik16omfy5nb9a9xb4g9` (`resources_id`),
  CONSTRAINT `FK_bpymxk56qo3f1x74otc9w2dal` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_sei0loik16omfy5nb9a9xb4g9` FOREIGN KEY (`resources_id`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_resource` */

insert  into `role_resource`(`roles_id`,`resources_id`) values (1,1),(2,1),(3,1),(4,1),(5,1),(1,2),(2,2),(3,2),(4,2),(5,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,29),(1,30),(1,34),(1,35),(6,35),(1,36);

/*Table structure for table `shopgallery` */

DROP TABLE IF EXISTS `shopgallery`;

CREATE TABLE `shopgallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actived` tinyint(1) NOT NULL DEFAULT '1',
  `cover` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` date DEFAULT NULL,
  `license` tinyint(1) NOT NULL DEFAULT '0',
  `updatedAt` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `shopInfo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_50f0mxnnoi6dpg6g26kapdycl` (`shopInfo_id`),
  CONSTRAINT `FK_50f0mxnnoi6dpg6g26kapdycl` FOREIGN KEY (`shopInfo_id`) REFERENCES `shopinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `shopgallery` */

insert  into `shopgallery`(`id`,`actived`,`cover`,`createdAt`,`license`,`updatedAt`,`url`,`shopInfo_id`) values (1,1,1,'2015-06-07',0,NULL,'image/url/log1.png',1),(2,1,1,'2015-06-07',0,NULL,'image/url/log2.png',2),(3,1,1,'2015-06-07',0,NULL,'image/url/log3.png',3),(4,1,1,'2015-06-07',0,NULL,'image/url/log4.png',4),(5,1,1,'2015-06-07',0,NULL,'image/url/log5.png',5),(6,1,1,'2015-06-07',0,NULL,'image/url/log6.png',6),(7,1,1,'2015-06-07',0,NULL,'image/url/log7.png',7),(8,1,1,'2015-06-07',0,NULL,'image/url/log8.png',8),(9,1,1,'2015-06-07',0,NULL,'image/url/log9.png',9),(10,1,1,'2015-06-07',0,NULL,'image/url/log10.png',10);

/*Table structure for table `shopinfo` */

DROP TABLE IF EXISTS `shopinfo`;

CREATE TABLE `shopinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `raseCount` int(11) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `totalRase` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shopName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_67u9ha6cfjm9vrxn5scfhr46w` (`user_id`),
  CONSTRAINT `FK_67u9ha6cfjm9vrxn5scfhr46w` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `shopinfo` */

insert  into `shopinfo`(`id`,`addr`,`area`,`city`,`county`,`detail`,`province`,`raseCount`,`street`,`totalRase`,`type`,`user_id`,`shopName`) values (1,'海南省海口市龙华区府城镇凤翔路321号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路321号',1,1,2,'车信达洗车店1'),(2,'海南省海口市美兰区府城镇凤翔路322号','美兰区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路322号',1,1,3,'车信达洗车店2'),(3,'海南省海口市龙华区府城镇凤翔路323号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路323号',1,1,4,'车信达洗车店3'),(4,'海南省海口市琼山区府城镇凤翔路324号','琼山区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路324号',1,1,5,'车信达洗车店4'),(5,'海南省海口市龙华区府城镇凤翔路325号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路325号',1,1,6,'车信达洗车店5'),(6,'海南省海口市秀英区府城镇凤翔路326号','秀英区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路326号',1,1,7,'车信达洗车店6'),(7,'海南省海口市龙华区府城镇凤翔路327号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路327号',1,1,8,'车信达洗车店7'),(8,'海南省海口市龙华区府城镇凤翔路328号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路328号',1,1,9,'车信达洗车店8'),(9,'海南省海口市龙华区府城镇凤翔路329号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路329号',1,1,10,'车信达洗车店9'),(10,'海南省海口市龙华区府城镇凤翔路330号','龙华区','海口市',NULL,NULL,'海南省',1,'府城镇凤翔路330号',1,1,2,'车信达洗车店10'),(11,'海口市秀英区博爱街道1号','秀英区','海口市','NULL','NULL','海南省',1,'博爱街道1号',1,1,2,'车优美洗车店1'),(12,'海南省海口市美兰区白龙街道5号','美兰区','海口市','NULL','NULL','海南省',1,'白龙街道5号',1,1,3,'车优美洗车店2'),(13,'海南省海口市琼山区国兴街道7号','琼山区','海口市','NULL','NULL','海南省',1,'国兴街道7号',1,1,4,'车优美洗车店3'),(14,'海南省海口市龙华区蓝天街道22号','龙华区','海口市','NULL','NULL','海南省',1,'蓝天街道22号',1,1,5,'车优美洗车店4'),(15,'海南省海口市秀英区海府街道67号','秀英区','海口市','NULL','NULL','海南省',1,'海府街道67号',1,1,6,'车优美洗车店5'),(16,'海南省海口市美兰区白沙街道34号','美兰区','海口市','NULL','NULL','海南省',1,'白沙街道34号',1,1,7,'车优美洗车店6'),(17,'海南省海口市琼山区海甸街道21号','琼山区','海口市','NULL','NULL','海南省',1,'海甸街道21号',1,1,8,'车优美洗车店7'),(18,'海南省海口市龙华区人民街道43号','龙华区','海口市','NULL','NULL','海南省',1,'人民街道43号',1,1,9,'车优美洗车店8'),(19,'海南省海口市秀英区和平南街道333号','秀英区','海口市','NULL','NULL','海南省',1,'和平南街道333号',1,1,10,'车优美洗车店9'),(20,'海南省海口市美兰区中山街道80号','美兰区','海口市','NULL','NULL','海南省',1,'中山街道80号',1,1,2,'车优美洗车店10'),(21,'海南省海口市琼山区大同街道81号','琼山区','海口市','NULL','NULL','海南省',1,'大同街道81号',1,1,13,'车优美洗车店11'),(22,'海南省海口市龙华区金贸街道73号','龙华区','海口市','NULL','NULL','海南省',1,'金贸街道73号',1,1,14,'车优美洗车店12'),(23,'海南省海口市秀英区海垦街道23号','秀英区','海口市','NULL','NULL','海南省',1,'海垦街道23号',1,1,15,'车优美洗车店13'),(24,'海南省海口市美兰区滨海街道44号','美兰区','海口市','NULL','NULL','海南省',1,'滨海街道44号',1,1,16,'车优美洗车店14'),(25,'海南省海口市琼山区金宇街道1号','琼山区','海口市','NULL','NULL','海南省',1,'金宇街道1号',1,1,17,'车优美洗车店15'),(26,'海南省海口市龙华区秀英街道5号','龙华区','海口市','NULL','NULL','海南省',1,'秀英街道5号',1,1,18,'车优美洗车店16'),(27,'海南省海口市美兰区海秀街道7号','美兰区','海口市','NULL','NULL','海南省',1,'海秀街道7号',1,1,19,'车优美洗车店17'),(28,'海南省海口市琼山区新埠街道22号','琼山区','海口市','NULL','NULL','海南省',1,'新埠街道22号',1,1,20,'车优美洗车店18'),(29,'海南省海口市琼山区博爱街道67号','琼山区','海口市','NULL','NULL','海南省',1,'博爱街道67号',1,1,21,'车优美洗车店19'),(30,'海南省海口市龙华区白龙街道34号','龙华区','海口市','NULL','NULL','海南省',1,'白龙街道34号',1,1,22,'车优美洗车店20');

/*Table structure for table `shopusrmoreinfo` */

DROP TABLE IF EXISTS `shopusrmoreinfo`;

CREATE TABLE `shopusrmoreinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avgArea` double NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `createdBy` int(11) NOT NULL,
  `hasCarPort` tinyint(1) DEFAULT NULL,
  `hasResting` tinyint(1) DEFAULT NULL,
  `moreInfo` varchar(255) DEFAULT NULL,
  `shopCat` int(11) DEFAULT '1',
  `shopCounts` int(11) NOT NULL,
  `workerCount` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `recommended` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_606ov1oh86e3dmty2pdr8a2yw` (`user_id`),
  CONSTRAINT `FK_606ov1oh86e3dmty2pdr8a2yw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `shopusrmoreinfo` */

insert  into `shopusrmoreinfo`(`id`,`avgArea`,`createdAt`,`createdBy`,`hasCarPort`,`hasResting`,`moreInfo`,`shopCat`,`shopCounts`,`workerCount`,`user_id`,`recommended`) values (1,23,'2015-06-09 00:00:00',1,0,0,'testq',1,1,4,2,0),(2,24,'2015-06-09 00:00:00',1,1,0,'nice shop!003',1,1,5,3,0),(3,25,'2015-06-09 00:00:00',1,1,1,'nice shop!004',1,1,6,4,0),(4,26,'2015-06-09 00:00:00',1,1,1,'nice shop!005',1,1,7,5,0),(5,27,'2015-06-09 00:00:00',1,1,0,'nice shop!006',1,1,8,6,0),(6,28,'2015-06-09 00:00:00',1,1,1,'nice shop!007',1,1,9,7,0),(7,29,'2015-06-09 00:00:00',1,1,1,'nice shop!008',1,1,10,8,0),(8,30,'2015-06-09 00:00:00',1,0,1,'nice shop!009',1,1,11,9,0),(9,31,'2015-06-09 00:00:00',1,1,1,'nice shop!010',1,1,5,10,0),(10,32,'2015-06-09 00:00:00',1,1,0,'nice shop!011',1,1,6,13,0),(11,33,'2015-06-09 00:00:00',1,1,1,'nice shop!012',1,1,7,14,0),(12,34,'2015-06-09 00:00:00',1,0,1,'nice shop!013',1,1,8,15,0),(13,35,'2015-06-09 00:00:00',1,1,1,'nice shop!014',1,1,6,16,0),(14,36,'2015-06-09 00:00:00',1,1,1,'nice shop!015',1,1,7,17,0),(15,37,'2015-06-09 00:00:00',1,1,1,'nice shop!016',1,1,8,18,0),(16,38,'2015-06-09 00:00:00',1,1,1,'nice shop!017',1,1,9,19,0),(17,39,'2015-06-09 00:00:00',1,1,1,'nice shop!018',1,1,10,20,0),(18,40,'2015-06-09 00:00:00',1,1,1,'nice shop!019',1,1,11,21,0),(19,41,'2015-06-09 00:00:00',1,1,1,'nice shop!020',1,1,12,22,0),(20,42,'2015-06-09 00:00:00',1,1,1,'nice shop!021',1,1,13,23,0),(21,43,'2015-06-09 00:00:00',1,1,1,'nice shop!022',1,1,14,24,0),(22,44,'2015-06-09 00:00:00',1,1,1,'nice shop!023',1,1,15,25,0),(23,45,'2015-06-09 00:00:00',1,1,1,'nice shop!024',1,1,16,26,0),(24,46,'2015-06-09 00:00:00',1,1,1,'nice shop!025',1,1,17,27,0),(25,47,'2015-06-09 00:00:00',1,1,1,'nice shop!026',1,1,18,28,0),(26,48,'2015-06-09 00:00:00',1,1,1,'nice shop!027',1,1,19,29,0),(27,49,'2015-06-09 00:00:00',1,1,1,'nice shop!028',1,1,20,30,0),(28,50,'2015-06-09 00:00:00',1,1,1,'nice shop!029',1,1,21,31,0),(29,51,'2015-06-09 00:00:00',1,1,1,'nice shop!030',1,1,22,32,0),(30,52,'2015-06-09 00:00:00',1,1,1,'nice shop!031',1,1,23,33,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actived` tinyint(1) NOT NULL DEFAULT '1',
  `addr` varchar(255) DEFAULT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `createdAt` datetime DEFAULT NULL,
  `deletedAt` datetime DEFAULT NULL,
  `deletedByUserId` int(11) NOT NULL DEFAULT '0',
  `firm` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `isdeleted` tinyint(1) NOT NULL DEFAULT '0',
  `lastLogin` datetime DEFAULT NULL,
  `loginPwd` varchar(255) DEFAULT NULL,
  `logoUrl` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `online` tinyint(1) NOT NULL DEFAULT '0',
  `payPwd` varchar(255) DEFAULT NULL,
  `point` int(11) NOT NULL DEFAULT '0',
  `raseCount` int(11) NOT NULL DEFAULT '0',
  `totalRase` int(11) NOT NULL DEFAULT '0',
  `userName` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fe6nqh4mlcjr068gcfrstmh2y` (`role_id`),
  CONSTRAINT `FK_fe6nqh4mlcjr068gcfrstmh2y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`actived`,`addr`,`balance`,`createdAt`,`deletedAt`,`deletedByUserId`,`firm`,`gender`,`isdeleted`,`lastLogin`,`loginPwd`,`logoUrl`,`mobilePhone`,`online`,`payPwd`,`point`,`raseCount`,`totalRase`,`userName`,`role_id`) values (1,1,'海南省海口市龙华区府城镇凤翔路320号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',1,'心蓝t透美妆精品屋','男',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18789018987',0,'123456',1,1,1,'admin',1),(2,1,'海南省海口市龙华区府城镇凤翔路321号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'新疆美味特产店','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','imge/2/logo.png','2222222',0,'123456',0,2,0,'username1',5),(3,1,'海南省海口市美兰区区府城镇凤翔路322号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'依人怡慧','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/3/logo.png','3333333',0,'123456',0,3,0,'username2',5),(4,1,'海南省海口市琼山区府城镇凤翔路323号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'广东商铺','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/4/logo.png','4444444',0,'123456',0,4,0,'username3',5),(5,1,'海南省海口市秀英区府城镇凤翔路324号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'海南商铺','女',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/5/logo.png','5555555',0,'123456',0,0,0,'username4',5),(6,1,'海南省海口市秀英区府城镇凤翔路325号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'广东商铺','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/6/logo.png','6666666',0,'123456',0,0,0,'username5',5),(7,1,'海南省海口市龙华区府城镇凤翔路326号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'上海快速','女',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/7/logo.png','7777777',0,'123456',0,0,0,'username6',5),(8,1,'海南省海口市琼山区府城镇凤翔路327号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'香港旺角','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/8/logo.png','8888888',0,'123456',0,0,0,'username7',5),(9,1,'海南省海口市龙华区府城镇凤翔路328号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'澳门大街','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/9/logo.png','9999999',0,'123456',0,0,0,'username8',5),(10,1,'海南省海口市美兰区府城镇凤翔路329号',1,'2015-06-07 14:28:19','2015-06-12 14:30:19',0,'广东商铺','男',0,'2015-06-07 14:30:19','1qaz2wsx3edc','image/10/logo.png','1000000',0,'123456',0,0,0,'username9',5),(13,1,'海南省海口市美兰区区府城镇凤翔路322号',0,'2015-06-08 17:21:40','2015-06-12 14:30:19',0,'心蓝t透美妆精品屋','男',1,'2015-06-08 17:21:40','18689876160','/images/users/logo/nologo.gif','18689876160',0,'18689876160',0,0,0,'18689876160',5),(14,1,'海口市秀英区博爱街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876160',0,'123456',1,1,1,'username15',5),(15,1,'海口市美兰区白龙街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876161',0,'123456',1,1,1,'username16',5),(16,1,'海口市琼山区国兴街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南融光商标代理有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876162',0,'123456',1,1,1,'username17',5),(17,1,'海口市龙华区蓝天街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海大源职业培训中心','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876163',0,'123456',1,1,1,'username18',5),(18,1,'海口市秀英区海府街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口格林豪泰国贸商务酒店','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876164',0,'123456',1,1,1,'username19',5),(19,1,'海口市美兰区白沙街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典传媒','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876165',0,'123456',1,1,1,'username20',5),(20,1,'海口市琼山区海甸街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876166',0,'123456',1,1,1,'username21',5),(21,1,'海口市龙华区人民街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南创艺无忧文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876167',0,'123456',1,1,1,'username22',5),(22,1,'海口市秀英区和平南街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南方能投资顾问有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876168',0,'123456',1,1,1,'username23',5),(23,1,'海口市美兰区中山街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南德狼科技有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876169',0,'123456',1,1,1,'username24',5),(24,1,'海口市琼山区大同街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南普讯信息科技有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876170',0,'123456',1,1,1,'username25',5),(25,1,'海口市龙华区金贸街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南我房装饰工程有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876171',0,'123456',1,1,1,'username26',5),(26,1,'海口市秀英区海垦街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口琼山梦依人家具维修店','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876172',0,'123456',1,1,1,'username27',5),(27,1,'海口市美兰区滨海街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南创艺无忧文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876173',0,'123456',1,1,1,'username28',5),(28,1,'海口市琼山区金宇街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南本岛知识产权服务有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876174',0,'123456',1,1,1,'username29',5),(29,1,'海口市龙华区秀英街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口龙华老乡搬家服务中心','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876175',0,'123456',1,1,1,'username30',5),(30,1,'海口市美兰区海秀街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876176',0,'123456',1,1,1,'username31',5),(31,1,'海口市琼山区新埠街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876177',0,'123456',1,1,1,'username32',5),(32,1,'海口市琼山区博爱街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南融光商标代理有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876178',0,'123456',1,1,1,'username33',5),(33,1,'海口市龙华区白龙街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海大源职业培训中心','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876179',0,'123456',1,1,1,'username34',5),(34,1,'海口市秀英区国兴街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口格林豪泰国贸商务酒店','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876180',0,'123456',1,1,1,'username35',5),(35,1,'海口市美兰区蓝天街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典传媒','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876181',0,'123456',1,1,1,'username36',5),(36,1,'海口市琼山区海府街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876182',0,'123456',1,1,1,'username37',5),(37,1,'海口市龙华区白沙街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南创艺无忧文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876183',0,'123456',1,1,1,'username38',5),(38,1,'海口市秀英区海甸街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南方能投资顾问有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876184',0,'123456',1,1,1,'username39',5),(39,1,'海口市美兰区人民街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南德狼科技有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876185',0,'123456',1,1,1,'username40',5),(40,1,'海口市琼山区和平南街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南普讯信息科技有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876186',0,'123456',1,1,1,'username41',5),(41,1,'海口市龙华区中山街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南我房装饰工程有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876187',0,'123456',1,1,1,'username42',5),(42,1,'海口市秀英区大同街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口琼山梦依人家具维修店','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876188',0,'123456',1,1,1,'username43',5),(43,1,'海口市美兰区金贸街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南创艺无忧文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876189',0,'123456',1,1,1,'username44',5),(44,1,'海口市琼山区海垦街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南本岛知识产权服务有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876190',0,'123456',1,1,1,'username45',5),(45,1,'海口市龙华区滨海街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口龙华老乡搬家服务中心','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876191',0,'123456',1,1,1,'username46',5),(46,1,'海口市美兰区金宇街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876192',0,'123456',1,1,1,'username47',5),(47,1,'海口市琼山区秀英街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海口华庭盛典文化传媒有限公司','女',0,'2015-06-07 14:30:19','111111','image/1/logo.png','18689876193',0,'123456',1,1,1,'username48',5),(48,1,'海口市琼山区海秀街道',0,'2015-06-08 17:21:40','2015-06-08 17:21:40',0,'海南融光商标代理有限公司','男',0,'2015-06-07 14:30:19','111111','/images/users/logo/nologo.gif','18689876194',0,'123456',1,1,1,'username49',5),(49,1,NULL,0,'2015-06-18 17:30:48',NULL,0,NULL,'男',1,'2015-06-18 17:30:48','13076922820','/images/users/logo/nologo.gif','13076922820',1,'13076922820',0,0,0,'13076922820',5);

/*Table structure for table `usrcar` */

DROP TABLE IF EXISTS `usrcar`;

CREATE TABLE `usrcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `defaultOne` tinyint(255) NOT NULL DEFAULT '1',
  `deleted` tinyint(255) NOT NULL DEFAULT '0',
  `plateNum` varchar(255) DEFAULT NULL,
  `carBrand_id` int(11) DEFAULT NULL,
  `userid_id` int(11) DEFAULT NULL,
  `carColor` varchar(255) DEFAULT NULL,
  `carSeries` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b0im8qg9url5r7eik2f4pk9it` (`carBrand_id`),
  KEY `FK_2txsssau38wf9vnexphj0kbt2` (`userid_id`),
  CONSTRAINT `FK_2txsssau38wf9vnexphj0kbt2` FOREIGN KEY (`userid_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_b0im8qg9url5r7eik2f4pk9it` FOREIGN KEY (`carBrand_id`) REFERENCES `carbrand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `usrcar` */

insert  into `usrcar`(`id`,`createdAt`,`defaultOne`,`deleted`,`plateNum`,`carBrand_id`,`userid_id`,`carColor`,`carSeries`) values (1,'2015-06-07 14:28:19',1,1,'苏B74111',1,5,'白色','SSS'),(2,'2015-06-09 15:50:13',0,0,'京B21353',1,5,'白色','宝马 X6系列'),(3,'2015-06-09 16:08:59',0,0,'苏JB7749',1,5,'黑色','宝马 A6 的国产');

/*Table structure for table `usrcategory` */

DROP TABLE IF EXISTS `usrcategory`;

CREATE TABLE `usrcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usrcategory` */

/*Table structure for table `zaccountdetail` */

DROP TABLE IF EXISTS `zaccountdetail`;

CREATE TABLE `zaccountdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `rechargeNum` varchar(255) DEFAULT NULL,
  `success` bit(1) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `paymentForm_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8n3c0h6de5jwo2x64cx9j4c19` (`order_id`),
  KEY `FK_jrjdfrb0jmtbrsnroomupkd` (`paymentForm_id`),
  KEY `FK_chbr80tkeupk01s30vywyrsuj` (`user_id`),
  CONSTRAINT `FK_8n3c0h6de5jwo2x64cx9j4c19` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_chbr80tkeupk01s30vywyrsuj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_jrjdfrb0jmtbrsnroomupkd` FOREIGN KEY (`paymentForm_id`) REFERENCES `paymentform` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zaccountdetail` */

/*Table structure for table `zappinfo` */

DROP TABLE IF EXISTS `zappinfo`;

CREATE TABLE `zappinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `dlIp` varchar(255) DEFAULT NULL,
  `dlMac` varchar(255) DEFAULT NULL,
  `dlTimes` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sysSupport` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l7yqulvnur8924w8ccx0x1jjj` (`user_id`),
  CONSTRAINT `FK_l7yqulvnur8924w8ccx0x1jjj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zappinfo` */

/*Table structure for table `zlog` */

DROP TABLE IF EXISTS `zlog`;

CREATE TABLE `zlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LogName` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Class` varchar(255) DEFAULT NULL,
  `Method` varchar(255) DEFAULT NULL,
  `CreateTime` varchar(255) DEFAULT NULL,
  `LogLevel` varchar(50) DEFAULT NULL,
  `MSG` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6414 DEFAULT CHARSET=utf8;

/*Data for the table `zlog` */

/*Table structure for table `zmiscellanea` */

DROP TABLE IF EXISTS `zmiscellanea`;

CREATE TABLE `zmiscellanea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bkyg4bopgvgbqaodf4l5gb7bp` (`user_id`),
  CONSTRAINT `FK_bkyg4bopgvgbqaodf4l5gb7bp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zmiscellanea` */

/*Table structure for table `zusrlog` */

DROP TABLE IF EXISTS `zusrlog`;

CREATE TABLE `zusrlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `remoteIp` varchar(255) DEFAULT NULL,
  `remoteMac` varchar(255) DEFAULT NULL,
  `row` int(11) NOT NULL,
  `tableName` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `operationCommand` varchar(255) DEFAULT NULL,
  `operationName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ojsfksrpy65bf4jbw47bcxnp5` (`user_id`),
  CONSTRAINT `FK_ojsfksrpy65bf4jbw47bcxnp5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zusrlog` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
