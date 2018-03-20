create sequence person_id_seq
;

create table if not exists person
(
	id serial not null
		constraint person_pkey
			primary key,
	name varchar(20) not null,
	surname varchar(50) not null,
	address varchar(100) not null
)
;

create unique index if not exists person_id_uindex
	on person (id)
;