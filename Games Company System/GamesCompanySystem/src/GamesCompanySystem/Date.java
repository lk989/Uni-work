package GamesCompanySystem;

import java.util.Calendar;

public class Date {
	//class fields
    public static Calendar cal = Calendar.getInstance(); 
	public static final int CURRENT_MONTH = cal.get(Calendar.MONTH) + 1;
	
	//attributes
    private int day, month, year;
    
    //constructors
    public Date() { day = 0; month = 0; year = 0; }
    public Date(int day, int month, int year) { this.day = day; this.month = month; this.year = year; }
    
    //setters and getters
    public void setDay(int d) { day = d; }
    public void setMonth(int m) { month = m; }
    public void setYear(int y) { year = y; }
    
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    
    @Override //toString
    public String toString() { return (String.format("%02d-%02d-%-4d", day, month, year)); } 
    
    @Override //equals
    public boolean equals(Object obj) {
    	if (((Date) obj).getDay() == day && ((Date) obj).getMonth() == month && ((Date) obj).getYear() == year)
    		return true;
    	return false;
    }
}