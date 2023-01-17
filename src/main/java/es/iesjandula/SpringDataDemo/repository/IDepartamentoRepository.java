package es.iesjandula.SpringDataDemo.repository;

import es.iesjandula.SpringDataDemo.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>
{

}
