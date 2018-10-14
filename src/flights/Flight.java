package flights;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flight")
public class Flight {
    private int id;

	private int Year;
	private int Month;
	private int Day;
	
	private int  Distance , FlightNum;
	private String DepTime,ArrTime, UniqueCarrier, TailNum;
	private int ActualElapsedTime,AirTime;
	private String Origin,Dest;
	
	
	public Flight() {}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	public int getYear() {
		return Year;
	}
	
	@XmlElement
	public void setYear(int year) {
		this.Year = year;
	}
	public int getMonth() {
		return Month;
	}
	
	@XmlElement
	public void setMonth(int month) {
		this.Month = month;
	}
	public int getDay() {
		return Day;
	}
	
	@XmlElement
	public void setDay(int day) {
		this.Day = day;
	}
	public String getDepTime() {
		return DepTime;
	}
	
	@XmlElement
	public void setDepTime(String depTime) {
		this.DepTime = depTime;
	}
	public String getArrTime() {
		return ArrTime;
	}
	
	@XmlElement
	public void setArrTime(String arrTime) {
		this.ArrTime = arrTime;
	}
	public int getDistance() {
		return Distance;
	}
	
	@XmlElement
	public void setDistance(int distance) {
		this.Distance = distance;
	}
	public String getUniqueCarrier() {
		return UniqueCarrier;
	}
	
	@XmlElement
	public void setUniqueCarrier(String uniqueCarrier) {
		this.UniqueCarrier = uniqueCarrier;
	}
	public int getFlightNum() {
		return FlightNum;
	}
	
	@XmlElement
	public void setFlightNum(int flightNum) {
		this.FlightNum = flightNum;
	}
	public String getTailNum() {
		return TailNum;
	}
	
	@XmlElement
	public void setTailNum(String tailNum) {
		this.TailNum = tailNum;
	}
	public int getActualElapsedTime() {
		return ActualElapsedTime;
	}
	
	@XmlElement
	public void setActualElapsedTime(int actualElapsedTime) {
		this.ActualElapsedTime = actualElapsedTime;
	}
	public int getAirTime() {
		return AirTime;
	}
	
	@XmlElement
	public void setAirTime(int airTime) {
		this.AirTime = airTime;
	}
	public String getOrigin() {
		return Origin;
	}
	
	@XmlElement
	public void setOrigin(String origin) {
		this.Origin = origin;
	}
	public String getDest() {
		return Dest;
	}
	
	
	@XmlElement
	public void setDest(String dest) {
		this.Dest = dest;
	}

	
	
	
	
}
