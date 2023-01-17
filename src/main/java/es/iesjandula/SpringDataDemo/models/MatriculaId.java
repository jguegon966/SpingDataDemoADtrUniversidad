package es.iesjandula.SpringDataDemo.models;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class MatriculaId implements Serializable
{

    @Serial
    private static final long serialVersionUID = -6496874805144002414L;

    private Long idAlumno;

    private Long idAsignatura;

    private Long idCurso;

    public MatriculaId()
    {

    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

}
