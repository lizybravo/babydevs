CREATE DATABASE baby_devs;

USE baby_devs;

CREATE TABLE `asesorados`(
  `idAsesorados` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `nivel_de_estudios` VARCHAR(45) NOT NULL,
  `ocupacion` VARCHAR(45) NOT NULL,
  `locacion` VARCHAR(45) NOT NULL,
  `Historial_de_compra_venta_idHistorial_de_compra_venta` INT NOT NULL,
  PRIMARY KEY (`idAsesorados`, `Historial_de_compra_venta_idHistorial_de_compra_venta`),
  INDEX `fk_Asesorados_Historial_de_compra_venta1_idx` (`Historial_de_compra_venta_idHistorial_de_compra_venta` ASC) VISIBLE)
  ;
  
CREATE TABLE `asesores`(
`idAsesores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `habilidad_principal` VARCHAR(45) NOT NULL,
  `habilidad_secundaria` VARCHAR(100) NOT NULL,
  `tarifa_por_asesoria` DECIMAL(10,0) NOT NULL,
  `fecha_de_inicio` DATE NOT NULL,
  PRIMARY KEY (`idAsesores`)
  );
  
CREATE TABLE `asesores_has_asesorias`(
 `Asesores_idAsesores` INT NOT NULL,
  `Asesorias_idAsesorias` INT NOT NULL,
  PRIMARY KEY (`Asesores_idAsesores`, `Asesorias_idAsesorias`),
  INDEX `fk_Asesores_has_Asesorías_Asesorías1_idx` (`Asesorias_idAsesorias` ASC) VISIBLE,
  INDEX `fk_Asesores_has_Asesorías_Asesores_idx` (`Asesores_idAsesores` ASC) VISIBLE)
  ;
  
CREATE TABLE `asesorias`(
`idAsesorias` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `materia` VARCHAR(45) NOT NULL,
  `duracion` VARCHAR(45) NOT NULL,
  `Historial_de_compra_venta_idHistorial_de_compra_venta` INT NOT NULL,
  PRIMARY KEY (`idAsesorias`, `Historial_de_compra_venta_idHistorial_de_compra_venta`),
  INDEX `fk_Asesorías_Historial_de_compra_venta1_idx` (`Historial_de_compra_venta_idHistorial_de_compra_venta` ASC) VISIBLE)
  ;
  
CREATE TABLE `asesorias_has_asesorados`(
 `Asesorias_idAsesorias` INT NOT NULL,
  `Asesorados_idAsesorados` INT NOT NULL,
  PRIMARY KEY (`Asesorias_idAsesorias`, `Asesorados_idAsesorados`),
  INDEX `fk_Asesorías_has_Asesorados_Asesorados1_idx` (`Asesorados_idAsesorados` ASC) VISIBLE,
  INDEX `fk_Asesorías_has_Asesorados_Asesorías1_idx` (`Asesorias_idAsesorias` ASC) VISIBLE)
  ;
  
CREATE TABLE `historial_de_compra_venta`(
`idHistorial_de_compra_venta` INT NOT NULL AUTO_INCREMENT,
  `fecha_y_horario_de_compra` DATETIME NOT NULL,
  `metodo_de_pago` VARCHAR(45) NOT NULL,
  `monto_total` DECIMAL(10,0) NOT NULL,
  `impuestos_e_IVA` DECIMAL(10,0) NOT NULL,
  `comision_BabyDevs` DECIMAL(10,0) NOT NULL,
  `comision_Asesor` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idHistorial_de_compra_venta`)
  );
