
insert into tb_endereco(logradouro, cep) values('rua aleatoria numero 123', '1234567890');
insert into tb_endereco(logradouro, cep) values('rua suspeita numero 123', '1234567890');

insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('daniel', '1928472942', 1, 500);
insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('gabriel', '1348472942', 2, 120);

insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('CARRO', 'c137g23', 1);
insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('MOTO', 'c157g26', 1);

