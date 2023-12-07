package in.co.vwits.sms.studentrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.co.vwits.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT DISTINCT s FROM Student AS s LEFT JOIN FETCH s.subjectsLearning")
	List<Student> findAllWithSubjects();

	@Query("FROM Student As s LEFT JOIN FETCH s.subjectsLearning WHERE s.rollno = :rno")
	Student findStudentWithSubjects(@Param(value="rno") int rollno);
	
	@Modifying
    @Query("UPDATE Student s SET s.name = :#{#updatedStudent.name},  s.percentage = :#{#updatedStudent.percentage}, s.numberOfAttempts = :#{#updatedStudent.numberOfAttempts}, s.subjectsLearning = :#{#updatedStudent.subjectsLearning} WHERE s.rollno = :rollno")
    void updateStudent(int rollno, Student updatedStudent);
	
}