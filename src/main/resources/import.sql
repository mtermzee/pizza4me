-- This file allow to write SQL commands that will be emitted in test and dev.

-- The commands are commented as their support depends of the database

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1000,
        'Margherita',
        'San Marzano Tomaten Sauce, Mozzarella di bufala, Oliven Öl',
        9.90
    );

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1001,
        'Marinara',
        'Marinara Sauce, Knoblauch, Olivenöl, Basilikum, Oregano',
        9.90
    );

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1002,
        'Prosciutto e funghi',
        'Tomatensauce, Mozzarella, Prosciutto (italienischer Schinken),Pilze',
        9.90
    );

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1003,
        'Al Salmone',
        'Tomatensauce, Mozzarella, Lachs, Knoblauch',
        9.90
    );

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1004,
        'Mozzarella',
        'Tomatensauce, Büffelmozzarella',
        9.90
    );

INSERT INTO
    DATA.Pizza(id, name, description, price)
VALUES (
        1005,
        'Carbonara',
        'Pecorino Romano Käse, Sahne, Frühlingszwiebeln, Eier, schwarzer Pfeffer',
        9.90
    );