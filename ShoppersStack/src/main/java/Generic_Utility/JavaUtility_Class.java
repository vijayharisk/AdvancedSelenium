package Generic_Utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility_Class {

	public int getRandomNo() {
		Random random = new Random();
		int random_no = random.nextInt(1000);
		return random_no;

	}

	public String getSystemDate() {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	public String getDateAndTime() {
		
		Date date = new Date();
		String timeAndDate = date.toString().replace(" ","_").replace(":","_");
		return timeAndDate;
		
		
		
	}
	

	
	
}
