package in.co.vwits.sms.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.model.exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.model.UserCredentials;
import in.co.vwits.sms.service.StudentService;
import in.co.vwits.sms.studentrepository.StudentRepository;

@Service
@Transactional 
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public List<Student> findAllStudentsScoredMoreThan(double percentage) {
		return repo.findAll().stream().filter(student -> student.getPercentage() > percentage)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> findAllStudentsScoredLessThan(double percentage, int attempts) {
		return repo.findAll().stream().filter(student -> student.getNumberOfAttempts() < attempts)
				.filter(student -> student.getPercentage() < percentage).collect(Collectors.toList());
	}

	@Override
	public long findTotalCountofStudentsStartsWith(String s) {
		return repo.findAll().stream().filter(student -> student.getName().startsWith(s)).count();
	}

	@Override
	public List<Student> findAllStudentsStartsWith(String s) {
		return repo.findAll().stream().filter(student -> student.getName().startsWith(s)).collect(Collectors.toList());
	}

	@Override
	public List<Student> findAllStudentSortedByPercentage() {
		return repo.findAll().stream().sorted().collect(Collectors.toList()); // collector for before jdk 16
	}

	@Override
	public List<String> findStudentNameWhoScoredMoreThanGivenPercentage(double percentage) {
		return repo.findAll().stream().filter(student -> student.getPercentage() > percentage)
				.map(Student::getName).collect(Collectors.toList());
	}

	@Override
	public List<Student> findAllStudentsLearningSpecificSubject(String subject) {
		return repo.findAll().stream()
				.filter(student -> student.getSubjectsLearning().stream().anyMatch(sub -> sub.equals(subject)))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Student> findAllStudentsBornBeforeSpecificDate(LocalDate SpecificDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isBefore(SpecificDate))
				.collect(Collectors.toList());
	}
	
	@Override
	public long findStudentsCountBornAfterSpecificDate(LocalDate SpecificDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isAfter(SpecificDate))
				.count();
	}

	@Override
	public List<Student> findAllStudentsBornBetweenSpecificDates(LocalDate startDate, LocalDate endDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isBefore(endDate))
				.filter(student -> student.getDateOfBirth().isAfter(startDate))
				.collect(Collectors.toList());
	}
	
	@Override
	public Map<Boolean, List<Student>> partioningStudentsBasedOnMarks(double mark){
		return repo.findAll().stream()
				.collect(Collectors.partitioningBy(s -> s.getPercentage() > mark));
	}
	
	@Override
	public long findCountOfUniqueSubjectsLearnedByAllStudents() {
	    return repo.findAll().stream()
	        .flatMap(student -> student.getSubjectsLearning().stream())
	        .distinct()
	        .count();
	}
	
	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Student s) {
		System.out.println(s.getRollno());
	    UserCredentials userCredentials = s.getUserCredentials();
	    if (userCredentials != null) {
	    	s.setUserCredentials(userCredentials);
	        userCredentials.setStudent(s);
	    }
	    repo.save(s);
	}

	@Override
	public Optional<Student> findByRollNo(int rollno) throws StudentNotFoundException {
		Optional<Student> p = repo.findById(rollno);
		if(p.isPresent()) {
			return p;
		}
		else {
			throw new StudentNotFoundException();
		}
	}

	@Override
	public void deleteStudent(int rollno) {
		repo.deleteById(rollno);
	}
	
	@Override
	public List<Student> findAllWithSubjects() {
		return this.repo.findAllWithSubjects();
	}

	@Override
	public Student findStudentWithSubjects(int rollno) {
		return this.repo.findStudentWithSubjects(rollno); 
	}
	
	@Override
    public void updateStudentDetails(int rollno, Student updatedStudent) {
        repo.updateStudent(rollno, updatedStudent);
    }

	@Override
	public void updateStudent(Student existingStudent) {
		this.repo.save(existingStudent);
	}

}