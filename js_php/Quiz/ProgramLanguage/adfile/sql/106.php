<h1>Create Table(Orders)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Orders (
OrderID int NOT NULL AUTO_INCREMENT,
CustomerID int NOT NULL,
EmployeeID int NOT NULL,
OrderDate date NOT NULL,
ShipperID int NOT NULL,
PRIMARY KEY(OrderID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
