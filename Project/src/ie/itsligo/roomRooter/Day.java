package ie.itsligo.roomRooter;

import java.util.Date;



public class Day {
	//private String date;
	public String Currentdate;
	private Date d = new Date();

	public Day() {
		//System.out.println(d.toString());
		String delims = "[ ]+";
		String[] tokens = d.toString().split(delims);
		Currentdate=tokens[0];
		
		switch(Currentdate){
		case "Mon":
			Currentdate="Monday";
			break;
		case "Tue":
			Currentdate="Tuesday";
			break;
		case "Wed":
			Currentdate="Wednesday";
			break;
		case "Thu":
			Currentdate="Thursday";
			break;
		case "Fri":
			Currentdate="Friday";
			break;
		case "Sat":
			Currentdate="Saturday";
			break;
		case "Sun":
			Currentdate="Sunday";
			break;
		default:
			Currentdate="Error";
			break;
			
		}
		
		
	}
	
	public String get(String data)
	{
		
		//date= "Tuesday";
		String delims = "[\n]+";
		String[] tokens = data.split(delims);
		
		String phrase2=tokens[0];
		String delims2 = "[ ]+";
		String[] date = phrase2.split(delims2);
		
		return(date[1]);	
	}

}
