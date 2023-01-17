package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Matricula;
import es.iesjandula.SpringDataDemo.models.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaRepository extends JpaRepository<Matricula, MatriculaId> {
}
