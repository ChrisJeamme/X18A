-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 08 Mai 2017 à 19:37
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `dealwithit`
--

-- --------------------------------------------------------

--
-- Structure de la table `depense`
--

CREATE TABLE `depense` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  `date` date NOT NULL,
  `montant` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `depense`
--

INSERT INTO `depense` (`idUtilisateur`, `idEvenement`, `date`, `montant`) VALUES
(1, 1, '2017-05-08', 200);

-- --------------------------------------------------------

--
-- Structure de la table `evenements`
--

CREATE TABLE `evenements` (
  `idEvenement` int(11) NOT NULL,
  `nomEvenement` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `budget` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `evenements`
--

INSERT INTO `evenements` (`idEvenement`, `nomEvenement`, `budget`) VALUES
(1, 'Development', 1200);

-- --------------------------------------------------------

--
-- Structure de la table `participe`
--

CREATE TABLE `participe` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `participe`
--

INSERT INTO `participe` (`idUtilisateur`, `idEvenement`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `poste_message`
--

CREATE TABLE `poste_message` (
  `idUtilisateur` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL,
  `date` date NOT NULL,
  `message` varchar(200) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `poste_message`
--

INSERT INTO `poste_message` (`idUtilisateur`, `idEvenement`, `date`, `message`) VALUES
(1, 1, '2017-05-08', 'Message de test.');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `prenom` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `pseudo` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`idUtilisateur`, `nom`, `prenom`, `email`, `pseudo`) VALUES
(1, 'Granjon', 'Thomas', 'thomas.granjon2@etu.univ-st-etienne.fr', 'TGranjon'),
(2, 'Sofonea', 'Axel', '', 'asofonea'),
(3, 'Jeamme', 'Christopher', '', 'cjeamme'),
(4, 'Bruyère', 'Dimitri', '', 'dbryuere'),
(5, 'Siracusa', 'Rémi', '', 'remi42320b');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `depense`
--
ALTER TABLE `depense`
  ADD KEY `fk_idUtilisateur` (`idUtilisateur`),
  ADD KEY `fk_idEvenement` (`idEvenement`);

--
-- Index pour la table `evenements`
--
ALTER TABLE `evenements`
  ADD PRIMARY KEY (`idEvenement`),
  ADD UNIQUE KEY `idEvenement` (`idEvenement`);

--
-- Index pour la table `participe`
--
ALTER TABLE `participe`
  ADD KEY `fk_idUtilisateur` (`idUtilisateur`),
  ADD KEY `fk_idEvenement` (`idEvenement`);

--
-- Index pour la table `poste_message`
--
ALTER TABLE `poste_message`
  ADD KEY `fk_idUtilisateur` (`idUtilisateur`),
  ADD KEY `fk_idEvenement` (`idEvenement`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD UNIQUE KEY `idUtilisateur` (`idUtilisateur`),
  ADD UNIQUE KEY `peudo` (`pseudo`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `evenements`
--
ALTER TABLE `evenements`
  MODIFY `idEvenement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
