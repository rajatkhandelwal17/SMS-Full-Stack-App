package in.co.vwits.sms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.sms.model.UserCredentials;
import in.co.vwits.sms.response.LoginResponse;
import in.co.vwits.sms.service.UserService;
import in.co.vwits.sms.studentrepository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
//	@Override
//	public List<User> findAll(){
//		return repo.findAll();
//	}
//
//	@Override
//	public void save(User usr)
//	{
//		repo.save(usr);
//	}
//	
//	@Override
//	public void deleteByUserId(int userId) 
//	{
//		repo.deleteById(userId);
//	}
//	
//	@Override
//	public Optional<User> findByUserId(int userId) throws UserNotFoundException {
//	    return repo.findById(userId);
//	}
	
	@Override
	public LoginResponse loginUser(UserCredentials user) {	    
		UserCredentials u1 = repo.findByUserName(user.getUsername());
	    
	    if (u1 != null) {
	        String password = user.getPassword();
	        
	        Boolean isPwdRight = password.equals(u1.getPassword());
	        
	        if (isPwdRight) {
	            Optional<UserCredentials> usr = repo.findOneByUsernameAndPassword(user.getUsername(), password);
	            
	            if (usr.isPresent()) {
	                return new LoginResponse("Login Success", true);
	            } else {
	                return new LoginResponse("Login Failed", false);
	            }
	        } else {
	            return new LoginResponse("Incorrect Password", false);
	        }
	    } else {
	        return new LoginResponse("Username Doesn't Exist", false);
	    }
	}
	
	@Override
	public LoginResponse signupUser(UserCredentials newUser) {
		UserCredentials existingUser = repo.findByUserName(newUser.getUsername());
	    
	    if (existingUser == null) {
	        repo.save(newUser);
	        return new LoginResponse("Registration Success", true);
	    } else {
	        return new LoginResponse("Username already exists", false);
	    }
	}
}