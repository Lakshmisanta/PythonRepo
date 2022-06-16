package utilities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.WebElement;

public class DateUtils {

	// Get The Current Day
	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Day Int: " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("TodayDay Str: " + todayStr + "\n");
		
		// Get Current Month as a number
				int CurrentMonthInt = calendar.get(Calendar.MONTH);
				System.out.println("CurrentMonthInt Day Int: " + CurrentMonthInt + "\n");
				
				// Integer to String Conversion
				String CurrentMonthStr = Integer.toString(CurrentMonthInt);
				System.out.println("CurrentMonthStr Str: " + CurrentMonthStr + "\n");

		return todayStr ;
	}
	
	
	// Get The Current Month
		public static String getCurrentMonth() {
			// Create a Calendar Object
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

			// Get Current Month as a number
					int CurrentMonthInt = calendar.get(Calendar.MONTH);
					System.out.println("CurrentMonthInt Day Int: " + CurrentMonthInt + "\n");
					
					// Integer to String Conversion
					String CurrentMonthStr = Integer.toString(CurrentMonthInt);
					System.out.println("CurrentMonthStr Str: " + CurrentMonthStr + "\n");

			return CurrentMonthStr ;
		}
	

	// Get The Current Day plus days. You can change this method based on your
	// needs.
	public static String getCurrentDayPlus(int days) {
		LocalDate currentDate = LocalDate.now();

		int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
		System.out.println("dayOfWeekPlus Str: " + dayOfWeekPlus + "\n");
		return Integer.toString(dayOfWeekPlus);
	}
	
	// Get The Current Day plus days. You can change this method based on your
		// needs.
		public static String getCurrentMonthPlus(int noOfMonth) {
			LocalDate currentDate = LocalDate.now();

			int MonthOfWeekPlus = currentDate.getMonthValue();
			int MonthPlus = MonthOfWeekPlus + noOfMonth;
			System.out.println("MonthOfWeekPlus int: " + MonthOfWeekPlus + "\n");
			System.out.println("MonthPlus int: " + MonthPlus + "\n");
			return Integer.toString(MonthPlus);
		}


	// Click to given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		/** Functional JAVA version of this method. */
		elementList.stream().filter(element -> element.getText().contains(day)).findFirst()
				.ifPresent(WebElement::click);

	}
}