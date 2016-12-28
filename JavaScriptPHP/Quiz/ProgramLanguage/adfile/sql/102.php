<h1>Create Table(Customers)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Customers (
CustomerID int NOT NULL AUTO_INCREMENT,
CustomerName varchar(100) NOT NULL,
ContactName varchar(100) NOT NULL,
Address varchar(100) NOT NULL,
City varchar(100) NOT NULL,
PostalCode varchar(100) NOT NULL,
Country varchar(100) NOT NULL,
PRIMARY KEY (CustomerID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
