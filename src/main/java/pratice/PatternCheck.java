package pratice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCheck {

    public static boolean checkPattern(String input, String pattern) {

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {

        String pattern = "^(Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday)\\s\\d{2}/\\d{2}/\\d{2}$";
        String input = "Thursday 02/15/24";
        boolean isMatch = checkPattern(input, pattern);

        if (isMatch) {
            System.out.println("Pattern matched!");
        } else {
            System.out.println("Pattern did not match.");
        }
    }
    static class TimeIntervalChecker {

        public static boolean isInterval(String timeStr1, String timeStr2, ChronoUnit unit, String pattern) {
            LocalDateTime dateTime1 = parseTimeString(timeStr1, pattern);
            LocalDateTime dateTime2 = parseTimeString(timeStr2, pattern);

            if (dateTime1 == null || dateTime2 == null) {
                return false; // Parsing failed
            }

            long between = unit.between(dateTime1, dateTime2);

            return between > 0;
        }

        private static LocalDateTime parseTimeString(String timeStr, String pattern) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                String[] parts = timeStr.split(" - ");
                String startTime = parts[0].substring(parts[0].indexOf(' ') + 1);
                String endTime = parts[1].substring(0, parts[1].indexOf(' '));

                LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
                LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

                // If the end time is before the start time, consider it for the next day
                if (endDateTime.isBefore(startDateTime)) {
                    endDateTime = endDateTime.plusDays(1);
                }

                return endDateTime;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
