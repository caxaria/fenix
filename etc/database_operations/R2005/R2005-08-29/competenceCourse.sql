SELECT CONCAT("INSERT INTO COMPETENCE_COURSE VALUES (NULL, 1,\"", CURRICULAR_COURSE.CODE,"\",\"", REPLACE(CURRICULAR_COURSE.NAME,'"',''),"\",NULL);") AS "" 
FROM 
CURRICULAR_COURSE INNER JOIN DEGREE_CURRICULAR_PLAN ON CURRICULAR_COURSE.KEY_DEGREE_CURRICULAR_PLAN = DEGREE_CURRICULAR_PLAN.ID_INTERNAL INNER JOIN DEGREE ON DEGREE_CURRICULAR_PLAN.KEY_DEGREE = DEGREE.ID_INTERNAL WHERE DEGREE.TYPE_DEGREE = "DEGREE" GROUP BY CURRICULAR_COURSE.CODE, CURRICULAR_COURSE.NAME;
