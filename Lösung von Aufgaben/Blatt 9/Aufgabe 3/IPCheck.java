import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPCheck {

	public static boolean check(String ip) {
    	String regex = "^(172)" +
                   "(\\.(1[6-9]|2[0-9]|3[0-1]))" +
                   "(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]))" +
                   "(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]))$";
    	Pattern p = Pattern.compile(regex);
    	Matcher m = p.matcher(ip);

		return m.matches();
	}
}
