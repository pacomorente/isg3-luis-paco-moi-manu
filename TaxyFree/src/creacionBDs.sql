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
  KEY `OIDViaje` (`OIDViaje`),
  KEY `OIDVehiculo` (`OIDVehiculo`),
  CONSTRAINT `OIDConductor` FOREIGN KEY (`OIDConductor`) REFERENCES `usuario` (`OIDUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
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
  PRIMARY KEY (`OIDPasajero`,`OIDViaje`) ,
  KEY `OIDViaje` (`OIDViaje`) ,
  CONSTRAINT `usuario` FOREIGN KEY (`OIDPasajero`) REFERENCES `usuario` (`OIDUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
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
  `idRuta` varchar(50) NOT NULL,
  `destino` varchar(100) NOT NULL,
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
  UNIQUE KEY `nick` (`nick`) 
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
  `idVehiculo` varchar(50) NOT NULL,
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
  `idViaje` varchar(50) NOT NULL,
  `anulado` tinyint(1) DEFAULT NULL,
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


-- ******* Realizado por FRANCISCO JOSE MORENTE BONILLA 
-- ******* GRUPO 1 - ISG3 - TAXIFREE
-- ******* CASO DE USO ROL CONDUCTOR

-- TABLA USUARIO

INSERT INTO usuario(OIDUsuario,nombre,apellidos,dni,correo,estrella,nick,pass)
values('00002','Manuel','Perez','90000002X','C1@US.ES',7,'USER2','USER2');

INSERT INTO usuario(OIDUsuario,nombre,apellidos,dni,correo,estrella,nick,pass)
values('00006','Monica','Ortiz','90000006X','C6@US.ES',1,'USER6','USER6');

INSERT INTO usuario(OIDUsuario,nombre,apellidos,dni,correo,estrella,nick,pass)
values('00003','Luis','Perez','90000003X','C3@US.ES',3,'USER3','USER3');

INSERT INTO usuario(OIDUsuario,nombre,apellidos,dni,correo,estrella,nick,pass)
values('00004','Jose','Lopez','90000004X','C4@US.ES',4,'USER4','USER4');

INSERT INTO usuario(OIDUsuario,nombre,apellidos,dni,correo,estrella,nick,pass)
values('00005','Maria','Rodriguez','90000005X','C5@US.ES',6,'USER5','USER5');

COMMIT;


-- TABLA VIAJE
INSERT INTO viaje(OIDViaje,origen,destino,fecha,idViaje,anulado)
values('VIAJE001','SEVILLA','CADIZ',STR_TO_DATE('01/06/2010','%d/%m/%Y'),'01',TRUE);

-- UPDATE VIAJE SET ANULADO=FALSE WHERE OIDVIAJE='VIAJE001';

INSERT INTO viaje(OIDViaje,origen,destino,fecha,idViaje,anulado)
values('VIAJE002','SEVILLA','GRANADA',STR_TO_DATE('15/05/2010','%d/%m/%Y'),'02',TRUE);

INSERT INTO viaje(OIDViaje,origen,destino,fecha,idViaje,anulado)
values('VIAJE003','CORDOBA','ALMERIA',STR_TO_DATE('12/05/2010','%d/%m/%Y'),'03',FALSE);

-- obtener fecha de mysql a string para variable
-- SELECT *, DATE_FORMAT(fecha,'%d/%m/%Y') AS `date` FROM `tabla`
COMMIT;


-- TABLA VEHICULO

INSERT INTO vehiculo(OIDVehiculo,marca,Modelo,Color,Plazas,idVehiculo)
values('VEH00010RENA','Renault','Renault','Verde',4,'01');

INSERT INTO vehiculo(OIDVehiculo,marca,Modelo,Color,Plazas,idVehiculo)
values('VEH00011MERC','Mercedes','Mercedes','Blanco',4,'02');

INSERT INTO vehiculo(OIDVehiculo,marca,Modelo,Color,Plazas,idVehiculo)
values('VEH00012AUDI','AUDI','AUDI','Negro',4,'03');

COMMIT;


-- TABLA CONDUCTOR

INSERT INTO conductor(OIDConductor,OIDViaje,OIDVehiculo)
values('00006','VIAJE001','VEH00012AUDI');

INSERT INTO conductor(OIDConductor,OIDViaje,OIDVehiculo)
values('00003','VIAJE003','VEH00011MERC');

INSERT INTO conductor(OIDConductor,OIDViaje,OIDVehiculo)
values('00006','VIAJE002','VEH00012AUDI');


COMMIT;
-- INSERT RELACIONADO CON EL CASO DE USO DE PASAJERO (MOISES)
INSERT INTO pasajero(OIDPasajero,OIDViaje)
values('00002','VIAJE002');

INSERT INTO pasajero(OIDPasajero,OIDViaje)
values('00006','VIAJE001');

INSERT INTO pasajero(OIDPasajero,OIDViaje)
values('00006','VIAJE002');

INSERT INTO ruta(OIDRuta,origen, desplazamiento, fecha, idRuta, destino)
values('RUTA001','SEVILLA','2',STR_TO_DATE('15/05/2010','%d/%m/%Y'),'R1','GRANADA');

INSERT INTO ruta(OIDRuta,origen, desplazamiento, fecha, idRuta, destino)
values('RUTA002','SEVILLA','2',STR_TO_DATE('01/06/2010','%d/%m/%Y'),'R2','CADIZ');

INSERT INTO pasajero_ruta(OIDPasajero, OIDRuta)
values('00002','RUTA001');

INSERT INTO pasajero_ruta(OIDPasajero, OIDRuta)
values('00006','RUTA002');

INSERT INTO pasajero_ruta(OIDPasajero, OIDRuta)
values('00006','RUTA001');
