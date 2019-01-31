package Singlton;

import java.io.File;

public class objectsHolder {
    private static objectsHolder instance;

    private String FileName;

    private File file2;
    public File getFile() {
		return file2;
	}

	public objectsHolder() {}

    public synchronized static objectsHolder getInstance() {
        if (instance == null) {
            instance = new objectsHolder();
        }
        return instance;
    }


    public String getFileName(){
    	file2=new File(FileName);
        return this.FileName;
    }
  public void deleteFile() {
	  file2.delete();
  }
    public void setFileName(String fileName){
 	   System.out.println("setFileName  55555555555555555555");

        this.FileName=fileName;
    }
}
