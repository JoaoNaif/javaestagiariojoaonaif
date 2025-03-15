---- 1 Clientes na tabela ----

SELECT COUNT(*)
FROM customers;

---- 2 Quartos na cadastrados ----

SELECT COUNT(*)
FROM rooms;

---- 3 Quantas reservas em aberto  ----

SELECT COUNT(*)
FROM reservations
WHERE status = 'ABSENCE';

---- 4 Quartos disponíveis ----

SELECT COUNT(*)
FROM reservations
WHERE NOT status in (
    'SCHEDULED',
    'IN_USE'
);

---- 5 Quartos ocupados  ----

SELECT COUNT(*)
FROM reservations
WHERE status = 'IN_USE';

---- 6 Quantos quartos reservados futuramente ----

SELECT COUNT(*)
FROM reservations
WHERE status = 'SCHEDULED';

---- 7 Qual o quarto mais caro  ----

SELECT *
FROM rooms
ORDER BY price DESC
LIMIT 1;

---- 8 Qual o quarto com mais cancelamento  ----

SELECT
    r.id,
    r.room_number,
    r.type,
    r.price,
    COUNT(c.id) AS total_cancelamentos
FROM rooms r
         INNER JOIN reservations c ON c.room_Id = r.id
WHERE c.status = 'CANCELED'
GROUP BY r.id, r.room_number, r.type, r.price
ORDER BY total_cancelamentos DESC
    LIMIT 1;

---- 9 Todos os quartos e quantos clientes ficaram nele ----

SELECT
    r.id,
    r.room_number,
    r.type,
    r.price,
    COUNT(c.id) AS total_ocupantes
FROM rooms r
         INNER JOIN reservations t ON t.room_Id = r.id
         LEFT JOIN customers c ON t.customer_id = c.id
WHERE NOT t.status = 'SCHEDULED'
GROUP BY r.id, r.room_number, r.type, r.price;

---- 10 Os 3 quartos mais ocupados ----

SELECT
    r.id,
    r.room_number,
    r.type,
    r.price,
    COUNT(c.id) AS total_ocupantes
FROM rooms r
         INNER JOIN reservations t ON t.room_Id = r.id
         LEFT JOIN customers c ON t.customer_id = c.id
WHERE t.status = 'FINISHED'
GROUP BY r.id, r.room_number, r.type, r.price
ORDER BY total_ocupantes DESC
    LIMIT 3;

---- 11 Os 10 melhores cliente ----

SELECT
    r.id,
    r.name,
    r.email,
    r.phone,
    COUNT(c.id) AS qtd_ocupacoes
FROM customers r
         INNER JOIN reservations c ON c.customer_id = r.id
GROUP BY r.id, r.name, r.email, r.phone
ORDER BY qtd_ocupacoes DESC
    LIMIT 10;
