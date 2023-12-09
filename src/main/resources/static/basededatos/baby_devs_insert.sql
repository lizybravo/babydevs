USE baby_devs;

INSERT INTO baby_devs.asesorados (`nombre`, `edad`, `nivel_de_estudios`, `ocupacion`, `locacion`, `Historial_de_compra_venta_idHistorial_de_compra_venta`) 
VALUES ('Pedro Díaz', '20', 'Licenciatura trunca', 'Estudiante', 'Ciudad de México', '1'),
('Jazmín Romero', '21', 'Licenciatura trunca', 'Cajera', 'Guadalajara', '2'),
('Karla Dalila Torres', '28', 'Licenciatura terminada', 'Marketing', 'Acapulco', '3'),
('Mauricio Pichardo Díaz', '33', 'Licenciatura terminada', 'Trabajo Social', 'Mérida', '4'),
('Karina Gutiérrez Hank', '25', 'Licenciatura terminada', 'Actuaria', 'Puebla', '5');

INSERT INTO baby_devs.asesores (`nombre`, `descripcion`, `habilidad_principal`, `habilidad_secundaria`, `tarifa_por_asesoria`, `fecha_de_inicio`)
VALUES ('Lizeth Bravo Acevedo', '¡Hola! Soy Lizeth, desarrolladora Java Full Stack con pasión por tecnología y gestión de proyectos. He perfeccionado la gestión de proyectos y desarrollo web en los últimos años. Me emociona compartir mis conocimientos en Git, HTML5 y CSS3.', 'HTML5', 'Git y CSS3', 150, '2023-12-18'),
('Ana Cristina Hernández', '¡Hola! Soy Ana Cristina Hernández, desarrolladora web con pasión por la tecnología. Mi experiencia en investigación me brinda habilidades avanzadas de análisis y comunicación. Espero con ansias poder trabajar contigo.', 'JavaScript', 'Bootstrap', 150, '2023-12-18'),
('Jessica L. Olivera', '¡Hola! Soy Jessica L. Olivera, una especialista en Java Full Stack con pasión por enseñar y perfeccionar habilidades técnicas y blandas en programación. Me apasiona aceptar desafíos y aprender constantemente. Y espero que pueda transmitirte todos mis conocimientos y energía.', 'JAVA', 'Trello y MySQL', 150, '2023-12-18'),
('Alma Graciela Martínez González', '¡Hola! Soy Alma, Desarrolladora Full Stack apasionada por la tecnología y el aprendizaje. He perfeccionado mis habilidades para transmitirlas de manera sencilla. Mi verdadera pasión es el conocimiento y compartirlo con otros.', 'CCS3', 'Metodología SCRUM', 150, '2023-12-18'),
('Amalia Elizalde', '¡Hola! Soy Amalia Elizalde, desarrolladora Java Full Stack apasionada por la programación. He perfeccionado mis habilidades en desarrollo web durante el último año. Más allá de los números y logros, mi pasión es aprender y mantenerme actualizada en TI.', 'JAVA', 'Trello y Bootstrap', 150, '2023-12-18'),
('Areli Moreno', '¡Hola! Soy Areli Moreno, desarrolladora web apasionada por las TI. He perfeccionado mis habilidades técnicas y blandas. Mi verdadera pasión es compartir conocimientos y ayudar a otros a alcanzar sus metas.', 'JavaScript', 'CSS3 y Figma', 150, '2023-12-18'),
('Abril Fernández', '¡Hola! Soy Abril, latinoamericanista y desarrolladora web apasionada por la enseñanza y el área TI. A lo largo de años, he perfeccionado la docencia y el desarrollo web. Mi pasión es compartir conocimiento y ayudarte a alcanzar tu éxito profesional.', 'HTML5', 'JAVA y Github', 150, '2023-12-18');

INSERT INTO baby_devs.asesores_has_asesorias(`Asesores_idAsesores`, `Asesorias_idAsesorias`)
VALUES (1,1),(2,2),(3,3),(4,4),(5,5);

INSERT INTO baby_devs.asesorias(`nombre`, `materia`, `duracion`, `Historial_de_compra_venta_idHistorial_de_compra_venta`)
VALUES ('Lizeth Bravo Acevedo','HTML5','1 hora',1),
('Ana Cristina Hernández','JavaScript','2 horas',2),
('Jessica L. Olivera','Java','3 horas',3),
('Amalia Elizalde','Trello','1 hora',4),
('Abril Fernández','GitHub','2 horas',5);

INSERT INTO baby_devs.asesorias_has_asesorados(`Asesorias_idAsesorias`, `Asesorados_idAsesorados`)
VALUES (1,1),(2,2),(3,3),(4,4),(5,5);

INSERT INTO baby_devs.historial_de_compra_venta(`fecha_y_horario_de_compra`, `metodo_de_pago`, `monto_total`, `impuestos_e_IVA`, `comision_BabyDevs`, `comision_Asesor`)
VALUES ('2023-12-23 09:05:17','Tarjeta de débito',150,30, 30, 90),
('2024-01-10 12:10:00','Transferencia',300,60,60,180),
('2024-02-15 15:43:37','Tarjeta de crédito',750,150,150,450),
('2023-12-27 09:17:51','Tarjeta de débito',250,50,50,150),
('2023-12-15 12:00:43','Transferencia',900,180,180,540);
