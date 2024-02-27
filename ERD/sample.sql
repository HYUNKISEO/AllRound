
show tables;

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
select *from a_answer;

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
delete from a_like;

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


-- a_like 테이블에 데이터 추가
insert into a_like(id, question_id, user_id) values (1, 1, 1);


-- basic_question 테이블에 데이터 추가
insert into basic_question(comment, example_input, example_output, input, output, question) values ('Sample comment', 'Sample input', 'Sample output', 'Sample input', 'Sample output', 'Sample question');

-- basic_attempt 테이블에 데이터 추가
insert into basic_attempt(basic_question_id, id, user_id, corret, user_answer) values (1, 1, 1, 1, 'Sample answer');

-- 여기부터 추가해야할 샘플 데이터

INSERT INTO a_user(dob, name, password, phone, username)values
(DATE_SUB(NOW(), INTERVAL 10 YEAR), '관리자', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01012345678', 'admin'),
(DATE_SUB(NOW(), INTERVAL 9 YEAR), 'user1', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01023456789', 'user1'),
(DATE_SUB(NOW(), INTERVAL 8 YEAR), 'user2', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01034567890', 'user2'),
(DATE_SUB(NOW(), INTERVAL 7 YEAR), 'user3', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01045678901', 'user3'),
(DATE_SUB(NOW(), INTERVAL 6 YEAR), 'user4', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01056789012', 'user4'),
(DATE_SUB(NOW(), INTERVAL 5 YEAR), 'user5', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01067890123', 'user5'),
(DATE_SUB(NOW(), INTERVAL 4 YEAR), 'user6', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01078901234', 'user6'),
(DATE_SUB(NOW(), INTERVAL 3 YEAR), 'user7', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01089012345', 'user7'),
(DATE_SUB(NOW(), INTERVAL 2 YEAR), 'user8', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01090123456', 'user8'),
(DATE_SUB(NOW(), INTERVAL 1 YEAR), 'user9', '$2a$10$SvkgYcnlmquHf2Hs5J8sZ.OMJy2zBMlJ/VgHTbDDpdP/Qi9Ww0SIm', '01098765432', 'user9');

INSERT INTO a_authority(id, name) VALUES
(1, 'ROLE_MEMBER'),
(2, 'ROLE_ADMIN');
INSERT INTO a_user_authorities(a_user_id, authorities_id) VALUES
(1,1), (1,2), (2,1), (3,1), (4,1), (5,1), (6,1), (7,1), (8,1), (9,1), (10,1);


insert into a_post (create_time, category, contents, subject, view_cnt, user_id)values
(now(), '스터디', 'AAA' ,'sample_title', 0, 1),
(now(), '질문', 'AAA' ,'sample_title', 0, 1),
(now(), '일반', 'AAA' ,'sample_title', 0, 1);

insert into a_board_comment(create_time, text, post_id, user_id)values
(now(), 'sample_data', 7, 1),
(now(), 'sample_data', 6, 1),
(now(), 'sample_data', 5, 1),
(now(), 'sample_data', 4, 1),
(now(), 'sample_data', 3, 1),
(now(), 'sample_data', 2, 1),
(now(), 'sample_data', 1, 1);

-- a_question 테이블에 데이터 추가
insert into a_question(create_time, user_id, view_cnt, answer, comment, example_input, example_output, input, output, question, like_cnt)
values
    ('2024-02-18 00:00:00', 1, 0, 'Sample answer', 'Sample comment', 'Sample input', 'Sample output', 'Sample input', 'Sample output', 'Sample question', 0),
    ('2024-02-18 01:30:00', 1, 0, 'Another answer', 'Another comment', 'Another input', 'Another output', 'Another input', 'Another output', 'Another question', 0),
    ('2024-02-18 03:45:00', 1, 0, 'Yet another answer', 'Yet another comment', 'Yet another input', 'Yet another output', 'Yet another input', 'Yet another output', 'Yet another question', 0),
    ('2024-02-18 05:10:00', 1, 0, 'Java code answer', 'Code comment', 'Code input', 'Code output', 'Code input', 'Code output', 'Code question', 0),
    ('2024-02-18 06:30:00', 1, 0, 'public class JavaExample {\n    public static void main(String[] args) {\n        System.out.println("Hello, Java");\n    }\n}', 'Java 코드 복사 하세요', '없음', 'Hello, Java', '없음', 'Hello, Java', '아래 출력문자를 출력하시오', 0);

-- a_share_comment 테이블에 데이터 추가
insert into a_share_comment(create_time, question_id, user_id, text)
values
    ('2024-02-18 09:00:00', 1, 1, 'Sample comment'),
    ('2024-02-18 10:15:00', 2, 1, 'Another comment'),
    ('2024-02-18 12:20:00', 3, 2, 'Yet another comment'),
    ('2024-02-18 14:50:00', 4, 3, 'Code comment');
