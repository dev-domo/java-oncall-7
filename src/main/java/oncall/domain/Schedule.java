package oncall.domain;

import static oncall.constants.KoreanDate.DAY;
import static oncall.constants.KoreanDate.DAY_OFF;
import static oncall.constants.KoreanDate.MONTH;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Schedule {
    private static final String SPACE = " ";
    private static final String LINE_SEPARATOR = "\n";

    private final List<LocalDate> workDates;
    private final List<Worker> workers;

    public Schedule(List<LocalDate> workDates, List<Worker> workers) {
        this.workDates = workDates;
        this.workers = workers;
    }

    @Override
    public String toString() {
        List<String> table = new ArrayList<>();
        List<String> dateInformation = new ArrayList<>();

        addDateInformation(dateInformation);
        addScheduleTable(table, dateInformation);
        return String.join(LINE_SEPARATOR, table);
    }

    private void addDateInformation(List<String> dateInformation) {
        for (LocalDate date : workDates) {
            dateInformation.add(date.getMonthValue() + MONTH.getMessage() + date.getDayOfMonth() + DAY.getMessage()
                    + date.getDayOfWeek()
                    .getDisplayName(TextStyle.NARROW, Locale.KOREAN) + checkDayOff(date));
        }
    }

    private void addScheduleTable(List<String> table, List<String> dateInformation) {
        for (int i = 0; i < workers.size(); i++) {
            table.add(dateInformation.get(i) + workers.get(i).getName());
        }
    }

    private String checkDayOff(LocalDate date) {
        if (PublicHolidays.isDayOff(date)) {
            return DAY_OFF.getMessage();
        }
        return SPACE;
    }
}
