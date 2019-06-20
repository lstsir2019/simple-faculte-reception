-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 20 juin 2019 à 15:43
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `simple_faculte_reception`
--

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(24),
(24);

--
-- Déchargement des données de la table `reception`
--

INSERT INTO `reception` (`id`, `date_reception`, `reference`, `reference_commande`, `total`) VALUES
(5, '2019-01-18', 'rec-2019-1', 'com-01', 0),
(9, '2019-08-20', 'rec-2019-2', 'com-01', 0),
(13, '2019-08-20', 'rec-2019-3', 'com-01', 0),
(17, '2019-08-20', 'rec-2019-5', 'com-02', 0);

--
-- Déchargement des données de la table `reception_item`
--

INSERT INTO `reception_item` (`id`, `qte`, `reference_categorie`, `reference_magasin`, `reference_produit`, `reception`) VALUES
(6, 20, NULL, 'mag-1', 'pr-1', 5),
(7, 99, NULL, 'mag-1', 'pr-3', 5),
(8, 22, NULL, 'mag-1', 'pr-4', 5),
(10, 15, NULL, 'mag-2', 'pr-1', 9),
(11, 99, NULL, 'mag-3', 'pr-3', 9),
(12, 10, NULL, 'mag-1', 'pr-4', 9),
(14, 15, NULL, 'mag-1', 'pr-1', 13),
(15, 14, NULL, 'mag-3', 'pr-3', 13),
(16, 10, NULL, 'mag-1', 'pr-4', 13),
(18, 1, NULL, 'mag-1', 'pr-4', 17),
(19, 1, NULL, 'mag-3', 'pr-1', 17),
(20, 1, NULL, 'mag-1', 'pr-4', 17);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
