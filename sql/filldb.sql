# Filling up RibbonSystem database structure;
# Data base structure version = 2;

#CHANGE DB;
USE ribbon;

#USERS CREATION
#USER_ID = 1
INSERT INTO User (login,description,passw,crt_date,log_date,is_admin,is_enabled) VALUES("root", "System administrator", MD5('root'), NOW(), NOW(), TRUE, TRUE);
#USER_ID = 2
INSERT INTO User (login,description,passw,crt_date,log_date,is_admin,is_enabled) VALUES("test", "Test user", MD5('test'), NOW(), NOW(), FALSE, TRUE);

#GROUP CREATION
#GROUP_ID = 1
INSERT INTO Groups (name,description) VALUES("test", "Test group");

#RELATION CREATION
#LINK test USER TO test GROUP AND ENABLE IT
INSERT INTO UserGroupsRel (user_id,group_id,is_enabled) VALUES (2, 1, TRUE);

#CREATER DIRECTORIS
#DIR_ID = 1
INSERT INTO Directory (path,description,is_hidden) VALUES ("Система", NULL, FALSE);
#DIR_ID = 2
INSERT INTO Directory (path,description,is_hidden) VALUES ("Система.Тест", "Тестовий напрямок випуску", FALSE);

#CREATE PERMISSIONS
#ADD PERMISSION FOR DIRECTORY FOR ALL TO POST AND READ
INSERT INTO Permission (dir_id,group_perm,all_perm,may_read,may_post,may_admin) VALUES (1,TRUE,TRUE,TRUE,TRUE,FALSE);

#POST ONE MESSAGE
INSERT INTO Message (header,post_date,auth_id,is_urgent,body) VALUES ("Тестове повідомлення", NOW(), 1, FALSE, "Це тестове повідомлення системи обробки новиних повідомленнь.");