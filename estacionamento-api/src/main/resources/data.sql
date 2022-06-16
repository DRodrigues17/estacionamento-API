
insert into tb_endereco(logradouro, cep) values('rua aleatoria numero 123', '1234567890');
insert into tb_endereco(logradouro, cep) values('rua suspeita numero 123', '1234567890');

insert into tb_assinante(nome, cpf, endereco_id) values ('daniel', '1928472942', 1);
insert into tb_assinante(nome, cpf, endereco_id) values ('gabriel', '1348472942', 2);

insert into  tb_plano(valor) values(15.0);
insert into  tb_plano(valor) values(30.0);

insert into tb_tarifa(entrada, saida, valor) values('2022-06-13 09:10:01', '2022-06-14 09:10:01', 10.0);
insert into tb_tarifa(entrada, saida, valor) values('2022-09-13 09:10:01', '2022-09-23 13:30:00', 100.0);

insert into tb_veiculo(tipo_veiculo, placa) values('CARRO', 'c137g23');
insert into tb_veiculo(tipo_veiculo, placa) values('MOTO', 'c157g26');

