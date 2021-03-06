package com.example.DataBase.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.domain.SeverityAppPercent;
import com.example.DataBase.domain.SeverityPercent;

@RestController
@RequestMapping("/SeverityAppPercent")
public class SeverityAppPercentController {
	@Autowired
	private DefectInstanceRepository repository;

	@GetMapping(value = "/{appName}/{severity}/{fdate}") 
	public ArrayList<SeverityAppPercent> getSeverityAppPercentDate(@PathVariable final String appName,@PathVariable final String severity
			,@PathVariable final String fdate) {
		return repository.getSeverityAppPercentDate(appName,severity,fdate);
	}
	@GetMapping(value = "/{appName}/{severity}") 
	public ArrayList<SeverityAppPercent> getSeverityAppPercent(@PathVariable final String appName,@PathVariable final String severity
			) {
		return repository.getSeverityAppPercent(appName,severity);
	}
	@GetMapping(value = "/{appName}") 
	public ArrayList<SeverityAppPercent> getSeveritiesAppPercent(@PathVariable final String appName
			) {
		return repository.getSeveritiesAppPercent(appName);
	}
}
