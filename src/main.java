import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args) throws ParseException {
        /*Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, -1); // 이전 달

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        System.out.println(formatter.format(cal.getTime()));*/

        int a = 5;
        int b = 7;

        System.out.println(Math.round(a/(float)b));
    }
}
