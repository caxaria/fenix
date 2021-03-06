
CREATE TABLE `REMOTE_SYSTEM` (
  `ID_INTERNAL` int(11) NOT NULL AUTO_INCREMENT,
  `OID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_INTERNAL`),
  KEY `OID` (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `REMOTE_HOST` (
  `ID_INTERNAL` int(11) NOT NULL AUTO_INCREMENT,
  `OID` bigint(20) DEFAULT NULL,
  `OID_REMOTE_SYSTEM` bigint(20) DEFAULT NULL,
  `PASSWORD` longtext,
  `URL` longtext,
  `USERNAME` longtext,
  `ALLOW_INVOCATION_ACCESS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_INTERNAL`),
  KEY `OID` (`OID`),
  KEY `OID_REMOTE_SYSTEM` (`OID_REMOTE_SYSTEM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `REMOTE_DOMAIN_OBJECT` (
  `ID_INTERNAL` int(11) NOT NULL AUTO_INCREMENT,
  `OID` bigint(20) DEFAULT NULL,
  `OID_REMOTE_HOST` bigint(20) DEFAULT NULL,
  `REMOTE_OID` longtext,
  `OJB_CONCRETE_CLASS` text,
  PRIMARY KEY (`ID_INTERNAL`),
  KEY `OID` (`OID`),
  KEY `OID_REMOTE_HOST` (`OID_REMOTE_HOST`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
