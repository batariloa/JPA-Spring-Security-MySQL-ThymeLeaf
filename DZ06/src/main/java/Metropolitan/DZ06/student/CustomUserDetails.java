package Metropolitan.DZ06.student;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Student student;
	 
	
	
	
	public CustomUserDetails(Student student) {
		super();
		this.student = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("EVO GA ROLE" + student.getRole());
		return Collections.singletonList(new SimpleGrantedAuthority(student.getRole()));
		
		
	}

	@Override
	public String getPassword() {
		
		return student.getPassword();
	}

	

	public Long getUserId() {
		
		return student.getId();
	}
	
	@Override
	public String getUsername() {
	
		return student.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return  true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
