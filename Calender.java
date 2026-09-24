import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

class CalendarTool {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        YearMonth yearMonth = YearMonth.of(year, month);

        System.out.println("\n      " + yearMonth.getMonth() + " " + year);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        // Get the first day of the month
        LocalDate firstDay = yearMonth.atDay(1);

        // Get the day of week
        int startDay = firstDay.getDayOfWeek().getValue();

        // Print spaces before the first date
        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print all dates
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {

            System.out.printf("%3d ", day);

            // Move to next line after Sunday
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
        sc.close();
    }
}
