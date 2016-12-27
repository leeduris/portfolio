<h1>Create Table(Categories)</h1>
CREATE TABLE table_name
(
column_name1 data_type(size),
column_name2 data_type(size),
column_name3 data_type(size),
....
);








CREATE TABLE Categories (
CategoryID int NOT NULL AUTO_INCREMENT,
CategoryName varchar(100) NOT NULL,
Description text NOT NULL,
PRIMARY KEY(CategoryID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
