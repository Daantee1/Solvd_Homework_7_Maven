SELECT * FROM mydb.animals;
INSERT INTO animals (id, name, species) values(1, "Alex", "Cat");
INSERT INTO animals (id, name, species) values(2, "Albert", "Dog");
INSERT INTO cars (id,model) VALUES(1, "BMW");
INSERT INTO cars (id,model) VALUES(2, "AUDI");
INSERT INTO dormitories (id, name, room, address) VALUES(1, "Żaczek", "505", "akademiki 2A");
INSERT INTO dormitories (id, name, room, address) VALUES(2, "Arkadia", "400", "akademiki 4A");
INSERT INTO events (id, name, ticket_number) VALUES(1, "Kacper", 5502);
INSERT INTO events (id, name, ticket_number) VALUES(2, "Paweł", 5486);
INSERT INTO dean (id, name, surname) VALUES(1, "Marek", "Paćko");
INSERT INTO dean (id, name, surname) VALUES(2, "Arkadiusz", "Brazko");

UPDATE animals SET name = "BlackCat" WHERE id = 1;
UPDATE animals SET species = "Frog" WHERE id = 2;
UPDATE cars SET model = "Volvo" WHERE id = 1;
UPDATE cars SET model = "Skoda" WHERE id = 2;
UPDATE dormitories SET name = "Urysn" WHERE id = 1;
UPDATE dormitories SET room = 512 WHERE id = 2;
UPDATE events SET name = "Maciek" WHERE id = 1;
UPDATE events SET ticket_number = 5501 WHERE id = 1;
UPDATE dean SET dean = "Mariusz" WHERE id = 1;
UPDATE dean SET surname = "Paciek" WHERE id = 1;

DELETE FROM animals WHERE id = 1;
DELETE FROM animals WHERE id = 2;
DELETE FROM cars WHERE id = 1;
DELETE FROM cars WHERE id = 2;
DELETE FROM dormitories WHERE id = 1;
DELETE FROM dormitories WHERE id = 2;
DELETE FROM events WHERE id = 1;
DELETE FROM events WHERE id = 2;
DELETE FROM dean WHERE id = 1;
DELETE FROM dean WHERE id = 2;

ALTER TABLE animals ADD COLUMN age INT;
ALTER TABLE animals ADD COLUMN owner VARCHAR(15);
ALTER TABLE cars ADD COLUMN color VARCHAR(15);
ALTER TABLE cars ADD COLUMN year_of_production INT;
ALTER TABLE dormitories RENAME COLUMN name TO owner;
ALTER TABLE dormitories ADD COLUMN price INT;
ALTER TABLE events ADD COLUMN date datetime;
ALTER TABLE events ADD COLUMN price INT;
ALTER TABLE dean ADD COLUMN date datetime;
ALTER TABLE dean ADD COLUMN proffesion VARCHAR(20);

SELECT 
    s.id AS student_id, s.name AS student_name, s.surname AS student_surname, s.location,
    c.id AS car_id, c.model AS car_model,
    d.id AS dormitory_id, d.name AS dormitory_name, d.room, d.address,
    dean.id AS dean_id, dean.name AS dean_name, dean.surname AS dean_surname,
    ts.id AS thesis_supervisor_id, ts.name AS thesis_supervisor_name, ts.surname AS thesis_supervisor_surname,
    g.id AS grade_id, g.na AS grade,
    a.id AS animal_id, a.name AS animal_name, a.species AS animal_species,
    sch.id AS scholarship_id, sch.amout AS scholarship_amount,
    crs.id AS course_id, crs.name AS course_name,
    fos.id AS field_of_study_id, fos.name AS field_of_study_name,
    ac.id AS academic_circle_id, ac.name AS academic_circle_name,
    bb.id AS borrowed_book_id, bb.name AS borrowed_book_name, bb.return_time AS book_return_time,
    ev.id AS event_id, ev.name AS event_name, ev.ticket_number AS ticket_number
FROM 
    Students s
    JOIN Cars c ON s.Cars_id = c.id
    JOIN Dormitories d ON s.Dormitories_id = d.id
    JOIN Dean dean ON s.Dean_id = dean.id
    JOIN Thesis_Supervisor ts ON s.Thesis_Supervisor_id = ts.id
    JOIN Grades g ON s.Grades_id = g.id
    JOIN Animals a ON s.Animals_id = a.id
    JOIN Scholarship sch ON s.Scholarship_id = sch.id
    
    LEFT JOIN Students_has_Courses shc ON s.id = shc.Students_id
    LEFT JOIN Courses crs ON shc.Courses_id = crs.id
    LEFT JOIN Students_has_Filed_Of_Study shfos ON s.id = shfos.Students_id
    LEFT JOIN Fileds_Of_Study fos ON shfos.Filed_Of_Study_id = fos.id
    LEFT JOIN Students_has_Academic_Circles shac ON s.id = shac.Students_id
    LEFT JOIN Academic_Circles ac ON shac.Academic_Circles_id = ac.id
    LEFT JOIN Students_has_Borrowed_Books shbb ON s.id = shbb.Students_id
    LEFT JOIN Borrowed_Books bb ON shbb.Borrowed_Books_id = bb.id
    LEFT JOIN Students_has_Events she ON s.id = she.Students_id
    LEFT JOIN Events ev ON she.Events_id = ev.id;
    
