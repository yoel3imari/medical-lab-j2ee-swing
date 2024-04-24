create DATABASE if not EXISTS medicallab;
use medicallab;

create table if not EXISTS admins (
    id int primary key AUTO_INCREMENT,
    username char(20) unique,
    password char(20),
    created_at date default now(),
    updated_at date default now()
);

create table if not EXISTS patients (
    id int primary key AUTO_INCREMENT,
    cin char(10) unique,
    email char(50) DEFAULT null,
    phone CHAR(30),
    gender char(10),
    birth date, 
    created_at date default now(),
    updated_at date default now()
);

CREATE TABLE IF NOT EXISTS tests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    label TEXT,
    price DECIMAL(8,2),
    daysToGetResult INT,
    description TEXT, 
    oftype VARCHAR(50),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


create table if not EXISTS appointements (
    id int primary key AUTO_INCREMENT,
    id_patient int,
    day date,
    houre char(6),
    state char(10),
    created_at date default now(),
    updated_at date default now(),
    FOREIGN key (id_patient) REFERENCES patients(id)
);

create table if not EXISTS appointement_tests (
    id int primary key AUTO_INCREMENT,
    id_appointement int,
    id_test int,
    created_at date default now(),
    updated_at date default now(),
    FOREIGN key (id_appointement) REFERENCES appointements(id),
    FOREIGN key (id_test) REFERENCES tests(id)
);

INSERT INTO admins (username, password) VALUES ('admin', '12345678');
