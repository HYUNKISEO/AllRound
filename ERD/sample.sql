
show tables;

select * from a_user;
select * from a_authority;
select * from a_post;
select * from a_board_comment;
select * from a_question;
select * from a_like;

update a_authority set name = "ROLE_MEMBER";

select * from a_testinfo;
delete from a_testinfo;
select * from a_authority;

ALTER TABLE a_user DROP CONSTRAINT UK_3nstbuhppkiorpc6ms42mluut;

ALTER TABLE a_authority
    DROP CONSTRAINT UK_sq6lwmnd95tb0kc75s1tjqrs5;

DROP TABLE basic_attempt;
DROP TABLE a_like;

ALTER TABLE user_authority DROP CONSTRAINT FK4ojeblvl273tr6bx50tcg3awn;


INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the capital of France?', 'Paris', 'Paris', 'This is a simple geography question.', 'Paris', 'Paris');

INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the square root of 25?', '25', '5', 'This is a math question.', '25', '5');

UPDATE a_post SET view_cnt = 100 WHERE id = 3;

DELETE FROM a_board_comment WHERE post_id IS NULL;

insert into a_post (create_time, category, contents, subject, view_cnt, user_id)values
(now(), '스터디', 'AAA' ,'sample_title', 0, 1),
(now(), '질문', 'AAA' ,'sample_title', 0, 1),
(now(), '일반', 'AAA' ,'sample_title', 0, 1);


-- Add more INSERT statements for additional questions as needed





