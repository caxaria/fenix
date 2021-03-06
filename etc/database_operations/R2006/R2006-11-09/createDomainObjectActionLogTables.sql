CREATE TABLE `DOMAIN_OBJECT_ACTION_LOG` (
  `ID_INTERNAL` int(11) unsigned NOT NULL auto_increment,
  `PERSON_USERNAME` varchar(100) NOT NULL,
  `KEY_PERSON` int(11) NOT NULL,      
  `KEY_DOMAIN_OBJECT` int(11) unsigned NOT NULL,
  `DOMAIN_OBJECT_CLASS_NAME` varchar(255) NOT NULL, 
  `INSTANT` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `ACTION` longtext NOT NULL,       
  `KEY_ROOT_DOMAIN_OBJECT` int(11) NOT NULL default '1',  
  PRIMARY KEY  (`ID_INTERNAL`),
  KEY `KEY_PERSON` (`KEY_PERSON`),
  KEY `KEY_ROOT_DOMAIN_OBJECT` (`KEY_ROOT_DOMAIN_OBJECT`)
) ENGINE=InnoDB;

CREATE TABLE `DOMAIN_OBJECT_ACTION_LOG_ENTRY` (
  `ID_INTERNAL` int(11) unsigned NOT NULL auto_increment,
  `KEY_DOMAIN_OBJECT_ACTION_LOG` int(11) NOT NULL,    
  `NAME` longtext NOT NULL,       
  `VALUE` longtext,       
  `KEY_ROOT_DOMAIN_OBJECT` int(11) NOT NULL default '1',  
  PRIMARY KEY  (`ID_INTERNAL`),
  KEY `KEY_DOMAIN_OBJECT_ACTION_LOG` (`KEY_DOMAIN_OBJECT_ACTION_LOG`),
  KEY `KEY_ROOT_DOMAIN_OBJECT` (`KEY_ROOT_DOMAIN_OBJECT`)
) ENGINE=InnoDB;

insert into ROLE (ROLE_TYPE, PORTAL_SUB_APPLICATION, PAGE, PAGE_NAME_PROPERTY) values ("SPACE_MANAGER_SUPER_USER", "/spaceManagerSuperUser", "/index.do", "portal.spaceManagerSuperUser");