SET AUTOCOMMIT = 0;

START TRANSACTION;

INSERT INTO EXECUTION_PATH (EXECUTION_PATH,CONTENT_ID,KEY_FUNCTIONALITY,KEY_ROOT_DOMAIN_OBJECT) VALUES ('candidacies/caseHandlingOver23CandidacyIndividualProcess.do?method=showApplicationSubmissionConditions','fc9a8fc8-74a8-42f6-8e4b-fd27d75583aa',1,1)  ;

INSERT INTO CONTENT (EXECUTION_PATH,VISIBLE,KEY_EXECUTION_PATH_VALUE,CONTENT_ID,CREATION_DATE,NAME,TITLE,BODY,DESCRIPTION,NORMALIZED_NAME,KEY_PORTAL,KEY_AVAILABILITY_POLICY,KEY_ROOT_DOMAIN_OBJECT,KEY_CREATOR,OJB_CONCRETE_CLASS) VALUES ('candidacies/caseHandlingOver23CandidacyIndividualProcess.do?method=showApplicationSubmissionConditions',null,2,'b03727af-dab0-49bc-be76-6ba4574eb724','2009-05-04 20:10:41','pt9:submissao','pt21:Submissao Candidatura',null,'pt21:Submissao Candidatura','pt9:submissao',null,null,1,null,'net.sourceforge.fenixedu.domain.functionalities.Functionality')  ;

INSERT INTO NODE (NODE_ORDER,ASCENDING,VISIBLE,CONTENT_ID,KEY_CHILD,KEY_PARENT,KEY_ROOT_DOMAIN_OBJECT,OJB_CONCRETE_CLASS) VALUES (1,1,1,'39c3f7d9-27b3-43d1-a180-6fb101fc1fac:b03727af-dab0-49bc-be76-6ba4574eb724',3,4,1,'net.sourceforge.fenixedu.domain.contents.ExplicitOrderNode')  ;

CREATE TEMPORARY TABLE UUID_TEMP_TABLE(COUNTER integer, UUID varchar(255), FROM_UUID varchar(255));

INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(1,'b03727af-dab0-49bc-be76-6ba4574eb724','fc9a8fc8-74a8-42f6-8e4b-fd27d75583aa') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(2,'fc9a8fc8-74a8-42f6-8e4b-fd27d75583aa','b03727af-dab0-49bc-be76-6ba4574eb724') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(3,'b03727af-dab0-49bc-be76-6ba4574eb724','39c3f7d9-27b3-43d1-a180-6fb101fc1fac:b03727af-dab0-49bc-be76-6ba4574eb724') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(4,'39c3f7d9-27b3-43d1-a180-6fb101fc1fac','39c3f7d9-27b3-43d1-a180-6fb101fc1fac:b03727af-dab0-49bc-be76-6ba4574eb724') ;
ALTER TABLE UUID_TEMP_TABLE ADD INDEX (COUNTER), ADD INDEX (UUID), ADD INDEX (FROM_UUID); 


UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PARENT=CT.ID_INTERNAL WHERE T.KEY_PARENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CHILD=CT.ID_INTERNAL WHERE T.KEY_CHILD=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, EXECUTION_PATH CT set T.KEY_EXECUTION_PATH_VALUE=CT.ID_INTERNAL WHERE T.KEY_EXECUTION_PATH_VALUE=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_INITIAL_CONTENT=CT.ID_INTERNAL WHERE T.KEY_INITIAL_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PORTAL=CT.ID_INTERNAL WHERE T.KEY_PORTAL=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, AVAILABILITY_POLICY CT set T.KEY_AVAILABILITY_POLICY=CT.ID_INTERNAL WHERE T.KEY_AVAILABILITY_POLICY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE AVAILABILITY_POLICY T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CONTENT=CT.ID_INTERNAL WHERE T.KEY_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE EXECUTION_PATH T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
DROP TABLE UUID_TEMP_TABLE;

INSERT INTO NODE (NODE_ORDER,ASCENDING,VISIBLE,CONTENT_ID,KEY_CHILD,KEY_PARENT,KEY_ROOT_DOMAIN_OBJECT,OJB_CONCRETE_CLASS) VALUES (1,1,1,'5c8e9512-0c1a-4841-a1e7-93599c019a71:390bc761-a17a-4d73-9a4e-4195be772d99',5,6,1,'net.sourceforge.fenixedu.domain.contents.ExplicitOrderNode')  ;

INSERT INTO EXECUTION_PATH (EXECUTION_PATH,CONTENT_ID,KEY_FUNCTIONALITY,KEY_ROOT_DOMAIN_OBJECT) VALUES ('candidacies/caseHandlingSecondCycleCandidacyIndividualProcess.do?method=showApplicationSubmissionConditions','940c2820-dcec-4911-bc1e-ac49ac956579',7,1)  ;

