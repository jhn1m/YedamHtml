CREATE TABLE comments(
    id VARCHAR2(10),
    name VARCHAR2(100),
    content VARCHAR2(300)
);

CREATE TABLE faq(
    id VARCHAR2(10),
    name VARCHAR2(100),
    content VARCHAR2(300),
    create_date DATE
);

CREATE TABLE id_repository(
    value NUMBER,
    name VARCHAR2(30)
);

-- 글 등록
INSERT INTO id_repository VALUES(1, 'COMMENT');
INSERT INTO id_repository VALUES(1, 'FAQ');

SELECT VALUE FROM id_repository WHERE name = 'COMMENT';

-- 1
INSERT INTO COMMENTS VALUES(1, 'user1', 'sample content');
INSERT INTO COMMENTS VALUES(2, 'user2', 'sample content2');


-- 2번으로 변경
UPDATE id_repository SET VALUE = 2 + 1 WHERE name = 'COMMENT';

-- FAQ
SELECT value FROM id_repository WHERE name = 'FAQ';
INSERT INTO faq VALUES(1, 'admin', 'faq공지', sysdate);
INSERT INTO faq VALUES(2, 'admin', 'faq공지2', sysdate);
UPDATE id_repository SET VALUE = 2 + 1 WHERE NAME = 'FAQ';


-- 1/18
CREATE table bbs(
    bbs_id NUMBER PRIMARY KEY,
    bbs_title varchar2(100),
    bbs_content varchar2(1000),
    bbs_writer varchar2(100),
    bbs_image VARCHAR2(100),
    bbs_create_date date,
    bbs_hit number
);

insert into bbs values(bbs_id_seq.nextval,'제목2', '내용2', 'user02', 'test.jpg', sysdate, 0);

select * from bbs order by 1;

commit;