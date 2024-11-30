drop table if exists member;
create table member(
	loginId varchar(8) primary key,
	name varchar(20) not null,
	phone varchar(10) not null,
	email varchar(20) 
)