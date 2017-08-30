/* This project uses Mysql database for storing and retreving information */
/* I have used a table for storing the details of the user in the mysql database */

| User  | CREATE TABLE `User` (
  `name` varchar(30) DEFAULT NULL,
  `DateofBirth` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Mail` varchar(30) NOT NULL,
  `Password` varchar(10) DEFAULT NULL,
  `Education` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |

