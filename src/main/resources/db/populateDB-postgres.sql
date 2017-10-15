DELETE FROM BUG;
DELETE FROM PERSON;

-- =====================================

INSERT INTO PERSON (id, name)
VALUES (10001, 'Flex Wheeler');

INSERT INTO PERSON (id, name)
VALUES (10002, 'Shawn Ray');

INSERT INTO PERSON (id, name)
VALUES (10003, 'Lee Priest');

INSERT INTO PERSON (id, name)
VALUES (10004, 'Kevin Levrone');

-- ======================================

INSERT INTO PERSON (id, name)
VALUES (20001, 'Tom Araya');

INSERT INTO PERSON (id, name)
VALUES (20002, 'Kerry King');

-- =====================================

INSERT INTO BUG (id, name, resolution, priority, bug_status, assignee_id, reporter_id)
VALUES (40001, 'Authenticator code not working', 'UNRESOLVED', 'HIGH', 'TO_DO', 10001, 20001);

INSERT INTO BUG (id, name, resolution, priority, bug_status, assignee_id, reporter_id)
VALUES (40002, 'Unable to login', 'UNRESOLVED', 'HIGH', 'TO_DO', 10001, 20001);

INSERT INTO BUG (id, name, resolution, priority, bug_status, assignee_id, reporter_id)
VALUES (40003, 'Captcha image broken', 'UNRESOLVED', 'HIGH', 'TO_DO', 10002, 20002);

INSERT INTO BUG (id, name, resolution, priority, bug_status, assignee_id, reporter_id)
VALUES (40004, 'Captcha image broken', 'UNRESOLVED', 'HIGH', 'TO_DO', 10003, 20002);

INSERT INTO BUG (id, name, resolution, priority, bug_status, assignee_id, reporter_id)
VALUES (40005, 'Unable to logout', 'UNRESOLVED', 'HIGH', 'TO_DO', 10004, 20002);




