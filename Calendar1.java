import javax.swing.*;
import java.awt.*;
import java.time.YearMonth;
import java.time.LocalDate;

public class Calendar1 extends JFrame {

    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;
    private JTextArea calendarArea;

    public Calendar1() {

        setTitle("Java Calendar");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();

        monthBox = new JComboBox<>(new String[]{
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        });

        yearBox = new JComboBox<>();

        for (int year = 1970; year <= 2050; year++) {
            yearBox.addItem(year);
        }

        JButton showButton = new JButton("Show Calendar");

        topPanel.add(new JLabel("Month:"));
        topPanel.add(monthBox);

        topPanel.add(new JLabel("Year:"));
        topPanel.add(yearBox);

        topPanel.add(showButton);

        add(topPanel, BorderLayout.NORTH);

        // Calendar display area
        calendarArea = new JTextArea();
        calendarArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        calendarArea.setEditable(false);

        add(new JScrollPane(calendarArea), BorderLayout.CENTER);

        // Button action
        showButton.addActionListener(e -> showCalendar());

        // Set current month and year
        LocalDate today = LocalDate.now();
        monthBox.setSelectedIndex(today.getMonthValue() - 1);
        yearBox.setSelectedItem(today.getYear());

        showCalendar();
    }

    private void showCalendar() {

        int month = monthBox.getSelectedIndex() + 1;
        int year = (int) yearBox.getSelectedItem();

        YearMonth yearMonth = YearMonth.of(year, month);

        StringBuilder calendar = new StringBuilder();

        calendar.append("\n        ")
                .append(yearMonth.getMonth())
                .append(" ")
                .append(year)
                .append("\n\n");

        calendar.append("Mon Tue Wed Thu Fri Sat Sun\n");

        LocalDate firstDay = yearMonth.atDay(1);

        int startDay = firstDay.getDayOfWeek().getValue();

        // Add spaces before first date
        for (int i = 1; i < startDay; i++) {
            calendar.append("    ");
        }

        // Print dates
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {

            calendar.append(String.format("%3d ", day));

            if ((day + startDay - 1) % 7 == 0) {
                calendar.append("\n");
            }
        }

        calendarArea.setText(calendar.toString());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Calendar1 calendar = new Calendar1 ();
            calendar.setVisible(true);
        });
    }
}