-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dealwithit
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `depense`
--

DROP TABLE IF EXISTS `depense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depense` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `montant` double NOT NULL,
  `description` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  KEY `fk_idUtilisateur` (`idUtilisateur`),
  KEY `fk_idEvenement` (`idEvenement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depense`
--

LOCK TABLES `depense` WRITE;
/*!40000 ALTER TABLE `depense` DISABLE KEYS */;
INSERT INTO `depense` VALUES (1,1,'2017-08-08 10:10:10',10,'Test du cul');
/*!40000 ALTER TABLE `depense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenements`
--

DROP TABLE IF EXISTS `evenements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenements` (
  `idEvenement` int(11) NOT NULL AUTO_INCREMENT,
  `nomEvenement` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `budget` double NOT NULL,
  PRIMARY KEY (`idEvenement`),
  UNIQUE KEY `idEvenement` (`idEvenement`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenements`
--

LOCK TABLES `evenements` WRITE;
/*!40000 ALTER TABLE `evenements` DISABLE KEYS */;
INSERT INTO `evenements` VALUES (1,'Development',1200),(2,'Anniversaire de Jacquie',200),(14,'Mes couilles sur ton front',0),(12,'Lévenement',10),(3,'Flip Party',894),(15,'Lévenement',10),(16,'Lévenement',10),(17,'Lévenement',10),(18,'Lévenement',10),(19,'Lévenement',10),(20,'Lévenement',10),(21,'Lévenement',10),(22,'Lévenement',10),(23,'Lévenement',10),(24,'Lévenement',10),(25,'Lévenement',10),(26,'Lévenement',10),(27,'Lévenement',10),(28,'Lévenement',10),(29,'Lévenement',10),(30,'Lévenement',10),(31,'Lévenement',10);
/*!40000 ALTER TABLE `evenements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participe`
--

DROP TABLE IF EXISTS `participe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participe` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  KEY `fk_idUtilisateur` (`idUtilisateur`),
  KEY `fk_idEvenement` (`idEvenement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participe`
--

LOCK TABLES `participe` WRITE;
/*!40000 ALTER TABLE `participe` DISABLE KEYS */;
INSERT INTO `participe` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(1,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(3,14),(4,14),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2),(2,2);
/*!40000 ALTER TABLE `participe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poste_message`
--

DROP TABLE IF EXISTS `poste_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poste_message` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  `date` date NOT NULL,
  `message` varchar(200) COLLATE latin1_general_ci NOT NULL,
  KEY `fk_idUtilisateur` (`idUtilisateur`),
  KEY `fk_idEvenement` (`idEvenement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poste_message`
--

LOCK TABLES `poste_message` WRITE;
/*!40000 ALTER TABLE `poste_message` DISABLE KEYS */;
INSERT INTO `poste_message` VALUES (1,1,'2017-05-05','Salut'),(2,2,'2017-05-05','Wesh'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test'),(1,1,'2017-01-01','test');
/*!40000 ALTER TABLE `poste_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateurs` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `prenom` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `pseudo` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `motDePasse` varchar(30) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `idUtilisateur` (`idUtilisateur`),
  UNIQUE KEY `peudo` (`pseudo`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateurs`
--

LOCK TABLES `utilisateurs` WRITE;
/*!40000 ALTER TABLE `utilisateurs` DISABLE KEYS */;
INSERT INTO `utilisateurs` VALUES (1,'Granjon','Thomas','thomas.granjon2@etu.univ-st-etienne.fr','TGranjon','pass'),(2,'Sofonea','Axel','','asofonea','pass'),(3,'Jeamme','Christopher','christopher@jeamme.fr','cjeamme','pass'),(4,'Bruyère','Dimitri','','dbryuere','pass'),(5,'Siracusa','Rémi','','remi42320b','pass'),(6,'Gourdin','Jean-Jacques','Jean-Jacques.Gourdin@rmc.bfmtv.com','Jo Gros Gourdin','FCf(RHçEfz-F(afAD*'),(7,'A','B','C','D','E');
/*!40000 ALTER TABLE `utilisateurs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08 22:10:54
