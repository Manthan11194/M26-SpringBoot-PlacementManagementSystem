package com.placementManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placementManagement.entity.College;

public interface CollegeRepository extends JpaRepository<College,Integer> {

}

