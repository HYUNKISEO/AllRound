
show tables;

INSERT INTO a_authority(id, name) VALUE (2, "ROLE_ADMIN");
INSERT INTO a_user_authorities(a_user_id, authorities_id) VALUES (1,2);

select * from a_user;
select * from a_authority;
select * from a_user_authorities;
select * from a_post;
select * from a_board_comment;
select * from a_question;
select * from a_like;
select * from basic_question;
select * from basic_attempt;
select *from a_question;

select * from a_user_history;
select * from a_post_history;
select * from basic_history;
select * from a_share_history;
select * from a_like_history;

show create table a_user_history;
show create table a_share_history;
show create table a_post_history;
show create table basic_history;
show create table basic_history;

ALTER TABLE a_user_history DROP CONSTRAINT FKr0x362473iitakjfk71idkc8j;
ALTER TABLE a_share_history DROP CONSTRAINT FK2p4vapkb0jmwaonu7rwjxiy3g;
ALTER TABLE a_post_history DROP CONSTRAINT FKqqfhuos6g36269eiots3gnbeq;
ALTER TABLE basic_history DROP CONSTRAINT FKdis79n9ajej876j8m5clw2koe;

drop table basicattempt_history;

delete from a_user_history;
delete from a_share_history;
delete from a_post_history;
delete from a_like_history;




ALTER TABLE a_authority
    DROP CONSTRAINT UK_sq6lwmnd95tb0kc75s1tjqrs5;

DROP TABLE basic_attempt;
DROP TABLE a_like;

ALTER TABLE a_user DROP CONSTRAINT FKjtxll9w4vd4tq2x4v9lxb0pjc;


INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the capital of France?', 'Paris', 'Paris', 'This is a simple geography question.', 'Paris', 'Paris');

INSERT INTO basic_attempt (corret, user_answer, basic_question_id, user_id)
VALUES ("정답", "Paris", 1, 1);

INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the square root of 25?', '25', '5', 'This is a math question.', '25', '5');

UPDATE a_post SET view_cnt = 100 WHERE id = 3;

DELETE FROM a_board_comment WHERE post_id IS NULL;

insert into a_post (create_time, category, contents, subject, view_cnt, user_id)values
(now(), '스터디', 'AAA' ,'sample_title', 0, 3),
(now(), '질문', 'AAA' ,'sample_title', 0, 3),
(now(), '일반', 'AAA' ,'sample_title', 0, 3);

insert into a_board_comment(create_time, text, post_id, user_id)values
(now(), "sample_data", 43, 3),
(now(), "sample_data", 44, 3),
(now(), "sample_data", 45, 3),
(now(), "sample_data", 46, 3),
(now(), "sample_data", 70, 3),
(now(), "sample_data", 71, 3),
(now(), "sample_data", 72, 3);

-- a_like 테이블에 데이터 추가
insert into a_like(id, question_id, user_id) values (1, 1, 1);

-- a_share_comment 테이블에 데이터 추가
insert into a_share_comment(create_time, id, question_id, user_id, text) values ('2024-02-18 00:00:00', 1, 1, 1, 'Sample comment');

-- a_answer 테이블에 데이터 추가
insert into a_answer(id, question_id, user_id, user_answer) values (1, 1, 1, 'Sample answer');

-- a_question 테이블에 데이터 추가
insert into a_question(create_time, id, user_id, view_cnt, answer, comment, example_input, example_output, input, output, question) values ('2024-02-18 00:00:00', 1, 1, 0, 'Sample answer', 'Sample comment', 'Sample input', 'Sample output', 'Sample input', 'Sample output', 'Sample question');

-- basic_question 테이블에 데이터 추가
insert into basic_question(comment, example_input, example_output, input, output, question) values ('Sample comment', 'Sample input', 'Sample output', 'Sample input', 'Sample output', 'Sample question');

-- basic_attempt 테이블에 데이터 추가
insert into basic_attempt(basic_question_id, id, user_id, corret, user_answer) values (1, 1, 1, 1, 'Sample answer');










-- Add more INSERT statements for additional questions as needed





