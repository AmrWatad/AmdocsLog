package com.example.DataBase;

//import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class FilesName {
	DataBaseApplication db;
	//("C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles"
	 final File folder = new File("AmdocsLog\\logFiles");
	

	public FilesName() {
		super();
		// TODO Auto-generated constructor stub
		listFilesForFolder(folder);
		//listFilesForFolder(folder);

	}

		
	 public  void listFilesForFolder(final File folder) {
		 
		 //while(true) {
				
	   		 for (final File fileEntry : folder.listFiles()) {
			        if (fileEntry.isDirectory()) {
			            listFilesForFolder(fileEntry);
			        } else {
			            System.out.println(fileEntry.getName());
			            //"C:\\Users\\Amr\\git\\AmdocsLog1\\logFiles\\"+fileEntry.getName()
			            db.FILENAME.setFileName("AmdocsLog\\logFiles\\"+fileEntry.getName());
			        }
			    }
	   		
	   		
	   		//}
		   
		}
}
