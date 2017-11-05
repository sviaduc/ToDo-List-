-- mysql -u root -p < tododb.sql
-- Command on command line to pipe in this file.
DROP DATABASE IF EXISTS tododb;
CREATE DATABASE tododb;

USE tododb;

CREATE TABLE `user` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `email` varchar(255) NOT NULL,
      `password` varchar(255) NOT NULL,
      PRIMARY KEY (`id`)
);

CREATE TABLE `todo` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `task` varchar(255) NOT NULL,
      `description` text,
      `completed` tinyint(1) DEFAULT 0,
      `user_id` int(11) NOT NULL,
      `due_date` varchar(50),
      `completed_date` varchar(50),
      `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
      PRIMARY KEY (`id`),
      FOREIGN KEY (`user_id`)
            REFERENCES `user` (`id`)
);


INSERT INTO `user` (email,password) VALUES ('test@test.com', 'test');
INSERT INTO `todo` (task,user_id) VALUES ('Get Milk', 1);
