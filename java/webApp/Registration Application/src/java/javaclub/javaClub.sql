/*
 * Document   : All SQL statements used for this assignment.
 * Created on : July 27, 2016
 * Updated on : July 27, 2016
 * Author     : Sung Woo Lee (leeduris@gmail.com)
 */
USE ejd;

DROP TABLE IF EXISTS `jcuser`;

CREATE TABLE `jcUser` (
`id` VARCHAR(25) NOT NULL PRIMARY KEY,
`password` VARCHAR(128) NOT NULL,
`firstName` VARCHAR(25) NOT NULL,
`lastName` VARCHAR(50) NOT NULL,
`email` VARCHAR(50) NOT NULL
) ENGINE=InnoDB;


