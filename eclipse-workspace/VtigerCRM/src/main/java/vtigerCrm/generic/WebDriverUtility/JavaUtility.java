package vtigerCrm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random = new Random();
		int rannum = random.nextInt(5000);
		return rannum;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String startdate = sdf.format(date);
		return startdate;
	}

	public String getRequireDate(int days)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(date);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
				
	}
}


