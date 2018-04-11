// The Zodiac class is responsible for converting its inputs into an appropriate Zodiac sign.
// Inputs can be any two integer numbers; however, only valid calendar month/day combinations
// will ouput a Zodiac sign.

public class Zodiac {

	private static int m;	// m is month.
	private static int d;	// d is day.
	private static String sign; // sign is Zodiac sign.

	// *******************       Constructor(String month, String day) {}     *************************

	public Zodiac(String month, String day) {
		sign = null;
		m = Integer.parseInt(month);
		d = Integer.parseInt(day);
	}

	// *******************       Setter/Getter Section     *************************

	public void setMonth(int month) {
		m = month;
	}

	public void setDay(int day) {
		d = day;
	}

	public int getMonth() {
		return m;
	}

	public int getDay() {
		return d;
	}

	public String getSign() {
		return sign;
	}

	// *******************       Convert() { returns sign }     *************************

	// Purpose: Ensure the given month is valid by accepting only 1-12, all else is sent to default as
	// 	invalid month entries.  The sign is determined by ensuring that the given day falls within a range
	// 	of days in the given month.  If the given month does not contain the given day, an invalid day
	// 	message is given.
	// 	Both the invalid day and month messages are unnecessary.  They were only used during development
	// 	to help catch any invalid date combinations while testing.

	public static String Convert() {

		switch( m ) {
		case 1:
			if( d >= 1 && d <= 19) {
				sign = "Your zodiac sign is Capricorn.";
			}
			else if( d >= 20 && d <= 31 ) {
				sign = "Your zodiac sign is Aquarius.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 2:
			if( d >= 1 && d <= 18 ) {
				sign = "Your zodiac sign is Aquarius.";
			}
			else if( d >= 19 && d <= 29 ) {
				sign = "Your zodiac sign is Pisces.";
			} else {
				sign = "Inavlid day.";
			}
			break;
		case 3:
			if( d >= 1 && d <= 20 ) {
				sign = "Your zodiac sign is Pisces.";
			}
			else if( d >= 21 && d <= 31 ) {
				sign = "Your zodiac sign is Aries.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 4:
			if( d >= 01 && d <= 19 ) {
				sign = "Your zodiac sign is Aries.";
			}
			else if( d > 19 && d <= 30 ) {
				sign = "Your zodiac sign is Taurus.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 5:
			if( d > 0 && d <= 20 ) {
				sign = "Your zodiac sign is Taurus.";
			}
			else if( d >= 21 && d <= 31 ) {
				sign = "Your zodiac sign is Gemini.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 6:
			if( d > 0 && d <= 20 ) {
				sign = "Your zodiac sign is Gemini.";
			}
			else if( d >= 21 && d <= 30 ) {
				sign = "Your zodiac sign is Cancer.";
			} else {
				sign = "Inavlid day.";
			}
			break;
		case 7:
			if( d > 0 && d <= 22 ) {
				sign = "Your zodiac sign is Cancer.";
			}
			else if( d >= 23 && d <= 31 ) {
				sign = "Your zodiac sign is Leo.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 8:
			if( d > 0 && d <= 22 ) {
				sign = "Your zodiac sign is Leo.";
			}
			else if( d >= 23 && d <= 31 ) {
				sign = "Your zodiac sign is Virgo.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 9:
			if( d > 0 && d <= 22 ) {
				sign = "Your zodiac sign is Virgo.";
			}
			else if( d >= 23 && d <= 30 ) {
				sign = "Your zodiac sign is Libra.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 10:
			if( d > 0 && d <= 22 ) {
				sign = "Your zodiac sign is Libra.";
			}
			else if( d >= 23 && d <= 31 ) {
				sign = "Your zodiac sign is Scorpio.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 11:
			if( d > 0 && d <= 21 ) {
				sign = "Your zodiac sign is Scorpio.";
			}
			else if( d >= 22 && d <= 30 ) {
				sign = "Your zodiac sign is Sagittarius.";
			} else {
				sign = "Invalid day.";
			}
			break;
		case 12:
			if( d > 0 && d <= 21 ) {
				sign = "Your zodiac sign is Sagittarius.";
			}
			else if( d >= 22 && d <= 31 ) {
				sign = "Your zodiac sign is Capricorn.";
			} else {
				sign = "Invalid day.";
			}
			break;
		default:
			sign = "Invalid month.";  // Months less than 1 or greater than 12 are invalid entries.
		}
		return sign;
	}

	// *******************       Convert() { returns sign }     *************************

	// Purpose: Output the sign.

	public void PrintSign() {
		System.out.println(sign);
	}
}
