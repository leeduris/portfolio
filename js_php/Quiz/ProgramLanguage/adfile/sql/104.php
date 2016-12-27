<h1>Create Table(Employees)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Employees (
EmployeeID int NOT NULL AUTO_INCREMENT,
LastName varchar(100) NOT NULL,
FirstName varchar(100) NOT NULL,
BirthDate date NOT NULL,
Photo	blob,
Notes text,
PRIMARY KEY(EmployeeID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
