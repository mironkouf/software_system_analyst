//package Client;

import java.util.ArrayList;
import java.util.Scanner;

import dataload.*;
import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.Result;
import mainengine.TheMainEngine;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		boolean headerBool;
		ArrayList<MeasurementRecord> ok = new ArrayList<MeasurementRecord>();
		TheMainEngine antikeimeno=new TheMainEngine();
		System.out.println("Give me the name of file:");
		String FileName=input.nextLine();
		System.out.println("Have the file header?");
		String header=input.nextLine();
		if(header.equals("yes"))
		{
			headerBool=true;
		}
		
		else
		{
			headerBool=false;
		}
		antikeimeno.loadData(FileName, "\t", true, 9,ok);
		System.out.println("Give me timeUnit:");
		String timeUnit=input.nextLine();
		System.out.println("Give me function:");
		String function=input.nextLine();
		IResult finali=antikeimeno.aggregateByTimeUnit(ok, timeUnit, function, "consumption over Kitchen Laundry A/C");
		antikeimeno.reportResultInFile(finali, "txt", "C:\\Users\\Hp\\Documents\\github-ergasies\\3o\\2019-2020_4382_4398_4417\\src\\Client");
	}
}