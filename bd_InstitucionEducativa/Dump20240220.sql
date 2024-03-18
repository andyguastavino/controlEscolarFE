CREATE DATABASE  IF NOT EXISTS `bd_institucion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_institucion`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_institucion
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idCarreras` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ALUMNOS_CARRERAS_idx` (`idCarreras`),
  CONSTRAINT `FK_ALUMNOS_CARRERAS` FOREIGN KEY (`idCarreras`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'pepe',2),(2,'pepa',1),(3,'pepo',1);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nota` int DEFAULT NULL,
  `idAlumnos` int DEFAULT NULL,
  `idMaterias` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CALIFICACIONES_ALUMNOS_idx` (`idAlumnos`),
  KEY `FK_CALIFICACIONES_MATERIAS_idx` (`idMaterias`),
  CONSTRAINT `FK_CALIFICACIONES_ALUMNOS` FOREIGN KEY (`idAlumnos`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FK_CALIFICACIONES_MATERIAS` FOREIGN KEY (`idMaterias`) REFERENCES `materias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (1,5,1,1),(2,7,1,1),(3,8,1,2),(4,4,2,3),(5,3,2,1),(6,8,3,4),(7,6,3,3);
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'cientifico'),(2,'tecnologico');
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catedraticos`
--

DROP TABLE IF EXISTS `catedraticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catedraticos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catedraticos`
--

LOCK TABLES `catedraticos` WRITE;
/*!40000 ALTER TABLE `catedraticos` DISABLE KEYS */;
INSERT INTO `catedraticos` VALUES (1,'juan'),(2,'pedro'),(3,'laura');
/*!40000 ALTER TABLE `catedraticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursar`
--

DROP TABLE IF EXISTS `cursar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursar` (
  `idAlumnos` int NOT NULL,
  `idMaterias` int NOT NULL,
  PRIMARY KEY (`idAlumnos`,`idMaterias`),
  KEY `FK_CURSAR_MATERIAS_idx` (`idMaterias`),
  CONSTRAINT `FK_CURSAR_ALUMNOS` FOREIGN KEY (`idAlumnos`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FK_CURSAR_MATERIAS` FOREIGN KEY (`idMaterias`) REFERENCES `materias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursar`
--

LOCK TABLES `cursar` WRITE;
/*!40000 ALTER TABLE `cursar` DISABLE KEYS */;
INSERT INTO `cursar` VALUES (1,1),(1,2),(2,3),(3,3),(3,4),(2,5);
/*!40000 ALTER TABLE `cursar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idCatedraticos` int DEFAULT NULL,
  `idSemestres` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MATERIAS_CATEDRATICOS_idx` (`idCatedraticos`),
  KEY `FK_MATERIAS_SEMESTRES_idx` (`idSemestres`),
  CONSTRAINT `FK_MATERIAS_CATEDRATICOS` FOREIGN KEY (`idCatedraticos`) REFERENCES `catedraticos` (`id`),
  CONSTRAINT `FK_MATERIAS_SEMESTRES` FOREIGN KEY (`idSemestres`) REFERENCES `semestres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,'mates',1,1),(2,'fisica',2,2),(3,'quimica',1,1),(4,'tecnologia',3,5),(5,'estadistica',3,6);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestres`
--

DROP TABLE IF EXISTS `semestres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semestres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idCarreras` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEMESTRES_CARRERAS_idx` (`idCarreras`),
  CONSTRAINT `FK_SEMESTRES_CARRERAS` FOREIGN KEY (`idCarreras`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestres`
--

LOCK TABLES `semestres` WRITE;
/*!40000 ALTER TABLE `semestres` DISABLE KEYS */;
INSERT INTO `semestres` VALUES (1,'primer',1),(2,'segundo',1),(3,'tercero',1),(4,'final',1),(5,'primero',2),(6,'segundo',2),(7,'tercero',2),(8,'final',2);
/*!40000 ALTER TABLE `semestres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20 13:20:15
