/* 

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

*/

-- Создание и заполнение Базы данных

CREATE DATABASE human_friends;
USE human_friends;

-- Тип животных
DROP TABLE IF EXISTS type_animal;
CREATE TABLE type_animal (
	id SERIAL PRIMARY KEY, -- SERIAL = BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE
    type_animal VARCHAR(50)
);

INSERT INTO type_animal (id, type_animal) VALUES 
(1, 'Pet'),
(2, 'Pack animals');

-- Вид животных
DROP TABLE IF EXISTS class_animal;
CREATE TABLE class_animal (
	id SERIAL PRIMARY KEY,
	type_animal_id BIGINT UNSIGNED NOT NULL,
    class_animal_name VARCHAR(50),
    FOREIGN KEY (type_animal_id) REFERENCES type_animal(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO class_animal  (id, type_animal_id, class_animal_name) VALUES
(1, 1, 'Собака'),
(2, 1, 'Кошка'),
(3, 1, 'Хомяк'),
(4, 2, 'Лошадь'),
(5, 2, 'Верблюд'),
(6, 2, 'Осёл');

-- Животные
DROP TABLE IF EXISTS animal;
CREATE TABLE animal (
	id SERIAL PRIMARY KEY,
	class_animal_id BIGINT UNSIGNED NOT NULL,
    animal_name VARCHAR(50),
    birthday DATE,
    FOREIGN KEY (class_animal_id) REFERENCES class_animal(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animal  (id, class_animal_id, animal_name, birthday) VALUES
(1, 1, 'Шарик', '2013-11-08'),
(2, 1, 'Бобик', '2023-01-01'),
(3, 2, 'Муська', '2003-11-10'),
(4, 2, 'Рыжик', '2022-02-02'),
(5, 3, 'Гоша', '2023-04-08'),
(6, 3, 'Гена', '2022-09-08'),
(7, 4, 'Ягодка', '2005-10-08'),
(8, 4, 'Варяг', '2015-09-01'),
(9, 5, 'Мисти', '1995-12-08'),
(10, 5, 'Драма', '2000-10-15'),
(11, 6, 'Тобина', '2009-11-07'),
(12, 6, 'Хельда', '2017-05-08');

-- Команды
DROP TABLE IF EXISTS comand;
CREATE TABLE comand (
	id SERIAL PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    comand_name VARCHAR(50),
    
    FOREIGN KEY (animal_id) REFERENCES animal(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO comand  (animal_id, comand_name) VALUES
(1, 'Ко мне'),
(1, 'Голос'),
(2, 'Ко мне'),
(2, 'Голос'),
(3, ''),
(4, ''),
(5, 'Ко мне'),
(6, 'Ко мне'),
(7, 'Ко мне'),
(8, 'Ко мне'),
(9, 'Ко мне'),
(10, 'Ко мне'),
(11, 'Ко мне'),
(12, 'Ко мне');

/*
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
*/
SET SQL_SAFE_UPDATES = 0;

DELETE FROM class_animal
WHERE class_animal_name = 'Верблюд';

SELECT 
class_animal_name, 
animal_name
FROM class_animal
JOIN animal an ON an.class_animal_id = class_animal.id
WHERE class_animal_name = 'Лошадь' OR class_animal_name ='Осёл';

/*
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/

DROP TABLE IF EXISTS young_animal;
CREATE TABLE young_animal 
SELECT
id,
animal_name,
birthday,
CONCAT(
EXTRACT(YEAR FROM (CURDATE() - INTERVAL 
CONCAT(EXTRACT(YEAR FROM birthday),'-',EXTRACT(MONTH FROM birthday))
YEAR_MONTH)),'y',EXTRACT(MONTH FROM (CURDATE() - INTERVAL 
CONCAT(EXTRACT(YEAR FROM birthday),'-',EXTRACT(MONTH FROM birthday)) 
YEAR_MONTH)), 'm') AS age
FROM animal
WHERE birthday < CURDATE() - INTERVAL 1 YEAR AND birthday > CURDATE() - INTERVAL 3 YEAR;

/*
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/
SELECT * FROM type_animal
JOIN class_animal ca ON ca.type_animal_id = type_animal.id
JOIN animal an ON an.class_animal_id = ca.id
JOIN comand com ON com.animal_id = an.id;