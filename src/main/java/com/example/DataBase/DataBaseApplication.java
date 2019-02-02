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

import Singlton.objectsHolder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
	 public static objectsHolder FILENAME;
	 //"C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles"
	 final File folder = new File("AmdocsLog1\\logFiles");

	public static void main(String[] args) {
		
		SpringApplication.run(DataBaseApplication.class, args);

	   		
	}
	 @Bean
     CommandLineRunner runner(){
       return args -> {
    	   listFilesForFolder(folder);
    	   
  				
       };
	 }
 public  void listFilesForFolder(final File folder) {
		 

		Calendar cal = null;
		while(true) {

		  cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	   
	   		 for (final File fileEntry : folder.listFiles()) { //loop on all files

	      	 
			            System.out.println(fileEntry.getName());
			     	  FILENAME=new objectsHolder();
			     	  //"C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles\\"+fileEntry.getName()
			            FILENAME.setFileName("logFiles\\"+fileEntry.getName());
			            doWork();
			            try {
					   		TimeUnit.SECONDS.sleep(10);

				      	} catch (InterruptedException e) {
				    		// TODO Auto-generated catch block
				    			System.out.println("Erroe    MINUTE "+ cal.get(Calendar.MINUTE)    + "     Hour" +cal.get(Calendar.HOUR));

				    		e.printStackTrace();
				    	}
			    }
	   		 // if finish files in directory take break for 10 minuts
			System.out.println("MINUTE "+ cal.get(Calendar.MINUTE)    + "     Hour" +cal.get(Calendar.HOUR));
	   		try {
				TimeUnit.HOURS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
		}
	   		
	   		
	   		//}
		   
		}
	private void doWork() {
		// TODO Auto-generated method stub
	
   
   
   try {
   
   String searchStr = "Caused by";
		
		LogFileRouting routingtotables = new LogFileRouting();

		if(FILENAME.getFileName()!=null)
		routingtotables.SearchDefects(FILENAME.getFile(), searchStr,appRepository,defectRepository, logFileRepository,defectInstanceRepository, solutionRepository);
		
		System.out.println("Hello Sprint Boot");
   }
		catch(Exception e) {
			System.out.println("Error!!!");
		}
			}
	
	 
	
}

