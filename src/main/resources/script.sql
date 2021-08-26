--

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `paymybudy`
--

-- --------------------------------------------------------

--
-- Structure de la table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11),
  `username` varchar(50),
  `authority` varchar(50),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `authorities`
--

INSERT INTO `authorities` (`user_id`, `username`, `authority`) VALUES
(1, 'test@test', 'USER');


-- --------------------------------------------------------

--
-- Structure de la table `bankaccounts`
--

DROP TABLE IF EXISTS `bankaccounts`;
CREATE TABLE IF NOT EXISTS `bankaccounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FK_iduser` int(11),
  `iban` varchar(200),
  `date` datetime,
  `moneyavailable` double,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_iduser` (`FK_iduser`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `relationships`
--

DROP TABLE IF EXISTS `relationships`;
CREATE TABLE IF NOT EXISTS `relationships` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `friend` int(11),
  PRIMARY KEY (`id`),
  KEY `id_friend` (`friend`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE IF NOT EXISTS `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime ,
  `amount` double ,
  `label` varchar(50),
  `FK_iduser` int(11),
  `recipient` int(11),
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_idUser` (`FK_iduser`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50),
  `name` varchar(50),
  `firstname` varchar(75),
  `birthdate` date,
  `address` varchar(100),
  `password` varchar(100),
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `name`, `firstname`, `birthdate`, `address`, `password`) VALUES
('test@test', 'test', 'test-test', NULL, 'rue de test', '$2y$10$jWvX8H.8XzHZkfZdP5pOY.1jXkH2HsLPCMTnINYCTtYL76F0saeHS');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `bankaccounts`
--
ALTER TABLE `bankaccounts`
  ADD CONSTRAINT `bankaccounts_ibfk_1` FOREIGN KEY (`FK_iduser`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `relationships`
--
ALTER TABLE `relationships`
  ADD CONSTRAINT `relationships_ibfk_1` FOREIGN KEY (`friend`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`FK_iduser`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
