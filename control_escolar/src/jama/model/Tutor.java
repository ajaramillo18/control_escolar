/**
 * 
 */
package jama.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author ajara
 *
 */
@Data
@Entity
public class Tutor {
	
	@Id
	@Column (name = "tutor_id")
	int tutorId;
	
	@Column (name = "first_name")
	String firstName;
	
	@Column (name = "last_name")
	String lastName;
	
	@Column (name = "email")
	String email;

}
