
insert into tb_endereco(logradouro, cep) values('rua aleatoria numero 123', '1234567890');
insert into tb_endereco(logradouro, cep) values('rua suspeita numero 123', '1234567890');

insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('daniel', '1928472942', 1, 500);
insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('gabriel', '1348472942', 2, 120);

--insert into tb_tarifa(conta_id, valor) values(2, 15.0);
--insert into tb_tarifa(conta_id, valor) values(1, 10.0);

insert into tb_conta(entrada, tipo_tarifa, tipo_veiculo) values('2022-06-13 09:10:01', 'ATE_UMA_HORA', 'MOTO');
insert into tb_conta(entrada, tipo_tarifa, tipo_veiculo) values('2022-06-13 09:10:01', 'ATE_UMA_HORA', 'CARRO');

insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('CARRO', 'c137g23', 1);
insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('MOTO', 'c157g26', 1);

