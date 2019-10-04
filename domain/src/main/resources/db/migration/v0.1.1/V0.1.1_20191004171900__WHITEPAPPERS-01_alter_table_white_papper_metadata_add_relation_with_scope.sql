alter table white_papper_metadata add column scope_id bigint;

comment on column white_papper_metadata.scope_id is 'Identifier of the scope';

alter table white_papper_metadata add constraint white_papper_metadata_created_scope_id_fkey
    foreign key (scope_id) references scope (id);
