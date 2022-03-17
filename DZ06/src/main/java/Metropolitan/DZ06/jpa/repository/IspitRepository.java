package Metropolitan.DZ06.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Metropolitan.DZ06.ispit.Ispit;


@Repository
public interface IspitRepository extends JpaRepository<Ispit, Long> {
	 
	List<Ispit> findAll();
	
	}