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

insert into POST values(POST_SEQ.nextval,'user2의 Test Java Title2 입니다.','User2의 TestTitle의 Content입니다.',sysdate,6);
insert into POST values(POST_SEQ.nextval,'user2의 Test C Title2 입니다.','User2의 TestTitle의 Content입니다.',sysdate,7);
insert into POST values(POST_SEQ.nextval,'user2의 Test C++ Title2 입니다.','User2의 TestTitle의 Content입니다.',sysdate,8);
insert into POST values(POST_SEQ.nextval,'user2의 Test C# Title2 입니다.','User2의 TestTitle의 Content입니다.',sysdate,9);
insert into POST values(POST_SEQ.nextval,'user2의 Test JavaScript Title2 입니다.','User2의 TestTitle의 Content입니다.',sysdate,10);

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
select a.no, a.title, a.content, a.reg_date as regDate from post a where a.category_no in ( select b.no from category b where b.blog_id = 'user2' ) order by a.no desc;
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

select * from blog;
select * from member;
select * from post;
select * from comments;

select no, title, content, reg_date as regDate from post where no = 1;
select content, member_id as memberId, reg_date as regDate from comments where post_no = 1;



commit;