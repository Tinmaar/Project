package ie.itsligo.roomRooter;
import java.util.Date;

public class Hour {
	public String hour;
	private Date d = new Date();
	private String CurrentHour;

	public Hour() {
		//System.out.println(d.toString());
		String delims = "[ ]+";
		String[] tokens = d.toString().split(delims);
		CurrentHour=tokens[3];
		String delims3 = "[:]+";
		String[] Hour = CurrentHour.split(delims3);
		hour=Hour[0];
		//System.out.println(hour);
		
	}
	
	public String get(String data)
	{
		//hour of the beggining of the lesson
		//hour= "9:00";
		String delims = "[\n]+";
		String[] tokens = data.split(delims);
		
		String phrase2=tokens[1];
		String delims2 = "[ ]+";
		String[] Fullhour = phrase2.split(delims2);
		
		String phrase3=Fullhour[1];
		String delims3 = "[:]+";
		String[] hour = phrase3.split(delims3);
	
		return(hour[0]);
	}
	public String get2(String data)
	{
		
		//hour of the end of the lesson
		String delims = "[\n]+";
		String[] tokens = data.split(delims);
		
		String phrase2=tokens[1];
		String delims2 = "[ ]+";
		String[] Fullhour = phrase2.split(delims2);
		
		String phrase3=Fullhour[3];
		String delims3 = "[:]+";
		String[] hour = phrase3.split(delims3);
		//System.out.println(hour[0]);
		return(hour[0]);
	}

}