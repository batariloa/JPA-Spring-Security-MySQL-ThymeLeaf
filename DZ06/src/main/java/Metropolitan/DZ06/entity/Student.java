package Metropolitan.DZ06.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
@Entity(name="student")
public class Student {
	
	
	 @Id
	 @GeneratedValue
	 private Long id;

	 
	 public List<Ispit> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}



	public void setPrijavljeniIspiti(List<Ispit> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_ispit_join", 
		    joinColumns = {@JoinColumn(name = "student_id")},
		    inverseJoinColumns = {@JoinColumn(name = "ispit_id")})
	 private List<Ispit> prijavljeniIspiti = new ArrayList<>();
	
	
	public Student(Long id, String ime, String indeks, String email, String password) {
		super();
		this.id = id;
		this.ime = ime;
		this.indeks = indeks;
		this.email = email;
		this.password = password;
		
	}



	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Size(min=1)
	private String ime;
	

	@Size(min=4, max=5)
	@NumberFormat
	private String indeks;
	
	private String role;
	
	@Email
	@Size(min=1)
	@Column(unique=true)
	private String email;
	@Size(min = 5)
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student() {
		super();
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime =ime;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public Student(String ime, String indeks) {
		super();
		this.ime = ime;
		this.indeks = indeks;
	
	}

}