INSERT INTO CONTENT (EXECUTION_PATH,VISIBLE,KEY_EXECUTION_PATH_VALUE,CONTENT_ID,CREATION_DATE,NAME,TITLE,BODY,DESCRIPTION,NORMALIZED_NAME,KEY_PORTAL,KEY_AVAILABILITY_POLICY,KEY_ROOT_DOMAIN_OBJECT,KEY_CREATOR,OJB_CONCRETE_CLASS) VALUES ('candidacies/caseHandlingSecondCycleCandidacyIndividualProcess.do?method=showApplicationSubmissionConditions',null,8,'390bc761-a17a-4d73-9a4e-4195be772d99','2009-05-04 20:11:31','pt9:submissao','pt21:Submissao Candidatura',null,'pt21:Submissao Candidatura','pt9:submissao',null,null,1,null,'net.sourceforge.fenixedu.domain.functionalities.Functionality')  ;

CREATE TEMPORARY TABLE UUID_TEMP_TABLE(COUNTER integer, UUID varchar(255), FROM_UUID varchar(255));

INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(5,'390bc761-a17a-4d73-9a4e-4195be772d99','5c8e9512-0c1a-4841-a1e7-93599c019a71:390bc761-a17a-4d73-9a4e-4195be772d99') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(6,'5c8e9512-0c1a-4841-a1e7-93599c019a71','5c8e9512-0c1a-4841-a1e7-93599c019a71:390bc761-a17a-4d73-9a4e-4195be772d99') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(7,'390bc761-a17a-4d73-9a4e-4195be772d99','940c2820-dcec-4911-bc1e-ac49ac956579') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(8,'940c2820-dcec-4911-bc1e-ac49ac956579','390bc761-a17a-4d73-9a4e-4195be772d99') ;
ALTER TABLE UUID_TEMP_TABLE ADD INDEX (COUNTER), ADD INDEX (UUID), ADD INDEX (FROM_UUID); 


UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PARENT=CT.ID_INTERNAL WHERE T.KEY_PARENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CHILD=CT.ID_INTERNAL WHERE T.KEY_CHILD=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, EXECUTION_PATH CT set T.KEY_EXECUTION_PATH_VALUE=CT.ID_INTERNAL WHERE T.KEY_EXECUTION_PATH_VALUE=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_INITIAL_CONTENT=CT.ID_INTERNAL WHERE T.KEY_INITIAL_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PORTAL=CT.ID_INTERNAL WHERE T.KEY_PORTAL=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, AVAILABILITY_POLICY CT set T.KEY_AVAILABILITY_POLICY=CT.ID_INTERNAL WHERE T.KEY_AVAILABILITY_POLICY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE AVAILABILITY_POLICY T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CONTENT=CT.ID_INTERNAL WHERE T.KEY_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE EXECUTION_PATH T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
DROP TABLE UUID_TEMP_TABLE;

INSERT INTO NODE (NODE_ORDER,ASCENDING,VISIBLE,CONTENT_ID,KEY_CHILD,KEY_PARENT,KEY_ROOT_DOMAIN_OBJECT,OJB_CONCRETE_CLASS) VALUES (1,1,1,'630e2bf2-2477-48de-82ce-690b51bd8410:e544175a-bfce-4be7-a905-40a9812b3c67',9,10,1,'net.sourceforge.fenixedu.domain.contents.ExplicitOrderNode')  ;

INSERT INTO CONTENT (KEY_FUNCTIONALITY,CONTENT_ID,CREATION_DATE,NAME,TITLE,BODY,DESCRIPTION,NORMALIZED_NAME,KEY_PORTAL,KEY_AVAILABILITY_POLICY,KEY_ROOT_DOMAIN_OBJECT,KEY_CREATOR,OJB_CONCRETE_CLASS) VALUES (11,'e544175a-bfce-4be7-a905-40a9812b3c67','2009-05-04 20:12:00',null,null,null,null,null,null,null,1,null,'net.sourceforge.fenixedu.domain.contents.FunctionalityCall')  ;

CREATE TEMPORARY TABLE UUID_TEMP_TABLE(COUNTER integer, UUID varchar(255), FROM_UUID varchar(255));

INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(9,'e544175a-bfce-4be7-a905-40a9812b3c67','630e2bf2-2477-48de-82ce-690b51bd8410:e544175a-bfce-4be7-a905-40a9812b3c67') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(10,'630e2bf2-2477-48de-82ce-690b51bd8410','630e2bf2-2477-48de-82ce-690b51bd8410:e544175a-bfce-4be7-a905-40a9812b3c67') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(11,'b03727af-dab0-49bc-be76-6ba4574eb724','e544175a-bfce-4be7-a905-40a9812b3c67') ;
ALTER TABLE UUID_TEMP_TABLE ADD INDEX (COUNTER), ADD INDEX (UUID), ADD INDEX (FROM_UUID); 


UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PARENT=CT.ID_INTERNAL WHERE T.KEY_PARENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CHILD=CT.ID_INTERNAL WHERE T.KEY_CHILD=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, EXECUTION_PATH CT set T.KEY_EXECUTION_PATH_VALUE=CT.ID_INTERNAL WHERE T.KEY_EXECUTION_PATH_VALUE=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_INITIAL_CONTENT=CT.ID_INTERNAL WHERE T.KEY_INITIAL_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PORTAL=CT.ID_INTERNAL WHERE T.KEY_PORTAL=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, AVAILABILITY_POLICY CT set T.KEY_AVAILABILITY_POLICY=CT.ID_INTERNAL WHERE T.KEY_AVAILABILITY_POLICY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE AVAILABILITY_POLICY T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CONTENT=CT.ID_INTERNAL WHERE T.KEY_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE EXECUTION_PATH T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
DROP TABLE UUID_TEMP_TABLE;

INSERT INTO NODE (NODE_ORDER,ASCENDING,VISIBLE,CONTENT_ID,KEY_CHILD,KEY_PARENT,KEY_ROOT_DOMAIN_OBJECT,OJB_CONCRETE_CLASS) VALUES (1,1,1,'d3d92169-07ce-40c5-bfad-7b90dab2714b:55767eba-3dcb-4fba-9277-0b2855654ed3',12,13,1,'net.sourceforge.fenixedu.domain.contents.ExplicitOrderNode')  ;

INSERT INTO CONTENT (KEY_FUNCTIONALITY,CONTENT_ID,CREATION_DATE,NAME,TITLE,BODY,DESCRIPTION,NORMALIZED_NAME,KEY_PORTAL,KEY_AVAILABILITY_POLICY,KEY_ROOT_DOMAIN_OBJECT,KEY_CREATOR,OJB_CONCRETE_CLASS) VALUES (14,'55767eba-3dcb-4fba-9277-0b2855654ed3','2009-05-04 20:12:19',null,null,null,null,null,null,null,1,null,'net.sourceforge.fenixedu.domain.contents.FunctionalityCall')  ;

CREATE TEMPORARY TABLE UUID_TEMP_TABLE(COUNTER integer, UUID varchar(255), FROM_UUID varchar(255));

INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(12,'55767eba-3dcb-4fba-9277-0b2855654ed3','d3d92169-07ce-40c5-bfad-7b90dab2714b:55767eba-3dcb-4fba-9277-0b2855654ed3') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(13,'d3d92169-07ce-40c5-bfad-7b90dab2714b','d3d92169-07ce-40c5-bfad-7b90dab2714b:55767eba-3dcb-4fba-9277-0b2855654ed3') ;
INSERT INTO UUID_TEMP_TABLE(COUNTER,UUID,FROM_UUID) VALUES(14,'390bc761-a17a-4d73-9a4e-4195be772d99','55767eba-3dcb-4fba-9277-0b2855654ed3') ;
ALTER TABLE UUID_TEMP_TABLE ADD INDEX (COUNTER), ADD INDEX (UUID), ADD INDEX (FROM_UUID); 


UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PARENT=CT.ID_INTERNAL WHERE T.KEY_PARENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE NODE T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CHILD=CT.ID_INTERNAL WHERE T.KEY_CHILD=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, EXECUTION_PATH CT set T.KEY_EXECUTION_PATH_VALUE=CT.ID_INTERNAL WHERE T.KEY_EXECUTION_PATH_VALUE=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_INITIAL_CONTENT=CT.ID_INTERNAL WHERE T.KEY_INITIAL_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_PORTAL=CT.ID_INTERNAL WHERE T.KEY_PORTAL=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE CONTENT T, UUID_TEMP_TABLE UIT, AVAILABILITY_POLICY CT set T.KEY_AVAILABILITY_POLICY=CT.ID_INTERNAL WHERE T.KEY_AVAILABILITY_POLICY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE AVAILABILITY_POLICY T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_CONTENT=CT.ID_INTERNAL WHERE T.KEY_CONTENT=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
UPDATE EXECUTION_PATH T, UUID_TEMP_TABLE UIT, CONTENT CT set T.KEY_FUNCTIONALITY=CT.ID_INTERNAL WHERE T.KEY_FUNCTIONALITY=UIT.COUNTER AND T.CONTENT_ID = UIT.FROM_UUID AND CT.CONTENT_ID=UIT.UUID;
DROP TABLE UUID_TEMP_TABLE;



COMMIT;
