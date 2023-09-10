package testpackage.Selenium11AMWEEKEND;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	
	String filepath = System.getProperty("user.dir")+"\\Input\\Output.txt";
	String filepath1 = System.getProperty("user.dir")+"\\Input\\Outputreadwrite.txt";
	
	String inputfilepath = System.getProperty("user.dir")+"\\Input\\TestData.txt";
	
	String texttoBePrint = "Sathish kumar from Besant technology";
	
	public void WriteFile() throws IOException
	{
		File F = new File(filepath);
		FileOutputStream FS = new FileOutputStream(F);
		FS.write(texttoBePrint.getBytes());
		FS.close();
		System.out.println("done");
	}
	
	public void WriteFilebyFileWriter() throws IOException
	{
		File F = new File(filepath);
		FileWriter FS = new FileWriter(F);
		FS.write(texttoBePrint);
		FS.close();
		System.out.println("done");
	}
	
	public void ReadAndWrite() throws IOException
	{
		File F = new File(filepath1);
		FileWriter FS = new FileWriter(F);
		File inputF = new File (inputfilepath);
		
		FileReader FR = new FileReader(inputF);
		
		BufferedReader BF = new BufferedReader(FR);
		String i = null;
		
		while((i= BF.readLine())!=null)
		{
		
			FS.write(i);
		}
	
		
		FS.close();
		System.out.println("done");
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWrite F = new FileWrite();
		F.WriteFile();
		F.WriteFilebyFileWriter();
		F.ReadAndWrite();
	}

}
