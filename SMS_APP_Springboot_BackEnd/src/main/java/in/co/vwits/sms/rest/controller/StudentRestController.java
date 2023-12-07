package in.co.vwits.sms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.model.exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.service.StudentService;

@RestController
@RequestMapping(value="/api/student")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Student> findAll(){
		return service.findAllWithSubjects();
	}
	
	@GetMapping(value="/{rollno}")
	public Student findByRollno(@PathVariable int rollno) {
		return service.findStudentWithSubjects(rollno); 
	}
	
	@PostMapping
	public ResponseEntity<Student> createNewStudent(@RequestBody Student s) {
		this.service.save(s);
		ResponseEntity<Student> entity = new ResponseEntity<>(s,HttpStatus.CREATED);
		return entity;
	}
	
//	To do - Improve server code to return appropriate status codes.
	
	@DeleteMapping(value="/{rollno}")
	public void deleteStudentByRollno(@PathVariable int rollno) throws InterruptedException {
		// Thread.sleep(10000);  // Forceful delay just to mimic the behavior as if server is taking time to do the processing
		this.service.deleteStudent(rollno);
	}
	
	@PutMapping(value="/{rollno}")
    public ResponseEntity<Student> updateStudent(@PathVariable int rollno, @RequestBody Student updatedStudent) throws StudentNotFoundException {
        Student existingStudent = this.findByRollno(rollno);
		if (existingStudent != null) {
		    existingStudent.setName(updatedStudent.getName());
		    existingStudent.setPercentage(updatedStudent.getPercentage());
		    existingStudent.setNumberOfAttempts(updatedStudent.getNumberOfAttempts());
		    existingStudent.setSubjectsLearning(updatedStudent.getSubjectsLearning());	
		    		    
		    service.updateStudent(existingStudent);
		    return new ResponseEntity<>(existingStudent, HttpStatus.OK);
		} else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
}