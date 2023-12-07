package in.co.vwits.sms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient; 

@Entity
@Table(name="tbl_student")
@NamedQuery(name="findAllWithSubjects", query="FROM Student AS s LEFT JOIN FETCH s.subjectsLearning")
public class Student implements Comparable<Student>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollno;
	
	@Column(name="st_name",nullable = false)
	private String name;
	private double percentage;
	private int numberOfAttempts;
	
	@ElementCollection(fetch = FetchType.LAZY) 
 	@CollectionTable(name="Students_Subjects", joinColumns = @JoinColumn(name="rollno_fk"))
	private List<String> subjectsLearning;
	
	@Transient
	private LocalDate dateOfBirth;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserCredentials userCredentials;
 
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public List<String> getSubjectsLearning() {
		return subjectsLearning;
	}

	public void setSubjectsLearning(List<String> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", numberOfAttempts="
				+ numberOfAttempts + ", subjectsLearning=" + subjectsLearning + ", dateOfBirth=" + dateOfBirth
				+ ", userCredentials=" + userCredentials + "]";
	}

	@Override
	public int compareTo(Student o) {
		return (int) (o.percentage - this.percentage);
	}
}