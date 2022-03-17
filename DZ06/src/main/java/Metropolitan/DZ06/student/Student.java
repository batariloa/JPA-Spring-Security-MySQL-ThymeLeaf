package Metropolitan.DZ06.student;

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

import org.springframework.stereotype.Component;

import Metropolitan.DZ06.ispit.Ispit;

@Component
@Entity(name="student")
public class Student {
	
	
	 @Id
	 @GeneratedValue
	 private Long id;

	 @JoinTable
	    @OneToMany(cascade = CascadeType.ALL)
	 private List<Ispit> prijaveljeniIspiti = new ArrayList<>();
	
	
	public Student(Long id, String ime, String indeks, String email, String password) {
		super();
		this.id = id;
		this.ime = ime;
		this.indeks = indeks;
		this.email = email;
		this.password = password;
		
	}

	public List<Ispit> getPrijaveljeniIspiti() {
		return prijaveljeniIspiti;
	}

	public void setPrijaveljeniIspiti(List<Ispit> prijaveljeniIspiti) {
		this.prijaveljeniIspiti = prijaveljeniIspiti;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	private String ime;
	private String indeks;
	private String role;
	
	private String email;
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
