package com.example.Employee_Service.configDaoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Employee_Service.configDAO.RegDAO;
@Repository
public interface RegistrationRepository extends JpaRepository<RegDAO, RegDAO>{


	public static final String FIND_UNAME = "SELECT email FROM regdao";
	@Query(value = FIND_UNAME, nativeQuery = true)
	public String[] findUname();
	
	public static final String FIND_PASSWORD = "SELECT password FROM regdao";
	@Query(value = FIND_PASSWORD, nativeQuery = true)
	public String[] findPassword();
}
