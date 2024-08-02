-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-08-2024 a las 18:25:32
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
-- Base de datos: `restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(200) NOT NULL,
  `nombre` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `nombre`) VALUES
(0, 'Stephie'),
(1, 'Badel'),
(2, 'Manu');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_facturas`
--

CREATE TABLE `historial_facturas` (
  `id_historial_facturas` int(150) NOT NULL,
  `fecha` date NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_facturas`
--

INSERT INTO `historial_facturas` (`id_historial_facturas`, `fecha`, `total`) VALUES
(3, '2024-08-01', 2.30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_ordenes`
--

CREATE TABLE `historial_ordenes` (
  `id_historial_ordenes` int(150) NOT NULL,
  `id_linea` int(150) NOT NULL,
  `hora` datetime NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `numero_mesa` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_tiquet`
--

CREATE TABLE `linea_tiquet` (
  `id_linea_tiquet` int(200) NOT NULL,
  `id_linea` int(200) NOT NULL,
  `cantidad` int(200) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_producto` int(200) DEFAULT NULL,
  `numero_mesa` int(20) NOT NULL,
  `id_empleado` int(50) NOT NULL,
  `pagado` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `linea_tiquet`
--

INSERT INTO `linea_tiquet` (`id_linea_tiquet`, `id_linea`, `cantidad`, `precio`, `id_producto`, `numero_mesa`, `id_empleado`, `pagado`) VALUES
(114, 1, 1, 4.00, 15, 1, 0, 1),
(115, 2, 1, 2.30, 2, 1, 0, 1),
(116, 3, 1, 2.30, 2, 2, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `numero_mesa` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`numero_mesa`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `tipo_producto` varchar(200) NOT NULL,
  `pvp` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `tipo_producto`, `pvp`) VALUES
(1, 'Pizza', 'Comida', 7.00),
(2, 'Bocata', 'Comida', 2.30),
(14, 'Hamburguesa', 'Comida', 3.50),
(15, 'Mojito', 'Bebida', 4.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(200) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `personas` int(200) NOT NULL,
  `comentarios` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `numero_mesa` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `nombre`, `personas`, `comentarios`, `fecha`, `hora`, `numero_mesa`) VALUES
(8, 'Ángel', 4, 'Alergias: cacahuete', '2024-08-16', '20:00:00', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `historial_facturas`
--
ALTER TABLE `historial_facturas`
  ADD PRIMARY KEY (`id_historial_facturas`);

--
-- Indices de la tabla `historial_ordenes`
--
ALTER TABLE `historial_ordenes`
  ADD PRIMARY KEY (`id_historial_ordenes`);

--
-- Indices de la tabla `linea_tiquet`
--
ALTER TABLE `linea_tiquet`
  ADD PRIMARY KEY (`id_linea_tiquet`),
  ADD KEY `FK_LITIQ_PRO` (`id_producto`),
  ADD KEY `numero_mesa_f` (`numero_mesa`) USING BTREE,
  ADD KEY `id_linea` (`id_linea`) USING BTREE,
  ADD KEY `id_empleado_f` (`id_empleado`) USING BTREE;

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`numero_mesa`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `numero_mesa_f` (`numero_mesa`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_facturas`
--
ALTER TABLE `historial_facturas`
  MODIFY `id_historial_facturas` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `historial_ordenes`
--
ALTER TABLE `historial_ordenes`
  MODIFY `id_historial_ordenes` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `linea_tiquet`
--
ALTER TABLE `linea_tiquet`
  MODIFY `id_linea_tiquet` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `numero_mesa` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `linea_tiquet`
--
ALTER TABLE `linea_tiquet`
  ADD CONSTRAINT `FK_LITIQ_PRO` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE SET NULL,
  ADD CONSTRAINT `linea_tiquet_ibfk_1` FOREIGN KEY (`numero_mesa`) REFERENCES `mesa` (`numero_mesa`),
  ADD CONSTRAINT `linea_tiquet_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `numero_mesa_f` FOREIGN KEY (`numero_mesa`) REFERENCES `mesa` (`numero_mesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
