alter table white_papper_metadata add column created_user_id int8;
alter table white_papper_metadata add column created_dt timestamptz(6);
alter table white_papper_metadata add column updated_user_id int8;
alter table white_papper_metadata add column updated_dt timestamptz(6);

comment on column white_papper_metadata.created_user_id is 'White pappers creator';
comment on column white_papper_metadata.created_dt is 'White pappers creation date';
comment on column white_papper_metadata.updated_user_id is 'White pappers updater';
comment on column white_papper_metadata.updated_dt is 'White pappers change date';

alter table white_papper_metadata add constraint white_papper_metadata_created_user_id_fkey
    foreign key (created_user_id) references s_user (id);

alter table white_papper_metadata add constraint white_papper_metadata_updated_user_id_fkey
    foreign key (updated_user_id) references s_user (id);
