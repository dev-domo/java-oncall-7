package oncall.domain;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Schedule {
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
        for (LocalDate date : workDates) {
            dateInformation.add(date.getMonthValue() + "월 " + date.getDayOfWeek() + "일 " + date.getDayOfWeek()
                    .getDisplayName(TextStyle.NARROW, Locale.KOREAN) + checkDayOff(date));
        }

        for (int i = 0; i < workers.size(); i++) {
            table.add(dateInformation.get(i) + workers.get(i).getName());
        }
        return String.join("\n", table);
    }

    private String checkDayOff(LocalDate date) {
        if (PublicHolidays.isDayOff(date)) {
            return "(휴일) ";
        }
        return " ";
    }
}
