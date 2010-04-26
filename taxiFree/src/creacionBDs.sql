-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.46-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema taxifree
--

CREATE DATABASE IF NOT EXISTS taxifree;
USE taxifree;

--
-- Definition of table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
CREATE TABLE `conductor` (
  `OIDConductor` varchar(100) NOT NULL,
  `OIDViaje` varchar(100) NOT NULL,
  `OIDVehiculo` varchar(100) NOT NULL,
  PRIMARY KEY (`OIDConductor`),
  KEY `OIDViaje` (`OIDViaje`),
  KEY `OIDVehiculo` (`OIDVehiculo`),
  CONSTRAINT `OIDVehiculo` FOREIGN KEY (`OIDVehiculo`) REFERENCES `vehiculo` (`OIDVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OIDViaje` FOREIGN KEY (`OIDViaje`) REFERENCES `viaje` (`OIDViaje`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conductor`
--

/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;


--
-- Definition of table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
CREATE TABLE `pasajero` (
  `OIDPasajero` varchar(100) NOT NULL,
  `OIDViaje` varchar(100) NOT NULL,
  PRIMARY KEY (`OIDPasajero`),
  KEY `OIDViaje` (`OIDViaje`) USING BTREE,
  CONSTRAINT `viaje` FOREIGN KEY (`OIDViaje`) REFERENCES `viaje` (`OIDViaje`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasajero`
--

/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;


--
-- Definition of table `pasajero_ruta`
--

DROP TABLE IF EXISTS `pasajero_ruta`;
CREATE TABLE `pasajero_ruta` (
  `OIDPasajero` varchar(100) NOT NULL,
  `OIDRuta` varchar(100) NOT NULL,
  PRIMARY KEY (`OIDPasajero`,`OIDRuta`),
  KEY `ruta` (`OIDRuta`),
  CONSTRAINT `pasajero` FOREIGN KEY (`OIDPasajero`) REFERENCES `pasajero` (`OIDPasajero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ruta` FOREIGN KEY (`OIDRuta`) REFERENCES `ruta` (`OIDRuta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasajero_ruta`
--

/*!40000 ALTER TABLE `pasajero_ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajero_ruta` ENABLE KEYS */;


--
-- Definition of table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
CREATE TABLE `ruta` (
  `OIDRuta` varchar(100) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `desplazamiento` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`OIDRuta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruta`
--

/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `OIDUsuario` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estrella` int(11) NOT NULL,
  `nick` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL,
  PRIMARY KEY (`OIDUsuario`),
  UNIQUE KEY `nick` (`nick`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
CREATE TABLE `vehiculo` (
  `OIDVehiculo` varchar(100) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `plazas` int(11) NOT NULL,
  PRIMARY KEY (`OIDVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehiculo`
--

/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;


--
-- Definition of table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
CREATE TABLE `viaje` (
  `OIDViaje` varchar(100) NOT NULL,
  `origen` varchar(50) NOT NULL,
  `destino` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`OIDViaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viaje`
--

/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
