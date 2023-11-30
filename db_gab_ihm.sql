-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 07 mars 2023 à 13:12
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_gab_ihm`
--

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `idBq` int(11) NOT NULL,
  `nomBq` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `banque`
--

INSERT INTO `banque` (`idBq`, `nomBq`) VALUES
(1, 'BOA'),
(2, 'BNI'),
(3, 'BFV');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idCl` int(11) NOT NULL,
  `nomCl` varchar(50) NOT NULL,
  `prenomCl` varchar(50) NOT NULL,
  `ageCl` int(11) NOT NULL,
  `emailCl` varchar(50) NOT NULL,
  `telCl` int(11) NOT NULL,
  `adresseCl` varchar(250) NOT NULL,
  `photoCl` text NOT NULL,
  `cinCl` int(11) NOT NULL,
  `mdpCompteCl` varchar(10) NOT NULL,
  `banqueCl` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idCl`, `nomCl`, `prenomCl`, `ageCl`, `emailCl`, `telCl`, `adresseCl`, `photoCl`, `cinCl`, `mdpCompteCl`, `banqueCl`) VALUES
(1, 'RAKOTONDRAVONY', 'Mickael', 19, 'mickaelrkt20@gmail.com', 381099372, 'Sabotsy Namehana', 'E:\\IRD\\. Licence3_informatique\\IHM\\PROJET_IHM\\IHM_GAB\\img\\Erick.jpg', 1011203214, '123', 'BOA'),
(2, 'RASAMIZAFY', 'Landy', 20, 'landy@gmail.com', 345025099, 'Tsarafara', 'E:\\IRD\\. Licence3_informatique\\IHM\\PROJET_IHM\\IHM_GAB\\img\\sarah.png', 1024562100, '1234', 'BNI'),
(3, 'RAKOTO', 'John', 25, 'john@gmail.com', 12345678, 'Ankadikely', 'E:\\IRD\\. Licence3_informatique\\IHM\\PROJET_IHM\\IHM_GAB\\img\\john.jpg', 1234567, '123', 'BOA');

-- --------------------------------------------------------

--
-- Structure de la table `comptebancaire`
--

CREATE TABLE `comptebancaire` (
  `idCompte` int(11) NOT NULL,
  `sommeArgent` int(11) NOT NULL,
  `pk_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `comptebancaire`
--

INSERT INTO `comptebancaire` (`idCompte`, `sommeArgent`, `pk_client`) VALUES
(1, 800, 1),
(2, 500, 2),
(3, 800, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`idBq`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idCl`),
  ADD KEY `pk_client_banque` (`banqueCl`);

--
-- Index pour la table `comptebancaire`
--
ALTER TABLE `comptebancaire`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `pk_compte_client` (`pk_client`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `banque`
--
ALTER TABLE `banque`
  MODIFY `idBq` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idCl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `comptebancaire`
--
ALTER TABLE `comptebancaire`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comptebancaire`
--
ALTER TABLE `comptebancaire`
  ADD CONSTRAINT `pk_compte_client` FOREIGN KEY (`pk_client`) REFERENCES `client` (`idCl`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
