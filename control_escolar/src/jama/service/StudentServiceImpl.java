/**
 * 
 */
package jama.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jama.dao.StudentDAO;
import jama.model.Student;

/**
 * @author ajara
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	EmailService emailService;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		List<Student> lista =  studentDAO.getStudents();//new ArrayList<>();
		
		/*Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Armando");
		student1.setLastName("Jaramillo");
		student1.setEmail("ajaramillo18@hotmail.com");
		lista.add(student1);
		Student student2 = new Student();
		student2.setId(2);
		student2.setFirstName("Angela");
		student2.setLastName("Magallon");
		student2.setEmail("gelamagallona@hotmail.com");
		lista.add(student2);
		Student student3 = new Student();
		student3.setId(3);
		student3.setFirstName("Dante");
		student3.setLastName("Dali");
		student3.setEmail("dddd@hotmail.com");
		lista.add(student3);*/
		return lista;
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDAO.save(student);
		
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		
		Student student = studentDAO.getStudent(theId);
		
		return student;
		
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		 
		studentDAO.deleteStudent(theId);
		
	}

	@Override
	@Transactional
	public List<Student> getStudentsByName(String name) {
		
		List<Student> lista =  studentDAO.getStudentsByName(name);
		
		return lista;
	}

	@Override
	@Transactional
	public void paymentStudent(int theId) {
		
		//TODO se debe generar un codigo unico de pago o algo asi
		//TODO asi como esta, se debe de resetear el status de P a todos los alumnos cada inicio de mes. 
				//se debe de cambiar para que el status dependa de si existe o no un registro en payments del mes actual
		studentDAO.paymentStudent(theId);
		
		
		Student student = studentDAO.getStudent(theId);
		//send email
		//TODO parametrizar los datos del mail usando un properties, como debe usarse en spring
		emailService.sendMail(student.getEmail(), "Pago instituto de ingles", "Gracias por pagar, te esperamos en clase");
		
	}

}
