/*package mainengine;

import java.util.ArrayList;

import dataload.Loader;
import datamodel.IResult;
import datamodel.MeasurementRecord;
import reporting.ResultReporter;
import timeaggregation.Aggregator;

public class TheMainEngine implements IMainEngine {

	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		Loader myLoader=new Loader();
		int rowsAdded =myLoader.load(fileName,delimeter,hasHeaderLine,numFields,objCollection);
		return rowsAdded;
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
		Aggregator myAggregator = new Aggregator("", description);
		IResult theResult = myAggregator.aggregateByTimeUnit(inputMeasurements, aggFunction, description);
		return theResult;
	}

	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		ResultReporter paok=new ResultReporter();
		paok.reportResultInFile(result, filename);
		return 0;
	}
}*/
package mainengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

import dataload.Loader;
import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.Result;
import reporting.ResultReporter;
import timeaggregation.Aggregator;

public class TheMainEngine implements IMainEngine {

	private ArrayList<MeasurementRecord> kainourgio = new ArrayList<MeasurementRecord>();
	 private HashMap<String, Double> check = new HashMap<String, Double>();
	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		Loader myLoader=new Loader();
		int rowsAdded =myLoader.load(fileName,delimeter,hasHeaderLine,numFields,objCollection);
		return rowsAdded;
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
		Result result = new Result(description, aggregatorType,aggFunction);
		for(int i=0; i<inputMeasurements.size(); i++){
			result.add(aggregatorType, inputMeasurements.get(i));
		}
		check = result.getAggregateMeterKitchen();
		System.out.println(check.get("01"));
		return result;
	}

	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		ResultReporter rep=new ResultReporter();
		rep.reportResultInFile(result, filename);
		return 0;
	}
}
