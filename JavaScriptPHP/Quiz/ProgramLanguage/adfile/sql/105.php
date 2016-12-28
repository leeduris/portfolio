<h1>Create Table(OrderDetails)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE OrderDetails (
OrderDetailID int NOT NULL AUTO_INCREMENT,
OrderID int NOT NULL,
ProductID int NOT NULL,
Quantity int NOT NULL,
PRIMARY KEY(OrderDetailID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
