package Metropolitan.DZ06.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Metropolitan.DZ06.jpa.repository.StudentRepository;

import Metropolitan.DZ06.student.Student;

@Controller
public class LoginController {

@Autowired 
private StudentRepository userRepository;

@PostMapping(path="/add") // Map ONLY POST Requests
public String addNewUser (
		@ModelAttribute Student student) {
	
student.setRole("USER");
userRepository.save(student);

return "users";
}

@GetMapping(path="/all")
public @ResponseBody Iterable<Student> getAllStdents() {

	

	
return userRepository.findAll();
}



	@GetMapping("/login")
	String getLogin(Model model){
		return "login";
	}
	
	@GetMapping("/register")
	String registerPage(Model model){
		model.addAttribute("student", new Student());
		return "register";
	}
	
}
