create database quiz;

use quiz;

CREATE TABLE `usuario` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nombre_usuario` varchar(50) NOT NULL,
   `contraseña` varchar(80) NOT NULL,
   `rol` int NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `nombre_usuario_UNIQUE` (`nombre_usuario`),
   CONSTRAINT `usuario_chk_1` CHECK (((`rol` = 1) or (`rol` = 2)))
 ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 #---------------------------------------------------------------------------------------------------------------------
 
 CREATE TABLE `nivel` (
   `id` int NOT NULL AUTO_INCREMENT,
   `categoria` varchar(100) NOT NULL,
   `puntos` int NOT NULL,
   `dificultad` varchar(100) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `categoria_UNIQUE` (`categoria`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 #--------------------------------------------------------------------------------------------------------------------
 
 CREATE TABLE `jugador` (
   `id` int NOT NULL AUTO_INCREMENT,
   `usuario_id` int NOT NULL,
   `nivel_id` int NOT NULL DEFAULT '1',
   `puntos_acumulados` int NOT NULL DEFAULT '0',
   PRIMARY KEY (`id`),
   KEY `fk_jugador_nivel` (`nivel_id`),
   KEY `fk_jugdor_usuario` (`usuario_id`),
   CONSTRAINT `fk_jugdor_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `jugador_ibfk_2` FOREIGN KEY (`nivel_id`) REFERENCES `nivel` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 #-----------------------------------------------------------------------------------------------------------------------------------------
 
 CREATE TABLE `administrador` (
   `id` int NOT NULL AUTO_INCREMENT,
   `usuario_id` int NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_administrador_usuario` (`usuario_id`),
   CONSTRAINT `fk_administrador_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 #---------------------------------------------------------------------------------------------------------------------------------------
 
 CREATE TABLE `pregunta` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nivel_id` int NOT NULL,
   `contenido` varchar(300) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_pregutna_nivel` (`nivel_id`),
   CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`nivel_id`) REFERENCES `nivel` (`id`) ON DELETE CASCADE
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 #------------------------------------------------------------------------------------------------------------------------------------
 
 CREATE TABLE `opcion` (
   `id` int NOT NULL AUTO_INCREMENT,
   `pregunta_id` int NOT NULL,
   `contenido` varchar(300) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_opcion_pregunta` (`pregunta_id`),
   CONSTRAINT `opcion_ibfk_1` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`) ON DELETE CASCADE
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 