select id,password,name,role from member where id = 'user1' and password = 'user1';
select id,password,name,role,reg_date as regDate from member ;

insert into member(id,password,name,role,reg_date) values('user4','user4','유저4','USER',sysdate);

commit;