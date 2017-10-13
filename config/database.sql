-- phpMyAdmin SQL Dump
-- version 2.8.2-Debian-0.2ubuntu0.1
-- http://www.phpmyadmin.net
-- 
-- Serveur: localhost
-- Généré le : Jeudi 14 Septembre 2017 à 10:41
-- Version du serveur: 5.0.24
-- Version de PHP: 5.1.6
-- 
-- Base de données: `RevuesOnLine`
-- 

-- --------------------------------------------------------

-- 
-- Structure de la table `Abonnement`
-- 

CREATE TABLE `Abonnement` (
  `id_client` int(11) NOT NULL,
  `id_revue` int(4) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY  (`id_client`,`id_revue`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table `Abonnement`
-- 


-- --------------------------------------------------------

-- 
-- Structure de la table `Client`
-- 

CREATE TABLE `Client` (
  `id_client` int(11) NOT NULL auto_increment,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `no_rue` varchar(8) default NULL,
  `voie` varchar(80) default NULL,
  `code_postal` varchar(10) default NULL,
  `ville` varchar(30) default NULL,
  `pays` varchar(30) default NULL,
  PRIMARY KEY  (`id_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Contenu de la table `Client`
-- 


-- --------------------------------------------------------

-- 
-- Structure de la table `Periodicite`
-- 

CREATE TABLE `Periodicite` (
  `id_periodicite` int(2) NOT NULL auto_increment,
  `libelle` varchar(20) NOT NULL,
  PRIMARY KEY  (`id_periodicite`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Contenu de la table `Periodicite`
-- 


-- --------------------------------------------------------

-- 
-- Structure de la table `Revue`
-- 

CREATE TABLE `Revue` (
  `id_revue` int(4) NOT NULL auto_increment,
  `titre` varchar(40) NOT NULL,
  `description` varchar(400) NOT NULL,
  `tarif_numero` float default NULL,
  `visuel` varchar(200) default NULL,
  `id_periodicite` int(2) NOT NULL,
  PRIMARY KEY  (`id_revue`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Contenu de la table `Revue`
-- 
