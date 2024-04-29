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

CREATE TABLE IF NOT EXISTS tests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    label TEXT,
    price DECIMAL(8,2),
    days_to_get_result INT,
    duration INT,
    description TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT not null,
    test_id INT not null,
    day DATE,
    hour TIME,
    state CHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY (test_id) REFERENCES tests(id) ON DELETE CASCADE
);

INSERT INTO admins (username, password) VALUES ('admin', '12345678');

INSERT INTO `tests` (`id`, `label`, `price`, `duration`, `days_to_get_result`, `description`, `created_at`, `updated_at`) VALUES
(1, 'Blood Test', 888.00, 60, 3, 'A standard blood test to check various parameters. ', '2024-04-24 23:21:50', '2024-04-27 20:57:29'),
(2, 'Urine Test	', 500.00, 40, 5, 'Analysis of urine sample for various health markers.', '2024-04-25 00:40:07', '2024-04-27 20:58:45'),
(3, 'MRI Scan', 700.00, 54, 6, 'Magnetic Resonance Imaging for detailed body scans.', '2024-04-25 00:42:02', '2024-04-27 21:00:12'),
(4, 'X-Ray', 450.00, 30, 5, 'Imaging technique to visualize internal structures.', '2024-04-25 00:47:00', '2024-04-27 21:01:02'),
(5, 'CT Scan', 350.00, 45, 3, 'Computerized Tomography for detailed imaging.', '2024-04-25 00:56:33', '2024-04-27 21:01:48'),
(6, 'ECG', 460.00, 35, 4, 'Electrocardiogram for heart function assessment.', '2024-04-25 01:03:22', '2024-04-27 21:02:38'),
(7, 'Mammogram', 400.00, 60, 3, 'Breast cancer screening using X-ray images.', '2024-04-25 01:16:37', '2024-04-27 21:04:41'),
(8, 'Pap Smear', 400.00, 15, 3, 'Cervical cancer screening through cell examination.', '2024-04-25 13:38:49', '2024-04-27 21:04:32'),
(12, 'Colonoscopy', 700.00, 2, 7, 'Examination of the colon for polyps and cancer.', '2024-04-27 21:07:01', '2024-04-27 21:07:01'),
(13, 'Prostate Exam', 399.00, 30, 2, 'Screening for prostate cancer in men.', '2024-04-27 21:08:00', '2024-04-27 21:08:00'),
(14, 'Genetic Testing', 1200.00, 70, 14, 'Analysis of DNA for genetic predispositions.', '2024-04-27 21:09:46', '2024-04-27 21:09:46'),
(15, 'Urine Drug Screen', 300.00, 1, 2, 'Screening test to detect the presence of drugs or their metabolites in urine.', '2024-04-27 21:12:09', '2024-04-27 21:12:09'),
(16, 'Hair Follicle Drug Test', 600.00, 1, 5, 'Test that analyzes a small sample of hair to detect the presence of drugs over an extended period, usually up to 90 days.', '2024-04-27 21:13:03', '2024-04-27 21:13:03'),
(17, 'Heavy Metal Panel', 900.00, 600, 5, 'Blood test to detect the presence of heavy metals such as lead, mercury, and arsenic, which can be toxic to the body.', '2024-04-27 21:14:24', '2024-04-27 21:14:24'),
(18, 'Skin Prick Test', 600.00, 30, 1, 'Introduction of small amounts of allergens into the skin to measure allergic reactions.', '2024-04-27 21:15:08', '2024-04-27 21:15:08'),
(19, 'Food Allergy Panel', 400.00, 50, 8, ' Blood test to identify allergies to specific foods by measuring IgE antibodies against common food allergens.', '2024-04-27 21:15:57', '2024-04-27 21:15:57'),
(20, 'Environmental Allergy Panel', 500.00, 60, 2, 'Blood test to identify allergies to environmental allergens such as pollen, dust mites, and pet dander', '2024-04-27 21:16:39', '2024-04-27 22:04:03'),
(21, 'blood test', 500.00, 20, 1, 'blood test', '2024-04-28 02:41:29', '2024-04-28 16:18:20');

INSERT INTO patients (fName, lName, cin, email, phone, gender, birthdate)
VALUES 
    ('Ahmed', 'Benbrahim', 'AB123456', 'ahmed@example.com', '0612345678', 'Male', '1990-05-15'),
    ('Fatima', 'El Kadi', 'FK987654', 'fatima@example.com', '0612345679', 'Female', '1985-10-20'),
    ('Youssef', 'Hassani', 'YH456789', NULL, '0612345680', 'Male', '1982-07-08'),
    ('Amina', 'Ouahbi', 'AO789012', 'amina@example.com', '0612345681', 'Female', '1995-02-28');


INSERT INTO `appointments` (`id`, `patient_id`, `test_id`, `day`, `hour`, `state`, `created_at`, `updated_at`) VALUES
(1, 1, 17, '2024-07-24', '11:30:00', 'pending', '2024-04-29 17:00:07', '2024-04-29 17:00:07'),
(2, 1, 21, '2024-06-26', '08:30:00', 'pending', '2024-04-29 17:02:15', '2024-04-29 17:02:15'),
(3, 1, 21, '2024-07-24', '09:00:00', 'pending', '2024-04-29 17:06:49', '2024-04-29 17:06:49'),
(4, 1, 21, '2024-08-22', '09:30:00', 'pending', '2024-04-29 17:09:35', '2024-04-29 17:09:35'),
(5, 1, 21, '2024-08-21', '10:00:00', 'pending', '2024-04-29 17:20:05', '2024-04-29 17:20:05'),
(6, 1, 14, '2024-04-30', '09:00:00', 'pending', '2024-04-29 17:26:24', '2024-04-29 17:26:24'),
(7, 1, 14, '2024-04-30', '10:30:00', 'pending', '2024-04-29 17:26:36', '2024-04-29 17:26:36');

