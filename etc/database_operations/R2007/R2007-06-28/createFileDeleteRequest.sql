CREATE TABLE `DELETE_FILE_REQUEST` (
  `ID_INTERNAL` int(11) unsigned NOT NULL auto_increment,
  `EXTERNAL_STORAGE_IDENTIFICATION` varchar(255) NOT NULL,
  `REQUESTOR_IST_USERNAME` varchar(255) NOT NULL,
  `DELETE_ITEM` tinyint(1) NOT NULL DEFAULT '1',
  `KEY_ROOT_DOMAIN_OBJECT` int(11) NOT NULL default '1',
  PRIMARY KEY  (`ID_INTERNAL`)
) ENGINE=InnoDB;

CREATE TABLE `DELETE_FILE_LOG` (
  `ID_INTERNAL` int(11) unsigned NOT NULL auto_increment,
  `EXTERNAL_STORAGE_IDENTIFICATION` varchar(255) NOT NULL,
  `REQUESTOR_IST_USERNAME` varchar(255) NOT NULL,
  `REQUEST_TIME` datetime,
  `KEY_ROOT_DOMAIN_OBJECT` int(11) NOT NULL default '1',
  PRIMARY KEY  (`ID_INTERNAL`)
) ENGINE=InnoDB;

