/**
 * 
 */
package jama.dao;

import java.util.List;


import jama.model.Student;;

/**
 * @author ajara
 *
 */

public interface StudentDAO {
	

	public List<Student> getStudents();

	public void save(Student student);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

	public List<Student> getStudentsByName(String name);

	public void paymentStudent(int theId);

}
