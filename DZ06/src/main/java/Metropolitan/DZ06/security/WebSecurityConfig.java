package Metropolitan.DZ06.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
		
	}
	
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http
	      .authorizeRequests()        
	      
	          .antMatchers("/resources/**", "/register/**", "/about","/","/static/**","/css/*", "/login","/navbar").permitAll()           
	          .antMatchers("/admin/**").hasRole("ADMIN")                                
	          .antMatchers().access("hasRole('ADMIN')")      
	          .antMatchers("/prijavi/**","/all/**","/","/dodaj").access("hasRole('USER')")   
	          .antMatchers("/*.css").permitAll()
	          .anyRequest().permitAll()                                   
	         
            .and()
            .formLogin().loginPage("/login").permitAll()
            ;
   }



}