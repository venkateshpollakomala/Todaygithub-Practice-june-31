package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class utilities {
	public static String generateEmailTimeStamp() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateFormat.format(date).replace(" ", "_").replace(":", "_");
		return "deepu_" + timestamp + "@gmail.com";
	}

}
