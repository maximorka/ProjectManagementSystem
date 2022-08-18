
--adding data in TABLEs
INSERT  INTO company(name, address)
VALUES
('Happy_work', 'Ukraine, Kyiv'),
('Shark company', 'Ukraine, Lviv'),
('Marmalade','Ukraine, Lugansk');
SELECT * FROM company;


INSERT  INTO developer(name,surname, age, sex,salary,company_id)
VALUES
('Max', 'Bugalo', 46,'male',4400,1),
('Huan', 'Pedro', 33,'male',2200,2),
('Anna', 'Maria', 24,'famale',2200,3),
('Ivan', 'Alien', 111,'unknown',4600,1);
SELECT * FROM developer;
INSERT  INTO customer(name, address)
VALUES
('Ministry of Defence', 'Ukraine, Kyiv'),
('Petro', 'Mexico, Mexico');
SELECT * FROM customer;


INSERT  INTO project(name, description,customer_id,company_id,cost,date)
VALUES
('Bad day', 'Software for the product which can do very big damage enemy unit in sea',1,1,12,'2020-02-11'),
('Cookie', 'Cookie cookie soft',1,2,13,'1995-12-13'),
('Cucumber', 'Software for the cucumber',2,1,14,'2022-07-17'),
('Loaf', 'Software which control cooking machine',1,2,15,'2021-03-21');
SELECT * FROM project;


INSERT  INTO skills(kategory,level)
VALUES
('Java', 'middle'),
('C++', 'junior'),
('C#', 'senior'),
('Java', 'senior');
SELECT * FROM skills;

INSERT  INTO developer_skills(develop_id, skills_id)
VALUES
(1, 4),
(1, 2),
(2, 1),
(3, 1),
(4, 2),
(4, 3);
SELECT * FROM developer_skills;


INSERT INTO developer_project(develop_id,project_id)
VALUES
(1,1),
(2,1),
(3,2),
(1,3),
(3,4),
(4,2);
SELECT * FROM developer_project;