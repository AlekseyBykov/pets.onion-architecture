alter table white_papper_metadata add column registration_date date not null;
comment on column white_papper_metadata.registration_date is 'Registration date of whitepapper';