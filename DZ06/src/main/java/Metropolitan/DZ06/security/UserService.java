package Metropolitan.DZ06.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import Metropolitan.DZ06.login.LoginController;
import Metropolitan.DZ06.student.Student;

public interface UserService extends UserDetailsService{
	String addNewUser(Student registrationDto);
	}