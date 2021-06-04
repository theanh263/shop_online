use shoponline;
insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into user(username,password,fullname,status, roleid) values('admin','admin','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('user','user','nguyen van a',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','nguyen van b',1,2);
