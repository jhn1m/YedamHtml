create table reply(
    reply_id number primary key, -- 댓글 번호
    reply_content varchar2(1000), -- 댓글 내용
    reply_writer varchar2(100), -- 댓글 작성자
    reply_date date, -- 댓글 작성일시
    bbs_id number -- 원본 글 번호
);

create sequence reply_id_seq;

select * from reply order by 1;

insert into reply 
values(reply_id_seq.nextval, '첫번째 댓글','user01',sysdate,4);

commit;