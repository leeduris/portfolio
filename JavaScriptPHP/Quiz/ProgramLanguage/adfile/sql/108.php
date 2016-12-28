<h1>Create Table(Shippers)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Shippers (
ShipperID int NOT NULL AUTO_INCREMENT,
ShipperName varchar(100) NOT NULL,
Phone varchar(100) NOT NULL,
PRIMARY KEY(ShipperID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
