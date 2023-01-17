package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long>
{

}
