INSERT INTO a_user(create_time, dob, name, password, phone, username)values
                                                                         (now() ,now(), '관리자', '$2a$10$DNtehTqnwOeNP2a4krrTxuEmOKttLAwSW5UQ2Iu2v1x0pIcJSIQ22', '01012345678', 'admin'),
                                                                         (now() ,now(), 'user1', '$2a$10$gO4bRXR69Enevj1yqgP1T.vpjf4W8LEJEztXVOvS4yxUeWicT6r5y', '01023456789', 'user1'),
                                                                         (now() ,now(), 'user2', '$2a$10$awgbBMJ3CJLy7IumJyr8u.JXYMjsrkaHGglf1XJSSWJNPVn./OlzO', '01034567890', 'user2'),
                                                                         (now() ,now(), 'user3', '$2a$10$0sZGiupVC6FQTQO01yHJz.JcelIvgGcGF9mYUNSK73Igo/Vivqq1.', '01045678901', 'user3'),
                                                                         (now() ,now(), 'user4', '$2a$10$k5pYY6oghqzZbTWVxE66YuRV72Bzs2ym0JEvWHH5PN62RtVIDUDb2', '01056789012', 'user4'),
                                                                         (now() ,now(), 'user5', '$2a$10$Q6caF9aHp/g4IpB9EllMw.tOco3lNJr7ipGuI.dtXGaMFJA/umcEW', '01067890123', 'user5'),
                                                                         (now() ,now(), 'user6', '$2a$10$wrM.0AZGuj0iSVPGoX3.auAylm47mHwjNHDljboRM79Y5LfElBAVe', '01078901234', 'user6'),
                                                                         (now() ,now(), 'user7', '$2a$10$Y6TuQlmVtmp8XMVw42w7JODXOctqECSzxUSn5HLkpvGRHHTMiaiHC', '01089012345', 'user7'),
                                                                         (now() ,now(), 'user8', '$2a$10$LZC2VeyXWT2T81cx.czoOenCEuGwPayNbXZV/vevuiuL0zHjG6Km6', '01090123456', 'user8'),
                                                                         (now() ,now(), 'user9', '$2a$10$r5Np/JImNV7hUpOk0zNhoeXONGCW8JIoSLuiFGWf7uHQ0P/UHd/VW', '01098765432', 'user9');

INSERT INTO a_authority(id, name) VALUES
                                      (1, 'ROLE_MEMBER'),
                                      (2, 'ROLE_ADMIN');
INSERT INTO a_user_authorities(a_user_id, authorities_id) VALUES
                                                              (1,1), (1,2), (2,1), (3,1), (4,1), (5,1), (6,1), (7,1), (8,1), (9,1), (10,1);


insert into a_post (create_time, category, contents, subject, view_cnt, user_id)values
                                                                                    (now(), '스터디', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '질문', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '질문', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '일반', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '일반', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '스터디', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '스터디', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '질문', 'AAA' ,'sample_title', 0, 1),
                                                                                    (now(), '일반', 'AAA' ,'sample_title', 0, 1);

insert into a_board_comment(create_time, text, post_id, user_id)values
                                                                    (now(), 'sample_data', 9, 1),
                                                                    (now(), 'sample_data', 8, 1),
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
    ('2024-02-18 12:20:00', 3, 1, 'Yet another comment'),
    ('2024-02-18 14:50:00', 4, 1, 'Code comment'),
    ('2024-02-18 14:50:00', 5, 1, 'Code comment');


-- basic_question 테이블에 데이터 추가
INSERT INTO basic_question (title, description, example_Input, example_Output) VALUES
                                                                                   ('문제 1', '두 개의 정수를 입력 받아 곱과 몫을 출력하시오.', '16 5', '16 * 5 = 80\n16 / 5 = 3'),
                                                                                   ('문제 2', '실수 2개와 한 개의 문자를 입력 받아 출력하되 실수는 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.', '12.2536\n526.129535\nA', '12.25\n526.13\nA'),
                                                                                   ('문제 3', '두 개의 정수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.', '7 5', '두 개의 수를 입력하시오. 7 5\n7 + 5 = 12\n7 - 5 = 2\n7 * 5 = 35\n7 / 5 = 1\n7 % 5 = 2'),
                                                                                   ('문제 4', '두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.', '50 85', '35'),
                                                                                   ('문제 5', '정수를 입력받아 0 이면 "zero" 양수이면 "plus" 음수이면 "minus" 라고 출력하는 프로그램을 작성하시오.', '0', 'zero');


