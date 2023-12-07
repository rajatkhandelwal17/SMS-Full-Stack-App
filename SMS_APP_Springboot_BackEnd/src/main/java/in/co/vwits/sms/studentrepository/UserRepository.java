package in.co.vwits.sms.studentrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.co.vwits.sms.model.UserCredentials;

@Repository
public interface UserRepository extends JpaRepository <UserCredentials, Integer> {
	
	UserCredentials findByUserName(String username);
	
	@Query("SELECT u FROM UserCredentials u WHERE u.userName = :username AND u.password = :password")
	Optional<UserCredentials> findOneByUsernameAndPassword(String username, String password);
}