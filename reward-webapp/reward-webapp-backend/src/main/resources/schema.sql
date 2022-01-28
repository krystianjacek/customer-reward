DROP TABLE IF EXISTS tab_customer;
CREATE TABLE tab_customer
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255)
);

DROP TABLE IF EXISTS tab_transaction;
CREATE TABLE tab_transaction
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    price NUMERIC,
    date TIMESTAMP WITH TIME ZONE
);
