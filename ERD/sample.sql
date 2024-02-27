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
