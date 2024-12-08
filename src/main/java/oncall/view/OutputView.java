package oncall.view;

import oncall.constants.OutputMessage;
import oncall.domain.Schedule;

public class OutputView {
    public void promptForInputMonthAndDayOfWeek() {
        System.out.print(OutputMessage.INPUT_MONTH_AND_DAY.getMessage());
    }

    public void promptForInputWeekdaysWorkers() {
        System.out.print(OutputMessage.INPUT_WORKERS_BY_WEEKDAYS_TURN.getMessage());
    }

    public void promptForInputHolidayWorkers() {
        System.out.print(OutputMessage.INPUT_WORKERS_BY_HOLIDAY_TURN.getMessage());
    }

    public void showEmergencyWorkSchedule(Schedule schedule) {
        System.out.println();
        System.out.println(schedule.toString());
    }
}
