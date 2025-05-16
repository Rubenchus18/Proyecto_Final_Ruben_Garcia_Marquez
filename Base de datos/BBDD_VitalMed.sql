
DROP DATABASE IF EXISTS ClinicaMedica;
CREATE DATABASE ClinicaMedica;
USE ClinicaMedica;

-- Tabla Empleados
CREATE TABLE Empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100)  NOT NULL,
    rol ENUM('admin', 'medico', 'recepcionista', 'paciente') NOT NULL
);

-- Tabla Pacientes
CREATE TABLE Pacientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(15),
    fecha_nacimiento DATE,
    correo_electronico VARCHAR(100) UNIQUE,
    empleado_id INT UNIQUE, 
    FOREIGN KEY (empleado_id) REFERENCES Empleados(id) ON DELETE CASCADE
);

-- Tabla Médicos
CREATE TABLE Medicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100),
    horario VARCHAR(100),
    empleado_id INT UNIQUE, 
    FOREIGN KEY (empleado_id) REFERENCES Empleados(id) ON DELETE CASCADE
);

-- Tabla Recepcionistas
CREATE TABLE Recepcionistas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    empleado_id INT UNIQUE, 
    FOREIGN KEY (empleado_id) REFERENCES Empleados(id) ON DELETE CASCADE
);

-- Tabla Citas
CREATE TABLE Citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    paciente_id INT,
    medico_id INT,
    motivo VARCHAR(200),
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES Medicos(id) ON DELETE CASCADE
);

-- Tabla Historiales_Médicos
CREATE TABLE Historiales_Medicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT,
    medico_id INT,
    diagnostico TEXT,
    tratamiento TEXT,
    receta TEXT,
    fecha DATE,
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES Medicos(id) ON DELETE CASCADE
);

-- Tabla Facturas
CREATE TABLE Facturas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT,
    monto DECIMAL(10, 2),
    fecha DATE,
    pagado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id) ON DELETE CASCADE
);

-- Insertar datos 

-- Insertar empleados
INSERT INTO Empleados (username, password, rol)
VALUES 
    ('admin', 'admin123', 'admin'),
    ('medico1', 'medico123', 'medico'),
    ('recepcion1', 'recepcion123', 'recepcionista'),
    ('ruben', '1234', 'paciente');

-- Insertar pacientes
INSERT INTO Pacientes (dni, nombre, direccion, telefono, fecha_nacimiento, correo_electronico, empleado_id)
VALUES 
    ('12345678A', 'Ruben', 'Calle Falsa 123', '555-1234', '1985-05-15', 'ruben@example.com', 4);

-- Insertar médicos
INSERT INTO Medicos (nombre, especialidad, horario, empleado_id)
VALUES 
    ('Dr. Carlos López', 'Cardiología', 'Lunes a Viernes, 8:00 - 16:00', 2);
  

-- Insertar recepcionistas
INSERT INTO Recepcionistas (nombre, empleado_id)
VALUES 
    ('Recepcionista Principal', 3); 

-- Insertar citas
INSERT INTO Citas (fecha, hora, paciente_id, medico_id, motivo)
VALUES 
    ('2023-10-20', '10:00', 1, 1, 'Dolor en el pecho');

-- Insertar historiales médicos
INSERT INTO Historiales_Medicos (paciente_id, medico_id, diagnostico, tratamiento, receta, fecha)
VALUES 
    (1, 1, 'migraña', 'Dieta baja en sal y ejercicio', 'Medicamento X, 1 tableta al día', '2023-10-20');


-- Insertar facturas
INSERT INTO Facturas (paciente_id, monto, fecha, pagado)
VALUES 
    (1, 150.00, '2023-10-20', FALSE);
    




