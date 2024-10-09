-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-10-2024 a las 07:19:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `blabber`
--
CREATE DATABASE IF NOT EXISTS `blabber` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `blabber`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_blabs`
--

CREATE TABLE `dbo_blabs` (
  `id_blab` bigint(20) NOT NULL,
  `content` varchar(350) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_comments`
--

CREATE TABLE `dbo_comments` (
  `id_comment` bigint(20) NOT NULL,
  `commented_at` datetime(6) NOT NULL,
  `content` varchar(350) NOT NULL,
  `blab_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_likes`
--

CREATE TABLE `dbo_likes` (
  `id_like` bigint(20) NOT NULL,
  `liked_at` datetime(6) NOT NULL,
  `id_blab` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_users`
--

CREATE TABLE `dbo_users` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dbo_users`
--

INSERT INTO `dbo_users` (`id_user`, `name`, `password`, `role`, `username`) VALUES
(1, 'Eliezer E. Navarro', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'enp'),
(2, 'Rayme L. Velandia', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'rayme');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  ADD PRIMARY KEY (`id_blab`),
  ADD KEY `FKr77jjrgi98rqiao454a6n5pwf` (`id_user`);

--
-- Indices de la tabla `dbo_comments`
--
ALTER TABLE `dbo_comments`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `FKixmu030suynj2sa57kbqr6n0g` (`blab_id`),
  ADD KEY `FK72v87o2uiriyo36se6bj2n68v` (`user_id`);

--
-- Indices de la tabla `dbo_likes`
--
ALTER TABLE `dbo_likes`
  ADD PRIMARY KEY (`id_like`),
  ADD KEY `FKslb7x8ium2knvxevipwb45q2p` (`id_blab`),
  ADD KEY `FKbt02fxh4rjrp3msoenserthl0` (`id_user`);

--
-- Indices de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  MODIFY `id_blab` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_comments`
--
ALTER TABLE `dbo_comments`
  MODIFY `id_comment` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_likes`
--
ALTER TABLE `dbo_likes`
  MODIFY `id_like` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  ADD CONSTRAINT `FKr77jjrgi98rqiao454a6n5pwf` FOREIGN KEY (`id_user`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `dbo_comments`
--
ALTER TABLE `dbo_comments`
  ADD CONSTRAINT `FK72v87o2uiriyo36se6bj2n68v` FOREIGN KEY (`user_id`) REFERENCES `dbo_users` (`id_user`),
  ADD CONSTRAINT `FKixmu030suynj2sa57kbqr6n0g` FOREIGN KEY (`blab_id`) REFERENCES `dbo_blabs` (`id_blab`);

--
-- Filtros para la tabla `dbo_likes`
--
ALTER TABLE `dbo_likes`
  ADD CONSTRAINT `FKbt02fxh4rjrp3msoenserthl0` FOREIGN KEY (`id_user`) REFERENCES `dbo_users` (`id_user`),
  ADD CONSTRAINT `FKslb7x8ium2knvxevipwb45q2p` FOREIGN KEY (`id_blab`) REFERENCES `dbo_blabs` (`id_blab`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
