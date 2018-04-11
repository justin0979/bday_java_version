// DayOWeek class is responsible for calculating the day of the week for any 3 integer inputs.
// Algorithm is taken from "https://en.wikipedia.org/wiki/Zeller's_congruence".
// To keep the same variable names as the above algorithm, the mm, dd, yyyy are all substituted 
// with the variable names used from the website. Comments are provided to describe where mm, dd, 
// and yyyy are used.

//package src;

public class DayOfWeek {

	private static int h; // Day of the week index (0=Sat, 1 = Sun,...,6=Fri).
	private static int q; // Day of the month.
	private static int m; // Month.
	private static int k; // The year of the century (year mod 100).
	private static int j; // Zero-based century (floor(year/100)).
	private static int year;

	// "For an ISO week date Day-of-Week d (1 = Monday to 7 = Sunday) use, d = ((h + 5) % 7) + 1" (wikipedia.org)
	// and apply:  dayOWeek[d], which equals the currrently used dayOWeek[h].
	private static String[] dayOfWeek = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

	// *******************       Constructor(String month, String day, String year) {}     *************************

	public DayOfWeek(String month, String day, String year) {
		m = Integer.parseInt(month);
		q = Integer.parseInt(day);
		k = Integer.parseInt(year) % 100;
		j = Integer.parseInt(year) / 100;
		h = 0;
		this.year = Integer.parseInt(year);
	}

	// *******************       Get Methods     *************************

	public int getMonth() {	return m; }

	public int getDay() { return q;	}

	public int getYear() { return year; }

	public int getH() { return h; }

	// *******************       Calculate() {}     *************************

	// Purpose: apply inputs into Zeller's formula to obtain the index for dayOWeek array.

	public void Calculate() {

		if( m < 3 ) {
			m += 12; // Ensures accurate month and year, since Zeller's numbers months 3=Mar,...,14=Feb.
				 // 01(Jan) + 12 = 13(Jan), 02(Feb) + 12 = 14(Feb).
			year -= 1; // Since 13(Jan), 14(Feb) are next year, 01(Jan), 02(Feb), refers to previous calendar year.
				   // "For 1 January 2000, the date would be treated as the 13th month of 1999..." (wikipedia.org).

			k = year % 100; // Update k after adjustment.
			j = year / 100; // Update j after adjustment.
		}

		h = ((q + (((m + 1) * 13) / 5) + k + (k/4) + (j/4)) + (5*j)) % 7; // Zeller's Algorithm from above website.
	}

	// *******************       output() {}     *************************

	// Purpose: Output day of week.

	public static void output() {
		m -= 12;
		year += 1;

		// if/else checks for non-leap years of year mod 100 (i.e., 1900, 1800, etc.) to not be accepted.
		// Used during testing.
		if( year % 100 == 0 && year % 400 != 0 && (m == 2 && q == 29) ) {
			System.out.println("February " + q + ", " + year + ", did not exist because " + year + " was not a leap year.");
		} else {
			System.out.println("You were born on a " + dayOfWeek[h]);
		}
	}
}
