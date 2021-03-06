INSERT INTO ROLE (ROLE_TYPE, OJB_CONCRETE_CLASS) VALUES('PUBLIC_RELATIONS_OFFICE','net.sourceforge.fenixedu.domain.Role');
SELECT @xpto:=null;
SELECT @xpto:=ROOT_DOMAIN_OBJECT.OID FROM ROOT_DOMAIN_OBJECT;
UPDATE ROLE set OID_ROOT_DOMAIN_OBJECT = @xpto;
SELECT @xpto:=null;
SELECT @xpto:=FF$DOMAIN_CLASS_INFO.DOMAIN_CLASS_ID from FF$DOMAIN_CLASS_INFO where FF$DOMAIN_CLASS_INFO.DOMAIN_CLASS_NAME = 'net.sourceforge.fenixedu.domain.Role';
UPDATE ROLE SET OID = (@xpto << 32) + ID_INTERNAL where ROLE_TYPE != "RESOURCE_ALLOCATION_MANAGER";
