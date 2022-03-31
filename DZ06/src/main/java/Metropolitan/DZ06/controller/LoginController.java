package Metropolitan.DZ06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Metropolitan.DZ06.entity.Student;
import Metropolitan.DZ06.jpa.repository.StudentRepository;
import Metropolitan.DZ06.security.CustomUserDetails;

@Controller
public class LoginController {

@Autowired 
private StudentRepository userRepository;

@Autowired PasswordEncoder passEncoder;

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

	
	@PostMapping(path="/register")
	public String registerUserAccount(
	  @ModelAttribute("student") @Valid Student user,BindingResult bindingResult, Model model ) {
	    
	

		if(userRepository.existsByEmail(user.getEmail()) || bindingResult.hasErrors()) {
			bindingResult.reject("Ne", "email");
		
			return "register";
		}
		user.setPassword(passEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
return "redirect:/";
	
	}
	
	
	@GetMapping(path="/success")
	String uspeh() {
		return "uspeh";
	}

	
	
}
