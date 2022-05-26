# ChallengeUltra


Used technologies:
Java 11
Spring Boot
Maven
PostgreSQL
Hibernate
Postman








Seeding Banco
-- INSERTS

INSERT INTO item(nome, preco, tipo) values ('combustivel', 15, 'P')
INSERT INTO pedidos_item (pedido_id, item_id) values(3,1)

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

Diagrama Banco
![image](https://user-images.githubusercontent.com/56515739/170579152-442e8daf-a0f3-4b3e-936f-c530e7aba419.png)



