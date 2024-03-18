package pratice;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {

        for (int i=0; i<10; i++) {
            if (i == 2)
                continue;
            System.out.print(i);
        }
        String str = "He did a good job", resultStr = "";
        String[] strArr = str.split(" ");
        for (int i=0; i<strArr.length; i++) {
            String resWord = "";
            for (int j=strArr[i].length()-1; j>=0; j--) {
                resWord += strArr[i].charAt(j);
            }
            if (!strArr[i].equals(resWord))
                resultStr += strArr[i] + " ";
        }
        System.out.print(resultStr);
    }

    public static void TossTheCoin() {
        Random random = new Random();
        int toss = random.nextInt(2);
        if (toss == 0) {
            System.out.println("Head");
        } else {
            System.out.println("Tail");
        }
    }
    private static boolean checkTimeDifference(String givenTime, int allowedDifferenceMinutes) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date givenDate = sdf.parse(givenTime);
            Date currentUTCDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();

            int timeDifferenceMinutes = (int) ((currentUTCDate.getTime() - givenDate.getTime()) / (60 * 1000));

            return Math.abs(timeDifferenceMinutes) <= allowedDifferenceMinutes;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getCurrentUTCTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        return sdf.format(calendar.getTime());
    }

    public static String getCurrentTimeStampForZone(String timeZone, String pattern) {

        DateTime startDate = new DateTime(DateTimeZone.forID(timeZone));
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.print(startDate);
    }

    private static int differenceInMinutes(String timeString1, String timeString2, String formatOfString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formatOfString);

            Date date1 = sdf.parse(timeString1);
            Date date2 = sdf.parse(timeString2);

            long differenceMillis = date2.getTime() - date1.getTime();
            return (int) (differenceMillis / (60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
