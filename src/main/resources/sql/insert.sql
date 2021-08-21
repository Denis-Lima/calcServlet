insert into classificacao (id, tipo) select * from (select 1, 'Elementar') as t where not exists (select id from classificacao where id = 1);

insert into classificacao (id, tipo) select * from (select 2, 'Transcendental') as t where not exists (select id from classificacao where id = 2);