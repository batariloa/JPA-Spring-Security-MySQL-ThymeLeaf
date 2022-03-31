package Metropolitan.DZ06.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Metropolitan.DZ06.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	 
	Student findByEmail(String email);
	  boolean existsByEmail(String email);

	}