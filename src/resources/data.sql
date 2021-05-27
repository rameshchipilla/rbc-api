insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(1,'8AM - 9AM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(2,'9AM - 10AM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(3,'10AM - 11AM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(4,'11AM - 12PM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(5,'1PM - 2PM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(6,'2PM - 3PM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(7,'3PM - 4PM', true);
insert into APPOINTMENT_SLOT(ID,SLOT_TEXT,ACTIVE) values(8,'4PM - 5PM', true);

insert into PET(PET_NAME,PET_COLOR,PET_GENDER,PET_TYPE) values('Pet 1','Black','M','Dog');
insert into PET(PET_NAME,PET_COLOR,PET_GENDER,PET_TYPE) values('Pet 2','White','F','Cat');

insert into VET(VET_FIRST_NAME,VET_LAST_NAME,VET_GENDER,VET_EMAIL,VET_PHONE) values('Rob', 'Steale','M','a@b.com','1111117890');
insert into VET(VET_FIRST_NAME,VET_LAST_NAME,VET_GENDER,VET_EMAIL,VET_PHONE) values('Bob', 'Baker','M','a@b.com','1234567890'); 

insert into APPOINTMENT(APPOINTMENT_DATE,SLOT_ID,VET_ID,PET_ID,STATUS) values(SYSDATE,1,1,1,'Scheduled');
insert into APPOINTMENT(APPOINTMENT_DATE,SLOT_ID,VET_ID,PET_ID,STATUS) values(SYSDATE,2,1,2,'Scheduled');
insert into APPOINTMENT(APPOINTMENT_DATE,SLOT_ID,VET_ID,PET_ID,STATUS) values(SYSDATE,2,2,1,'Scheduled');
insert into APPOINTMENT(APPOINTMENT_DATE,SLOT_ID,VET_ID,PET_ID,STATUS) values(SYSDATE,3,2,1,'Scheduled');