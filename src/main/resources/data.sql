insert into user_details(id, birth_date, name)
values(1001, current_date(), 'Vlad');

insert into user_details(id, birth_date, name)
values(1002, current_date(), 'John');

insert into user_details(id, birth_date, name)
values(1003, current_date(), 'Jack');

insert into post(id, description, user_id)
values(2001, 'Learn Java', 1001);

insert into post(id, description, user_id)
values(2002, 'Learn Angular', 1002);

insert into post(id, description, user_id)
values(2003, 'Learn React', 1002);

insert into post(id, description, user_id)
values(2004, 'AWS certified', 1003);