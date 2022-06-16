package datamodel;

import timeaggregation.*;
//import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Result implements IResult{

	
	/*private int chooseWhatToTake; // dialegw poia average kai poia sum thelw apo to aggregagor
	
	public int ChooseWhatToTake() {
		return chooseWhatToTake;
	}
	public Result(int chooseWhatToTake) {
		this.chooseWhatToTake = chooseWhatToTake;
	}*/
	
	
	private double averageSum;
	
	public double getAverageSum() {
		return averageSum;
	}
	public Result()
	{
		
	}

	public Result(double averageSum) {
		this.averageSum = averageSum;
	}//auto to xreiazomai gia mesa sthn aggregator na ftiaxnw ena neo Result

	private String aggFunction;
	private String description;
	private String timeUnit;
	
	public String getTimeUnit() { //ulopoihte mesa sthn iaggregator oxi akoma omws 
		return timeUnit;
	}

	HashMap<String,ArrayList<MeasurementRecord>> detailedResults = new HashMap<String,ArrayList<MeasurementRecord>>();
	HashMap<String, Double> aggregateMeterKitchen = new HashMap<String, Double>();
	HashMap<String, Double> aggregateMeterLaundry = new HashMap<String, Double>();
	HashMap<String, Double> aggregateMeterAC = new HashMap<String, Double>();
	//HashMap<String, Double> aggregateMeterKitchen = new HashMap<String, Double>();
	
	
	/**
	 *  ArrayList<MeasurementRecord> Nseason = new ArrayList<MeasurementRecord>();
	 * 	ArrayList<MeasurementRecord> Nmonth = new ArrayList<MeasurementRecord>();
	 	ArrayList<MeasurementRecord> Nweek = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> NduringTheDay = new ArrayList<MeasurementRecord>();
	 */	
	
	private ArrayList<ArrayList<MeasurementRecord>> season = new ArrayList<ArrayList<MeasurementRecord>>(4);
	private ArrayList<ArrayList<MeasurementRecord>> month = new ArrayList<ArrayList<MeasurementRecord>>(12);
	private ArrayList<ArrayList<MeasurementRecord>> week = new ArrayList<ArrayList<MeasurementRecord>>(7);
	private ArrayList<ArrayList<MeasurementRecord>> duringTheDay = new ArrayList<ArrayList<MeasurementRecord>>(5);
	
	ArrayList<MeasurementRecord> winter = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> spring = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> summer = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> autumn = new ArrayList<MeasurementRecord>();
	
	ArrayList<MeasurementRecord> jan = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> feb = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> march = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> apr = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> mai = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> jun = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> jul = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> aug = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> sept = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> oct = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> nov = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> dec = new ArrayList<MeasurementRecord>();
	
	ArrayList<MeasurementRecord> monday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> tuesday= new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> wednasday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> thursay = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> friday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> saturday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> sunday = new ArrayList<MeasurementRecord>();
	
	ArrayList<MeasurementRecord> night = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> early_morning = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> morning = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> afternoon = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> evening = new ArrayList<MeasurementRecord>();

	
	String[] theSeason = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
	String[] theMonth = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	String[] theWeek = {"1", "2", "3", "4", "5", "6", "7"};
	String[] periodOfTheDay= {"NIGHT", "EARLY_MORNING", "MORNING", "AFTERNOON", "EVENING"};
	
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		// TODO Auto-generated method stub
		if(timeUnit.equals("season")) {
			if(record.getDay()[1] == 12 || record.getDay()[1] == 1 || record.getDay()[1] == 2 ) {
				season.get(0).add(record);
				return season.size();
			}else if(record.getDay()[1] == 3 || record.getDay()[1] == 4 || record.getDay()[1] == 5 ) {
				season.get(1).add(record);
				return season.size();
			}else if(record.getDay()[1] == 6 || record.getDay()[1] == 7 || record.getDay()[1] == 8 ) {
				season.get(2).add(record);
				return season.size();
			}else if(record.getDay()[1] == 9 || record.getDay()[1] == 10 || record.getDay()[1] == 11 ) {
				season.get(3).add(record);
				return season.size();
			}
		}
		else if(timeUnit.equals("month")){
			if(record.getDay()[1] == 1) {
				month.get(0).add(record);
				return month.size();
			}else if(record.getDay()[1] == 2) {
				month.get(1).add(record);
				return month.size();
			}else if(record.getDay()[1] == 3) {
				month.get(2).add(record);
				return month.size();
			}else if(record.getDay()[1] == 4) {
				month.get(3).add(record);
				return month.size();
			}else if(record.getDay()[1] == 5) {
				month.get(4).add(record);
				return month.size();
			}else if(record.getDay()[1] == 6) {
				month.get(5).add(record);
				return month.size();
			}else if(record.getDay()[1] == 7) {
				month.get(6).add(record);
				return month.size();
			}else if(record.getDay()[1] == 8) {
				month.get(7).add(record);
				return month.size();
			}else if(record.getDay()[1] == 9) {
				month.get(8).add(record);
				return month.size();
			}else if(record.getDay()[1] == 10) {
				month.get(9).add(record);
				return month.size();
			}else if(record.getDay()[1] == 11) {
				month.get(10).add(record);
				return month.size();
			}else if(record.getDay()[1] == 12) {
				month.get(11).add(record);
				return month.size();
			}
		}
		else if(timeUnit.equals("week")) {// na dw to LocalDate
			int theRealDate = LocalDate.parse(record.getDay()[2] + "-" + record.getDay()[1] + "-" + record.getDay()[0]).getDayOfWeek().getValue()-1;
			week.get(theRealDate).add(record);	
			return week.size();
		}
		else if(timeUnit.equals("periodofday")) {
			if(record.getHour()[0] >= 21 && record.getHour()[0] < 5 ) {
				duringTheDay.get(0).add(record);
				return duringTheDay.size();
			}else if(record.getHour()[0] >= 5 && record.getHour()[0] < 9 ) {
				duringTheDay.get(1).add(record);
				return duringTheDay.size();
			}else if(record.getHour()[0] >= 9 && record.getHour()[0] < 13 ) {
				duringTheDay.get(2).add(record);
				return duringTheDay.size();
			}else if(record.getHour()[0] >= 13 && record.getHour()[0] < 17 ) {
				duringTheDay.get(3).add(record);
				return duringTheDay.size();
			}else if(record.getHour()[0] >= 17 && record.getHour()[0] < 21 ) {
				duringTheDay.get(4).add(record);
				return duringTheDay.size();
			}
		
		}
		return 0;
	}

	public Result(String description, String timeUnit, String aggFunction) {
		this.aggFunction= aggFunction;
		this.description = description;
		this.timeUnit = timeUnit;
		for(int i=0;i<12;i++)
		{
			month.add(new ArrayList<MeasurementRecord>());
		}for(int i=0;i<4;i++)
		{
			season.add(new ArrayList<MeasurementRecord>());
		}for(int i=0;i<7;i++)
		{
			week.add(new ArrayList<MeasurementRecord>());
		}for(int i=0;i<5;i++)
		{
			duringTheDay.add(new ArrayList<MeasurementRecord>());
		}
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		if (timeUnit.equals("season")) {
			for(int i =0; i < season.size(); i++) {
				detailedResults.put(theSeason[i], season.get(i));
			}
		}else if (timeUnit.equals("month")) {
			for(int i =0; i < month.size(); i++) {
				detailedResults.put(theMonth[i], month.get(i));
			}
		}else if (timeUnit.equals("week")) {
			for(int i =0; i < week.size(); i++) {
				detailedResults.put(theWeek[i], week.get(i));
			}
		}else if (timeUnit.equals("periodofday")) {
			for(int i =0; i < duringTheDay.size(); i++) {
				detailedResults.put(periodOfTheDay[i], duringTheDay.get(i));
			}
		}
		return detailedResults;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
			double sum=0;
			int count=0;
			HashMap<String, ArrayList<MeasurementRecord>> res=getDetailedResults();
			for (Entry<String, ArrayList<MeasurementRecord>> entry : res.entrySet())
			{
				ArrayList<MeasurementRecord> mon=entry.getValue();
				for(int i=0;i<mon.size();i++)
				{
					sum+=mon.get(i).getKitchen();
					count++;
				}
				if(aggFunction.equals("avg"))
				{
					sum=sum/count;
				}
				aggregateMeterKitchen.put(entry.getKey(),sum);
			}
			return aggregateMeterKitchen;

	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		double sum=0;
		int count=0;
		HashMap<String, ArrayList<MeasurementRecord>> res=getDetailedResults();
		for (Entry<String, ArrayList<MeasurementRecord>> entry : res.entrySet())
		{
			ArrayList<MeasurementRecord> mon=entry.getValue();
			for(int i=0;i<mon.size();i++)
			{
				sum+=mon.get(i).getKitchen();
				count++;
			}
			if(aggFunction.equals("avg"))
			{
				sum=sum/count;
			}
			aggregateMeterLaundry.put(entry.getKey(),sum);
		}
		return aggregateMeterLaundry;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC(){
		double sum=0;
		int count=0;
		HashMap<String, ArrayList<MeasurementRecord>> res=getDetailedResults();
		for (Entry<String, ArrayList<MeasurementRecord>> entry : res.entrySet())
		{
			ArrayList<MeasurementRecord> mon=entry.getValue();
			for(int i=0;i<mon.size();i++)
			{
				sum+=mon.get(i).getKitchen();
				count++;
			}
			if(aggFunction.equals("avg"))
			{
				sum=sum/count;
			}
			aggregateMeterAC.put(entry.getKey(),sum);
		}
		return aggregateMeterAC;	
		}

	@Override
	public String getAggregateFunction() { 
		return aggFunction;
	}

}
