
insert into tb_endereco(logradouro, cep) values('rua aleatoria numero 123', '1234567890');
insert into tb_endereco(logradouro, cep) values('rua suspeita numero 123', '1234567890');

insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('daniel', '1928472942', 1, 500);
insert into tb_assinante(nome, cpf, endereco_id, credito_total) values ('gabriel', '1348472942', 2, 120);

insert into tb_tarifa(tipo_tarifa, tipo_veiculo, entrada, saida, valor) values('ATE_UMA_HORA', 'CARRO', '2022-06-13 09:10:01', '2022-06-14 09:10:01', 15.0);
insert into tb_tarifa(tipo_tarifa, tipo_veiculo, entrada, saida, valor) values('HORA_ADICIONAL', 'MOTO', '2022-09-13 09:10:01', '2022-09-23 13:30:00', 10.0);

insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('CARRO', 'c137g23', 1);
insert into tb_veiculo(tipo_veiculo, placa, assinante_id) values('MOTO', 'c157g26', 1);

