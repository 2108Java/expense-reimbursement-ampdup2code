create table user_table (
user_id serial primary key,
username varchar(30) not null unique,
password varchar(30) not null
);

alter table user_table 
rename column password to user_password;

create table employee_table (
employee_id serial primary key,
f_name varchar(30) not null,
l_name varchar(30) not null,
user_id int references user_table(user_id) on delete cascade
);

create table finance_manager_table (
fm_id serial primary key,
f_name varchar(30) not null,
l_name varchar(30) not null,
user_id int references user_table(user_id) on delete cascade
);

create table approval_table (
approval_id serial primary key,
approval_status varchar(10) not null
);

create table reimbursement_type (
type_id serial primary key,
category varchar(10) not null
);

create table reimbursement_table (
reimbursement_id serial primary key,
employee_id int references employee_table(employee_id) on delete cascade,
approval_id int references approval_table(approval_id) on delete cascade default 1,
reimbursment_amount numeric not null,
fm_id int references finance_manager_table(fm_id) on delete cascade,
type_id int references reimbursement_type(type_id) on delete cascade,
time_submitted timestamp default now(),
description varchar(100) not null
);

insert into approval_table (approval_status)
values ('Pending'), ('Approved'), ('Rejected');

insert into reimbursement_type (category)
values ('Lodging'), ('Travel'), ('Food'), ('Other');

insert into user_table (username, user_password)
values ('jacky', 'pass1'), ('luis', 'pass2'), ('yibeltal', 'pass3');

insert into employee_table (f_name, l_name, user_id)
values ('Jacky', 'Thomas', 1), ('Luis', 'Ramirez', 2);

insert into finance_manager_table (f_name, l_name, user_id)
values ('Yibeltal', 'Zerinhun', 3)