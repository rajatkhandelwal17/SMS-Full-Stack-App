package in.co.vwits.sms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_credentials")
public class UserCredentials implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rollno")
    private int rollno;
    
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne
    @MapsId
    @JoinColumn(
        name = "rollno",
        referencedColumnName = "rollno",
        foreignKey = @ForeignKey(name = "FK_user_credentials_student")
    )
    private Student student;
    
    public void setStudent(Student student) {
        this.student = student;
    }

	@Override
	public String toString() {
		return "UserCredentials [username=" + userName + ", password=" + password + "]";
	}
}