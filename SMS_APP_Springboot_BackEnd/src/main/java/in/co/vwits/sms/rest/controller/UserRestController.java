package in.co.vwits.sms.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.sms.model.UserCredentials;
import in.co.vwits.sms.response.LoginResponse;
import in.co.vwits.sms.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
//	@GetMapping
//	public List<User> findAll(){
//		return service.findAll();
//	}
//	
//	@PostMapping("/signup")
//	public User createNewUser(@RequestBody User user) {
//		this.service.save(user);
//		return user;
//	}
//	
//	@GetMapping("/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable int userId) {
//        try {
//            Optional<User> user = service.findByUserId(userId);
//            return ResponseEntity.ok(user.orElse(null));
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//	
//	@DeleteMapping(value="/{userId}")
//	public void deleteUserByUserId(@PathVariable int userId) {
//		this.service.deleteByUserId(userId);
//	}
	 
	 @PostMapping("/login")
	   public ResponseEntity<?> loginUser(@RequestBody UserCredentials user) {
		 LoginResponse loginResponse = service.loginUser(user);
		 return ResponseEntity.ok(loginResponse);
	  }	
}