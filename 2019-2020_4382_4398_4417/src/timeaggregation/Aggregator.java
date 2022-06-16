package timeaggregation;

import java.util.ArrayList;

import datamodel.*;
import datamodel.IResult;
import datamodel.MeasurementRecord;

public class Aggregator implements IAggregator{

	private String whatToChoose;
	private String unitType;
	
	public Aggregator(String whatToChoose, String unitType) {
		this.whatToChoose = whatToChoose;
		this.unitType = unitType;
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction,
			String description) {
		
		int countKitchen =0;
		double sumKitchen = 0;
		double averageKitchen =0;
		
		int countLaundry =0;
		double sumLaundry = 0;
		double averageLaundry =0;
		
		int countAc =0;
		double sumAc = 0;
		double averageAc =0;
		
		if (whatToChoose.equals("kitchen")) {
			if(aggFunction.equals("sum")){
				for (int i=0; i < inputMeasurements.size() ; i++) {
					sumKitchen += inputMeasurements.get(i).getKitchen();
				}
				Result theResult1 = new Result(sumKitchen);
				return theResult1;
			}
			
			if (aggFunction.equals("avg")) {	
				for (int i=0; i < inputMeasurements.size() ; i++) {
					countKitchen ++;
				}
				if(sumKitchen != 0) {	
					averageKitchen = sumKitchen / countKitchen;
					Result theResult2 = new Result(averageKitchen);
					return theResult2;
				}else {
					averageKitchen = 0;
					Result theResult2 = new Result(averageKitchen);
					return theResult2;
				}
			}
		}else if (whatToChoose.equals("laundry")) {
			if(aggFunction.equals("sum")){
				for (int i=0; i < inputMeasurements.size() ; i++) {
					sumLaundry += inputMeasurements.get(i).getLaundry();
				}
				Result theResult1 = new Result(sumLaundry);
				return theResult1;
			}
			
			if (aggFunction.equals("avg")) {	
				for (int i=0; i < inputMeasurements.size() ; i++) {
					countLaundry ++;
				}
				if(sumLaundry != 0) {
					averageLaundry = sumLaundry / countLaundry;
					Result theResult2 = new Result(averageLaundry);
					return theResult2;
				}else {
					averageLaundry = 0;
					Result theResult2 = new Result(sumLaundry);
					return theResult2;
				}
			}
		}else if (whatToChoose.equals("ac")) {
			if(aggFunction.equals("sum")){
				for (int i=0; i < inputMeasurements.size() ; i++) {
					sumAc += inputMeasurements.get(i).getAc();
				}
				Result theResult1 = new Result(sumAc);
				return theResult1;
			}
			
			if (aggFunction.equals("avg")) {	
				for (int i=0; i < inputMeasurements.size() ; i++) {
					countAc ++;
				}
				if(sumAc != 0) {
					averageAc = sumAc / countAc;
					Result theResult2 = new Result(averageAc);
					return theResult2;
				}else {
					sumLaundry = 0;
					Result theResult2 = new Result(averageAc);
					return theResult2;
				}
			}
		}
		return null;
	}

	@Override
	public String getTimeUnitType() {
		return unitType;
	}

}

