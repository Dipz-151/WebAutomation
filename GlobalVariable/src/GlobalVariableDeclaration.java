import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalVariableDeclaration {

	public static void main(String[] args) throws IOException 
	{
		Properties prp = new Properties(); //Use the Properties class of java to get the info for the properties file
		
		FileInputStream fis = new FileInputStream("D:\\Java Workspace\\Code\\GlobalVariable\\src\\data.properties"); //Use the FileInputStream class from java to read the file
		prp.load(fis);
		System.out.println(prp.getProperty("browser"));
		System.out.println(prp.getProperty("URL"));
		prp.setProperty("browser", "firefox");
		System.out.println(prp.getProperty("browser"));
		
		//Makes changes to the properties file using the FileOutputStream class
		FileOutputStream fos = new FileOutputStream("D:\\Java Workspace\\Code\\GlobalVariable\\src\\data.properties");
		prp.store(fos, null);
		
	}

}
