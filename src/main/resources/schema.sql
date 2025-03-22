CREATE TABLE IF NOT EXISTS users (
  username varchar(50) NOT NULL,
  password varchar(132) NOT NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY (username));



CREATE TABLE IF NOT EXISTS authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL);



CREATE TABLE IF NOT EXISTS notes (
  note_id int NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  note varchar(500) NOT NULL,
  PRIMARY KEY (note_id));



