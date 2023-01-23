package es.iesjandula.SpringDataDemo;

import es.iesjandula.SpringDataDemo.models.Alumno;
import es.iesjandula.SpringDataDemo.models.Curso;
import es.iesjandula.SpringDataDemo.models.Departamento;
import es.iesjandula.SpringDataDemo.models.Grado;
import es.iesjandula.SpringDataDemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner
{
	@Autowired
	private IDepartamentoRepository iDepartamentoRepository;
	@Autowired
	private IAlumnoRepository iAlumnoRepository;
	//@Autowired
	//private IAsignaturaRepository iAsignaturaRepository;
	@Autowired
	private ICursoRepository iCursoRepository;
	@Autowired
	private IGradoRepository iGradoRepository;
	//@Autowired
	//private IMatriculaRepository iMatriculaRepository;
	//@Autowired
	//private IProfesorRepository iProfesorRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Transactional(readOnly = false)
	@Override
	public void run(String... args) throws Exception
	{
		this.parsearAlumno();
		//launcherTemporal.parsearAsignatura();
		this.parsearCurso();
		this.parsearDepartamento();
		this.parsearGrado();
		//launcherTemporal.parsearProfesor();
		//launcherTemporal.parsearMatricula();

	}

	public void parsearAlumno()
	{

		final String separadorCampo = ",";

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			fileReader = new FileReader("src/main/resources/alumno.csv");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			//lee la cabecera y se la salta
			bufferedReader.readLine();

			while((linea = bufferedReader.readLine()) != null)
			{

				String[] alumnoArray = linea.split(separadorCampo);

				Alumno alumno = new Alumno();
				alumno.setId(Long.parseLong(alumnoArray[0]));
				alumno.setNif(alumnoArray[1]);
				alumno.setNombre(alumnoArray[2]);
				alumno.setApellido1(alumnoArray[3]);
				alumno.setApellido2(alumnoArray[4]);
				alumno.setCiudad(alumnoArray[5]);
				alumno.setDireccion(alumnoArray[6]);
				alumno.setTelefono(alumnoArray[7]);
				alumno.setFechaNacimiento((Date) formato.parse(alumnoArray[8]));
				alumno.setSexo(alumnoArray[9]);

				this.iAlumnoRepository.saveAndFlush(alumno);

			}

			System.out.println(listaAlumnos);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

	// public void parsearAsignatura()
	// {
	//
	//     final String separadorCampo = ",";
	//
	//     List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
	//
	//     FileReader fileReader = null;
	//     BufferedReader bufferedReader = null;
	//
	//     try
	//     {
	//         fileReader = new FileReader("src/main/resources/asignatura.csv");
	//         bufferedReader = new BufferedReader(fileReader);
	//
	//         String linea;
	//
	//         //lee la cabecera y se la salta
	//         bufferedReader.readLine();
	//
	//         while((linea = bufferedReader.readLine()) != null)
	//         {
	//
	//             String[] asignaturaArray = linea.split(separadorCampo);
	//
	//             Asignatura asignatura = new Asignatura();
	//             asignatura.setId(Long.parseLong(asignaturaArray[0]));
	//             asignatura.setNombre(asignaturaArray[1]);
	//             asignatura.setCreditos(Double.parseDouble(asignaturaArray[2]));
	//             asignatura.setTipo(asignaturaArray[3]);
	//             asignatura.setCurso(Integer.parseInt(asignaturaArray[4]));
	//             asignatura.setCuatrimestre(Integer.parseInt(asignaturaArray[5]));
	//             asignatura.setIdProfesor(asignaturaArray[6]); // volver a poner clase Profesor
	//             asignatura.setIdGrado(asignaturaArray[7]); // volver a poner clase Grado
	//
	//             listaAsignaturas.add(asignatura);
	//
	//         }
	//
	//         System.out.println(listaAsignaturas);
	//
	//     } catch (FileNotFoundException e) {
	//         throw new RuntimeException(e);
	//     } catch (IOException e) {
	//         throw new RuntimeException(e);
	//     }
	//
	// }

	public void parsearCurso()
	{

		final String separadorCampo = ",";

		List<Curso> listaCursos = new ArrayList<Curso>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			fileReader = new FileReader("src/main/resources/curso.csv");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			//lee la cabecera y se la salta
			bufferedReader.readLine();

			while((linea = bufferedReader.readLine()) != null)
			{

				String[] cursosArray = linea.split(separadorCampo);

				Curso curso = new Curso();

				curso.setId(Long.valueOf(cursosArray[0]));
				curso.setAnioInicio(Integer.parseInt(cursosArray[1]));
				curso.setAnioFin(Integer.parseInt(cursosArray[2]));

				this.iCursoRepository.saveAndFlush(curso);

			}

			System.out.println(listaCursos);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void parsearDepartamento()
	{

		final String separadorCampo = ",";

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			fileReader = new FileReader("src/main/resources/departamento.csv");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			//lee la cabecera y se la salta
			bufferedReader.readLine();

			while((linea = bufferedReader.readLine()) != null)
			{

				String[] departamentoArray = linea.split(separadorCampo);

				Departamento departamento = new Departamento();

				departamento.setId(Long.valueOf(departamentoArray[0]));
				departamento.setNombre(departamentoArray[1]);

				this.iDepartamentoRepository.saveAndFlush(departamento);

			}

			System.out.println(listaDepartamentos);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void parsearGrado()
	{

		final String separadorCampo = ",";

		List<Grado> listaGrados = new ArrayList<Grado>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			fileReader = new FileReader("src/main/resources/grado.csv");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			//lee la cabecera y se la salta
			bufferedReader.readLine();

			while((linea = bufferedReader.readLine()) != null)
			{

				String[] gradoArray = linea.split(separadorCampo);

				Grado grado = new Grado();

				grado.setId(Long.valueOf(gradoArray[0]));
				grado.setNombre(gradoArray[1]);

				this.iGradoRepository.saveAndFlush(grado);

			}

			System.out.println(listaGrados);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}



	//  public void parsearProfesor()
	//  {
	//
	//      final String separadorCampo = ",";
	//
	//      List<Profesor> listaProfesores = new ArrayList<Profesor>();
	//
	//      FileReader fileReader = null;
	//      BufferedReader bufferedReader = null;
	//
	//      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	//
	//      try
	//      {
	//          fileReader = new FileReader("src/main/resources/profesor.csv");
	//          bufferedReader = new BufferedReader(fileReader);
	//
	//          String linea;
	//
	//          //lee la cabecera y se la salta
	//          bufferedReader.readLine();
	//
	//          while((linea = bufferedReader.readLine()) != null)
	//          {
	//
	//              String[] profesorArray = linea.split(separadorCampo);
	//
	//              Profesor profesor = new Profesor();
	//              profesor.setId(Long.parseLong(profesorArray[0]));
	//              profesor.setNif(profesorArray[1]);
	//              profesor.setNombre(profesorArray[2]);
	//              profesor.setApellido1(profesorArray[3]);
	//              profesor.setApellido2(profesorArray[4]);
	//              profesor.setCiudad(profesorArray[5]);
	//              profesor.setDireccion(profesorArray[6]);
	//              profesor.setTelefono(profesorArray[7]);
	//              profesor.setFechaNacimiento((Date) formato.parse(profesorArray[8]));
	//              profesor.setSexo(profesorArray[9]);
	//              profesor.setIdDepartamento(profesorArray[10]); // volver a poner clase Departamento
	//
	//              listaProfesores.add(profesor);
	//
	//          }
	//
	//          System.out.println(listaProfesores);
	//
	//      } catch (FileNotFoundException e) {
	//          throw new RuntimeException(e);
	//      } catch (IOException e) {
	//          throw new RuntimeException(e);
	//      } catch (ParseException e) {
	//          throw new RuntimeException(e);
	//      }
	//
	//  }

}
