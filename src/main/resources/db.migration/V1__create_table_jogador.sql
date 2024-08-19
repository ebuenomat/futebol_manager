CREATE TABLE jogador (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INT,
    posicao VARCHAR(50),
    status VARCHAR(50),
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(20),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    numero VARCHAR(10),
    complemento VARCHAR(255)
);