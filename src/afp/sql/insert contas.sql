-- insert contas
INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) 
VALUES (
	"Conta de Luz de Abril", 
    "Conta de luz do mes de abril", 
    2, 
    "DESPESA",
    150,
    20160401, 
    20160405, 
    true
);

INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) 
VALUES (
	"Conta de Luz de Maio", 
    "Conta de luz do mes de maio", 
    2, 
    "DESPESA",
    155,
    20160501, 
    20160505, 
    false
);

INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) 
VALUES (
	"Conta de Gas de Abril", 
    "Conta de Gas do mes de abril", 
    2, 
    "DESPESA",
    100,
    20160401, 
    20160405, 
    false
);

INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) 
VALUES (
	"Filme do Homem de Ferro 3", 
    "Conta do cinema", 
    3, 
    "DESPESA",
    30,
    20160401, 
    20160401, 
    true
);

INSERT INTO contas(titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) 
VALUES (
	"Viagem para Maui",
    "Viagem de férias para o hawai",
    5,
    "DESPESA",
    3000,
    20160401,
    20160401,
    true
);
