CREATE TABLE CUSTOMER_EVENT (
    id INTEGER auto_increment PRIMARY KEY,
    identifier VARCHAR2(144),
    first_name VARCHAR2(30),
    last_name VARCHAR2(30),
    birth_date timestamp(6),
    email VARCHAR2(50),
    type VARCHAR2(20)
);