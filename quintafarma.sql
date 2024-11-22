-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: quintafarma
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `boletas`
--

DROP TABLE IF EXISTS `boletas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boletas` (
  `bol_id` int NOT NULL AUTO_INCREMENT,
  `bol_descripcion` varchar(45) NOT NULL,
  `bol_fecha` date NOT NULL,
  `bol_total` decimal(10,0) NOT NULL,
  `ord_id` int NOT NULL,
  `cli_id` int NOT NULL,
  PRIMARY KEY (`bol_id`),
  KEY `fk_boletas_orden_pedido1` (`ord_id`),
  KEY `fk_boletas_cliente1` (`cli_id`),
  CONSTRAINT `fk_boletas_cliente1` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`cli_id`),
  CONSTRAINT `fk_boletas_orden_pedido1` FOREIGN KEY (`ord_id`) REFERENCES `orden_pedido` (`ord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletas`
--

LOCK TABLES `boletas` WRITE;
/*!40000 ALTER TABLE `boletas` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_nombre` varchar(45) NOT NULL,
  `cat_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (4,'Andres','asdasd');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cli_id` int NOT NULL AUTO_INCREMENT,
  `cli_nombre` varchar(45) NOT NULL,
  `cli_cel` int NOT NULL,
  `cli_direccion` varchar(45) NOT NULL,
  `cli_correo` varchar(45) NOT NULL,
  `cli_dni` int NOT NULL,
  PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `tipo_cliente_id` bigint unsigned DEFAULT NULL,
  `tipo_documento_id` bigint unsigned DEFAULT NULL,
  `distrito_id` bigint unsigned DEFAULT NULL,
  `nombres` varchar(150) DEFAULT NULL,
  `apellido_paterno` varchar(150) DEFAULT NULL,
  `apellido_materno` varchar(150) DEFAULT NULL,
  `nro_documento` varchar(50) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `fecha_editado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_distrito_cliente_idx` (`distrito_id`),
  KEY `fk_tipclo_cliente_idx` (`tipo_cliente_id`),
  KEY `fk_tipdoc_cliente_idx` (`tipo_documento_id`),
  CONSTRAINT `fk_distrito_cliente` FOREIGN KEY (`distrito_id`) REFERENCES `distritos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tipclo_cliente` FOREIGN KEY (`tipo_cliente_id`) REFERENCES `tipo_cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tipdoc_cliente` FOREIGN KEY (`tipo_documento_id`) REFERENCES `tipo_documento` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,1,2,8,'More','Marti','MORE','169681516','Lima','919746551','2024-11-22 00:00:00',NULL);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_orden_pedido`
--

DROP TABLE IF EXISTS `detalle_orden_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_orden_pedido` (
  `det_id` int NOT NULL AUTO_INCREMENT,
  `det_cantidad` varchar(45) NOT NULL,
  `det_precio` decimal(10,0) NOT NULL,
  `det_importe` decimal(10,0) NOT NULL,
  `prod_id` int NOT NULL,
  `ord_id` int NOT NULL,
  PRIMARY KEY (`det_id`),
  KEY `fk_detalle_orden_pedido_productos1` (`prod_id`),
  KEY `fk_detalle_orden_pedido_orden_pedido1` (`ord_id`),
  CONSTRAINT `fk_detalle_orden_pedido_orden_pedido1` FOREIGN KEY (`ord_id`) REFERENCES `orden_pedido` (`ord_id`),
  CONSTRAINT `fk_detalle_orden_pedido_productos1` FOREIGN KEY (`prod_id`) REFERENCES `productos` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_orden_pedido`
--

LOCK TABLES `detalle_orden_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_orden_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_orden_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distritos`
--

DROP TABLE IF EXISTS `distritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distritos` (
  `id` bigint unsigned NOT NULL,
  `nombre_distrito` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distritos`
--

LOCK TABLES `distritos` WRITE;
/*!40000 ALTER TABLE `distritos` DISABLE KEYS */;
INSERT INTO `distritos` VALUES (1,'Ancón'),(2,'Ate'),(3,'Barranco'),(4,'Breña'),(5,'Carabayllo'),(6,'Chaclacayo'),(7,'Chorrillos'),(8,'Cieneguilla'),(9,'Comas'),(10,'El Agustino\n'),(11,'Independencia'),(12,'Jesús María\n'),(13,'La Molina\n'),(14,'La Victoria\n'),(15,'Lima (Cercado de Lima)\n'),(16,'Lince'),(17,'Los Olivos\n'),(18,'Lurigancho-Chosica\n'),(19,'Lurín'),(20,'Magdalena del Mar\n'),(21,'Miraflores'),(22,'Pachacámac'),(23,'Pucusana'),(24,'Pueblo Libre\n'),(25,'Puente Piedra\n'),(26,'Punta Hermosa\n'),(27,'Punta Negra\n'),(28,'Rímac'),(29,'San Bartolo\n'),(30,'San Borja\n'),(31,'San Isidro\n'),(32,'San Juan de Lurigancho\n'),(33,'San Juan de Miraflores\n'),(34,'San Luis\n'),(35,'San Martín de Porres\n'),(36,'San Miguel\n'),(37,'Santa Anita\n'),(38,'Santa María del Mar\n'),(39,'Santa Rosa\n'),(40,'Santiago de Surco\n'),(41,'Surquillo'),(42,'Villa El Salvador\n'),(43,'Villa María del Triunfo\n');
/*!40000 ALTER TABLE `distritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `inve_id` int NOT NULL AUTO_INCREMENT,
  `inve_articulo` varchar(45) NOT NULL,
  `inve_stock` int NOT NULL,
  PRIMARY KEY (`inve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,'sdasd',26),(2,'asdasdas',15);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_pedido`
--

DROP TABLE IF EXISTS `orden_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_pedido` (
  `ord_id` int NOT NULL AUTO_INCREMENT,
  `ord_fecha` date NOT NULL,
  `ord_total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_pedido`
--

LOCK TABLES `orden_pedido` WRITE;
/*!40000 ALTER TABLE `orden_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `prod_nombre` varchar(45) NOT NULL,
  `prod_precio` decimal(10,2) NOT NULL,
  `prod_fecha_registro` date NOT NULL,
  `cat_id` int NOT NULL,
  `inve_id` int NOT NULL,
  `prov_id` int NOT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `fk_productos_categoria` (`cat_id`),
  KEY `fk_productos_inventario1` (`inve_id`),
  KEY `fk_productos_proveedor1` (`prov_id`),
  CONSTRAINT `fk_productos_categoria` FOREIGN KEY (`cat_id`) REFERENCES `categoria` (`cat_id`),
  CONSTRAINT `fk_productos_inventario1` FOREIGN KEY (`inve_id`) REFERENCES `inventario` (`inve_id`),
  CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`prov_id`) REFERENCES `proveedor` (`prov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Pruebasss',15.00,'2024-11-22',4,2,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `prov_id` int NOT NULL AUTO_INCREMENT,
  `prov_nombre` varchar(45) NOT NULL,
  `prov_direc` varchar(45) NOT NULL,
  `prov_telefono` int NOT NULL,
  PRIMARY KEY (`prov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'INsda','asdasd',9491874);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_roles_usuario1` (`user_id`),
  CONSTRAINT `fk_roles_usuario1` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROL_ADMIN',1);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cliente` (
  `id` bigint unsigned NOT NULL,
  `nombre_tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (1,'Ordinario'),(2,'VIP');
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `id` bigint unsigned NOT NULL,
  `nombre_documento` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'DNI'),(2,'RUC');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enable` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','$2a$12$RsIZNJFcxBwuT3OExtg1EuZ5sAgIKBDCsHxLyWlecVraeV6uICD/a',1),(2,'Erick','admin',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-22 10:18:16
