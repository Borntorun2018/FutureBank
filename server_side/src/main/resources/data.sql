Insert into OPUS_PERMISSION
   (OPRM_ID, OPRM_NAME, OPRM_DESCRIPTION,  OPRM_APPLICATION)
 Values
   (2, 'PERM_ACCS_1', 'Minimum level permission for entry to Access system.',  'ACCS');
Insert into OPUS_PERMISSION
   (OPRM_ID, OPRM_NAME, OPRM_DESCRIPTION,  OPRM_APPLICATION)
 Values
   (3, 'PERM_CIS_READ_ONLY', 'Minimum level permission into CIS', 'CIS');
Insert into OPUS_PERMISSION
   (OPRM_ID, OPRM_NAME, OPRM_DESCRIPTION,  OPRM_APPLICATION)
 Values
   (4, 'PERM_CORE_OPUS', 'Minimum level permission into OPUS', 'OPUS');
COMMIT;

 Insert into OPUS_ROLE
   (OROL_ID, OROL_NAME, OROL_DESCRIPTION, OROL_APPLICATION)
 Values
   (1, 'ROLE_ADMIN', 'ROLE ADMIN', 'FUTUTREBANK');
Insert into OPUS_ROLE
   (OROL_ID, OROL_NAME, OROL_DESCRIPTION, OROL_APPLICATION)
 Values
   (2, 'ROLE_USER', 'ROLE USER',  'FUTUREBANK');

    
INSERT INTO User (OSTA_ID, OSTA_USERNAME, OSTA_PASSWORD, OSTA_SALARY, OSTA_AGE, OSTA_EMAIL, OSTA_ENABLED, OSTA_ACCOUNTNONLOCKED, OSTA_ACCOUNTNONEXPIRED, OSTA_CREDENTIALSNONEXPIRED, OSTA_CREATION_DATE) 
VALUES (1, 'Mary.Harrow@smartbank.uk', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33,'Mary.Harrow@smartbank.uk', 1,1,1,1,TO_DATE('11/29/2018 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));

INSERT INTO User (OSTA_ID, OSTA_USERNAME, OSTA_PASSWORD, OSTA_SALARY, OSTA_AGE, OSTA_EMAIL, OSTA_ENABLED, OSTA_ACCOUNTNONLOCKED, OSTA_ACCOUNTNONEXPIRED, OSTA_CREDENTIALSNONEXPIRED, OSTA_CREATION_DATE) 
VALUES (2, 'Richard.Lucas@smartbank.uk', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 3456, 33,'Richard.Lucas@smartbank.uk', 1,1,1,1,TO_DATE('11/29/2018 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));

INSERT INTO User (OSTA_ID, OSTA_USERNAME, OSTA_PASSWORD, OSTA_SALARY, OSTA_AGE, OSTA_EMAIL, OSTA_ENABLED, OSTA_ACCOUNTNONLOCKED, OSTA_ACCOUNTNONEXPIRED, OSTA_CREDENTIALSNONEXPIRED, OSTA_CREATION_DATE) 
VALUES (3, 'Tom.Harrow@smartbank.uk', '$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK', 7823, 23,'Tom.Harrow@smartbank.uk', 1,1,1,1,TO_DATE('11/29/2018 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));

INSERT INTO User (OSTA_ID, OSTA_USERNAME, OSTA_PASSWORD, OSTA_SALARY, OSTA_AGE, OSTA_EMAIL, OSTA_ENABLED, OSTA_ACCOUNTNONLOCKED, OSTA_ACCOUNTNONEXPIRED, OSTA_CREDENTIALSNONEXPIRED, OSTA_CREATION_DATE) 
VALUES (4, 'Adam.Harrow@smartbank.uk', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 4234, 45,'Adam.Harrow@smartbank.uk', 1,1,1,1,TO_DATE('11/29/2018 00:00:00', 'MM/DD/YYYY HH24:MI:SS'));
COMMIT;

Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (1, 1, 1, 'FUTUREBANK');
 Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (2, 1, 2, 'FUTUREBANK');
   
Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (3, 2, 1, 'FUTUREBANK');
Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (4, 2, 2, 'FUTUREBANK');
COMMIT;

Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (1, 3, 1, 'FUTUREBANK');
 Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (2, 3, 2, 'FUTUREBANK');
   
  Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (1, 4, 1, 'FUTUREBANK');
 Insert into OPUS_STAFF_ROLE_LINK
   (OSRL_ID, OSRL_OSTA_ID, OSRL_OROL_ID, OSRL_SOURCE_SYSTEM)
 Values
   (2, 4, 2, 'FUTUREBANK'); 
   
   
Insert into OPUS_STAFF_ATTEMPTS
(OSA_ATTEMPTS, OSA_LASTMODIFIED, OSA_EMAIL)
Values
  (0,'2017-09-09','Richard.Lucas@smartbank.uk');
COMMIT;  
   
   
Insert into transaction (id, type, account, amount, date) 
Values
  (-1, 'debit', -1, 100, '2017-01-01'),
  (-2, 'debit', -1, 100, '2017-01-05'),
  (-3, 'debit', -1, 100, '2017-01-05'),
  (-4, 'debit', -1, 100, '2017-01-07'),
  (-5, 'debit', -2, 100, '2017-01-01'),
  (-6, 'debit', -2, 100, '2017-01-04'),
  (-7, 'debit', -3, 100, '2017-01-06'),
  (-8, 'debit', -3, 100, '2017-01-07'),
  (-9, 'debit', -3, 100, '2017-01-08'),
  (-10, 'debit', -4, 100, '2017-02-01');
COMMIT;  

