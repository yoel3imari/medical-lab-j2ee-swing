DROP DATABASE IF EXISTS medicallab;

CREATE DATABASE IF NOT EXISTS medicallab;
USE medicallab;

CREATE TABLE IF NOT EXISTS admins (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username CHAR(20) UNIQUE,
    password CHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fName VARCHAR(25),
    lName VARCHAR(25),
    cin VARCHAR(12) UNIQUE,
    email VARCHAR(50) DEFAULT NULL,
    phone VARCHAR(10),
    gender VARCHAR(6) CHECK (gender IN ('Male', 'Female')),
    birthdate DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create table if not EXISTS tests (
    id int primary key AUTO_INCREMENT,
    label text,
    price decimal(8,2),
    description TEXT, 
    type VARCHAR(50),
    created_at date default now(),
    updated_at date default now()
);

CREATE TABLE IF NOT EXISTS appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_patient INT,
    day DATE,
    hour CHAR(6),
    state CHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_patient) REFERENCES patients(id)
);

CREATE TABLE IF NOT EXISTS appointment_tests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_appointment INT,
    id_test INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_appointment) REFERENCES appointments(id),
    FOREIGN KEY (id_test) REFERENCES tests(id)
);

INSERT INTO admins (username, password) VALUES ('admin', '12345678');
