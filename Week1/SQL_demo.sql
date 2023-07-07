use library;

-- CRUD - create, read, update, delete


-- alter table

CREATE TABLE `member` (
  `member_id` smallint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone_num` char(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_joined` date NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- create
insert into member values (1, "John Doe","07324532457", "john@doe.com", now());

insert into member(name, phone_num, email, date_joined) values ("Jane Doe","07324596457", "jane@doe.com", now());

insert into member(name, phone_num, email, date_joined) values ("Jim Doe","07324596243", "jim@doe.com", now()), 
("Jinny Doe","07324596233", "jinny@doe.com", now());


-- read
select * from member;
select name, email from member;
select name as "First and Last Name", email from member;
select name, email from member where member_id =5;
select name, email, phone_num from member where phone_num like "%2";
select name, email, phone_num from member where name in ("John Doe", "Josephine Doe", "Jinny Doe");
select name, email from member order by name desc;


-- update
update member set phone_num="07235344234" where member_id=5;


-- delete
delete from member where member_id=3;



CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(15) NOT NULL,
  `title` varchar(25) NOT NULL,
  `author` varchar(30) NOT NULL,
  `book_desc` varchar(120) DEFAULT NULL,
  `member_id` smallint NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into book values (1, "978-3243-234", "1984", "G. Orwell", "Scary", 1);

insert into book values (2, "978-3213-234", "Jane Eyre", "C. Bronte", "Romantic", 1);

select * from book;

select * from member right outer join book on member.member_id = book.member_id;

select name, email, title, author from member join book on member.member_id = book.member_id;



alter table book modify column member_id smallint;

insert into book values (3, "978-323-124", "Slime", "D. Walliams", "Kids", null);



