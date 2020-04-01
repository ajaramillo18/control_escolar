/**
 * 
 */
package jama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@NamedQueries({
	@NamedQuery(name = "student.getStudents", query = "from Student order by firstName"),
	@NamedQuery(name = "student.getStudentsByName", query = "from Student where lastName = ? order by firstName")

})



/**
 * @author ajara
 *
 */
@Data
@Entity
@Table (name = "student")
public class Student {
	
	@Id
	@Column (name = "student_id")
	int id;
	
	@Column (name = "first_name")
	@NotEmpty(message="*Dato Requerido") 
	@Pattern(regexp="[a-zA-Z]*", message="*Solo letras")
	String firstName;
	
	@Column (name = "last_name")
	@NotEmpty(message="*Dato Requerido") 
	@Pattern(regexp="[a-zA-Z]*", message="*Solo letras")
	String lastName;
	
	@Column (name = "email")
	@NotEmpty(message="*Dato Requerido") 
	@Email(message="*formato invalido") 
	String email;
	
	@Column (name = "status")
	String status;
	
	@Column (name = "tutor_id")
	int tutorId;

	@Column (name = "phone")
	@NotEmpty(message="*Dato Requerido") 
	@Size(min=10, max=10, message="*Deben ser 10 digitos") 
	@Pattern(regexp="[0-9]*", message="*Solo numeros")
	String phone;
}
