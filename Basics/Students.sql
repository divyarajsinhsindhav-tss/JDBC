CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(20),
    state VARCHAR(20),
    pincode VARCHAR(6)
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    roll_number INT,
    age INT,
    name VARCHAR(100),
    address_id INT REFERENCES address(id)
);


CREATE TABLE course (
    course_id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    fees NUMERIC(10,2)
);

CREATE TABLE enrolled (
    enrolled_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(id),
    course_id INT REFERENCES course(course_id)
);

INSERT INTO address (city, state, pincode) VALUES
('Rajkot', 'Gujarat', '360001'),
('Ahmedabad', 'Gujarat', '380001'),
('Surat', 'Gujarat', '395003'),
('Vadodara', 'Gujarat', '390001'),
('Mumbai', 'Maharashtra', '400001');

INSERT INTO students (roll_number, age, name, address_id) VALUES
(101, 20, 'Amit Patel', 1),
(102, 21, 'Rahul Shah', 2),
(103, 19, 'Priya Mehta', 3),
(104, 22, 'Neha Joshi', 1),
(105, 20, 'Karan Desai', 4);

INSERT INTO course (name, fees) VALUES
('Mathematics', 15000.00),
('Computer Science', 25000.00),
('Physics', 18000.00),
('Chemistry', 17000.00),
('Data Structures', 30000.00);

INSERT INTO enrolled (student_id, course_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3),
(3, 5),
(4, 1),
(4, 4),
(5, 2),
(5, 5);

SELECT 
    s.name AS student_name,
    s.roll_number,
    c.name AS course_name,
    a.city
FROM enrolled e
JOIN students s ON e.student_id = s.id
JOIN course c ON e.course_id = c.course_id
JOIN address a ON s.address_id = a.id;