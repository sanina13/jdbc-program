-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Jan-2020 às 23:48
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `caritas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `colaboradores`
--

CREATE TABLE `colaboradores` (
  `cod_colaborador` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `tipo_colaborador` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `colaboradores`
--

INSERT INTO `colaboradores` (`cod_colaborador`, `nome`, `senha`, `tipo_colaborador`) VALUES
(1, 'Rute Silva', 'rute24', 'Admin'),
(2, 'sanina', '123', 'Funcionario'),
(3, 'vitor', 'vitor321', 'Ajudante');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE `servicos` (
  `cod_servico` int(10) UNSIGNED NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `nome_servico` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servicos`
--

INSERT INTO `servicos` (`cod_servico`, `area`, `nome_servico`) VALUES
(1, 'alojamento', 'Servico de alojamento'),
(2, 'alimentacao', 'Serviço de refeicao no refeitorio'),
(3, 'alimentacao', 'Serviço de refeicao no domicilio'),
(4, 'higiene', 'Serviço de higiene no domicilio'),
(5, 'roupa', 'Serviço de tratamento de roupa'),
(6, 'financeira', 'Serviço de acao social\r\n'),
(7, 'convivio', 'Atividades de convivio\r\n'),
(8, 'sasdsad', 'dasdasd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos_utentes`
--

CREATE TABLE `servicos_utentes` (
  `cod_requesicao` int(10) NOT NULL,
  `cod_utente` int(10) UNSIGNED NOT NULL,
  `cod_servico` int(10) UNSIGNED NOT NULL,
  `estado` varchar(100) NOT NULL,
  `data_requesicao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servicos_utentes`
--

INSERT INTO `servicos_utentes` (`cod_requesicao`, `cod_utente`, `cod_servico`, `estado`, `data_requesicao`) VALUES
(1, 1, 4, 'aberto', '12/01/2020');

-- --------------------------------------------------------

--
-- Estrutura da tabela `utentes`
--

CREATE TABLE `utentes` (
  `cod_utente` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `profissao` varchar(100) DEFAULT NULL,
  `morada` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `utentes`
--

INSERT INTO `utentes` (`cod_utente`, `nome`, `profissao`, `morada`) VALUES
(1, 'Joao Guerreiro', 'Reformado', 'Rua das flores nº20, Beja'),
(2, 'Rui Costa', 'Desempregado', 'Rua do carmo velho nº20, Beja');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `colaboradores`
--
ALTER TABLE `colaboradores`
  ADD PRIMARY KEY (`cod_colaborador`);

--
-- Índices para tabela `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`cod_servico`);

--
-- Índices para tabela `servicos_utentes`
--
ALTER TABLE `servicos_utentes`
  ADD PRIMARY KEY (`cod_requesicao`),
  ADD KEY `cod_servico` (`cod_servico`),
  ADD KEY `cod_utente` (`cod_utente`);

--
-- Índices para tabela `utentes`
--
ALTER TABLE `utentes`
  ADD PRIMARY KEY (`cod_utente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `colaboradores`
--
ALTER TABLE `colaboradores`
  MODIFY `cod_colaborador` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `servicos`
--
ALTER TABLE `servicos`
  MODIFY `cod_servico` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `servicos_utentes`
--
ALTER TABLE `servicos_utentes`
  MODIFY `cod_requesicao` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `utentes`
--
ALTER TABLE `utentes`
  MODIFY `cod_utente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `servicos_utentes`
--
ALTER TABLE `servicos_utentes`
  ADD CONSTRAINT `cod_servico` FOREIGN KEY (`cod_servico`) REFERENCES `servicos` (`cod_servico`),
  ADD CONSTRAINT `cod_utente` FOREIGN KEY (`cod_utente`) REFERENCES `utentes` (`cod_utente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
