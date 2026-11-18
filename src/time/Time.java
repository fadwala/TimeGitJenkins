package time;

public class Time
{
	public static void main(String[] args) 
	{
		int totalSeconds = getTotalSeconds("10:10:10");
		System.out.println("Github Seconds = " + totalSeconds);
	}

	public static int getTotalSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		int hours = getTotalHours(time);
		int minutes = getTotalMinutes(time);
		int seconds = getSeconds(time);
		return hours * 3600 + minutes * 60 + seconds;
	}
	
	public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{
		return Integer.parseInt(time.substring(6,8));
	}

	public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length() > 8)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(3,5));
	}

	public static int getTotalHours(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		return Integer.parseInt(time.substring(0,2));
	}
	
	public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		if (time.length() > 11)
		{
			throw new NumberFormatException("your time was too long!");
		}
		return Integer.parseInt(time.substring(9,11));
	}

	public static int getAllMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
		int hours = getTotalHours(time);
		int minutes = Integer.parseInt(time.substring(3,5));
		int seconds = getSeconds(time);
		int ms = getMilliseconds(time);
		return hours * 3600000 + minutes * 60000 + seconds * 1000 + ms;
	}
}