-- Esto es util para hacer demostraciones o probar


-- Insertamos datos de ejemplo en la tabla Owner
INSERT INTO Owner(name, surname, address)
VALUES('Maximiliano', 'Sandoval', 'Calle 123');
INSERT INTO Owner(name, surname, address)
VALUES('Natalia', 'Cirullo', 'Calle 456');
INSERT INTO Owner(name, surname, address)
VALUES('Antonella', 'Bevilacqua', 'Calle 789');
INSERT INTO Owner(name, surname, address)
VALUES('Sergio', 'Benicio', 'Calle 101');
INSERT INTO Owner(name, surname, address)
VALUES('Brian', 'Mermelstein', 'Calle 112');

-- Insertamos datos de ejemplo en la tabla Pet
INSERT INTO Pet(name, age, species, owner_id)
VALUES('Chano', 2, 'Apiradora Robot', 1);
INSERT INTO Pet(name, age, species, owner_id)
VALUES('Pepe', 1, 'Sapo', 2);
INSERT INTO Pet(name, age, species, owner_id)
VALUES('Morita', 10, 'Perro', 3);
INSERT INTO Pet(name, age, species, owner_id)
VALUES('Bondiola', 3, 'Perro', 4);
INSERT INTO Pet(name, age, species, owner_id)
VALUES('Momo', 2, 'Gato', 5);

-- Insertamos usuarios con sus contraseñas encriptadas
--INSERT INTO "User"(name, surname, username, password)
--VALUES('Antonella', 'Bevilacqua', 'antobevib', '$2a$08$BK28FvD3/hUaVe6ioWqW/ef84x0D6lMgDN8jAA.vnJRpH.W4Rk07y'); -- 1234
INSERT INTO "User"(username, password)
VALUES('antobevib', '$2a$08$BK28FvD3/hUaVe6ioWqW/ef84x0D6lMgDN8jAA.vnJRpH.W4Rk07y'); --1234