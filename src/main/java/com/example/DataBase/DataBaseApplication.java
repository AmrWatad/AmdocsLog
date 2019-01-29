package com.example.DataBase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.example.DataBase.Repository.AppRepository;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.Repository.DefectRepository;
import com.example.DataBase.Repository.LogFileRepository;
import com.example.DataBase.Repository.SolutionRepository;
import com.example.DataBase.Routing.LogFileRouting;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class DataBaseApplication {
	  @Autowired 
  private AppRepository appRepository;

  @Autowired 
  private DefectRepository defectRepository;
  
  @Autowired 
  private LogFileRepository logFileRepository;
  
  @Autowired 
  private DefectInstanceRepository defectInstanceRepository;
	
  @Autowired 
  private SolutionRepository solutionRepository;
	  
	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}
	 @Bean
     CommandLineRunner runner(){
       return args -> {
    	   
    	   String searchStr = "Caused by";
   			File file = new File("CMServer.20170924_1557.log");
   			File file2 = new File("CMServer.20170914_2028.log");
ArrayList<File> fils=new ArrayList();
fils.add(file);
fils.add(file2);
   			LogFileRouting routingtotables = new LogFileRouting();
   			//comment to prevent add the data from file all the time (temporery comment
   		//	routingtotables.SearchDefects(file2, searchStr,appRepository,defectRepository, logFileRepository,defectInstanceRepository, solutionRepository);
   		/*	for(int i=0;i<fils.size();i++) {
   	   			routingtotables.SearchDefects(fils.get(i), searchStr,appRepository,defectRepository, logFileRepository,defectInstanceRepository, solutionRepository);

   			}*/
   			System.out.println("Hello Sprint Boot");

       };
	 }
}

