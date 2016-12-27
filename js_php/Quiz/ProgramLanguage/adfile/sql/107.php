<h1>Create Table(Products)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Products (
ProductID int NOT NULL AUTO_INCREMENT,
ProductName varchar(100) NOT NULL,
SupplierID int NOT NULL,
CategoryID int NOT NULL,
Unit varchar(100) NOT NULL,
Price double NOT NULL,
PRIMARY KEY(ProductID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
