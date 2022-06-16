 package reporting;

import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


import datamodel.IResult;
import datamodel.Result;

public class ResultReporter implements IResultReporter{
	Result myResult = new Result();
	
	@Override
	public int reportResultInFile(IResult result, String filename) {

				FileOutputStream outputStream = null;
				try
				{
					outputStream=new FileOutputStream(filename);
				}
				catch(FileNotFoundException e)
				{
					System.exit(5);
				}
				
				PrintWriter arxeio=new PrintWriter(outputStream);
				arxeio.println(result.getDescription());
				arxeio.println("KITCHEN");
				for(String key: result.getAggregateMeterKitchen().keySet())
				{
					arxeio.println(key +"  "+result.getAggregateMeterKitchen().get(key));
				}
				arxeio.println("LAUNDRY");
				for(String key: result.getAggregateMeterLaundry().keySet())
				{
					arxeio.println(key +"  "+result.getAggregateMeterLaundry().get(key));
				}
				arxeio.println("A/C");
				for(String key: result.getAggregateMeterAC().keySet())
				{
					arxeio.println(key +"  "+result.getAggregateMeterAC().get(key));
				}
				arxeio.close();
			
			return 0;
	}

}
