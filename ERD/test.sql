INSERT INTO a_user (username, password, name, dob, phone)
VALUES ('user3', 'password123', 'Test User 3', '1990-01-01', '010-1234-5678');


select * from a_user;
select * from basic_question;
DROP TABLE basic_question;

DROP TABLE IF EXISTS basic_question;

INSERT INTO basic_question (title, description, example_Input, example_Output) VALUES
                                                                                   ('문제 1', '두 개의 정수를 입력 받아 곱과 몫을 출력하시오.', '16 5', '16 * 5 = 80\n16 / 5 = 3'),
                                                                                   ('문제 2', '실수 2개와 한 개의 문자를 입력 받아 출력하되 실수는 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.', '12.2536\n526.129535\nA', '12.25\n526.13\nA'),
                                                                                   ('문제 3', '영문 대문자를 입력받아 등급을 출력하는 프로그램을 작성하시오.', 'ABCDEF', 'Excellent,Good,Usually,Effort,Failure,error');


