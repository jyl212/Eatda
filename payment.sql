select * from PAYMENT;

DROP table payment;

CREATE TABLE payment (
       PAYMENT_NO	NUMBER			NOT NULL, 
       MEM_ID		VARCHAR2(20)	NOT NULL, 
       ORDER_NO		NUMBER			NOT NULL, 
       RESER_NO		NUMBER			NOT NULL, 
       PAYMENT_DATE	DATE			NOT NULL, 
       TOTAL_PRICE	NUMBER			NOT NULL, 
       PAYMENT_TYPE	VARCHAR2(20)	NOT NULL 
);

create sequence payment_SEQ;