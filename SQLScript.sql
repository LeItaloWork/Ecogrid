-- 1. Tabela: Community
CREATE TABLE Community (
    community_id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    location VARCHAR2(150),
    population NUMBER
);

-- 2. Tabela: User
CREATE TABLE "User" (
    user_id NUMBER PRIMARY KEY,
    community_id NUMBER,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR2(255) NOT NULL,
    role VARCHAR2(10) CHECK (role IN ('admin', 'operator')),
    email VARCHAR2(100),
    FOREIGN KEY (community_id) REFERENCES Community(community_id) ON DELETE SET NULL
);

-- 3. Tabela: Microgrid
CREATE TABLE Microgrid (
    microgrid_id NUMBER PRIMARY KEY,
    community_id NUMBER,
    capacity NUMBER(10, 2) NOT NULL, -- capacidade em kWh
    status VARCHAR2(12) CHECK (status IN ('active', 'maintenance')),
    FOREIGN KEY (community_id) REFERENCES Community(community_id) ON DELETE CASCADE
);

-- 4. Tabela: EnergyUsage
CREATE TABLE EnergyUsage (
    usage_id NUMBER PRIMARY KEY,
    microgrid_id NUMBER,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    consumption NUMBER(10, 2) NOT NULL, -- consumo em kWh
    cost NUMBER(10, 2), -- custo estimado do consumo
    FOREIGN KEY (microgrid_id) REFERENCES Microgrid(microgrid_id) ON DELETE CASCADE
);

-- 5. Tabela: EnergyStorage
CREATE TABLE EnergyStorage (
    storage_id NUMBER PRIMARY KEY,
    microgrid_id NUMBER,
    capacity NUMBER(10, 2) NOT NULL, -- capacidade de armazenamento em kWh
    status VARCHAR2(12) CHECK (status IN ('charging', 'available', 'maintenance')),
    FOREIGN KEY (microgrid_id) REFERENCES Microgrid(microgrid_id) ON DELETE CASCADE
);

-- 6. Tabela: SecurityLog
CREATE TABLE SecurityLog (
    log_id NUMBER PRIMARY KEY,
    user_id NUMBER,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    event_type VARCHAR2(50) NOT NULL, -- tipo de evento de segurança
    description CLOB,
    FOREIGN KEY (user_id) REFERENCES "User"(user_id) ON DELETE SET NULL
);

-- 7. Tabela: Billing
CREATE TABLE Billing (
    billing_id NUMBER PRIMARY KEY,
    community_id NUMBER,
    billing_date DATE NOT NULL,
    amount NUMBER(10, 2) NOT NULL, -- valor da cobrança
    status VARCHAR2(10) CHECK (status IN ('paid', 'pending')),
    FOREIGN KEY (community_id) REFERENCES Community(community_id) ON DELETE CASCADE
);

-- Comandos de DROP para exclusão das tabelas, caso necessário
DROP TABLE IF EXISTS Billing CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS SecurityLog CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS EnergyStorage CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS EnergyUsage CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS Microgrid CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS "User" CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS Community CASCADE CONSTRAINTS;
