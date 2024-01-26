
show tables;

select * from a_user;

select * from a_testinfo;

select * from a_authority;

ALTER TABLE a_user DROP CONSTRAINT UK_3nstbuhppkiorpc6ms42mluut;

ALTER TABLE a_authority
    DROP CONSTRAINT UK_sq6lwmnd95tb0kc75s1tjqrs5;

DROP TABLE user_authority;

ALTER TABLE user_authority DROP CONSTRAINT FK4ojeblvl273tr6bx50tcg3awn;







