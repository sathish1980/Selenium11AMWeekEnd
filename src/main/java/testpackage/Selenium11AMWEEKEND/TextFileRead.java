package testpackage.Selenium11AMWEEKEND;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class TextFileRead {
	
	String filepath = System.getProperty("user.dir")+"\\Input\\TestData.txt";
	
	public void ReadData() throws IOException
	{
		File F = new File (filepath);
		
		FileInputStream FI = new FileInputStream(F);
		
		int i = 0;
		
		while((i= FI.read())!=-1)
		{
		
		System.out.print((char)i);
		}
	
		
	}
	
	public void ReadDatawithFileReader() throws IOException, InterruptedException
	{
		File F = new File (filepath);
		
		FileReader FI = new FileReader(F);
		
		int i = 0;
		
		while((i= FI.read())!=-1)
		{
		
			System.out.print((char)i);
			Thread.sleep(500);
		}
	
		
	}

	public void ReadDataLineByLine() throws IOException, InterruptedException
	{
		File F = new File (filepath);
		
		FileReader FR = new FileReader(F);
		
		BufferedReader BF = new BufferedReader(FR);
		String i = null;
		
		while((i= BF.readLine())!=null)
		{
		
			System.out.println(i);
			Thread.sleep(500);
		}
	
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		TextFileRead T = new TextFileRead();
		T.ReadDataLineByLine();
	}

}
