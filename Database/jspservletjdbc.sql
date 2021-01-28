CREATE  DATABASE jspservletjdbc
GO
USE jspservletjdbc

CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY IDENTITY,
  name NVARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate DATETIME DEFAULT GETDATE(),
  modifieddate DATETIME DEFAULT GETDATE(),
  createdby NVARCHAR(255) NULL,
  modifiedby NVARCHAR(255) NULL
)


CREATE TABLE users
(
  id bigint NOT NULL PRIMARY KEY identity,
  username NVARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname NVARCHAR(150) NULL,
  status int NOT NULL,
  roleid bigint NOT NULL,
  createddate DATETIME DEFAULT GETDATE(),
  modifieddate DATETIME DEFAULT GETDATE(),
  createdby NVARCHAR(255) NULL,
  modifiedby NVARCHAR(255) NULL
)


ALTER TABLE users ADD CONSTRAINT fk_users_role FOREIGN KEY (roleid) REFERENCES role(id)

CREATE TABLE news (
  id bigint NOT NULL PRIMARY KEY IDENTITY,
  title NVARCHAR(255) NULL,
  thumbnail VARCHAR(255) NULL,
  shortdescription TEXT NULL,
  content TEXT NULL,
  categoryid bigint NOT NULL,
  createddate DATETIME DEFAULT GETDATE(),
  modifieddate DATETIME DEFAULT GETDATE(),
  createdby NVARCHAR(255) NULL,
  modifiedby NVARCHAR(255) NULL
)

CREATE TABLE category (
  id bigint NOT NULL PRIMARY KEY IDENTITY,
  name NVARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate DATETIME DEFAULT GETDATE(),
  modifieddate DATETIME DEFAULT GETDATE(),
  createdby NVARCHAR(255) NULL,
  modifiedby NVARCHAR(255) NULL
)

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id)

CREATE TABLE comment (
  id bigint NOT NULL PRIMARY KEY IDENTITY,
  content TEXT NOT NULL,
  userId bigint NOT NULL,
  new_id bigint NOT NULL,
  createddate DATETIME DEFAULT GETDATE(),
  modifieddate DATETIME DEFAULT GETDATE(),
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
)

ALTER TABLE comment ADD CONSTRAINT fk_comment_users FOREIGN KEY (userId) REFERENCES users(id)
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (new_id) REFERENCES news(id)

insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into users(username,password,fullname,status, roleid) values('admin','123456','admin',1,1);
insert into users(username,password,fullname,status, roleid) values('nguyenvana','123456','nguyen van a',1,2);
insert into users(username,password,fullname,status, roleid) values('nguyenvanb','123456','nguyen van b',1,2);
SELECT @@VERSION;
SELECT  *FROM dbo.category

