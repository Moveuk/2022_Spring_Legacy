create table board(
    bno number not null,
    title varchar2(150) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate,
    constraint pk_board PRIMARY key(bno)
);

-- sysdate : db �ð� �ֱ�

-- board ������ ����
create sequence
    board_seq
    increment by 1
    start with 1;
    
-- �׽�Ʈ db ����
insert into board(bno, title, content, writer) values (board_seq.nextval,'�׽�Ʈ ����', '�׽�Ʈ ����', '�۰�');
 
select * from board;
commit;
--rollback;

