-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2024 a las 16:44:46
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
  `content` varchar(500) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dbo_blabs`
--

INSERT INTO `dbo_blabs` (`id_blab`, `content`, `created_at`, `id_user`) VALUES
(1, 'Hola esta es una prueba', '2024-10-29 10:28:00.100000', 1),
(2, 'Hola esta es una segunda prueba con más información y otros caracteres como la letra ñ que funciona', '2024-10-29 10:43:00.000000', 1);

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
(1, 'Eliezer Navarro P.', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'enp');

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
  MODIFY `id_blab` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  ADD CONSTRAINT `FKr77jjrgi98rqiao454a6n5pwf` FOREIGN KEY (`id_user`) REFERENCES `dbo_users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
