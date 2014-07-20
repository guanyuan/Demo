drop table expenseRecords if exists;
drop table employeeInfo if exists;
create table expenseRecords(uid varchar(5), type varchar(20), cost decimal(6,2));
create table employeeInfo(uid varchar(5), uname varchar(20), exp decimal(3,1));
