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
	 //final File folder = new File("C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles");
	 final File folder = new File("CMServer.20170914_2028.log");

	public static void main(String[] args) {
		
		SpringApplication.run(DataBaseApplication.class, args);

	   		
	}
	 @Bean
     CommandLineRunner runner(){
       return args -> {
    	   //listFilesForFolder(folder);
    	   doWork();
  				
       };
	 }
/* public  void listFilesForFolder(final File folder) {
		 

		Calendar cal = null;
		while(true) {

		  cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	   
	   		 for (final File fileEntry : folder.listFiles()) { //loop on all files

	      	
			          //  System.out.println(fileEntry.getName());
			     	  FILENAME=new objectsHolder();
			     	  //"C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles\\"+fileEntry.getName()
			            FILENAME.setFileName("logFiles\\"+fileEntry.getName());
			            doWork();
			         
			    }  
	   		 // if finish files in directory take break for 10 minuts
			System.out.println("MINUTE "+ cal.get(Calendar.MINUTE)    + "     Hour" +cal.get(Calendar.HOUR));
	   		try {
				TimeUnit.MINUTES.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
		}
	   		
	   		
	   		//}
		   
		}
*/	private void doWork() {
		// TODO Auto-generated method stub
	
   
   
   try {
   
   String searchStr = "Caused by";
		
		LogFileRouting routingtotables = new LogFileRouting();

	//	if(FILENAME.getFileName()!=null)
		routingtotables.SearchDefects(folder, searchStr,appRepository,defectRepository, logFileRepository,defectInstanceRepository, solutionRepository);
		
		System.out.println("Hello Sprint Boot");
   }
		catch(Exception e) {
			System.out.println("Error!!!");
		}
			}
	
	 
	
}

