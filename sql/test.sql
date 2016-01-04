select id,password,name,role from member where id = 'user1' and password = 'user1';
select id,password,name,role,reg_date as regDate from member ;

insert into member(id,password,name,role,reg_date) values('user4','user4','유저4','USER',sysdate);

insert into post values(POST_SEQ.nextval,'제목 테스트1','내용 테스트1',sysdate,'1');

insert into blog values('user1','user1의 블로그입니다.','활성');
insert into blog values('user4','user4의 블로그입니다.','활성');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'Java','Programming',sysdate,'user2');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C','Programming',sysdate,'user2');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C++','Programming',sysdate,'user2');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C#','Programming',sysdate,'user2');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'JavaScript','Programming',sysdate,'user2');

insert into POST values(POST_SEQ.nextval,'user1의 Test Java Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,1);
insert into POST values(POST_SEQ.nextval,'user1의 Test C Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,2);
insert into POST values(POST_SEQ.nextval,'user1의 Test C++ Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,3);
insert into POST values(POST_SEQ.nextval,'user1의 Test C# Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,4);
insert into POST values(POST_SEQ.nextval,'user1의 Test JavaScript Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,5);


select title, content, reg_date as regDate  from post;


select content, post_no as postNo ,member_id as memberId, reg_date as regDate from comments;


insert into comments values(COMMENTS_SEQ.nextval,'title 2의 세번째 댓글입니다.',2,'user3',sysdate);

select content, post_no as postNo, member_id as memberId, reg_date as regDate from comments;

select name, description, reg_date as regDate, blog_id as blogId from category;

select * from category;
select * from blog;
select * from member;
select * from post;
select * from comments;


commit;