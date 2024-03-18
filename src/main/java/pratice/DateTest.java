package pratice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {

        Year currentYear = Year.now();
        int yearValue = currentYear.getValue();
        String str = "Thu, Feb 29 " + yearValue + " 8:00 PM";
        System.out.println(str);
        String format = "EEE, MMM d yyyy hh:mm a";
//        String str = "Thu, Feb 29 2024 03:41 PM";
//        String format = "EEE, MMM d yyyy hh:mm a";

        try {
            // Parse the input string to a Date object
            SimpleDateFormat inputFormat = new SimpleDateFormat(format);
            Date date = inputFormat.parse(str);

            // Format the Date object to the desired output format
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = outputFormat.format(date);

            System.out.println("Converted Date: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean areDatesWithinFiveMinutes(String dateStr1, String dateStr2, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        Date date1 = dateFormat.parse(dateStr1);
        Date date2 = dateFormat.parse(dateStr2);

        long differenceInMillis = Math.abs(date1.getTime() - date2.getTime());

        // 5 minutes in milliseconds
        long fiveMinutesInMillis = 5 * 60 * 1000;

        return differenceInMillis <= fiveMinutesInMillis;
    }
}
