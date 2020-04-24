-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 24, 2020 at 03:20 PM
-- Server version: 5.7.29-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetgi`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `num_tel` varchar(10) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `zone_geo` varchar(255) DEFAULT NULL,
  `km_max` int(11) DEFAULT NULL,
  `secretariat` tinyint(1) DEFAULT NULL,
  `dispoSec` tinyint(1) DEFAULT NULL,
  `specialite` varchar(255) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  `cartePro_filename` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `offre`
--

CREATE TABLE `offre` (
  `id_offre` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `type_offre` smallint(6) DEFAULT NULL,
  `visite_domicile` int(11) DEFAULT NULL,
  `activite` tinyint(1) DEFAULT NULL,
  `horaire` varchar(255) DEFAULT NULL,
  `logiciel_utilise` varchar(255) DEFAULT NULL,
  `retrocession` varchar(255) DEFAULT NULL,
  `type_patient` varchar(255) DEFAULT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `archivage` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `postulat`
--

CREATE TABLE `postulat` (
  `id_postulat` int(11) NOT NULL,
  `id_remplacant` int(11) NOT NULL,
  `id_offre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `remplacant`
--

CREATE TABLE `remplacant` (
  `id_remplacant` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `num_tel` varchar(10) DEFAULT NULL,
  `dispo` varchar(255) DEFAULT NULL,
  `zone_geo` varchar(255) DEFAULT NULL,
  `km_max` int(11) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `description` varchar(4095) DEFAULT NULL,
  `cv_filename` varchar(255) DEFAULT NULL,
  `carte_pro_filename` varchar(255) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id_offre`),
  ADD KEY `FK_id_client` (`id_client`);

--
-- Indexes for table `postulat`
--
ALTER TABLE `postulat`
  ADD PRIMARY KEY (`id_postulat`),
  ADD KEY `FK_id_remplacent` (`id_remplacant`),
  ADD KEY `FK_id_offre` (`id_offre`);

--
-- Indexes for table `remplacant`
--
ALTER TABLE `remplacant`
  ADD PRIMARY KEY (`id_remplacant`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `offre`
--
ALTER TABLE `offre`
  MODIFY `id_offre` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `postulat`
--
ALTER TABLE `postulat`
  MODIFY `id_postulat` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `remplacant`
--
ALTER TABLE `remplacant`
  MODIFY `id_remplacant` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `FK_id_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Constraints for table `postulat`
--
ALTER TABLE `postulat`
  ADD CONSTRAINT `FK_id_offre` FOREIGN KEY (`id_offre`) REFERENCES `offre` (`id_offre`),
  ADD CONSTRAINT `FK_id_remplacent` FOREIGN KEY (`id_remplacant`) REFERENCES `remplacant` (`id_remplacant`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
