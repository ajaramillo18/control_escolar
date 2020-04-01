/**
 * 
 */
package jama.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;


import jama.service.StudentService;
import lombok.Getter;
import jama.model.Student;






/**
 * @author ajara
 *
 */
@Controller
@RequestMapping ("/student")
public class StudentController {
	
	
	// need to inject our customer service
	@Autowired	
	private StudentService studentService;

	@RequestMapping ("/list") //@GetMapping("/get/{id}")
	public String listStudents(Model model) {
		
		// get customers from the service
		List<Student> studentList = studentService.getStudents();
							
		// add the customers to the model
		model.addAttribute("students", studentList);
		return "list-students";
		
	}
	@GetMapping("/showFormForAdd")
	public String addStudent(Model model) {
		
		Student newStudent = new Student();
		model.addAttribute(newStudent);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
		
		//return to form if there are validation errors
		if(bindingResult.hasErrors())
			return  "student-form";
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
		studentService.save(student);
		
		return "redirect:/student/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Student student = studentService.getStudent(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("student", student);
		
		// send over to our form		
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		// delete the customer
		studentService.deleteStudent(theId);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/payment")
	public String paymentStudent(@RequestParam("studentId") int theId) {
		
		// delete the customer
		studentService.paymentStudent(theId);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/search")
	public String searchStudent(@RequestParam("name") String name, Model model) {
		
		// get customers from the service
		List<Student> studentList = studentService.getStudentsByName(name);
									
		// add the customers to the model
		model.addAttribute("students", studentList);
		return "list-students";
		
	}
		
		
	
}
