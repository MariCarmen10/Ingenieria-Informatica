-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-10-2020 a las 11:22:18
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `centroeducativo`
--
CREATE DATABASE IF NOT EXISTS `centroeducativo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `centroeducativo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actos_evaluacion`
--

CREATE TABLE `actos_evaluacion` (
  `nombre` varchar(25) NOT NULL,
  `descripcion` text,
  `asignatura` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actos_evaluacion`
--

INSERT INTO `actos_evaluacion` (`nombre`, `descripcion`, `asignatura`) VALUES
('Análisis de necesidades', 'Entregadle con el estudio cualitativo, la Persona y los escenarios', 'DCU.2020'),
('Consumo REST', 'Extensión del prototipo Web para inyectar datos de un servicio REST', 'DCU.2020'),
('Entregable 1', 'Proyecto Mule ESB con la integración De Fuentes de datos', 'IAP.2020'),
('Entregable 2', 'Servicio REST implementado en Mule ESB', 'IAP.2020'),
('Entregable 3', 'Desarrollo solución de integración con colas', 'IAP.2020'),
('Examen', 'Prueba escrita de la asignatura', 'DEW.2020'),
('Práctica 1', 'Acto de evaluación correspondiente a los ejercicios de la práctica 1', 'DEW.2020'),
('Práctica 2', 'Acto de evaluación correspondiente a los ejercicios de la práctica 2', 'DEW.2020'),
('Práctica 3', 'Acto de evaluación correspondiente a los ejercicios de la práctica 3', 'DEW.2020'),
('Prototipo Web', 'Entregable con el diseño web responsive de la aplicación del caso de estudio', 'DCU.2020'),
('Test escrito', 'Prueba escrita de la asignatura', 'DCU.2020'),
('Test escrito', 'Prueba escrita de la asignatura', 'IAP.2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `apellidos` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`dni`, `nombre`, `apellidos`) VALUES
('12345678W', 'Pepe', 'Garcia Sanchez'),
('23456387R', 'Maria', 'Fernandez Gómez'),
('34567891F', 'Miguel', 'Hernandez Llopis'),
('37264096W', 'Minerva', 'Alonso Pérez'),
('93847525G', 'Laura', 'Benitez Torres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno_asignatura`
--

CREATE TABLE `alumno_asignatura` (
  `alumno` varchar(10) NOT NULL,
  `asignatura` varchar(8) NOT NULL,
  `nota` float NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno_asignatura`
--

INSERT INTO `alumno_asignatura` (`alumno`, `asignatura`, `nota`) VALUES
('12345678W', 'DCU.2020', 9.5),
('12345678W', 'DEW.2020', 7.5),
('12345678W', 'IAP.2020', 8),
('23456387R', 'DCU.2020', 6),
('23456387R', 'DEW.2020', 8),
('34567891F', 'DCU.2020', 8.5),
('34567891F', 'IAP.2020', 9),
('93847525G', 'DEW.2020', 7),
('93847525G', 'IAP.2020', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `id_asig` varchar(8) NOT NULL,
  `acronimo` varchar(3) NOT NULL,
  `anyo` int(11) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `curso` int(11) NOT NULL,
  `cuatrimestre` varchar(1) NOT NULL,
  `creditos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`id_asig`, `acronimo`, `anyo`, `nombre`, `curso`, `cuatrimestre`, `creditos`) VALUES
('DCU.2020', 'DCU', 2020, 'Desarrollo Centrado en el Usuario', 4, 'A', 5),
('DEW.2020', 'DEW', 2020, 'Desarrollo Web', 3, 'B', 5),
('IAP.2020', 'IAP', 2020, 'Integración de Aplicaciones', 4, 'A', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `alumno` varchar(10) NOT NULL,
  `nombre_acto` varchar(25) NOT NULL,
  `asignatura` varchar(8) NOT NULL,
  `nota` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(512) NOT NULL,
  `apellidos` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`dni`, `nombre`, `apellidos`) VALUES
('06374291A', 'Manoli', 'ALbert'),
('10293756L', 'Pedro', 'Valderas'),
('23456733H', 'Ramón', 'Garcia'),
('65748923M', 'Joan', 'Fons');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor_asignatura`
--

CREATE TABLE `profesor_asignatura` (
  `profesor` varchar(10) NOT NULL,
  `asignatura` varchar(8) NOT NULL,
  `creditos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesor_asignatura`
--

INSERT INTO `profesor_asignatura` (`profesor`, `asignatura`, `creditos`) VALUES
('06374291A', 'DCU.2020', 8),
('10293756L', 'DCU.2020', 3),
('10293756L', 'IAP.2020', 5),
('23456733H', 'DEW.2020', 11),
('65748923M', 'IAP.2020', 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actos_evaluacion`
--
ALTER TABLE `actos_evaluacion`
  ADD PRIMARY KEY (`nombre`,`asignatura`),
  ADD KEY `actos_evaluacion_asignatura` (`asignatura`),
  ADD KEY `nombre` (`nombre`);

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD PRIMARY KEY (`alumno`,`asignatura`),
  ADD KEY `asignatura` (`asignatura`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`id_asig`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`alumno`,`nombre_acto`,`asignatura`),
  ADD KEY `asignatura` (`asignatura`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `profesor_asignatura`
--
ALTER TABLE `profesor_asignatura`
  ADD PRIMARY KEY (`profesor`,`asignatura`),
  ADD KEY `asignatura` (`asignatura`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actos_evaluacion`
--
ALTER TABLE `actos_evaluacion`
  ADD CONSTRAINT `actos_evaluacion_asignatura` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id_asig`) ON DELETE CASCADE;

--
-- Filtros para la tabla `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD CONSTRAINT `alumno_asignatura_ibfk_1` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id_asig`) ON DELETE CASCADE,
  ADD CONSTRAINT `alumno_asignatura_ibfk_2` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`dni`) ON DELETE CASCADE;

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`dni`) ON DELETE CASCADE,
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id_asig`) ON DELETE CASCADE;

--
-- Filtros para la tabla `profesor_asignatura`
--
ALTER TABLE `profesor_asignatura`
  ADD CONSTRAINT `profesor_asignatura_ibfk_1` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`dni`) ON DELETE CASCADE,
  ADD CONSTRAINT `profesor_asignatura_ibfk_2` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id_asig`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
