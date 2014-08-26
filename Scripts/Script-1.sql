#####################
use test;

create table item (name text, price DECIMAL);
      
select * from test.item;   

insert into item (name, price) values ("A", 1);
insert into item (name, price) values ("B", 2);
insert into item (name, price) values ("C", 3);