package dataload;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import datamodel.MeasurementRecord;


public class Loader implements ILoader<MeasurementRecord>{
	//private MeasurementRecord miron; 
	ArrayList<MeasurementRecord> objCollection = new ArrayList<MeasurementRecord>();
	
	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		// TODO Auto-generated method stub
		int count = 0;
		if(numFields < 1) {
			System.out.println("Wrong number of fields, less than 1!");
			System.exit(0);
		}
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + fileName);
			System.exit(0);
		}
		int counter=0;
		if(hasHeaderLine){
			String titleLine = inputStream.nextLine();
			System.out.println(titleLine);
			counter=1;
			System.out.println(counter);
		}
		while (inputStream.hasNextLine()) {
			String line;
			if(counter==0){
				line = inputStream.nextLine();
				String[] all = line.split(delimeter);
				if(all.length == 9) {//elegxos an exw kapoio keno
					MeasurementRecord myRecord= new MeasurementRecord(all);
					objCollection.add(myRecord);
					count++;
				}
			}
			counter =0;
		}
		numFields = objCollection.size();	
		inputStream.close();
		System.out.println("Processed " + count + " rows and loaded " + objCollection.size() + " objects.");
		this.objCollection = objCollection;
		return count;
	}
	public ArrayList<MeasurementRecord> epistrofi()
	{
		return objCollection;
	}
}

