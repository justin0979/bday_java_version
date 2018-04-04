import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		MyUser u = new MyUser();
		u.Prompt();	

		DayOWeek day = new DayOWeek(u.getMM(), u.getDD(), u.getYYYY());
		day.Calculate();
		day.output();		

		Zodiac z = new Zodiac(u.getMM(), u.getDD());
		System.out.println(z.Convert());
	}
}
