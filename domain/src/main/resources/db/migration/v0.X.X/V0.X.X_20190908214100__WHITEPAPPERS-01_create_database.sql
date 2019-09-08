create table white_papper (
  id                bigserial   not null,
  name              text        not null,
  created_user_id   bigint,
  created_dt        timestamptz,
  updated_user_id   bigint,
  updated_dt        timestamptz,
  constraint white_papper_id_pkey primary key (id),
  constraint white_papper_created_user_id_fkey foreign key (created_user_id) references s_user (id),
  constraint white_papper_updated_user_id_fkey foreign key (updated_user_id) references s_user (id)
);

comment on table white_papper is 'White pappers';

comment on column white_papper.id is 'Identifier of white papper';
comment on column white_papper.name is 'Name of white papper';
comment on column white_papper.created_dt is 'White pappers creation date';
comment on column white_papper.created_user_id is 'White pappers creator';
comment on column white_papper.updated_user_id is 'White pappers updater';
comment on column white_papper.updated_dt is 'White pappers change date';

create table white_papper_metadata
(
    id                     bigserial       primary key,
    name                   text            not null,
    type                   text            not null,
    registration_number    text            not null,
    white_papper_id        bigint          not null references white_papper (id) on delete cascade,
);

comment on table white_papper_metadata is 'Metadata of white papper';

comment on column white_papper_metadata.id is 'Metadata identifier';
comment on column white_papper_metadata.name is 'Name';
comment on column white_papper_metadata.type is 'Type';
comment on column white_papper_metadata.registration_number is 'Registration number';

create table s_user (
  id          bigserial   not null,
  last_name   text        not null,
  first_name  text,
  middle_name text,
  constraint  s_user_id_pkey primary key (id)
);

comment on table s_user is 'System users';

comment on column s_user.id is 'User identifier';
comment on column s_user.last_name is 'Last name';
comment on column s_user.first_name is 'First name';
comment on column s_user.middle_name is 'Middle name';
