INSERT INTO countries VALUES
  (1, 'USA', 22.2),
  (2, 'Ukraine', 25.1),
  (3, 'Russia', 41.0),
  (4, 'China', 10.5),
  (5, 'Germany', 11.9);

INSERT INTO cities VALUES -- TODO Add normal values longitude and latitude
  (1, 1, 'Washington', 1, 1, 10.5),
  (2, 1, 'New York', 2, 2, 11),
  (3, 2, 'Kiev', 3, 3, 17.7),
  (4, 2, 'Odessa', 4, 4, 19.4),
  (5, 3, 'St. Petersburg', 5, 5, 13.5);

INSERT INTO branches VALUES
  (1, 1, 'Porter Street Northwest', '3523'),
  (2, 2, '49th Street', '4109'),
  (3, 2, 'West 182nd Street', '27-49'),
  (4, 3, 'вулиця Велика Васильківська', '100a'),
  (5, 4, 'Головківська вулиця', '25'),
  (6, 5, 'Знаменка улица', '13');

INSERT INTO users VALUES
  ('db81c084-80f9-11e6-ae22-56b6b6499611', '99999', 'qwerty', '@mail', 'Alvian', 'Fedoceev', 'CLIENT'),
  ('db81c354-80f9-11e6-ae22-56b6b6499611', '19875', 'qazwsx', '@gmail', 'Eduard', 'Guseev', 'CLIENT'),
  ('db81c502-80f9-11e6-ae22-56b6b6499611', '19889', 'zimeeko', '@yahoo', 'Tichon', 'Egorov', 'CLIENT'),
  ('db81c67e-80f9-11e6-ae22-56b6b6499611', '19801', 'tribel', '@yandex', 'Avkensiy', 'Subotin', 'MANAGER'),
  ('db81c818-80f9-11e6-ae22-56b6b6499611', '19900', 'isaiev', '@ukr', 'Efim', 'Alkseev', 'MANAGER');

INSERT INTO parcels VALUES
  ('a0000a74-fd22-11e7-8be5-0ed5f89f718b', 'db81c084-80f9-11e6-ae22-56b6b6499611', 'db81c354-80f9-11e6-ae22-56b6b6499611',
   2, 1, '2017-06-22 19:10:25', 'IN_TRANSIT', TRUE , 43.3),

  ('a0000de4-fd22-11e7-8be5-0ed5f89f718b', 'db81c354-80f9-11e6-ae22-56b6b6499611', 'db81c084-80f9-11e6-ae22-56b6b6499611',
   1, 2, '2017-06-27 11:11:59', 'IN_TRANSIT', TRUE , 322.5),

  ('a000137a-fd22-11e7-8be5-0ed5f89f718b', 'db81c502-80f9-11e6-ae22-56b6b6499611', 'db81c354-80f9-11e6-ae22-56b6b6499611',
   3, 2, '2017-03-12 14:20:33', 'IN_TRANSIT', TRUE , 10.7),

  ('a0001582-fd22-11e7-8be5-0ed5f89f718b', 'db81c354-80f9-11e6-ae22-56b6b6499611', 'db81c084-80f9-11e6-ae22-56b6b6499611',
   4, 5, '2016-11-22 09:01:46', 'IN_TRANSIT', TRUE , 73.45),

  ('a000174e-fd22-11e7-8be5-0ed5f89f718b', 'db81c354-80f9-11e6-ae22-56b6b6499611', 'db81c502-80f9-11e6-ae22-56b6b6499611',
   5, 4, '2017-01-12 16:32:00', 'IN_TRANSIT', TRUE , 21.8);

INSERT INTO goods VALUES
  ('b92aca4c-fd23-11e7-8be5-0ed5f89f718b', 'a0000a74-fd22-11e7-8be5-0ed5f89f718b', 0.32, 122, 21, 21, 32.4),
  ('b92ad53c-fd23-11e7-8be5-0ed5f89f718b', 'a0000de4-fd22-11e7-8be5-0ed5f89f718b', 4.66, 24, 17, 4, 200.9),
  ('b92ad866-fd23-11e7-8be5-0ed5f89f718b', 'a000137a-fd22-11e7-8be5-0ed5f89f718b', 1.5, 71, 12, 44, 10.0),
  ('b92adafa-fd23-11e7-8be5-0ed5f89f718b', 'a0001582-fd22-11e7-8be5-0ed5f89f718b', 2.0, 11, 63, 11, 72.7),
  ('b92add70-fd23-11e7-8be5-0ed5f89f718b', 'a000174e-fd22-11e7-8be5-0ed5f89f718b', 43.7, 44, 76, 55, 83.1);

INSERT INTO deliveries VALUES
  ('a334ffa4-fd24-11e7-8be5-0ed5f89f718b', 'a0000de4-fd22-11e7-8be5-0ed5f89f718b', TRUE , 2, 'Sullivan St', '150'),
  ('a33502ce-fd24-11e7-8be5-0ed5f89f718b', 'a0001582-fd22-11e7-8be5-0ed5f89f718b', FALSE, 4, 'ул. Малая Арнаутская', '27');