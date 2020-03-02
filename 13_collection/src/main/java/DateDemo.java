import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateDemo {
    public static void main(String[] args) {
        // < 7
        // java.date
        // >= 8
        // java.time

        System.out.println(System.currentTimeMillis());
        {
            Date date = new Date();
            System.out.println(date);
            System.out.println(date.getTime());
        }
        {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

            calendar.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        }

    }
}
