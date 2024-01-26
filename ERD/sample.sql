
show tables;

select * from a_user;

select * from a_testinfo;

select * from a_authority;

ALTER TABLE a_user DROP CONSTRAINT UK_3nstbuhppkiorpc6ms42mluut;

ALTER TABLE a_authority
    DROP CONSTRAINT UK_sq6lwmnd95tb0kc75s1tjqrs5;

DROP TABLE user_authority;

ALTER TABLE user_authority DROP CONSTRAINT FK4ojeblvl273tr6bx50tcg3awn;


INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the capital of France?', 'Paris', 'Paris', 'This is a simple geography question.', 'Paris', 'Paris');

INSERT INTO basic_question (question, example_input, example_output, comment, input, output)
VALUES ('What is the square root of 25?', '25', '5', 'This is a math question.', '25', '5');

-- Add more INSERT statements for additional questions as needed





