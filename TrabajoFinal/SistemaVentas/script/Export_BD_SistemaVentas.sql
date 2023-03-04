CREATE DATABASE  IF NOT EXISTS `bd_sistemaventas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_sistemaventas`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_sistemaventas
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `codigo_cli` varchar(10) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `apellido` varchar(40) DEFAULT NULL,
  `documento` varchar(16) NOT NULL,
  `clave` char(5) DEFAULT NULL,
  PRIMARY KEY (`codigo_cli`,`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`codigo_cli`, `nombre`, `apellido`, `documento`, `clave`) VALUES ('CLI0001','Karina','Palacios','77777777','1234'),('CLI0002','Mario','Cuba','88888888','5555'),('CLI0003','Jose','Vasquez','44444444','1111'),('CLI0004','Luisa','Ramos','99999999','5213');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `codigo_emp` varchar(10) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `apellido` varchar(40) DEFAULT NULL,
  `permisos` varchar(50) DEFAULT NULL,
  `usuario` varchar(40) NOT NULL,
  `clave` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`codigo_emp`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`codigo_emp`, `nombre`, `apellido`, `permisos`, `usuario`, `clave`) VALUES ('EMP0001','Mauro','Ramirez','clientes;empleados','mramirez','1111'),('EMP0002','Karina','Suarez','empleados;productos','ksuarez','2222'),('EMP0003','Jeff','Solano','clientes;empleados','jsolano','3333'),('EMP0004','Pedro','Carpio','clientes;empleados;productos','pcarpio','1111'),('EMP0005','Maria','Dominguez','clientes;empleados','mdominguez','1234');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `codigo_ped` varchar(20) NOT NULL,
  `lista_productos` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`codigo_ped`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` (`codigo_ped`, `lista_productos`) VALUES ('106','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('1075','PRD0001,Leche evaporada,5.0,30;'),('1084','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('1335','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('1357','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('1371','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0001,Leche evaporada,5.0,30;PRD0001,Leche evaporada,5.0,30;'),('1377','PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('1475','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('1745','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('1875','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('1884','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('2042','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('2152','PRD0004,Arroz,16.0,5;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('2248','PRD0003,Papel H.,1.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('2333','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('2361','PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('2665','PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('2781','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('282','PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('3419','PRD0003,Papel H.,1.0,30;'),('3718','PRD0004,Arroz,16.0,5;'),('3921','Modelo.Productos@21e1714d,Leche evaporada,5.0,30;'),('4131','PRD0001,Leche evaporada,5.0,30;'),('4147','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('4148','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('4362','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('4371','PRD0005,Yogurt,8.0,50;'),('4439','PRD0001,Leche evaporada,5.0,30;'),('4457','PRD0005,Yogurt,8.0,50;'),('4497','PRD0003,Papel H.,1.0,30;'),('4561','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('4565','PRD0001,Leche evaporada,5.0,30;PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('458','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('4620','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('4697','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('4699','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('4866','PRD0004,Arroz,16.0,5;'),('5021','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('5046','PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('5135','PRD0001,Leche evaporada,5.0,30;'),('5348','PRD0001,Leche evaporada,5.0,30;PRD0001,Leche evaporada,5.0,30;PRD0001,Leche evaporada,5.0,30;'),('5418','PRD0001,Leche evaporada,5.0,30;'),('5440','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('5733','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('5751','PRD0001,Leche evaporada,5.0,30;'),('590','PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('5969','PRD0002,Jabon,4.0,20;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('6134','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('628','PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('6359','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('6399','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('6496','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('6516','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('6525','PRD0002,Jabon,4.0,20;'),('660','PRD0002,Jabon,4.0,20;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('6667','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('6805','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('6912','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('696','Modelo.Productos@51ee7bbc,Leche evaporada,5.0,30;'),('6967','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('7025','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('7059','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0004,Arroz,16.0,5;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('7152','PRD0001,Leche evaporada,5.0,30;PRD0001,Leche evaporada,5.0,30;PRD0001,Leche evaporada,5.0,30;'),('7305','PRD0003,Papel H.,1.0,30;'),('7319','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('7320','PRD0005,Yogurt,8.0,50;'),('7347','PRD0002,Jabon,4.0,20;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('7479','PRD0002,Jabon,4.0,20;'),('7490','PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('7723','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('8003','PRD0001,Leche evaporada,5.0,30;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('8030','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('8042','PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('8101','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('8236','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('8271','PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('8529','PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('8729','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('8738','PRD0002,Jabon,4.0,20;'),('8745','PRD0002,Jabon,4.0,20;'),('8758','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('8870','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('8941','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('9294','PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;PRD0002,Jabon,4.0,20;'),('9510','PRD0003,Papel H.,1.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('9532','PRD0002,Jabon,4.0,20;PRD0004,Arroz,16.0,5;PRD0005,Yogurt,8.0,50;PRD0004,Arroz,16.0,5;PRD0004,Arroz,16.0,5;'),('9566','PRD0001,Leche evaporada,5.0,30;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('9594','PRD0002,Jabon,4.0,20;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('9637','PRD0005,Yogurt,8.0,50;'),('9667','PRD0001,Leche evaporada,5.0,30;PRD0005,Yogurt,8.0,50;PRD0005,Yogurt,8.0,50;'),('9737','PRD0005,Yogurt,8.0,50;'),('9747','PRD0004,Arroz,16.0,5;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('9902','PRD0001,Leche evaporada,5.0,30;PRD0002,Jabon,4.0,20;PRD0003,Papel H.,1.0,30;PRD0003,Papel H.,1.0,30;'),('aaa','aaaa');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `codigo_prod` varchar(10) NOT NULL,
  `descripcion` varchar(40) DEFAULT NULL,
  `preciounitario` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`codigo_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`codigo_prod`, `descripcion`, `preciounitario`, `stock`) VALUES ('PRD0001','Leche evaporada',5,30),('PRD0002','Jabon',4,20),('PRD0003','Papel H.',1,30),('PRD0004','Arroz',16,5),('PRD0005','Yogurt',8,80);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_sistemaventas'
--
/*!50003 DROP PROCEDURE IF EXISTS `actualizarClienteSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarClienteSP`(IN codigoOrigParamSP VARCHAR(10), IN codigoNewParamSP VARCHAR(10), IN nombreParamSP VARCHAR(40), IN apellidoParamSP VARCHAR(40), IN documentoParamSP VARCHAR(16), IN claveParamSP VARCHAR(5))
BEGIN
   UPDATE Clientes SET codigo_cli = codigoNewParamSP, nombre = nombreParamSP, apellido = apellidoParamSP, documento = documentoParamSP, clave = claveParamSP WHERE codigo_cli = codigoOrigParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarEmpleadoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarEmpleadoSP`(IN codigoOrigParamSP VARCHAR(10), IN codigoNewParamSP VARCHAR(10), IN nombreParamSP VARCHAR(40), IN apellidoParamSP VARCHAR(40), IN permisosParamSP VARCHAR(50), usuarioParamSP VARCHAR(40), IN claveParamSP VARCHAR(5))
BEGIN
   UPDATE Empleados SET codigo_emp = codigoNewParamSP, nombre = nombreParamSP, apellido = apellidoParamSP, permisos = permisosParamSP, clave = claveParamSP WHERE codigo_emp = codigoOrigParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarPedidoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarPedidoSP`(IN codigoPedParamSP VARCHAR(20), IN lista_productosParamSP VARCHAR(400))
BEGIN
   UPDATE Pedidos SET  lista_productos = lista_productosParamSP WHERE codigo_ped = codigoPedParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarProductoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarProductoSP`(IN codigoOrigParamSP VARCHAR(10), IN codigoNewParamSP VARCHAR(10), IN descripcionParamSP VARCHAR(40), IN precioParamSP DOUBLE, IN stockParamSP INT)
BEGIN
   UPDATE Productos SET codigo_prod = codigoNewParamSP, descripcion = descripcionParamSP, preciounitario = precioParamSP, stock = stockParamSP WHERE codigo_prod = codigoOrigParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarClienteSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarClienteSP`(IN codigoCliParamSP VARCHAR(10))
BEGIN
		DELETE FROM Clientes WHERE codigo_cli=codigoCliParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarEmpleadoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarEmpleadoSP`(IN codigoempParamSP VARCHAR(10))
BEGIN
		DELETE FROM Empleados WHERE codigo_emp=codigoempParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarPedidoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPedidoSP`(IN codigoPedParamSP VARCHAR(10))
BEGIN
		DELETE FROM Pedidos WHERE codigo_ped=codigoPedParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarProductoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarProductoSP`(IN codigoProdParamSP VARCHAR(10))
BEGIN
		DELETE FROM Productos WHERE codigo_prod=codigoProdParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarClienteSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarClienteSP`(IN codigocliParamSP VARCHAR(10), IN nombreParamSP VARCHAR(40), IN apellidoParamSP VARCHAR(40), IN documentoParamSP VARCHAR(16), IN claveParamSP VARCHAR(5))
BEGIN
   INSERT INTO Clientes values (codigocliParamSP, nombreParamSP, apellidoParamSP, documentoParamSP, claveParamSP);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarEmpleadoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpleadoSP`(IN codigoempParamSP VARCHAR(10), IN nombreParamSP VARCHAR(40), IN apellidoParamSP VARCHAR(40), IN permisosParamSP VARCHAR(50), IN usuarioParamSP VARCHAR(40), IN claveParamSP VARCHAR(5))
BEGIN
   INSERT INTO Empleados values (codigoempParamSP, nombreParamSP, apellidoParamSP, permisosParamSP, usuarioParamSP, claveParamSP);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarPedidoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarPedidoSP`(IN codigoPedParamSP VARCHAR(20), IN lista_productosParamSP VARCHAR(400))
BEGIN
   INSERT INTO Pedidos values (codigoPedParamSP, lista_productosParamSP);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarProductoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarProductoSP`(IN codigoprodParamSP VARCHAR(10), IN descripcionParamSP VARCHAR(40), IN precioParamSP DOUBLE, IN stockParamSP INT)
BEGIN
   INSERT INTO Productos values (codigoprodParamSP, descripcionParamSP, precioParamSP, stockParamSP);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mostrarClienteSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarClienteSP`(IN codigoCliParamSP VARCHAR(10))
BEGIN
	IF(codigoCliParamSP="") THEN
		SELECT * FROM Clientes;
	ELSE
		SELECT * FROM Clientes WHERE codigo_cli=codigoCliParamSP;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mostrarEmpleadoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarEmpleadoSP`(IN codigoempParamSP VARCHAR(10))
BEGIN
	IF(codigoempParamSP="") THEN
		SELECT * FROM Empleados;
	ELSE
		SELECT * FROM Empleados WHERE codigo_emp=codigoempParamSP;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mostrarPedidoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarPedidoSP`(IN codigoPedParamSP VARCHAR(20))
BEGIN
		SELECT * FROM Pedidos WHERE codigo_ped=codigoPedParamSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mostrarProductoSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrarProductoSP`(IN codigoProdParamSP VARCHAR(10))
BEGIN
	IF(codigoProdParamSP="") THEN
		SELECT * FROM Productos;
	ELSE
		SELECT * FROM Productos WHERE codigo_prod=codigoProdParamSP;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validarUsuarioCliSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validarUsuarioCliSP`(IN documentoParamSP VARCHAR(40), IN claveParamSP CHAR(5), OUT resultadoParamSP VARCHAR(16))
BEGIN
    DECLARE numRow INT;
    
    SELECT count(*) INTO numRow FROM Clientes WHERE documento = documentoParamSP;
	IF (numRow = 1) THEN
		SET resultadoParamSP="ENCONTRADO_CINV";
        SELECT count(*) INTO numRow FROM Clientes WHERE documento = documentoParamSP AND clave = claveParamSP;
        IF (numRow = 1) THEN
			SET resultadoParamSP="ENCONTRADO_CVAL";
		END IF;
	ELSE
		SET resultadoParamSP="NO_ENCONTRADO";
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validarUsuarioEmpSP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validarUsuarioEmpSP`(IN usuarioParamSP VARCHAR(40), IN claveParamSP CHAR(5), IN permisosParamSP VARCHAR(50), OUT resultadoParamSP VARCHAR(14))
BEGIN
    DECLARE numRow INT;
    
    SELECT count(*) INTO numRow FROM Empleados WHERE usuario = usuarioParamSP AND clave = claveParamSP;
	IF (numRow = 1) THEN
		SET resultadoParamSP="ENCONTRADO_SP";
        SELECT count(*) INTO numRow FROM Empleados WHERE usuario = usuarioParamSP AND clave = claveParamSP AND permisos LIKE CONCAT('%',permisosParamSP, '%');
        IF (numRow = 1) THEN
			SET resultadoParamSP="ENCONTRADO_CP";
		END IF;
	ELSE
		SET resultadoParamSP="NO_ENCONTRADO";
	END IF;
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

-- Dump completed on 2023-03-04  8:06:32
