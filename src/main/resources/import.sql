-- This file allow to write SQL commands that will be emitted in test and dev.

-- The commands are commented as their support depends of the database

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');

-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

-- Active: 1672226063112@@127.0.0.1@50575

-- Insert Address

INSERT INTO
    `Address`(
        id,
        city,
        houseNumber,
        street,
        zip
    )
VALUES (
        1,
        'Budapest',
        '1',
        'Kossuth Lajos',
        '1111'
    ), (
        2,
        'Osnabrueck',
        '49',
        'Sedanstrasse',
        '46697'
    ), (
        3,
        'London',
        '1',
        'Baker Street',
        'NW1 6XE'
    );

-- Insert Customer

INSERT INTO
    `Customer`(
        id,
        firstname,
        lastname,
        address_id
    )
VALUES (1, 'John', 'Doe', 1), (2, 'Jane', 'Doe', 2), (3, 'Sherlock', 'Holmes', 3);

-- Insert Pizza

INSERT INTO
    `Pizza`(id, description, name, price)
VALUES (1, 'Is so good', 'funghi', 10), (
        2,
        'Italian Pizza',
        'Salami',
        11
    ), (3, 'Awosome', '4 Seesion', 11)