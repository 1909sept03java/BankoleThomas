package Question23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Dates {
	
	

	public static String formatDate(String dateInString) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            return formatter.format(date);
        }}
    
   

	   