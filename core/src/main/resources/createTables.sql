create database Demo;
use Demo;
create table expenseRecords(uid varchar(5), type varchar(20), cost decimal(6,2));
load data local infile "/Users/yguan/Git/Demo/core/src/main/resources/expenseRecords.txt" into table expenseRecords;
select * from expenseRecords;

create table employeeInfo(uid varchar(5), uname varchar(20), exp decimal(3,1));
load data local infile "/Users/yguan/Git/Demo/core/src/main/resources/employeeInfo.txt" into table EmployeeInfo;
select * from employeeInfo;