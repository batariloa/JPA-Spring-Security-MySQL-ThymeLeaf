package Metropolitan.DZ06.ispit;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Ispit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	

	private String ime;
	private String sifra;
	

	@DateTimeFormat (pattern="YYYY-MM-dd")
	private Date datum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Ispit() {
		super();
	}
	@Override
	public String toString() {
		return "Ispit [id=" + id + ", ime=" + ime + ", sifra=" + sifra + ", datum=" + datum + "]";
	}
	public Ispit(Long id, String ime, String sifra, Date datum) {
		super();
		this.id = id;
		this.ime = ime;
		this.sifra = sifra;
		this.datum = datum;
	}
	public Ispit(String ime, String sifra) {
		super();
		this.ime = ime;
		this.sifra = sifra;
		
	}
	

	
}
