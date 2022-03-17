package Metropolitan.DZ06.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Metropolitan.DZ06.jpa.repository.StudentRepository;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Student student = studentRepo.findByEmail(email);
	
		if(student == null) {
			throw new UsernameNotFoundException("Student nije pronadjen");
			
		}
		System.out.println("OVO JE STUDENT " + student.getEmail());
		System.out.println("PERMISSION JE " + student.getRole());
		return new CustomUserDetails(student);
	}

}
