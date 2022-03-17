package Metropolitan.DZ06.ispit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Metropolitan.DZ06.jpa.repository.IspitRepository;
import Metropolitan.DZ06.jpa.repository.StudentRepository;
import Metropolitan.DZ06.student.CustomUserDetails;
import Metropolitan.DZ06.student.Student;

@Controller
public class IspitController {

	
List<Ispit>	listaDostupnihIspita = new ArrayList<Ispit>();
List<Ispit> listaPrijavljenihIspita = new ArrayList<Ispit>();

	
@Autowired
private StudentRepository studentRepo;




@Autowired
private IspitRepository ispitRepo;

	@GetMapping({"/prijavi","/	"})
	String getIspiti(Model model) {
		
		model.addAttribute("myispit", new Ispit());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUser = (CustomUserDetails)auth.getPrincipal();
		long userId = customUser.getUserId();

	
		Student s1 = studentRepo.getById(userId);
		

		listaPrijavljenihIspita = s1.getPrijaveljeniIspiti();
		listaDostupnihIspita = filtrirajIspite(ispitRepo.findAll(), listaPrijavljenihIspita);
		System.out.println("trenutni id je "+ userId);
		model.addAttribute("prijavljeniIspiti", listaPrijavljenihIspita);
		model.addAttribute("ispiti", listaDostupnihIspita);
	
		
		return "prijava";
		
	}
	
	@PostMapping("/nije")
	String prijaviIspit(@ModelAttribute Ispit ispitDodat) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUser = (CustomUserDetails)auth.getPrincipal();
		long userId = customUser.getUserId();

	
		Student s1 = studentRepo.getById(userId);
		listaPrijavljenihIspita = s1.getPrijaveljeniIspiti();
		System.out.println("OVO JE DODAT" + " "+ ispitDodat.getId());
		
		Ispit ispitTemp = ispitRepo.getById(ispitDodat.getId());
		listaPrijavljenihIspita.add(ispitTemp);
		
		s1.setPrijaveljeniIspiti(listaPrijavljenihIspita);
		studentRepo.save(s1);
		
	
		
		return "uspeh";
		
		
	}
	
	
	public List<Ispit> filtrirajIspite(List<Ispit> dostupniIspiti, List<Ispit> prijavljeniIspiti){
		
		System.out.println("DOSTUPNI ISPITI "+ dostupniIspiti.toString());
		System.out.println("Prijavljeni ISPITI "+ prijavljeniIspiti.toString());
		List<Ispit> rezultat = new ArrayList<>();
		for(Ispit element : dostupniIspiti) {
			if(!prijavljeniIspiti.contains(element)) {
				rezultat.add(element);
			}
		}
		return rezultat;
		
	}
	
}
