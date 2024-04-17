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
    id int AUTO_INCREMENT primary key ,
    fName VARCHAR(25),
    lName VARCHAR(25),
    cin VARCHAR(12) unique,
    email VARCHAR(50) DEFAULT null,
    phone VARCHAR(10),
    gender VARCHAR(6) CHECK (gender IN ('Male', 'Female')),
    birthdate DATE
    created_at date default now(),
    updated_at date default now()
);

create table if not EXISTS tests (
    id int primary key AUTO_INCREMENT,
    label text,
    price decimal(8,2),
    result_after int,
    created_at date default now(),
    updated_at date default now()
);

create table if not EXISTS appointements (
    id int primary key AUTO_INCREMENT,
    id_patient int,
    day date,
    hour char(6),
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
