-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: johns_airTravel_DB
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `airlines`
--

DROP TABLE IF EXISTS `airlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airlines` (
  `airline_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`airline_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airlines`
--

LOCK TABLES `airlines` WRITE;
/*!40000 ALTER TABLE `airlines` DISABLE KEYS */;
INSERT INTO `airlines` VALUES (1,'FOXAIR'),(2,'Diamond Wings'),(3,'Patriot Air'),(4,'Big Boss Airline'),(5,'Codec Airlines'),(6,'Cypher Airways'),(7,'Solid Air');
/*!40000 ALTER TABLE `airlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `ticket_id` int NOT NULL,
  `flight_id` int NOT NULL,
  `passenger_id` int NOT NULL,
  `booking_agency_id` int NOT NULL,
  `meal_preference` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `ticket_id_idx` (`ticket_id`),
  KEY `flight_id_idx` (`flight_id`),
  KEY `passenger_id_idx` (`passenger_id`),
  KEY `booking_agency_id_idx` (`booking_agency_id`),
  KEY `meal_preference_idx` (`meal_preference`),
  CONSTRAINT `booking_agency_id` FOREIGN KEY (`booking_agency_id`) REFERENCES `booking_agency` (`agency_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`flight_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `meal_preference` FOREIGN KEY (`meal_preference`) REFERENCES `meals` (`meal_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `passenger_id` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`passender_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,15,2,5,2),(2,2,14,1,4,1),(3,3,13,2,3,3),(4,5,12,2,1,2),(5,4,11,5,2,3),(6,6,10,3,1,4),(7,7,9,4,1,4),(8,8,8,5,3,8),(9,9,7,6,3,3),(10,10,6,7,5,4),(11,11,5,8,2,7),(12,12,4,9,4,5),(13,13,3,10,1,6),(14,14,2,11,3,11),(15,15,1,12,5,3),(16,16,2,13,2,11),(17,17,3,14,3,1),(18,18,4,15,4,1),(19,19,5,15,4,1),(20,11,6,14,3,12);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_agency`
--

DROP TABLE IF EXISTS `booking_agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_agency` (
  `agency_id` int NOT NULL AUTO_INCREMENT,
  `agency_name` varchar(45) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `website` varchar(45) NOT NULL,
  PRIMARY KEY (`agency_id`,`agency_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_agency`
--

LOCK TABLES `booking_agency` WRITE;
/*!40000 ALTER TABLE `booking_agency` DISABLE KEYS */;
INSERT INTO `booking_agency` VALUES (1,'Foxhound Adventures','5552346434','foxhoundadv.com'),(2,'Outer Haven Travels','5558776342','outerhaventravels.com'),(3,'Diamond Dog Expeditions','5550987756','ddexpeditions.com'),(4,'Metal Gear Excursions','5551234567','metalgearex.com'),(5,'Shadow Moses Vacations','5554366322','shadowmosesvaca.com');
/*!40000 ALTER TABLE `booking_agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew` (
  `crew_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`crew_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES (17,'Leo','Stenbuck','flight attendant'),(18,'Ken','Marinaris','flight attendant'),(19,'Elena','Weinberg','flight attendant'),(20,'Celvice','Klein','flight attendant'),(21,'Viola','Gyune','pilot'),(22,'Rock','Thunderheart','flight engineer'),(23,'Lloyd','Goldwyn','flight attendant'),(24,'Vic','Viper','co-pilot'),(25,'Rachel','Links','flight attendant'),(26,'Dingo','Egret','co-pilot'),(27,'Sam','Bridges','flight medic'),(28,'Higgs','Monaghan','pilot'),(29,'Bridget','Strand','flight engineer'),(30,'Nicolas','Refn','co-pilot'),(31,'Margaret','Qualley','flight attendant'),(32,'Emily','O\'Brien','pilot'),(33,'Lindsay','Wagner','flight medic'),(34,'Tommy','Jenkins','flight attendant'),(35,'Troy','Baker','flight attendant'),(36,'Lea','Seydoux','flight attendant');
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinations`
--

DROP TABLE IF EXISTS `destinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destinations` (
  `destination_id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `airport` varchar(45) NOT NULL,
  PRIMARY KEY (`destination_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinations`
--

LOCK TABLES `destinations` WRITE;
/*!40000 ALTER TABLE `destinations` DISABLE KEYS */;
INSERT INTO `destinations` VALUES (1,'USA','Shadow Moses Island','Fairbanks International'),(2,'USA','New York City','LaGuardia'),(3,'Africa','Zanzibar Land','O.R. Tambo International'),(4,'South Africa','Outer Heaven','Cape Town International'),(5,'International Waters','Mother Base','Diamond Dogs International'),(6,'Cuba','Camp Omega','Leeward Point Field'),(7,'Russia','Groznyj Grad','Koltsovo'),(8,'Eastern Europe','OKB-754','Budapest International'),(9,'Russia','Omsk','Pulkovo'),(10,'Costa Rica','Mount Irazu','Limon International'),(11,'Japan','Tokyo','Narita International'),(12,'Russia','Razvet','Kazan'),(13,'Panama','Panama City','Tocumen International'),(14,'Cuba','Havana','Jose Marti International'),(15,'England','London','Heathrow'),(16,'France','Paris','Paris Charles de Gaulle'),(17,'Dhekelia','Cyprus','Ercan International'),(18,'Galuade','South America','El Dorado International'),(19,'Abkhazia','Georgia','Kutaisi International');
/*!40000 ALTER TABLE `destinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_crew`
--

DROP TABLE IF EXISTS `flight_crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_crew` (
  `flight_id2` int NOT NULL,
  `crew_id2` int NOT NULL,
  KEY `flight_id_idx` (`flight_id2`),
  KEY `crew_id_idx` (`crew_id2`),
  CONSTRAINT `crew_id2` FOREIGN KEY (`crew_id2`) REFERENCES `crew` (`crew_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flight_id2` FOREIGN KEY (`flight_id2`) REFERENCES `flights` (`flight_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_crew`
--

LOCK TABLES `flight_crew` WRITE;
/*!40000 ALTER TABLE `flight_crew` DISABLE KEYS */;
INSERT INTO `flight_crew` VALUES (1,17),(1,36),(1,18),(1,19),(1,20),(1,21),(2,17),(2,18),(2,19),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(3,29),(3,30),(4,31),(5,32),(6,33),(7,31),(8,34),(9,32),(10,35),(11,33),(12,32),(13,34),(14,23),(15,35);
/*!40000 ALTER TABLE `flight_crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_meals`
--

DROP TABLE IF EXISTS `flight_meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_meals` (
  `flight_id3` int NOT NULL,
  `meal_id2` int NOT NULL,
  KEY `flight_id_idx` (`flight_id3`),
  KEY `meal_id_idx` (`meal_id2`),
  CONSTRAINT `flight_id3` FOREIGN KEY (`flight_id3`) REFERENCES `flights` (`flight_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `meal_id2` FOREIGN KEY (`meal_id2`) REFERENCES `meals` (`meal_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_meals`
--

LOCK TABLES `flight_meals` WRITE;
/*!40000 ALTER TABLE `flight_meals` DISABLE KEYS */;
INSERT INTO `flight_meals` VALUES (15,12),(12,12),(13,11),(2,11),(4,11),(3,1),(4,2),(11,3),(7,4),(7,5),(7,6),(8,7),(4,8),(3,9),(6,12),(1,1),(7,12),(8,2);
/*!40000 ALTER TABLE `flight_meals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `flight_id` int NOT NULL AUTO_INCREMENT,
  `airline_id` int NOT NULL,
  `depart_time` datetime NOT NULL,
  `arrival_time` datetime NOT NULL,
  `route_id` int NOT NULL,
  `flight_status` varchar(45) NOT NULL,
  `plane_id` int NOT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `airline_id_idx` (`airline_id`),
  KEY `route_id_idx` (`route_id`),
  KEY `plane_id_idx` (`plane_id`),
  CONSTRAINT `airline_id` FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`airline_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plane_id` FOREIGN KEY (`plane_id`) REFERENCES `planes` (`plane_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `route_id` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,2,'2023-03-18 09:27:14','2023-03-18 15:27:14',22,'On Time',1),(2,2,'2022-09-24 17:56:42','2022-09-25 01:56:42',33,'Canceled',2),(3,2,'2023-01-12 12:33:03','2023-01-12 18:33:03',11,'On Time',3),(4,2,'2022-11-07 23:18:20','2022-11-08 05:18:20',12,'Delayed',4),(5,1,'2023-04-10 10:41:59','2023-04-10 16:41:59',13,'On Time',5),(6,1,'2022-12-27 20:09:05','2022-12-28 02:09:05',1,'On Time',6),(7,3,'2023-03-06 15:35:12','2023-03-06 21:35:12',2,'Delayed',7),(8,3,'2022-10-15 05:24:38','2022-10-15 11:24:38',3,'Canceled',8),(9,5,'2023-02-02 07:58:47','2023-02-02 13:58:47',4,'On Time',9),(10,4,'2022-09-03 14:13:58','2022-09-03 20:13:58',5,'Delayed',16),(11,4,'2022-12-10 22:40:02','2022-12-11 04:40:02',6,'On Time',15),(12,7,'2023-02-21 16:01:19','2023-02-21 22:01:19',45,'On Time',14),(13,7,'2022-11-17 03:32:25','2022-11-17 09:32:25',36,'Delayed',13),(14,6,'2023-01-25 08:54:36','2023-01-25 14:54:36',27,'On Time',2),(15,5,'2022-10-28 19:25:43','2022-10-29 01:25:43',32,'On Time',3);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meals`
--

DROP TABLE IF EXISTS `meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meals` (
  `meal_id` int NOT NULL AUTO_INCREMENT,
  `meal_name` varchar(100) NOT NULL,
  `travel_class` int NOT NULL,
  PRIMARY KEY (`meal_id`),
  KEY `travel_class_idx` (`travel_class`),
  CONSTRAINT `travel_class` FOREIGN KEY (`travel_class`) REFERENCES `travel_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meals`
--

LOCK TABLES `meals` WRITE;
/*!40000 ALTER TABLE `meals` DISABLE KEYS */;
INSERT INTO `meals` VALUES (1,'Chicken breast with rice and vegetables',1),(2,'Beef stew with mashed potatoes',1),(3,'Pasta with marinara sauce',1),(4,'Grilled salmon with steamed vegetables',1),(5,'Vegetarian stir-fry with tofu and rice',2),(6,'Roast chicken with mashed potatoes and gravy',2),(7,'Lasagna with garlic bread',2),(8,'Shrimp scampi with angel hair pasta',2),(9,'Baked cod with lemon butter sauce and couscous',3),(10,'Vegetable curry with basmati rice',3),(11,'Beef teriyaki with fried rice',3),(12,'Stuffed bell pepers with quinoa and tomato sauce',3);
/*!40000 ALTER TABLE `meals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `passender_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`passender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'John','Pennington','jonwpen@gmail.com','1987-08-14','5551234567'),(2,'Solid','Snake','ssnake@gmail.com','1972-01-22','5559876543'),(3,'Liquid','Snake','lsnake@gmail.com','1972-01-22','5552468135'),(4,'Revolver','Ocelot','rocelot@gmail.com','1942-08-10','5553692580'),(5,'Hal','Emmerich','halemm@gmail.com','1975-12-25','5557778888'),(6,'Meryl','Silverburgh','msilver@gmail.com','1978-03-23','5555551212'),(7,'Sniper','Wolf','swolf@gmail.com','1982-02-27','5553216547'),(8,'Gray','Fox','gfox@gmail.com','1965-09-09','5558889999'),(9,'Mei','Ling','meiling@gmail.com','1985-11-11','5554443333'),(10,'Kazuhira','Miller','kazmiller@gmail.com','1972-01-22','5557771111'),(11,'Solidus','Snake','soliduss@gmail.com','1960-07-12','5552345678'),(12,'Olga','Gurlukovich','olgagurl@gmail.com','1980-02-22','5558765432'),(13,'Sunny','Gurlukovich','sunnygurl@gmail.com','1998-06-05','5551357902'),(14,'Naomi','Hunter','naomihunt@gmail.com','1976-10-30','5556789012'),(15,'Psycho','Mantis','pmantis@gmail.com','1971-01-15','5551112222');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes`
--

DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes` (
  `plane_id` int NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  PRIMARY KEY (`plane_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes`
--

LOCK TABLES `planes` WRITE;
/*!40000 ALTER TABLE `planes` DISABLE KEYS */;
INSERT INTO `planes` VALUES (1,'Boeing','E-3 Sentry'),(2,'Airbus','A380'),(3,'Boeing','757'),(4,'Lockheed','L-1011 TriStar'),(5,'Boeing','747'),(6,'Boeing','727'),(7,'British Aerospace','146'),(8,'Fokker','70'),(9,'Fokker','100'),(10,'Boeing','767'),(11,'Douglas','DC-8'),(12,'Convair','880'),(13,'Ilyushin','II-86'),(14,'Comac','C919'),(15,'Boeing','787 Dreamliner'),(16,'Airbus','A320');
/*!40000 ALTER TABLE `planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `departing_dest` int NOT NULL,
  `arriving_dest` int NOT NULL,
  PRIMARY KEY (`route_id`),
  KEY `departing_dest_idx` (`departing_dest`),
  KEY `arriving_dest_idx` (`arriving_dest`),
  CONSTRAINT `arriving_dest` FOREIGN KEY (`arriving_dest`) REFERENCES `destinations` (`destination_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `departing_dest` FOREIGN KEY (`departing_dest`) REFERENCES `destinations` (`destination_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,1,2),(2,1,4),(3,1,6),(4,1,8),(5,1,10),(6,2,3),(7,2,4),(8,2,5),(9,3,6),(10,3,7),(11,3,8),(12,4,6),(13,5,7),(14,5,8),(15,4,1),(16,4,2),(17,5,1),(18,6,2),(19,6,3),(20,6,4),(21,7,1),(22,7,2),(23,7,3),(24,8,4),(25,8,5),(26,9,6),(27,9,7),(28,10,8),(29,10,9),(30,11,8),(31,11,7),(32,12,6),(33,12,5),(34,13,4),(35,13,3),(36,14,2),(37,14,1),(38,15,2),(39,15,3),(40,16,4),(41,16,5),(42,17,6),(43,17,7),(44,18,6),(45,18,8),(46,19,9),(47,19,10);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `ticket_id` int NOT NULL AUTO_INCREMENT,
  `time_purchased` datetime NOT NULL,
  `class_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `seat_number` int NOT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `class_id_idx` (`class_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `travel_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'2023-01-15 09:32:17',1,400.00,20),(2,'2022-12-07 18:20:42',1,360.00,330),(3,'2023-03-28 11:56:05',1,655.76,196),(4,'2022-10-19 07:41:33',1,598.75,423),(5,'2023-04-02 14:15:22',1,555.42,21),(6,'2022-11-29 20:03:48',1,834.33,189),(7,'2023-02-09 13:27:11',2,2231.46,203),(8,'2022-09-26 23:10:51',2,1909.44,324),(9,'2023-01-01 08:50:14',2,3000.11,111),(10,'2022-12-15 16:38:39',2,2231.21,221),(11,'2023-03-18 10:04:26',2,1432.34,132),(12,'2022-10-07 04:29:58',2,1200.00,134),(13,'2023-03-31 12:01:07',3,3500.44,412),(14,'2022-11-23 19:46:29',3,2890.43,356),(15,'2023-02-15 15:20:53',3,3622.31,255),(16,'2022-09-16 02:03:41',3,3332.78,112),(17,'2022-12-23 11:35:19',3,4545.67,477),(18,'2023-01-08 07:54:37',3,5000.90,279),(19,'2022-09-26 23:10:51',3,6634.65,17);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_class`
--

DROP TABLE IF EXISTS `travel_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_class`
--

LOCK TABLES `travel_class` WRITE;
/*!40000 ALTER TABLE `travel_class` DISABLE KEYS */;
INSERT INTO `travel_class` VALUES (1,'First Class'),(2,'Business Class'),(3,'Economy Class');
/*!40000 ALTER TABLE `travel_class` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12 12:16:21
