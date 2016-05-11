-- insert categorias
INSERT INTO categorias(titulo, descricao) VALUES (?, ?);

-- update categorias
UPDATE categorias SET titulo=?, descricao=? WHERE id=?;

-- select categorias
SELECT * FROM categorias;

-- delete all in categorias
DELETE FROM categorias WHERE id>0;