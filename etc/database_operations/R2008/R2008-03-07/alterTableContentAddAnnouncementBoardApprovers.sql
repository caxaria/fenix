ALTER TABLE CONTENT ADD APPROVED tinyint(1) default '0';
ALTER TABLE CONTENT ADD APPROVERS text;
UPDATE CONTENT SET CONTENT.APPROVED = 1 WHERE CONTENT.OJB_CONCRETE_CLASS LIKE "net.sourceforge.fenixedu.domain.messaging.Announcement";