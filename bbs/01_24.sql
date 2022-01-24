select * from user_sequences;

insert into members VALUES(1, 1234, 'member1', 'm1@email.com');

commit;

commit;

select * from comments;

select * from reply;

insert into bbs
select bbs_id_seq.nextval, bbs_title, bbs_content, bbs_writer, bbs_image, sysdate, 0 from bbs;

select count(*) from bbs order by 1;

select b.* from
(select rownum rn, a.* from
(select * from bbs order by 1) a)b
where b.rn between 1 and 11; -- 1 page : 1 ~ 10, 2page : 11 ~ 20

