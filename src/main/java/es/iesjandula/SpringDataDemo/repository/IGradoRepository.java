package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGradoRepository extends JpaRepository<Grado, Long>
{

}
