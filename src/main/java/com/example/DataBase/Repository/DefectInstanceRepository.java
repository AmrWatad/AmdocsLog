package com.example.DataBase.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DataBase.domain.AppPercent;
import com.example.DataBase.domain.DefectInstance;
import com.example.DataBase.domain.SeverityAppPercent;
import com.example.DataBase.domain.SeverityPercent;
import com.example.DataBase.domain.ViewDefects;
@RepositoryRestResource
public interface DefectInstanceRepository extends CrudRepository<DefectInstance, Long>{

	
	@Query(nativeQuery = true)
	ArrayList<ViewDefects> getViewDefects();
	
	@Query(nativeQuery = true)
	ArrayList<SeverityPercent> getSeverityPercent();

	@Query(nativeQuery = true)
	ArrayList<AppPercent> getAppPercent();
	
	@Query(nativeQuery = true)
	ArrayList<SeverityAppPercent> getSeverityAppPercent(@Param("appName") String appName ,@Param("severity") String severity);
	
	
	
	
}
