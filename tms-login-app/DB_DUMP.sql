# MySQL Scripts

# Show all databases

show databases;

# Use database
use sys;

# Create role table script

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Create user table script
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Create user_role table script

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `UK_it77eq964jhfqtu54081ebtin` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6n` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3x` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Insert script
use sys;

INSERT INTO `role` (`role_id`, `role`) VALUES (1,'ADMIN');
INSERT INTO `role` (`role_id`, `role`) VALUES (2,'USER');

INSERT INTO `user` (`user_id`, `active`, `email`, `name`, `password`)
VALUES (1,1,'admin@gmail.com','Pranab Kumar Sahoo','123'),
	(2,1,'user@gmail.com','Dhiren Kumar Chhotaray','345');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1,1);