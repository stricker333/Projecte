CREATE DATABASE  IF NOT EXISTS `alumnesql` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `alumnesql`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alumnesql
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `alumneonline`
--

DROP TABLE IF EXISTS `alumneonline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumneonline` (
  `nom` varchar(45) DEFAULT NULL,
  `cognom` varchar(45) DEFAULT NULL,
  `DNI` varchar(20) NOT NULL,
  `especialitat` varchar(45) DEFAULT NULL,
  `direccio` varchar(45) DEFAULT NULL,
  `curs` int(11) DEFAULT '0',
  `edat` int(11) DEFAULT '0',
  `datanaix` varchar(50) DEFAULT '00/00/0000',
  `beca` double DEFAULT '0',
  `user` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `avatar` varchar(150) DEFAULT NULL,
  `hora_conexion` int(10) DEFAULT '0',
  `hora_desconexion` int(10) DEFAULT '0',
  `horas_conectado` int(10) DEFAULT '0',
  `faltas` int(10) DEFAULT '0',
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumneonline`
--

LOCK TABLES `alumneonline` WRITE;
/*!40000 ALTER TABLE `alumneonline` DISABLE KEYS */;
INSERT INTO `alumneonline` VALUES ('Mariana','Dolores','00003636W','Periodismo','Madrid',1,54,'21/11/1960',1510,'Marianico','MariConchi86',NULL,NULL,NULL,NULL,2,8,6,1),('Carlos','Floriano','06539374Z','DAW','Ontinyent',2,25,'23/11/1989',1000,'DPeas','PepCasasd23',NULL,NULL,NULL,NULL,10,13,3,0),('Joan','Martinez','27697047X','Economia','Ontinyent',2,57,'15/3/1958',1550,'Joanito','Mazetilla34',NULL,NULL,NULL,NULL,5,12,7,0),('Pere','Lopez','30730217D','Castella','Bocairent',1,6,'27/4/2009',1000,'Pezosito','Afasda1234',NULL,NULL,NULL,NULL,12,16,4,0),('Mariano','Vergara','44155246F','Periodismo','Madrid',2,51,'21/5/1964',1510,'Marianico','MariConchi86',NULL,NULL,NULL,NULL,2,7,5,0),('Julieta','Escardi','49057491D','Admin','Ontinyent',2,22,'11/1/1993',3000,'Alico','ASDasd1234',NULL,NULL,NULL,NULL,10,17,7,0),('Damian','Gimenez','51804590B','Programacion','Ontinyent',1,28,'03/08/1986',2000,'Dammmmmyan','Pistacho65',NULL,NULL,NULL,NULL,4,14,10,0),('Pepe','Casado','52315047Y','DAW','Ontinyent',1,16,'23/04/1999',1000,'DPeas','PepCasasd23',NULL,NULL,NULL,NULL,10,14,4,0),('Jose','Vicente','58665659L','Comercio','Alcoy',2,21,'16/8/1993',1050,'DPoasd','CaraVicen34',NULL,NULL,NULL,NULL,4,17,13,0),('Rafa','Montava','59563463H','Multimedia','Bocairent',2,19,'9/5/1996',1000,'AfasdA','asdASaf233',NULL,NULL,NULL,NULL,12,15,3,0),('Alicia','Santamaria','72373345G','Admin','Ontinyent',1,22,'16/09/1992',3000,'Alice','ASDasd1234',NULL,NULL,NULL,NULL,10,17,7,0),('Alejandro','Perez','83207143C','Comercio','Alcoy',1,18,'16/07/1996',1050,'DPoasd','CaraVicen34',NULL,NULL,NULL,NULL,4,17,13,0),('Alfonso','Rivera','90468269T','Economia','Ontinyent',1,58,'15/7/1956',1550,'Joanito','Mazetilla34',NULL,NULL,NULL,NULL,5,10,5,0);
/*!40000 ALTER TABLE `alumneonline` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_historial_alumnes` AFTER INSERT ON `alumneonline` FOR EACH
ROW BEGIN
insert into historial_alumnes(fecha_creacio, nom, cognom, DNI)
values( Now(), new.nom, new.cognom, new.DNI);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `historial_alumnes`
--

DROP TABLE IF EXISTS `historial_alumnes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_alumnes` (
  `fecha_creacio` datetime NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `cognom` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_alumnes`
--

LOCK TABLES `historial_alumnes` WRITE;
/*!40000 ALTER TABLE `historial_alumnes` DISABLE KEYS */;
INSERT INTO `historial_alumnes` VALUES ('2015-05-26 12:35:21','asd','asd','96372132Q'),('2015-05-26 13:28:56','Pere','Lopez','30730217D'),('2015-05-26 14:39:13','yuyu','hakusho','75090158B'),('2015-05-26 15:54:42','Pere','Lopez','30730217D'),('2015-05-31 20:44:58','Carlos','Florano','06539374Z'),('2015-05-31 20:46:49','Rafa','Montava','59563463H'),('2015-05-31 23:57:21','Mariana','Dolores','00003636W'),('2015-05-31 23:57:54','Carlos','Ferrando','48607020Q'),('2015-05-31 23:58:16','Carlos','Ferrandiz','48607020Q'),('2015-06-02 13:42:24','Joanot','Martinez','27697047X'),('2015-06-02 15:04:55','Pere','Lopez','30730217D'),('2015-06-02 18:28:36','Joan','Martinez','27697047X'),('2015-06-02 18:29:33','Carlos','Floriano','06539374Z'),('2015-06-02 18:35:32','Carlos','Floriano','06539374Z'),('2015-06-02 18:37:14','Carlos','Flor','06539374Z'),('2015-06-03 09:56:58','Carlos','Flor','06539374Z'),('2015-06-03 09:58:07','Carlos','Floriano','06539374Z'),('2015-06-03 10:04:45','Joan','Martinez','27697047X'),('2015-06-03 10:06:13','Joan','Martinez','27697047X'),('2015-06-03 10:10:22','Joan','Martinez','27697047X'),('2015-06-03 10:13:25','Joan','Martinez','27697047X'),('2015-06-03 10:40:13','Pere','Lopez','30730217D'),('2015-06-03 10:45:26','asdasd','asd','48607020Q'),('2015-06-03 10:46:16','asd','asd','98333791M'),('2015-06-03 10:47:09','asdlo','asd','89419790E'),('2015-06-03 10:47:28','asd','asd','98333791M'),('2015-06-03 10:54:42','yuyu','haku','75090158B'),('2015-06-03 11:12:52','Pere','Lopez','30730217D'),('2015-06-03 11:14:08','Pere','Lopez','30730217D'),('2015-06-03 11:16:53','asd','asd','48607020Q'),('2015-06-03 12:17:00','Pere','Lopez','30730217D'),('2015-06-03 12:20:35','Alfonso','Rivera','90468269T'),('2015-06-03 12:23:00','Joan','Martinez','27697047X'),('2015-06-03 12:24:31','Joan','Martinez','27697047X'),('2015-06-03 12:36:11','Pere','Lopez','30730217D'),('2015-06-03 12:43:52','asd','asd','48607020Q'),('2015-06-03 12:44:33','Mariano','Vergara','44155246F'),('2015-06-03 12:45:40','Carlos','Floriano','06539374Z'),('2015-06-03 12:48:23','Mariano','Vergara','44155246F'),('2015-06-03 12:50:57','Pere','Lopez','30730217D'),('2015-06-03 12:51:48','Mariano','Vergara','44155246F'),('2015-06-03 13:44:32','Pere','Lopez','30730217D'),('2015-06-03 13:44:46','Pere','Lopez','30730217D'),('2015-06-03 13:46:33','fdasdfasda','afasdada','48607020Q'),('2015-06-03 13:50:44','Mariano','Vergara','44155246F'),('2015-06-03 13:56:32','cas','cas','48607020Q'),('2015-06-03 13:57:02','casa','cas','48607020Q');
/*!40000 ALTER TABLE `historial_alumnes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_professors`
--

DROP TABLE IF EXISTS `historial_professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_professors` (
  `fecha_creacio` datetime NOT NULL,
  `user` varchar(40) DEFAULT NULL,
  `Email` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_professors`
--

LOCK TABLES `historial_professors` WRITE;
/*!40000 ALTER TABLE `historial_professors` DISABLE KEYS */;
INSERT INTO `historial_professors` VALUES ('2015-05-26 14:47:57','Joaquin','cferrando.estacio@gmail.com'),('2015-05-26 15:51:32','Ferran','cferrando.estacio@gmail.com'),('2015-05-31 18:53:21','Actiu','cferrando.estacio@gmail.com');
/*!40000 ALTER TABLE `historial_professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesoronline`
--

DROP TABLE IF EXISTS `profesoronline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesoronline` (
  `user` varchar(45) NOT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `avatar` varchar(150) DEFAULT NULL,
  `token` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesoronline`
--

LOCK TABLES `profesoronline` WRITE;
/*!40000 ALTER TABLE `profesoronline` DISABLE KEYS */;
INSERT INTO `profesoronline` VALUES ('Actiu','d37bf76d0e3a451783a944d8e4a99877','cferrando.estacio@gmail.com','Actiu','Off','src/alumnes/Img/avatar.png','PYtYpxPfiIcL79LMwEuTn3UOuMw79nYD$vs_D9bDR4bdsmI0gbMl7ereCuvf76Bf'),('admin','d37bf76d0e3a451783a944d8e4a99877','cferrando.estacio@gmail.com','Admin',NULL,'src/alumnes/Img/RN7YM.jpg',NULL),('Ferran','d37bf76d0e3a451783a944d8e4a99877','cferrando.estacio@gmail.com','Actiu','Off','src/alumnes/Img/6VRR8.png','CI5w7CgNRsLuEFx0r853c_TMaRJnu7VE4kow_k0dQmFOK2neFcelxrykcUuUav4k'),('Joaquin','d37bf76d0e3a451783a944d8e4a99877','cferrando.estacio@gmail.com','Actiu','Off','src/alumnes/Img/avatar.png','EFwFY_utX4j37ODIDk5I0Mb0ggXcgdLGE_mdgTvHSJ1g0JmaC_fhWM$0DyufJb3O');
/*!40000 ALTER TABLE `profesoronline` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_historial_professors` AFTER INSERT ON `profesoronline` FOR EACH
ROW BEGIN
insert into historial_professors (fecha_creacio, user, Email)
values( Now(), new.user, new.Email);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'alumnesql'
--
/*!50003 DROP PROCEDURE IF EXISTS `procedure1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure1`(OUT `edad_media` DOUBLE)
BEGIN
SELECT ROUND(AVG(edat)) into edad_media FROM alumneonline;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-03 14:23:44
