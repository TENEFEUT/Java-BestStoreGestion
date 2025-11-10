-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 nov. 2025 à 02:42
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `beststore`
--

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `id` int(11) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_fichier_image` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`id`, `categorie`, `created_at`, `description`, `marque`, `nom`, `nom_fichier_image`, `prix`) VALUES
(3, 'Téléphone', '2025-11-09 01:10:36.000000', 'téléphone de qualité supérieur, de premier choix ', 'SAMSUNG', 'SAMSUNG S25', 'T8.jpg', 1100),
(4, 'TELEPHONE', '2025-11-09 16:10:42.000000', 'Téléphone de manque apple de meilleur Qualité qu\'un samsung', 'APPLE', 'IPHONE 17', 'T7.jpg', 1000),
(5, 'Ordinateur', '2025-11-09 16:13:01.000000', 'Ordinateur de marque APPLE, avec un clavier Azerty, 16go de Ram, 500go de Stockage', 'APPLE', 'MacBook', 'PC5.jpg', 680),
(6, 'CHARGEUR', '2025-11-09 16:13:01.000000', 'chargeur multi sortie avec batterie intégrer ', 'HP', 'Chargeur HP Multi sortie', 'CH2.png', 50),
(7, 'Autre', '2025-11-09 16:48:00.000000', 'écouteur Bluetooth, bonne qualité  ', 'HP', 'ECOUTEUR F32', 'E4.jpg', 25),
(8, 'ECOUTEUR', '2025-11-09 17:07:10.000000', 'écouteur Bluetooth, bonne qualité  ', 'OREIMO', 'ECOUTEUR GL8', 'E1.jpg', 20),
(9, 'Ordinateur', '2025-11-09 22:49:44.000000', 'Ordinateur de marque APPLE de bonne Qualité, idéale pour les études, le MacBook Pro', 'APPLE', 'MacBooK Pro', '1762731434294_macbookpro-2016-officiel-puissance.jpg', 850),
(10, 'Ordinateur', '2025-11-10 02:34:56.000000', 'Ordinateur portable, SSD 500GO, Ram 32go, clavier Querty', 'APPLE', 'Mac Book Pro 2022', '1762738496673_apple-macbook-pro-16-2021-m1-pro-10-cours-gris-sideral-mk183fn-a.jpg', 900),
(11, 'Ordinateur', '2025-11-10 02:38:53.000000', 'Ordinateur Gaming Dell, 1To SSD, Ram 64 go, processeur 4.5GHZ, carte graphique Nvdia ', 'DELL', 'PC GAMING G15', '1762738733505_Dell-G15-5520-1.jpg', 1349.99);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
