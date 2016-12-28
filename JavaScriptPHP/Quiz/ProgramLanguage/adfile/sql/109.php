<h1>Create Table(Suppliers)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Suppliers (
SupplierID int NOT NULL AUTO_INCREMENT,
SupplierName varchar(100) NOT NULL,
ContactName varchar(100) NOT NULL,
Address varchar(100) NOT NULL,
City varchar(100) NOT NULL,
PostalCode varchar(100) NOT NULL,
Country	varchar(100) NOT NULL,
Phone varchar(100) NOT NULL,
PRIMARY KEY(SupplierID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
