SELECT a.nombre, c.nota, m.nombre materia FROM bd_institucion.calificaciones c JOIN alumnos a ON a.id = c.idAlumnos JOIN materias m ON m.id = c.idMaterias;

SELECT c.nombre carrera, s.nombre semestre, m.nombre materia FROM materias m JOIN semestres s ON m.idSemestres = s.id JOIN carreras c ON s.idCarreras = c.id;
SELECT DISTINCT a.nombre alumno, s.nombre semestre, m.nombre materia FROM calificaciones c JOIN alumnos a ON c.idAlumnos = a.id JOIN materias m ON c.idMaterias = m.id JOIN semestres s ON m.idSemestres = s.id;
SELECT c.nombre catedratico, m.nombre materia FROM materias m JOIN catedraticos c ON m.idCatedraticos = c.id;

SELECT a.nombre alumno, m.nombre materia FROM alumnos a JOIN carreras c ON a.idCarreras = c.id JOIN semestres s ON s.idCarreras = c.id JOIN materias m ON m.idSemestres = s.id WHERE m.nombre = "mates";
SELECT COUNT(a.nombre) numero_Alumnos FROM alumnos a JOIN carreras c ON a.idCarreras = c.id JOIN semestres s ON s.idCarreras = c.id JOIN materias m ON m.idSemestres = s.id WHERE m.nombre = "mates";

SELECT a.nombre alumno, m.nombre materia FROM alumnos a JOIN cursar c ON c.idAlumnos = a.id JOIN materias m ON c.idMaterias = m.id WHERE m.nombre = "quimica";
SELECT COUNT(a.nombre) numero_Alumnos FROM alumnos a JOIN cursar c ON c.idAlumnos = a.id JOIN materias m ON c.idMaterias = m.id WHERE m.nombre = "quimica";

SELECT a.nombre alumno, c.nota nota FROM calificaciones c JOIN alumnos a ON c.idAlumnos = a.id WHERE a.nombre = "pepe"; 
SELECT c.nota nota FROM calificaciones c JOIN materias m ON c.idMaterias = m.id JOIN catedraticos cat ON m.idCatedraticos = cat.id WHERE cat.nombre = "juan";
SELECT c.nota nota, m.nombre materias FROM calificaciones c JOIN materias m ON c.idMaterias = m.id WHERE m.nombre = "mates" AND c.nota > 7 ORDER BY c.nota DESC;
SELECT c.nombre carrera, a.nombre alumno FROM alumnos a JOIN carreras c ON a.idCarreras = c.id WHERE a.nombre = "Ignacio Perez";