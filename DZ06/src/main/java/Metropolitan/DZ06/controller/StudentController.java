package Metropolitan.DZ06.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StudentController {

	
	@GetMapping("/logout")
	String logout() {
		
		SecurityContextHolder.getContext().setAuthentication(null);
		return "login";
	}
	     

}
