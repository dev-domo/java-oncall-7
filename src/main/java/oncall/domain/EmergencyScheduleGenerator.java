package oncall.domain;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class EmergencyScheduleGenerator {
    private static final int WEEKDAYS_STANDARD = 6;

    private final WeekdaysWorkers weekdaysWorkers;
    private final HolidayWorkers holidayWorkers;

    public EmergencyScheduleGenerator(WeekdaysWorkers weekdaysWorkers, HolidayWorkers holidayWorkers) {
        this.weekdaysWorkers = weekdaysWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public Schedule generate(LocalDate startDate) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker(""));
        List<LocalDate> workDates = new ArrayList<>();

        decideWorkersTurn(startDate, workers, workDates);

        return new Schedule(workDates, workers.subList(1, workers.size() - 1));
    }

    private void decideWorkersTurn(LocalDate startDate, List<Worker> workers, List<LocalDate> workDates) {
        LocalDate currentDate = startDate;
        int weekdaysIndex = 0;
        int holidayIndex = 0;

        for (int day = 0; isLastDayOfMonth(startDate, currentDate); day++) {
            currentDate = calculateCurrentDate(startDate, day);
            if (calculateDayValue(currentDate) < WEEKDAYS_STANDARD) {
                addWeekdaysWorker(workers, workDates, weekdaysIndex++, currentDate);
                continue;
            }
            addHolidayWorker(workers, workDates, holidayIndex++, currentDate);
        }
    }

    private void addWeekdaysWorker(List<Worker> workers, List<LocalDate> workDates, int weekdaysIndex,
                                   LocalDate currentDate) {
        workers.add(weekdaysWorkers.findNextWorker(weekdaysIndex, workers.getLast()));
        workDates.add(currentDate);
    }

    private void addHolidayWorker(List<Worker> workers, List<LocalDate> workDates, int holidayIndex,
                                  LocalDate currentDate) {
        workers.add(holidayWorkers.findNextWorker(holidayIndex, workers.getLast()));
        workDates.add(currentDate);
    }

    private int calculateDayValue(LocalDate currentDate) {
        return currentDate.getDayOfWeek().getValue();
    }

    private boolean isLastDayOfMonth(LocalDate startDate, LocalDate currentDate) {
        return currentDate.isBefore(YearMonth.from(startDate).atEndOfMonth());
    }

    private LocalDate calculateCurrentDate(LocalDate startDate, int day) {
        return startDate.plusDays(day);
    }
}
