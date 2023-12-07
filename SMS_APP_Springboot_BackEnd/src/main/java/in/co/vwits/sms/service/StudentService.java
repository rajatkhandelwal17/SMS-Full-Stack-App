package in.co.vwits.sms.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.model.exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;

public interface StudentService {

	List<Student> findAllStudentsScoredMoreThan(double percentage);
	List<Student> findAllStudentsScoredLessThan(double percentage, int attempts);
	long findTotalCountofStudentsStartsWith(String s);
	List<Student> findAllStudentsStartsWith(String s);
	List<Student> findAllStudentSortedByPercentage();
	List<String> findStudentNameWhoScoredMoreThanGivenPercentage(double percentage);
	List<Student> findAllStudentsLearningSpecificSubject(String subject);
	List<Student> findAllStudentsBornBeforeSpecificDate(LocalDate SpecificDate);
	long findStudentsCountBornAfterSpecificDate(LocalDate SpecificDate);
	List<Student> findAllStudentsBornBetweenSpecificDates(LocalDate startDate, LocalDate endDate);
	Map<Boolean, List<Student>> partioningStudentsBasedOnMarks(double mark);
	long findCountOfUniqueSubjectsLearnedByAllStudents();
	List<Student> findAll();
	void save(Student s);
	Optional<Student> findByRollNo(int rollno) throws StudentNotFoundException;
	void deleteStudent(int rollno);
	List<Student> findAllWithSubjects();
	Student findStudentWithSubjects(int rollno);
	void updateStudentDetails(int rollno, Student updatedStudent);
	void updateStudent(Student existingStudent);
}