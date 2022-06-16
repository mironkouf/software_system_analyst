package datamodel;

//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

public class MeasurementRecord {
	private int[] day;
	private int[] hour;
	private double globalActivePower;
	private double globalReactivePower;
	private double voltage;
	private double globalIntensity;
	private double kitchen;
	private double laundry;
	private double ac;
	
	public MeasurementRecord(double kitchen, double laundry, double ac) {
		this.kitchen = kitchen;
		this.laundry = laundry;
		this.ac = ac;
	}

	
	public MeasurementRecord(String[] allRecords) {
		
		
		String[] dateBeforeSplit = allRecords[0].split("/");
		day = new int[3];
		day[0] = Integer.parseInt(dateBeforeSplit[0]);
		day[1] = Integer.parseInt(dateBeforeSplit[1]);
		day[2] = Integer.parseInt(dateBeforeSplit[2]);
		
		String[] hourBeforeSplit = allRecords[1].split(":");
		hour = new int[3];
		hour[0] = Integer.parseInt(hourBeforeSplit[0]);
		hour[1] = Integer.parseInt(hourBeforeSplit[1]);
		hour[2] = Integer.parseInt(hourBeforeSplit[2]);
		
		this.globalActivePower = Double.parseDouble(allRecords[2]);
		this.globalReactivePower = Double.parseDouble(allRecords[3]);
		this.voltage = Double.parseDouble(allRecords[4]);
		this.globalIntensity = Double.parseDouble(allRecords[5]);
		this.kitchen = Double.parseDouble(allRecords[6]);
		this.laundry = Double.parseDouble(allRecords[7]);
		this.ac = Double.parseDouble(allRecords[8]);
	}


	public double getGlobalActivePower() {
		return globalActivePower;
	}


	public void setGlobalActivePower(double globalActivePower) {
		this.globalActivePower = globalActivePower;
	}


	public double getGlobalReactivePower() {
		return globalReactivePower;
	}


	public void setGlobalReactivePower(double globalReactivePower) {
		this.globalReactivePower = globalReactivePower;
	}


	public double getVoltage() {
		return voltage;
	}


	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}


	public double getGlobalIntensity() {
		return globalIntensity;
	}


	public void setGlobalIntensity(double globalIntensity) {
		this.globalIntensity = globalIntensity;
	}


	public int[] getDay() {
		return day;
	}


	public void setDay(int[] day) {
		this.day = day;
	}


	public int[] getHour() {
		return hour;
	}


	public void setHour(int[] hour) {
		this.hour = hour;
	}


	public double getKitchen() {
		return kitchen;
	}


	public void setKitchen(double kitchen) {
		this.kitchen = kitchen;
	}


	public double getLaundry() {
		return laundry;
	}


	public void setLaundry(double laundry) {
		this.laundry = laundry;
	}


	public double getAc() {
		return ac;
	}


	public void setAc(double ac) {
		this.ac = ac;
	}

}