CREATE TABLE users(
    id_user SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    fullname VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL
);

CREATE TABLE categorytemplates (
    id_categorytemplate SERIAL PRIMARY KEY,
    categorytemplate_description VARCHAR(200) NOT NULL
);

CREATE TABLE categories(
    id_category SERIAL PRIMARY KEY,
    category_description VARCHAR(200) NOT NULL,
    id_user INTEGER NOT NULL,
    CONSTRAINT fk_categories_users FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE users_categorytemplates (
    id_user_categorytemplate SERIAL PRIMARY KEY,
    id_categorytemplate INTEGER NOT NULL,
    id_user INTEGER NOT NULL,
    CONSTRAINT fk_uct_template FOREIGN KEY (id_categorytemplate) REFERENCES categorytemplates(id_categorytemplate),
    CONSTRAINT fk_uct_user FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE transactions(
    id_transaction SERIAL PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_description VARCHAR(250),
    transaction_date DATE NOT NULL,
    id_user INTEGER NOT NULL,
    id_category INTEGER NOT NULL,
    CONSTRAINT fk_transaction_user FOREIGN KEY (id_user) REFERENCES users(id_user),
    CONSTRAINT fk_transaction_category FOREIGN KEY (id_category) REFERENCES categories(id_category)
);