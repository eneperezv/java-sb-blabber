-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2024 a las 22:17:37
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
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL,
  `commented_at` datetime(6) NOT NULL,
  `content` varchar(500) NOT NULL,
  `blab_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(2, 'Hola esta es una segunda prueba con más información y otros caracteres como la letra ñ que funciona', '2024-10-29 10:43:00.000000', 1),
(3, 'Estoy programandoi y no se que escribir aqui', '2024-10-31 10:43:00.000000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_users`
--

CREATE TABLE `dbo_users` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dbo_users`
--

INSERT INTO `dbo_users` (`id_user`, `name`, `password`, `role`, `username`, `email`) VALUES
(1, 'Eliezer Navarro P.', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'enp', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direct_messages`
--

CREATE TABLE `direct_messages` (
  `id` bigint(20) NOT NULL,
  `content` varchar(500) NOT NULL,
  `is_read` bit(1) NOT NULL,
  `sent_at` datetime(6) NOT NULL,
  `receiver_id` bigint(20) NOT NULL,
  `sender_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `follows`
--

CREATE TABLE `follows` (
  `id` bigint(20) NOT NULL,
  `followed_at` datetime(6) NOT NULL,
  `followed_id` bigint(20) NOT NULL,
  `follower_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likes`
--

CREATE TABLE `likes` (
  `id` bigint(20) NOT NULL,
  `liked_at` datetime(6) NOT NULL,
  `blab_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notifications`
--

CREATE TABLE `notifications` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `is_read` bit(1) NOT NULL,
  `message` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbmel7k9fya741ojy283ujbvuu` (`blab_id`),
  ADD KEY `FKni6jreecryc345ax24reuv6bo` (`user_id`);

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
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UK36tahs15hgcbvcyxi5nj215wa` (`email`);

--
-- Indices de la tabla `direct_messages`
--
ALTER TABLE `direct_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8u215sy9ydi2d705rqs4a8bsa` (`receiver_id`),
  ADD KEY `FK42ga7rprk6467cr14bbwghgya` (`sender_id`);

--
-- Indices de la tabla `follows`
--
ALTER TABLE `follows`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtta0b8uknr78iu7v61nvi9vp` (`followed_id`),
  ADD KEY `FKaat9hoe90lel9ewckeuu4mjdh` (`follower_id`);

--
-- Indices de la tabla `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5cbq93a4hde0bq5vc6p9yrecp` (`blab_id`),
  ADD KEY `FKhde2385gwsqw8tn4hdr1dnwfg` (`user_id`);

--
-- Indices de la tabla `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhpnbbgbem72oqbyhgihnp3v9c` (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  MODIFY `id_blab` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `direct_messages`
--
ALTER TABLE `direct_messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `follows`
--
ALTER TABLE `follows`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `likes`
--
ALTER TABLE `likes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FKbmel7k9fya741ojy283ujbvuu` FOREIGN KEY (`blab_id`) REFERENCES `dbo_blabs` (`id_blab`),
  ADD CONSTRAINT `FKni6jreecryc345ax24reuv6bo` FOREIGN KEY (`user_id`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `dbo_blabs`
--
ALTER TABLE `dbo_blabs`
  ADD CONSTRAINT `FKr77jjrgi98rqiao454a6n5pwf` FOREIGN KEY (`id_user`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `direct_messages`
--
ALTER TABLE `direct_messages`
  ADD CONSTRAINT `FK42ga7rprk6467cr14bbwghgya` FOREIGN KEY (`sender_id`) REFERENCES `dbo_users` (`id_user`),
  ADD CONSTRAINT `FK8u215sy9ydi2d705rqs4a8bsa` FOREIGN KEY (`receiver_id`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `follows`
--
ALTER TABLE `follows`
  ADD CONSTRAINT `FKaat9hoe90lel9ewckeuu4mjdh` FOREIGN KEY (`follower_id`) REFERENCES `dbo_users` (`id_user`),
  ADD CONSTRAINT `FKtta0b8uknr78iu7v61nvi9vp` FOREIGN KEY (`followed_id`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `FK5cbq93a4hde0bq5vc6p9yrecp` FOREIGN KEY (`blab_id`) REFERENCES `dbo_blabs` (`id_blab`),
  ADD CONSTRAINT `FKhde2385gwsqw8tn4hdr1dnwfg` FOREIGN KEY (`user_id`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `FKhpnbbgbem72oqbyhgihnp3v9c` FOREIGN KEY (`user_id`) REFERENCES `dbo_users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
