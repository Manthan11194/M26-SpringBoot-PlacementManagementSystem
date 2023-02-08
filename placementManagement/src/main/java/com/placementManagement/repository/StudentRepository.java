package com.placementManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placementManagement.entity.Student;



/*JPARepository is exists in Spring Data JPA dependencies and it contains
 * all the CRUD operation of Spring JPA
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

	
	Student findByRollNo(Integer rollNo);
	

}