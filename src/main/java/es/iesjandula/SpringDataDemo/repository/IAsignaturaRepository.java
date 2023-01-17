package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long>
{

}
