# ChallengeUltra


* Used technologies:
* Java 11
* Spring Boot
* Maven
* PostgreSQL
* Hibernate
* Postman


* Diagrama Banco 

 ![diagrama](https://user-images.githubusercontent.com/56515739/170579902-aa6e6015-b9c4-4a12-badd-83cc302f2eca.jpg)


* -- Inserindo empresas 


insert into empresa(id,cnpj,nome) values (default,'12345678', 'ultra');
insert into empresa(id,cnpj,nome) values (default,'12345678', 'ultrateste');
select * from empresa
-- inserindo meta

insert into meta(id,meta_faturamento,novos_clientes, empresa_id) values (default,'500000', '500',1);
insert into meta(id,meta_faturamento,novos_clientes, empresa_id) values (default,'500000', '500',2);
select * from meta

-- inserindo funcionario
insert into funcionario(id,nome,empresa_id) values (default,'Guilherme Diniz', 1);
insert into funcionario(id,nome,empresa_id) values (default,'Gabriel Borges', 1);
insert into funcionario(id,nome,empresa_id) values (default,'Anibal Martins', 2);


-- inserindo cliente

-- lembrete adicionar data de inclusão para o relatorio clientes novos
insert into cliente (id,endereco,nome) values (default,'Avenida Afonso Pena 981, Centro','Guilherme Diniz');
insert into cliente (id,endereco,nome) values (default,'Avenida Afonso Pena 981, Centro','Gabriel Borges');
insert into cliente (id,endereco,nome) values (default,'Avenida Afonso Pena 981, Centro','Lucas Xavier');
insert into cliente (id,endereco,nome) values (default,'Avenida Afonso Pena 981, Centro','Fernanda Diniz');

-- inserindo item
insert into item (id,nome, preco, tipo) values (default,'Filtro de oleo ','25','p');
insert into item (id,nome, preco, tipo) values (default,'troca de oleo ','50','s');
insert into item (id,nome, preco, tipo) values (default,'Filtro de combustível ','20','p');

-- inserindo pedidos
insert into pedidos(id,data,quantidade,cliente_id,funcionario_id) values(default,'26-05-2022',5,4,1);
insert into pedidos(id,data,quantidade,cliente_id,funcionario_id) values(default,'25-05-2022',5,3,2);



-- inserindo pedidos itens

INSERT INTO pedidos_item (pedido_id, item_id) values(1,1);
INSERT INTO pedidos_item (pedido_id, item_id) values(2,1);


* -- select
* 
-- Metas da empresa

SELECT e.nome, m.meta_faturamento, m.novos_clientes
FROM empresa as e
INNER JOIN meta as m on e.id = m.empresa_id
WHERE m.id = 1

-- Funcionarios da empresa

SELECT e.nome, f.nome
FROM empresa as e
INNER JOIN funcionario as f on e.id = f.empresa_id

-- Venda com todos os dados

SELECT e.nome as empresa, f.nome as vendedor, c.nome as cliente, p.data as data, i.nome as produto, i.preco as preco, p.quantidade as quantidade, i.preco * p.quantidade as valortotal
FROM empresa as e
INNER JOIN funcionario as f on e.id = f.empresa_id
INNER JOIN pedidos as p on f.id = p.funcionario_id
INNER JOIN cliente as c on c.id = p.cliente_id
INNER JOIN pedidos_item as v on v.pedido_id = p.id
INNER JOIN item as i on i.id = v.item_id

-- Comparacao de meta com faturamento real

SELECT distinct e.nome, m.meta_faturamento as meta, SUM(i.preco * p.quantidade) as faturamentoatual, m.meta_faturamento - SUM(i.preco * p.quantidade) as diferenca
FROM meta as m
INNER JOIN empresa as e on e.id = m.empresa_id
INNER JOIN funcionario as f on e.id = f.empresa_id
INNER JOIN pedidos as p on f.id = p.funcionario_id
INNER JOIN cliente as c on c.id = p.cliente_id
INNER JOIN pedidos_item as v on v.pedido_id = p.id
INNER JOIN item as i on i.id = v.item_id
WHERE m.id = 1
GROUP BY e.nome, m.meta_faturamento
