/**
 * 
 */
package jama.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jama.model.Student;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author ajara
 *
 */



@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Student> getStudents() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.getNamedQuery("student.getStudents");
		List<Student> lista = query.list();	
		
		
		/*Query<Student> theQuery = session.createQuery("from Customer order by lastName");		
		// execute query and get result list
		List<Student> customers = theQuery.getResultList();*/
		
		
		return lista;
	}

	
	@Override
	public int save(Student student) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		 int id = (Integer)currentSession.save(student);
		 return id;
		
	}

	
	@Override
	public void saveOrUpdate(Student student) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(student);
		
	}

	@Override
	public Student getStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = currentSession.get(Student.class, id);

		return student;
	}

	@Override
	public void deleteStudent(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, id);
		currentSession.delete(student);	
		
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.getNamedQuery("student.getStudentsByName");
		query.setString(0, name);
		List<Student> lista = query.list();		
		return lista;
		
	}

	@Override
	public void paymentStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve the student and change the status
		Student student = session.get(Student.class, id);		
		student.setStatus("P");		
		session.saveOrUpdate(student);
		
		//insert new record in payment table
		//TODO make payment object instead of raw query
		String queryString = "INSERT INTO `instituto_ingles`.`payment_student`\r\n" + 
				"(`date`,\r\n" + 
				"`student_id`)\r\n" + 
				"VALUES\r\n" + 
				"(?,\r\n" + 
				"?);";
		SQLQuery query = session.createSQLQuery(queryString);
		
		Date date = new Date();  
		
		query.setDate(0, date);
		query.setInteger(1, id);
		
		query.executeUpdate();		
				
		
		
	}


}
