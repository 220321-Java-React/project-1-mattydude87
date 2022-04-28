CREATE TABLE user_roles (
user_role_id SERIAL PRIMARY KEY,
user_role VARCHAR(20) NOT NULL
)

INSERT INTO user_roles (user_role) VALUES ('manager'), ('employee');

CREATE TABLE reimbursement_type (
reimb_type_id SERIAL PRIMARY KEY,
reimb_type varchar(200) NOT NULL
)

INSERT INTO reimbursement_type (reimb_type) VALUES 
('lodging'),
('food'),
('travel'),
('other');

CREATE TABLE reimbursement_status (
reimb_status_id SERIAL PRIMARY KEY,
reimb_status varchar(200) NOT NULL
)

INSERT INTO reimbursement_status (reimb_status) VALUES
('pending'),
('approved'),
('denied');

CREATE TABLE users (
bvilll
)
