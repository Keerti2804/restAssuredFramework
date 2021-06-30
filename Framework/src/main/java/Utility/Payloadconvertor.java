package Utility;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

public class Payloadconvertor {
	//Basically to convert the body in to string 
	public static String generatepayloadString(String filename) throws IOException
	{
		
		//i want is the file name
		String filepath = "C:\\Users\\KeertiSarode\\eclipse-workspace\\Framework\\resource\\" + filename;
		//String filepath =System.getProperty("uder.dir") + \\resource\\" + filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
		
	}

}
