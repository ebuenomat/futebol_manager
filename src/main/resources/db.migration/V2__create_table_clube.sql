CREATE TABLE clube (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_fantasia VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    fundacao DATE,
    mascote VARCHAR(25),
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(20),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    numero VARCHAR(10),
    complemento VARCHAR(255)
);