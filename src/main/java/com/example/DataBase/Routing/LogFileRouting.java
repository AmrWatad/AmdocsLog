package com.example.DataBase.Routing;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.Metadata;
import com.example.DataBase.DataBaseApplication;
import com.example.DataBase.Repository.AppRepository;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.Repository.DefectRepository;
import com.example.DataBase.Repository.LogFileRepository;
import com.example.DataBase.Repository.SolutionRepository;
import com.example.DataBase.domain.App;
import com.example.DataBase.domain.Defect;
import com.example.DataBase.domain.DefectInstance;
import com.example.DataBase.domain.LogFile;
import com.example.DataBase.domain.Solution;

import dropBox.DBClientService;

//@RestController
public class LogFileRouting {
	public DataBaseApplication db;

	public static final int typePosition = 5;
	public static final int SeverityPosition = 4;
	public static final int ErrorPosition = 3;
	
	
	public List<Defect> defList = new ArrayList<Defect>();
	public List<App> appList = new ArrayList<App>();
	public List<DefectInstance> defInsList = new ArrayList<DefectInstance>();
	public List<LogFile> logFList = new ArrayList<LogFile>();
	public List<Solution> solList = new ArrayList<Solution>();
	DBClientService dbClient=new DBClientService();
	

//	  @Autowired 
//      private AppRepository appRepository;
//
//	  @Autowired 
//      private DefectRepository defectRepository;
//	  
//	  @Autowired 
//      private LogFileRepository logFileRepository;
//	  
//	  @Autowired 
//      private DefectInstanceRepository defectInstanceRepository;

	 
//-----------------------------------------------------getters and setters----------------------------------------------------------------
	 

		
//----------------------------------------------------------controller methods-----------------------------------------------------------
	
	public void SearchDefects(Metadata metadata, String searchStr,AppRepository appRepo, DefectRepository defRepo, LogFileRepository logRepo, DefectInstanceRepository definsRepo, SolutionRepository solRepo) throws Exception 
	
	{
		
		 String my_link = null;
         URL my_url = null;
         URLConnection conn = null;
         BufferedReader reader = null;
         try {
         	String line="";
             my_link = dbClient.client.files().getTemporaryLink(metadata.getPathLower()).getLink();//.files().getTemporaryLink(metadata.getPathLower()).getLink();
             my_url = new URL (my_link);
             conn = my_url.openConnection();
             reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            /* while( (line = reader.readLine()) != null ) {
             	System.out.println("read!!    "+line);
             }*/
         } catch (DbxException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
		
		int Counter = 0;
		//Scanner scanFile = new Scanner(metadata);
		String line = reader.readLine().toString();
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
		
		LogFile templogfile = new LogFile(metadata.getName(),timeformat.format(Calendar.getInstance().getTime()),dateformat.format(Calendar.getInstance().getTime()));
		Solution tempsol = new Solution("Magic solution","turn of your device");
		
		
		while ((line = reader.readLine()) != null) {
			
			System.out.println("hoon routing   "+ line);
			Defect tempDefect = new Defect() ;
			App tempApp = new App() ;
			DefectInstance tempDefectInstance = new DefectInstance();
			//line = scanFile.nextLine().toString();
			String arr[] = line.split(" ");
			 
			if (arr.length > ErrorPosition && line.contains(searchStr)) {
				if (arr[ErrorPosition].startsWith("(") && arr[ErrorPosition].endsWith(")")) {
					Counter++;
					int pos = arr[ErrorPosition].indexOf("-");
					String ProgramName = arr[ErrorPosition].substring(1, pos - 1);
					String defCode = arr[ErrorPosition].substring(pos + 1, arr[ErrorPosition].length() - 1);
					
					tempDefect.setErrorCode(defCode);
					tempDefect.setSolution(tempsol);
					tempApp.setName(ProgramName);
					
					
					
					int redDig = Character.getNumericValue(tempDefect.getErrorCode().charAt(typePosition));
					// level of defect (1-3) critical, (4-6) error, more than 6 warning
					if (1 <= redDig && redDig <= 3) {
						tempDefect.setSeverity("Critical");
					
					}
					if (4 <= redDig && redDig <= 6) {
						tempDefect.setSeverity("Error");
					}
					if (redDig > 6) {
						tempDefect.setSeverity("Warning");
					}
					if (arr[ErrorPosition].charAt(4) == '1')
						tempApp.setType("Core");
					else
						tempApp.setType("Custom");
					
					solList = solRepo.checkSolexist(tempsol.getName(), tempsol.getDescription());
					if(solList.isEmpty()) {
						solRepo.save(tempsol);
						tempDefect.setSolution(tempsol);
					}
					else {
						tempDefect.setSolution(solList.get(0));
					}
					
					//check if app exist in database
					appList = appRepo.checkAppexist(tempApp.getName() ,tempApp.getType() );
					if(appList.isEmpty()) {
						appRepo.save(tempApp);
						tempDefectInstance.setApp(tempApp);
					}
					else {
						tempDefectInstance.setApp(appList.get(0));
					} 
					
					//check if defect exist in database
					defList = defRepo.checkDefectexist(tempDefect.getErrorCode());
					if(defList.isEmpty()) {
						defRepo.save(tempDefect);
						tempDefectInstance.setDefect(tempDefect);
					}
					else {
						tempDefectInstance.setDefect(defList.get(0));
					}
					
					//check if logfile exist in database
					logFList = logRepo.checkLogexist(templogfile.getName());
					if(logFList.isEmpty()) {
						logRepo.save(templogfile);
						tempDefectInstance.setLogfile(templogfile);
					}
					else {
						tempDefectInstance.setLogfile(logFList.get(0));
					}
					//tempDefectInstance.setApp(tempApp);
					//tempDefectInstance.setDefect(tempDefect);
					//tempDefectInstance.setLogfile(templogfile);
					
				
					defInsList.add(tempDefectInstance);
					
	
			}
		}


	}
		logFList.add(templogfile);
		System.out.println(Counter + " '" + searchStr + "' founded in log file " );
		//scanFile.close();
		
		
		//defRepo.deleteAll();
		//logRepo.deleteAll();
		//appRepo.deleteAll();
		//definsRepo.deleteAll();
			
		//defRepo.saveAll(defList);
		//logRepo.saveAll(logFList);
		//appRepo.saveAll(appList);
		definsRepo.saveAll(defInsList);
		//db.FILENAME.deleteFile(); // after finsh insert data from file delet the file
System.out.println("metadata.getPathLower()="+metadata.getPathLower());

		dbClient.client.files().delete(metadata.getPathLower());
		
}
	


}
