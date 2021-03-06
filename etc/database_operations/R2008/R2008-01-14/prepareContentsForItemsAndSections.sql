 alter table CONTENT add column SHOW_NAME tinyint(1), 
 add column KEY_SITE int(11),
 add column  ALTERNATIVE_SITE                         varchar(255)     , 
 add column  MAIL                                     varchar(50)      , 
 add column  INITIAL_STATEMENT                        text             , 
 add column  INTRODUCTION                             text             , 
 add column  STYLE                                    varchar(255)     , 
 add column  DYNAMIC_MAIL_DISTRIBUTION                int(11)          , 
 add column  LESSON_PLANNING_AVAILABLE                tinyint(1)       , 
 add column  KEY_TEMPLATE                             int(11)          , 
 add column  SITE_TYPE                                varchar(255)     , 
 add column  KEY_PERSON                               int(11)          , 
 add column  ACTIVATED                                tinyint(1)       , 
 add column  SHOW_UNIT                                tinyint(1)       , 
 add column  SHOW_PHOTO                               tinyint(1)       , 
 add column  SHOW_EMAIL                               tinyint(1)       , 
 add column  SHOW_CATEGORY                            tinyint(1)       , 
 add column  SHOW_ALTERNATIVE_HOMEPAGE                tinyint(1)       , 
 add column  SHOW_TELEPHONE                           tinyint(1)       , 
 add column  SHOW_WORK_TELEPHONE                      tinyint(1)       , 
 add column  SHOW_MOBILE_TELEPHONE                    tinyint(1)       , 
 add column  SHOW_ACTIVE_STUDENT_CURRICULAR_PLANS     tinyint(1)       , 
 add column  SHOW_ALUMNI_DEGREES                      tinyint(1)       , 
 add column  SHOW_CURRENT_EXECUTION_COURSES           tinyint(1)       , 
 add column  SHOW_CURRENT_ATTENDING_EXECUTION_COURSES tinyint(1)       , 
 add column  SHOW_RESEARCH_UNIT_HOMEPAGE              tinyint(1)       , 
 add column  RESEARCH_UNIT                            longtext         , 
 add column  RESEARCH_UNIT_HOMEPAGE                   varchar(250)     , 
 add column  SHOW_INTERESTS                           tinyint(1)       , 
 add column  SHOW_PATENTS                             tinyint(1)       , 
 add column  SHOW_PUBLICATIONS                        tinyint(1)       , 
 add column  KEY_DEGREE                               int(11)          , 
 add column  KEY_UNIT                                 int(11)          , 
 add column  SHOW_PARTICIPATIONS                      tinyint(1)       , 
 add column  KEY_LOGO                                 int(11)          , 
 add column  PERSONALIZED_LOGO                        tinyint(1)       , 
 add column  SHOW_BANNER                              tinyint(1)       , 
 add column  SHOW_INTRODUCTION                        tinyint(1)       , 
 add column  SHOW_ANNOUNCEMENTS                       tinyint(1)       , 
 add column  SHOW_EVENTS                              tinyint(1)       , 
 add column  LAYOUT                                   varchar(50)      , 
 add column  SIDE_BANNER                              longtext         , 
 add column  SHOW_FLAGS                               tinyint(1)       , 
 add column  SHOW_INSTITUTION_LOGO                    tinyint(1)       , 
 add column  KEY_MODULE                               int(11)          , 
 add column  SHOW_PRIZES                              tinyint(1)       ,
 add index (KEY_TEMPLATE), 
 add index (KEY_MODULE);

