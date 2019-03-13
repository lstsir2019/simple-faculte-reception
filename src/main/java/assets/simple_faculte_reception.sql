-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2019 at 01:36 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simple_faculte_reception`
--
CREATE DATABASE IF NOT EXISTS `simple_faculte_reception` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `simple_faculte_reception`;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21),
(21);

-- --------------------------------------------------------

--
-- Table structure for table `reception`
--

CREATE TABLE `reception` (
  `id` bigint(20) NOT NULL,
  `code_fournisseur` varchar(255) DEFAULT NULL,
  `date_reception` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `reference_commande` varchar(255) DEFAULT NULL,
  `total` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reception`
--

INSERT INTO `reception` (`id`, `code_fournisseur`, `date_reception`, `reference`, `reference_commande`, `total`) VALUES
(5, NULL, '2019-01-18', 'rec-2019-1', 'com-01', 0),
(9, NULL, '2019-08-20', 'rec-2019-2', 'com-01', 0),
(13, NULL, '2019-08-20', 'rec-2019-3', 'com-01', 0),
(17, NULL, '2019-08-20', 'rec-2019-5', 'com-02', 0);

-- --------------------------------------------------------

--
-- Table structure for table `reception_item`
--

CREATE TABLE `reception_item` (
  `id` bigint(20) NOT NULL,
  `qte` int(11) NOT NULL,
  `reference_categorie` varchar(255) DEFAULT NULL,
  `reference_magasin` varchar(255) DEFAULT NULL,
  `reference_produit` varchar(255) DEFAULT NULL,
  `reception` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reception_item`
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reception`
--
ALTER TABLE `reception`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reception_item`
--
ALTER TABLE `reception_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkdus2ecsu4rn664xtnuni0sit` (`reception`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
