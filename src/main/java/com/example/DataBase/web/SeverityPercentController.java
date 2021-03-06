package com.example.DataBase.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.domain.SeverityPercent;
import com.example.DataBase.domain.SeverityPercentApp;
import com.example.DataBase.domain.SeverityPercentSeverity;

@RestController
public class SeverityPercentController {
	@Autowired
	private DefectInstanceRepository repository;
	

	@RequestMapping("/SeverityPercent")
	public ArrayList<SeverityPercent> getSeverityPercent() {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercent(/*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-18");
	}
	
	@RequestMapping("/SeverityPercentApp/{appName}")
	public ArrayList<SeverityPercentApp> getSeverityPercentApp(@PathVariable String appName) {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercentApp(appName,/*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-18");
	}
	
	@RequestMapping("/SeverityPercentSeverity/{severityName}")
	public ArrayList<SeverityPercentSeverity> getSeverityPercentSeverity(@PathVariable String severityName) {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercentSeverity(severityName, /*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-18");
	}
}