SELECT 
    s.id AS student_id, 
    s.name AS student_name, 
    c.model AS car_model
FROM 
    Students s
LEFT JOIN 
    Cars c ON s.Cars_id = c.id;

SELECT 
    d.id AS dormitory_id, 
    d.name AS dormitory_name, 
    s.name AS student_name
FROM 
    Students s
RIGHT JOIN 
    Dormitories d ON s.Dormitories_id = d.id;
    
SELECT 
    s.id AS student_id, 
    s.name AS student_name, 
    dean.name AS dean_name
FROM 
    Students s
INNER JOIN 
    Dean dean ON s.Dean_id = dean.id;
    
SELECT 
    s.id AS student_id, 
    s.name AS student_name, 
    bb.name AS borrowed_book
FROM 
    Students s
LEFT JOIN 
    Students_has_Borrowed_Books shbb ON s.id = shbb.Students_id
LEFT JOIN 
    Borrowed_Books bb ON shbb.Borrowed_Books_id = bb.id
WHERE 
    bb.id IS NOT NULL;
    
SELECT 
    s.id AS student_id, 
    s.name AS student_name, 
    sch.amout AS scholarship_amount
FROM 
    Students s
LEFT JOIN 
    Scholarship sch ON s.Scholarship_id = sch.id
UNION
SELECT 
    s.id AS student_id, 
    s.name AS student_name, 
    sch.amout AS scholarship_amount
FROM 
    Students s
RIGHT JOIN 
    Scholarship sch ON s.Scholarship_id = sch.id;
    
SELECT 
    Dormitories_id, 
    COUNT(id) AS total_students
FROM 
    Students
GROUP BY 
    Dormitories_id;

SELECT 
    id, 
    MAX(return_time) AS latest_return_time
FROM 
    Borrowed_Books
GROUP BY 
    id;
    
SELECT 
    Students_id, 
    COUNT(Courses_id) AS total_courses
FROM 
    Students_has_Courses
GROUP BY 
    Students_id;
    
SELECT 
    Academic_Circles_id, 
    COUNT(Students_id) AS total_students
FROM 
    Students_has_Academic_Circles
GROUP BY 
    Academic_Circles_id;
    
SELECT 
    Dormitories_id, 
    COUNT(*) AS total_students
FROM 
    Students
GROUP BY 
    Dormitories_id;
    
SELECT 
    Scholarship_id, 
    SUM(CAST(amout AS DECIMAL(10, 2))) AS total_scholarship
FROM 
    Scholarship
GROUP BY 
    Scholarship_id;
    
SELECT 
    Grades_id, 
    AVG(CAST(na AS DECIMAL(10,2))) AS average_grade
FROM 
    Grades
GROUP BY 
    Grades_id;
    

SELECT 
    Dormitories_id, 
    COUNT(*) AS total_students
FROM 
    Students
GROUP BY 
    Dormitories_id
HAVING 
    total_students > 10;

SELECT 
    Grades_id, 
    AVG(CAST(na AS DECIMAL(10, 2))) AS average_grade
FROM 
    Grades
GROUP BY 
    Grades_id
HAVING 
    average_grade > 3.5;
    
SELECT 
    Students_id, 
    COUNT(Borrowed_Books_id) AS total_books
FROM 
    Students_has_Borrowed_Books
GROUP BY 
    Students_id
HAVING 
    total_books > 5;

SELECT 
    Scholarship_id, 
    SUM(CAST(amout AS DECIMAL(10, 2))) AS total_scholarship
FROM 
    Scholarship
GROUP BY 
    Scholarship_id
HAVING 
    total_scholarship > 2000;
    
SELECT 
    Scholarship_id, 
    MIN(CAST(amout AS DECIMAL(10, 2))) AS min_scholarship
FROM 
    Scholarship
GROUP BY 
    Scholarship_id
HAVING 
    min_scholarship > 1000;

SELECT 
    Courses_id, 
    COUNT(Students_id) AS total_students
FROM 
    Students_has_Courses
GROUP BY 
    Courses_id
HAVING 
    total_students > 3;
    
SELECT 
    Academic_Circles_id, 
    COUNT(Students_id) AS total_members
FROM 
    Students_has_Academic_Circles
GROUP BY 
    Academic_Circles_id
HAVING 
    total_members > 3;
    
SELECT 
    Grades_id, 
    AVG(CAST(na AS DECIMAL(10, 2))) AS average_grade
FROM 
    Grades
GROUP BY 
    Grades_id
HAVING 
    average_grade < 3.0;
    
    


