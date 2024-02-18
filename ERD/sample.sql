
show tables;

select * from a_user;
select * from a_authority;
select * from a_user_authorities;
select * from a_post;
select * from a_board_comment;
select * from a_question;
select * from a_like;


select * from a_testinfo;
delete from a_testinfo;
select * from a_authority;

ALTER TABLE a_user DROP CONSTRAINT UK_3nstbuhppkiorpc6ms42mluut;

ALTER TABLE a_authority
    DROP CONSTRAINT UK_sq6lwmnd95tb0kc75s1tjqrs5;

DROP TABLE basic_attempt;
DROP TABLE a_like;

ALTER TABLE a_user DROP CONSTRAINT FKjtxll9w4vd4tq2x4v9lxb0pjc;


INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the capital of France?', 'Paris', 'Paris', 'This is a simple geography question.', 'Paris', 'Paris');

INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the square root of 25?', '25', '5', 'This is a math question.', '25', '5');

UPDATE a_post SET view_cnt = 100 WHERE id = 3;

DELETE FROM a_board_comment WHERE post_id IS NULL;

insert into a_post (create_time, category, contents, subject, view_cnt, user_id)values
(now(), '스터디', 'AAA' ,'sample_title', 0, 2),
(now(), '질문', 'AAA' ,'sample_title', 0, 3),
(now(), '일반', 'AAA' ,'sample_title', 0, 4);

insert into a_board_comment(create_time, text, post_id, user_id)values
(now(), "sample_data", 29, 2),
(now(), "sample_data", 28, 3),
(now(), "sample_data", 27, 4),
(now(), "sample_data", 26, 2),
(now(), "sample_data", 25, 3),
(now(), "sample_data", 24, 4),
(now(), "sample_data", 23, 2);

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

INSERT INTO a_authority(id, name) VALUE (2, "ROLE_ADMIN");
INSERT INTO a_user_authorities(a_user_id, authorities_id) VALUES (1,2)








-- Add more INSERT statements for additional questions as needed





