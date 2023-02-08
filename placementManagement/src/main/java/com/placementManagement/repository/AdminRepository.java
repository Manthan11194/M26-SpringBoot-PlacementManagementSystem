package com.placementManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placementManagement.entity.Admin;

/*JPARepository is exists in Spring Data JPA dependencies and it contains
 * all the CRUD operation of Spring JPA
 */
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
