package id.go.hackerrank;

public class DayOfProgrammerLeapYear {
	
	/**
	 * created by rudi purnomo
	 * date june,3 2020
	 */
	
	public DayOfProgrammerLeapYear() {
		super();
	}
	
	public String getDayProggrammer(int year) {
		
		int sevenMonth = 215;
        int feb;

        if(year < 1918) feb = year%4==0 ? 29 : 28; //julian 
        else if(year > 1918) feb = (year%400==0) || (year%4==0 && year%100!=0) ? 29 : 28; //gregorian 
        else feb = 15; //dread
        
        int day = 256 - (sevenMonth + feb);
        return day+".09."+year;
	}

}
