package college.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Util {
   
    static Date convertStringToDate(String dateString) throws ParseException {
        if (dateString == "") {
            return new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	sdf.setLenient(false);
    	Date date = sdf.parse(dateString);
        return date;
    }
    
    static String convertDateToString(Date date) {
    	if (date == null) {
            return "";
        }
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String stringDate = sdf.format(date);
    	return stringDate;
    }
}
