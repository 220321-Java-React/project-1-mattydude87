CREATE TABLE user_roles (
user_role_id SERIAL PRIMARY KEY,
user_role VARCHAR(20) NOT NULL
);


INSERT INTO user_roles (user_role) VALUES ('manager'), ('employee');

CREATE TABLE reimbursement_type (
reimb_type_id SERIAL PRIMARY KEY,
reimb_type varchar(200) NOT NULL
);

INSERT INTO reimbursement_type (reimb_type) VALUES 
('lodging'),
('food'),
('travel'),
('other');

CREATE TABLE reimbursement_status (
reimb_status_id SERIAL PRIMARY KEY,
reimb_status varchar(200) NOT NULL
);

INSERT INTO reimbursement_status (reimb_status) VALUES
('pending'),
('approved'),
('denied');

CREATE TABLE users (
user_id SERIAL PRIMARY KEY,
username VARCHAR(200) UNIQUE NOT NULL,
password VARCHAR(200) NOT NULL,
first_name VARCHAR(200) NOT NULL,
last_name VARCHAR(200) NOT NULL,
email VARCHAR(200) UNIQUE NOT NULL,
role_id_fk INT REFERENCES user_roles(user_role_id) NOT NULL
);

INSERT INTO users (username, password, first_name, last_name, email, role_id_fk)
VALUES ('mikecordero42', 'bossman24', 'mike', 'cordero', 'mikec42@gmail.com', 1),
('joeybones5', 'greenobot', 'joey', 'jones', 'joeyb5@gmail.com', 2),
('samanthafitz33', 'sunshine22', 'samantha', 'fitzwald', 'samfitz92', 2);


CREATE TABLE reimbursement (
reimb_id SERIAL PRIMARY KEY,
amount INT NOT NULL,
date_submitted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
date_resolved TIMESTAMP,
description VARCHAR(250) NOT NULL,

author_fk int REFERENCES users(user_id),
resolver_fk int REFERENCES users(user_id),
status_id_fk int REFERENCES reimbursement_status(reimb_status_id),
reimb_type_id_fk int REFERENCES reimbursement_type(reimb_type_id)
);

INSERT INTO reimbursement (amount, description, author_fk, resolver_fk, status_id_fk, reimb_type_id_fk)
VALUES (225, 'airplane ticket', 2, 1, 2, 3), (450, 'business dinner', 3, 1, 1, 2),
(65, 'gasoline', 1, 1, 2, 4);

select * from users where username = 'joeybones5' and PASSWORD = 'greenobot'
select * from reimbursement where status_id_fk = 1
