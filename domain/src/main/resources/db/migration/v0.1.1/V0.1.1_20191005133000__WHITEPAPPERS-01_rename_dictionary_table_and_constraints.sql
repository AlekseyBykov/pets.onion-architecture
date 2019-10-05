alter table white_papper_metadata drop constraint if exists white_papper_metadata_created_scope_id_fkey;

alter table if exists scope rename to some_dictionary;

comment on table some_dictionary is 'Example of some dictionary';
comment on column some_dictionary.id is 'Dictionary item identifier';
comment on column some_dictionary.name is 'Dictionary item name';

alter table white_papper_metadata drop column scope_id;
alter table white_papper_metadata add column some_dictionary_id bigint;

alter table white_papper_metadata add constraint white_papper_metadata_some_dictionary_id_fkey
    foreign key (some_dictionary_id) references some_dictionary (id);
