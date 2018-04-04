// User class that gets user input, ensures input is valid.  Other classes are able
// to access the stored user input in form of month (mm), day (dd) and year (yyyy).

import java.util.Scanner;
import java.lang.*;

public class MyUser {

	Scanner userInput = null;

	private static int incorrectCounter;
	final private static int numAttemptsAllowed = 3;
	private static String dob; // Date of birth.
	private static String mm; // Month.
	private static String dd; // Day.
	private static String yyyy; // Year.

	public MyUser() {
		incorrectCounter = 0;
		dob = null;
		mm = null;
		dd = null;
		yyyy = null;
	}

	// method does all of the checks to ensure valid user input.
	public void Prompt() {
		while( incorrectCounter++ < numAttemptsAllowed ) {

			System.out.print("Enter your date of birth in format MM/DD/YYYY:  ");
			userInput = new Scanner(System.in);
			dob = userInput.nextLine();

			if_only_enter_key_hit();

			dob = dob.replaceAll("\\s","");
			
			try {
				validateDates();
			} catch ( Exception e ) {
				System.out.println("Check input and be sure to use \"/\" symbol for separation." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
				continue;
			}	
			check_single_digit_mm_dd();
			
			if( Check_dob_Length() ) { }
			else if( check_slashes_positions() ) { }
			else if( check_format() ) { }			
			else if( validate_leap_year() ) { }
			else if( check_number_of_months() ) { }
			else if( check_negative_values() ) { }
			else if( check_days_in_Feb() ) { }
			else if( check_29Feb_leapyear() ) { }
			else if( check_30_day_month()) { }
			else if( check_31_day_month() ) { } 
			else {
				break;
			} // if/else
		} // while
		close_program();	// conducts a check if numAttemptsAllowed is met.
		userInput.close();	
	}

	public void if_only_enter_key_hit() {
		while( dob.equals("") ) {
			System.out.println("That's not a try!");
			System.out.print("You only hit \"Enter\" key.\n\nEnter your date of birth in format MM/DD/YYYY:  ");
			userInput = new Scanner(System.in);
			dob = userInput.nextLine();
		}
	}

	public void validateDates() {
				String[] date = dob.split("/|-");
				mm = date[0];
				dd = date[1];
				yyyy=date[2];
	}
	
	public void check_single_digit_mm_dd() {
		if( mm.length() == 1 ) {
			mm = "0" + mm;
			dob = "0" + dob;
		}
		if( dd.length() == 1 ) {
			dd = "0" + dd;
			dob = dob.substring(0,3) + "0" + dob.substring(3, dob.length());
		}
	}
	
	// Checks that user input is no more or less than 10 characters. If 8 or 9 characters are entered, for days and moths
	// that is handled in check_single_digit_mm_dd() method. 
	public boolean Check_dob_Length() {
		if( dob.length() != 10 ) {
			System.out.println("Error in length of your input." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}
	
	public boolean check_slashes_positions() {
		if( dob.substring(2,3).equals("/") && dob.substring(5,6).equals("/") ||
			dob.substring(2,3).equals("-") && dob.substring(5,6).equals("-") ) {
			return false;
		}
		System.out.println("Slashes in wrong place. " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
		return true;
	}

	// Checks to make sure only integer values are entered in for month, day and year.
	public boolean check_format() {
		try {
			int m = Integer.parseInt(mm);
			int d = Integer.parseInt(dd);
			int y = Integer.parseInt(yyyy);
		} catch ( NumberFormatException e ) {
			System.out.println("Please follow the format of MM/DD/YYYY." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean validate_leap_year() {
		if( Integer.parseInt(yyyy) % 100 == 0 && Integer.parseInt(yyyy) % 400 != 0 && (mm.equals("02") && dd.equals("29"))) {
			System.out.println("This is not a leap year (i.e. no February 29 in year " + yyyy + ")." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean check_number_of_months() {
		if( Integer.parseInt(mm) > 12 ) {
			System.out.println("There are only 12 months in a year.  First two digits are months (MM)." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean check_negative_values() {
		if( Integer.parseInt(dd) < 1 || Integer.parseInt(mm) < 1 || Integer.parseInt(yyyy) < 0 ) {
			System.out.println("You entered a negative value or 0 days or 0 months." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean check_days_in_Feb() {
		if( mm.equals("02") && Integer.parseInt(dd) > 29 ) {
			System.out.println("February has at most 29 days." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean check_29Feb_leapyear() {
		if( mm.equals("02") && dd.equals("29") && (Integer.parseInt(yyyy) % 4 != 0) ) {
			System.out.println("February does not have 29 days in this year." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		} 
		return false;		
	}

	public boolean check_30_day_month() {
		if( Integer.parseInt(dd) > 30 && (mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) ) {
			System.out.println("There are only 30 days in this month." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	public boolean check_31_day_month() {
		if( Integer.parseInt(dd) > 31 ) {
			System.out.println("There are only 31 days in this month." + " " + (numAttemptsAllowed - incorrectCounter) + " attempts left.");
			return true;
		}
		return false;
	}

	// Checks if user tries have passed numAttemptsPassed limit.
	public void close_program() {
		if( incorrectCounter == 4 ) {
			System.out.println("There have been " + numAttemptsAllowed + " unsucessful attempts.  This session will now close.");
			System.exit(0);
		}
	}

	// SETTERS/GETTERS
	public void setMM(String month) { mm = month;  }
	public void setDD(String day) {  dd = day; }
	public void setYYYY(String year) { yyyy = year; }

	public String getMM() {	return mm; }
	public String getDD() {	return dd; }
	public String getYYYY() { return yyyy; }

}
