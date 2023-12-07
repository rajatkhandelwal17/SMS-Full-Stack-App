package in.co.vwits.sms.service;

import in.co.vwits.sms.model.UserCredentials;
import in.co.vwits.sms.response.LoginResponse;

public interface UserService {
	
//	void save(UserCredentials usr);
//	void deleteByUserId(int userId);
//	List<UserCredentials> findAll();
//	Optional<UserCredentials> findByUserId(int userId) throws UserNotFoundException;
	
	LoginResponse loginUser(UserCredentials user);
	LoginResponse signupUser(UserCredentials newUser);
}