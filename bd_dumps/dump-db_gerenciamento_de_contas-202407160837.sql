-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_gerenciamento_de_contas
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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `tipo_categoria` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `tipo_categoria` (`tipo_categoria`),
  CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`tipo_categoria`) REFERENCES `tipo_categoria` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,1,'Salario','Salario mensal'),(2,2,'Passeios','passeios em geral'),(3,1,'Investimentos','investimento'),(4,2,'TEST','Viagens'),(5,2,'Contas Casa','Contas Casa'),(6,2,'Transporte',NULL),(7,2,'Alimentação',NULL);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despesas`
--

DROP TABLE IF EXISTS `despesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `despesas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Categoria_ID` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Vencimento` date DEFAULT NULL,
  `Pagamento` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `despesas_categoria_FK` (`Categoria_ID`),
  CONSTRAINT `despesas_categoria_FK` FOREIGN KEY (`Categoria_ID`) REFERENCES `categoria` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesas`
--

LOCK TABLES `despesas` WRITE;
/*!40000 ALTER TABLE `despesas` DISABLE KEYS */;
INSERT INTO `despesas` VALUES (2,2,'Pizza',100.00,NULL,NULL),(3,4,'Viajem p/ peabiru',200.00,NULL,NULL),(4,2,'Bit coin',50.00,NULL,NULL),(6,2,'luz',200.00,NULL,'2024-01-01'),(7,2,'teste',10.00,NULL,NULL),(8,2,'teste 2',5000.00,NULL,NULL),(11,2,'Mantimentos',300.00,NULL,NULL),(12,2,'teste2',4000000.00,NULL,NULL),(14,2,'asd',123.00,NULL,NULL),(15,2,'aaaa',1.00,NULL,NULL),(16,5,'',450.00,'2024-01-02','2024-01-01');
/*!40000 ALTER TABLE `despesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metas`
--

DROP TABLE IF EXISTS `metas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Meses` int NOT NULL,
  `Data_Inicial` date DEFAULT NULL,
  `valor_depositado` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metas`
--

LOCK TABLES `metas` WRITE;
/*!40000 ALTER TABLE `metas` DISABLE KEYS */;
INSERT INTO `metas` VALUES (1,'Viajar',2000.00,7,'2024-04-21',2000.00),(5,'teste',1.00,2,'2021-01-01',51.50),(6,'teste',1.00,2,'2021-01-01',0.00),(8,'Carro Novo',30000.00,15,'2024-02-01',35700.00),(9,'Moto nova',25000.00,10,'2024-07-13',22500.00),(10,'Viajar Praia',10000.00,8,'2024-01-02',10001.00);
/*!40000 ALTER TABLE `metas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receitas`
--

DROP TABLE IF EXISTS `receitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receitas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Categoria_ID` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Data_de_Lancamento` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `receitas_categoria_FK` (`Categoria_ID`),
  CONSTRAINT `receitas_categoria_FK` FOREIGN KEY (`Categoria_ID`) REFERENCES `categoria` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receitas`
--

LOCK TABLES `receitas` WRITE;
/*!40000 ALTER TABLE `receitas` DISABLE KEYS */;
INSERT INTO `receitas` VALUES (1,1,'Salario ref. Janeiro',1500.00,'2020-04-05'),(4,1,'teste',111.00,NULL),(5,1,'asdasd',200.15,NULL),(11,1,'janeiro',1095.00,'2023-02-04'),(12,3,'terreno',50000.00,'2022-05-16'),(13,3,'aluguel',1000.00,'2024-01-25');
/*!40000 ALTER TABLE `receitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_categoria`
--

DROP TABLE IF EXISTS `tipo_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_categoria` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_categoria`
--

LOCK TABLES `tipo_categoria` WRITE;
/*!40000 ALTER TABLE `tipo_categoria` DISABLE KEYS */;
INSERT INTO `tipo_categoria` VALUES (1,'Receitas'),(2,'Despesas');
/*!40000 ALTER TABLE `tipo_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_gerenciamento_de_contas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16  8:37:09
