select * from member;

select id,password,name,role from member where id = 'user1' and password = 'user1';
select id,password,name,role,reg_date as regDate from member ;

insert into member(id,password,name,role,reg_date) values('user4','user4','유저4','USER',sysdate);

insert into post values(POST_SEQ.nextval,'제목 테스트1','내용 테스트1',sysdate,'1');

insert into blog values('user1','user1의 블로그입니다.','활성');
insert into blog values('user2','user2의 블로그입니다.','활성');
insert into blog values('user3','user3의 블로그입니다.','활성');
commit;
insert into CATEGORY values(CATEGORY_SEQ.nextval,'Java11','Programming',sysdate,'user1');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C11','Programming',sysdate,'user1');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C++11','Programming',sysdate,'user1');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'C#11','Programming',sysdate,'user1');
insert into CATEGORY values(CATEGORY_SEQ.nextval,'JavaScript11','Programming',sysdate,'user1');
select * from post;
select * from category;
insert into POST values(POST_SEQ.nextval,'user1의 Test Java Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,6);
insert into POST values(POST_SEQ.nextval,'user1의 Test C Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,7);
insert into POST values(POST_SEQ.nextval,'user1의 Test C++ Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,8);
insert into POST values(POST_SEQ.nextval,'user1의 Test C# Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,9);
insert into POST values(POST_SEQ.nextval,'user1의 Test JavaScript Title1 입니다.','User1의 TestTitle의 Content입니다.',sysdate,10);

select no, title, content, reg_date as regDate, category_no as categoryNo from post;
select no,title, content, reg_date as regDate  from post;
select no, title, content, reg_date as regDate
		from post
		where category_no in (
								select category_no
								from category
								where blog_id = 'user1')
		order by no desc;
select a.no, a.title, a.content, a.reg_date as regDate

from post a 
where a.category_no in ( 
						 select b.no 
						 from category b 
						 where b.blog_id = 'user2' ) 
order by a.no desc;
select a.no, a.title, a.content, a.reg_date as regDate, a.category_no categoryNo from post a where a.category_no in ( select b.no from category b where b.blog_id = 'user2' ) order by a.no desc;
select * from category where blog_id = 'user2';
select * from post;
select content, post_no as postNo ,member_id as memberId, reg_date as regDate from comments;

select id, title from blog where title LIKE '%user2%';
select id, title, status from blog where id = 'user1';

insert into comments values(COMMENTS_SEQ.nextval,'title 2의 세번째 댓글입니다.',2,'user3',sysdate);

select content, post_no as postNo, member_id as memberId, reg_date as regDate from comments;

select name, description, reg_date as regDate, blog_id as blogId from category;

select * from category where blog_id = 'user1';

select * from category;


select no, name, description, reg_date as regDate from category where blog_id = 'user1';

select * from blog;


update blog set title=':var1', status=':var2' where id=':var3';

update blog set title='user1의 title test입니다', status='활성 활성 활성' where id='user1';
update member set id='user6', password='user6' where name='유저5';
select * from member;

select * from post;
select * from comments;

select no, title, content, reg_date as regDate from post where no = 1;
select content, member_id as memberId, reg_date as regDate from comments where post_no = 1;
select * from category;

update category set name ='옷',description='1000만벌' where no ='19';
insert into category values(CATEGORY_SEQ.nextval,'Test','TestCategory',sysdate,'user1');

insert into post values(POST_SEQ.nextval,'제목 제목 제목 제목','내용 내용 내용내용',sysdate,11);

ALTER TABLE WEBDB.BLOG
   MODIFY (STATUS VARCHAR2 (100));


commit;