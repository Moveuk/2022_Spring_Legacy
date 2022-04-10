# sql 계정 추가 및 권한
create user ldudb identified by ldu1234;
grant connect, dba, resource to ldudb;
commit;

-----