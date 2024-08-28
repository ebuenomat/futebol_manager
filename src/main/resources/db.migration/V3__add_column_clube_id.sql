ALTER TABLE jogador
ADD COLUMN clube_id BIGINT;

ALTER TABLE jogador
ADD CONSTRAINT fk_clube
FOREIGN KEY (clube_id) REFERENCES clube(id);