CREATE TABLE `empresa` (
    `id` bigint(20) NOT NULL,
    `razao_social` varchar(255) NOT NULL,
    `cnpj` varchar(255) NOT NULL,
    `data_atualizacao` datetime NOT NULL,
    `data_criacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `empresa`
ADD PRIMARY KEY (`id`);

ALTER TABLE `empresa`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT; 