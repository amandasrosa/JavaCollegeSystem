package college.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date convertStringToDate(String dateString) throws ParseException {
		if (dateString == "") {
			return new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date date = sdf.parse(dateString);
		return date;
	}

	public static String convertDateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = sdf.format(date);
		return stringDate;
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	public static String padRight(int s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
}
