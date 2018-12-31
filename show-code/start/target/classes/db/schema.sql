-- auto-generated definition
drop table  city if exists;
create table city
(
  city_id   int not null auto_increment,
  city_code varchar,
  city_name varchar,
  mtime date not null default sysdate,
  ctime date not null default sysdate,
  primary key(city_id)
);

drop table  user_info if exists;
create table user_info
(
  user_id   int not null auto_increment,
  user_code varchar,
  name varchar,
  mtime date not null default sysdate,
  ctime date not null default sysdate,
  primary key(user_id)
);


-- auto-generated definition
/*create table city
(
  city_id   int not null,
  city_code varchar,
  city_name varchar,
  mtime date not null default now(),
  ctime date not null default now(),
  primary key(city_id)
);

create table user_info
(
  user_id   int not null,
  user_code varchar,
  name varchar,
  mtime date not null default now(),
  ctime date not null default now(),
  primary key(user_id)
);*/