use webfinal;
create table Member
( id int primary key auto_increment,
Firstname char(50),
Lastname char(50),
Username char(50),
Password char(30),
Phone char(50),
Email char(50),
Description varchar(200),
CreateDate datetime,
UpdateTime datetime
);

create table Content
(
id int primary key auto_increment,  
Title char(200),
Brief char(150),
Content text(1000),
CreateDate datetime,
UpdateTime datetime,
Sort char(20),
AuthorId int
);
drop table Member;
drop table Content;
INSERT INTO Content (CreateDate, UpdateTime, AuthorId) VALUES  ( NOW(), LOCALTIME(), 5);
UPDATE Content SET Title="possesion play", UpdateTime = NOW() WHERE id = 3 AND AuthorId = 5;
DELETE FROM Content WHERE id = 4 AND AuthorId = 5;
SELECT * FROM Member;
SELECT * FROM Content;
SELECT * FROM Content WHERE id = 5;