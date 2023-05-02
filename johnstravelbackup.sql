CREATE DATABASE  IF NOT EXISTS `johnstraveldb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `johnstraveldb`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: johnstraveldb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `Booking`
--

DROP TABLE IF EXISTS `Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Booking` (
  `Booking_Id` int NOT NULL AUTO_INCREMENT,
  `Booking_Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  PRIMARY KEY (`Booking_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Booking`
--

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Destination`
--

DROP TABLE IF EXISTS `Destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Destination` (
  `Destination_Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Description` text NOT NULL,
  `Photo_URL` varchar(150) NOT NULL,
  PRIMARY KEY (`Destination_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Destination`
--

LOCK TABLES `Destination` WRITE;
/*!40000 ALTER TABLE `Destination` DISABLE KEYS */;
/*!40000 ALTER TABLE `Destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Expense`
--

DROP TABLE IF EXISTS `Expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Expense` (
  `Expense_Id` int NOT NULL,
  `Name` varchar(75) NOT NULL,
  `Cost` decimal(10,2) NOT NULL,
  `Description` text NOT NULL,
  `Photo_URL` varchar(150) NOT NULL,
  `Destination_Id2` int NOT NULL,
  PRIMARY KEY (`Expense_Id`),
  KEY `Destination_Id_idx` (`Destination_Id2`),
  CONSTRAINT `Destination_Id2` FOREIGN KEY (`Destination_Id2`) REFERENCES `Destination` (`Destination_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Expense`
--

LOCK TABLES `Expense` WRITE;
/*!40000 ALTER TABLE `Expense` DISABLE KEYS */;
/*!40000 ALTER TABLE `Expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Expense_Booking`
--

DROP TABLE IF EXISTS `Expense_Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Expense_Booking` (
  `Booking_Id3` int NOT NULL,
  `Expense_Id` int NOT NULL,
  KEY `Booking_Id3_idx` (`Booking_Id3`),
  KEY `Expense_Id_idx` (`Expense_Id`),
  CONSTRAINT `Booking_Id3` FOREIGN KEY (`Booking_Id3`) REFERENCES `Booking` (`Booking_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Expense_Id` FOREIGN KEY (`Expense_Id`) REFERENCES `Expense` (`Expense_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Expense_Booking`
--

LOCK TABLES `Expense_Booking` WRITE;
/*!40000 ALTER TABLE `Expense_Booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `Expense_Booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flight`
--

DROP TABLE IF EXISTS `Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Flight` (
  `Flight_Number` int NOT NULL AUTO_INCREMENT,
  `Departure_Time` time NOT NULL,
  `Departure_Date` date NOT NULL,
  `Arrival_Time` time NOT NULL,
  `Arrival_Date` date NOT NULL,
  `Departure_City` varchar(100) NOT NULL,
  `Arrival_City` varchar(100) NOT NULL,
  `Booking_Id2` int NOT NULL,
  PRIMARY KEY (`Flight_Number`),
  KEY `Booking_Id_idx` (`Booking_Id2`),
  CONSTRAINT `Booking_Id2` FOREIGN KEY (`Booking_Id2`) REFERENCES `Booking` (`Booking_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flight`
--

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payment` (
  `Payment_Id` int NOT NULL,
  `User_Id2` int NOT NULL,
  `Payment_Date` datetime NOT NULL,
  `Amount` decimal(10,2) NOT NULL,
  `Trip_Id3` int NOT NULL,
  PRIMARY KEY (`Payment_Id`),
  KEY `User_Id_idx` (`User_Id2`),
  KEY `Trip_Id3_idx` (`Trip_Id3`),
  CONSTRAINT `Trip_Id3` FOREIGN KEY (`Trip_Id3`) REFERENCES `Trip` (`Trip_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `User_Id2` FOREIGN KEY (`User_Id2`) REFERENCES `User` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trip`
--

DROP TABLE IF EXISTS `Trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Trip` (
  `Trip_Id` int NOT NULL AUTO_INCREMENT,
  `User_Id` int NOT NULL,
  `Trip_Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Trip_Id`),
  KEY `User_Id_idx` (`User_Id`),
  CONSTRAINT `User_Id` FOREIGN KEY (`User_Id`) REFERENCES `User` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trip`
--

LOCK TABLES `Trip` WRITE;
/*!40000 ALTER TABLE `Trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trip_Bookings`
--

DROP TABLE IF EXISTS `Trip_Bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Trip_Bookings` (
  `Trip_Id2` int NOT NULL,
  `Booking_Id` int NOT NULL,
  KEY `Trip_Id_idx` (`Trip_Id2`),
  KEY `Booking_Id_idx` (`Booking_Id`),
  CONSTRAINT `Booking_Id` FOREIGN KEY (`Booking_Id`) REFERENCES `Booking` (`Booking_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Trip_Id2` FOREIGN KEY (`Trip_Id2`) REFERENCES `Trip` (`Trip_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trip_Bookings`
--

LOCK TABLES `Trip_Bookings` WRITE;
/*!40000 ALTER TABLE `Trip_Bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trip_Bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trip_Destinations`
--

DROP TABLE IF EXISTS `Trip_Destinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Trip_Destinations` (
  `Trip_Id` int NOT NULL,
  `Destination_Id` int NOT NULL,
  KEY `Trip_Id_idx` (`Trip_Id`),
  KEY `Destination_Id_idx` (`Destination_Id`),
  CONSTRAINT `Destination_Id` FOREIGN KEY (`Destination_Id`) REFERENCES `Destination` (`Destination_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Trip_Id` FOREIGN KEY (`Trip_Id`) REFERENCES `Trip` (`Trip_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trip_Destinations`
--

LOCK TABLES `Trip_Destinations` WRITE;
/*!40000 ALTER TABLE `Trip_Destinations` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trip_Destinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `User_Id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(45) NOT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Date_of_Birth` date NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Phone_Number` int NOT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-02 12:33:21
