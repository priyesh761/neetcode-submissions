-- Write your query below
SELECT name
    FROM customers LEFT JOIN orders
    ON customers.id=orders.customer_id
    where orders.id is NULL;