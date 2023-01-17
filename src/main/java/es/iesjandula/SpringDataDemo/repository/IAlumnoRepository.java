package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long>
{

}
