# sql ���� �߰� �� ����
create user ldudb identified by ldu1234;
grant connect, dba, resource to ldudb;
commit;

-----
테이블 작성

create table board(
    bno number not null,
    title varchar2(150) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate,
    constraint pk_board PRIMARY key(bno)
);

-- sysdate : db 시간 넣기

-- board 시퀀스 생성
create sequence
    board_seq
    increment by 1
    start with 1;
    
-- 테스트 db 정보
insert into board(bno, title, content, writer) values (board_seq.nextval,'테스트 제목', '테스트 내용', '작가');
 
select * from board;
commit;
--rollback;



--상세조회 쿼리문

select * from board where bno = 8;

-- 게시글 수정 쿼리문
-- Oracle
update board set title='제목 수정', content='내용 수정', updateDate = sysdate where bno = 8;
-- MySQL
update board set title='제목 수정', content='내용 수정', updateDate = now() where bno = 8;

-- 게시글 삭제 쿼리문
delete from board where bno = '삭제할 게시판 번호';