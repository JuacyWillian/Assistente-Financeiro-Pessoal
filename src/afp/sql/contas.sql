-- insert contas
INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) VALUES (?, ?, ?, ?, ?, ?, ?, ?);

-- update contas
UPDATE contas SET titulo=?, descricao=?, cat_id=?, tipo=?, valor=?, dt_criacao=?, dt_vencimento=?, quitado=? WHERE id=?;

-- select contas
SELECT * FROM contas LEFT JOIN categorias ON contas.cat_id = categorias.id;

-- delete all in contas
DELETE FROM contas WHERE id>0;