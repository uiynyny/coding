select name
from employees
where id not in
(
  select managerid
  from employees
  where managerid not null
)

CREATE TABLE users_roles (
  userId INTEGER not null,
  roleId INTEGER not null,
  foreign key (userId) references users(id),
  foreign key (roleId) references roles(id),
  primary key (userId, roleId)
);