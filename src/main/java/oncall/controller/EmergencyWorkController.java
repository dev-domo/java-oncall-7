package oncall.controller;

import java.time.LocalDate;
import oncall.domain.EmergencyScheduleGenerator;
import oncall.domain.HolidayWorkers;
import oncall.domain.Schedule;
import oncall.domain.WeekdaysWorkers;
import oncall.domain.Workers;
import oncall.domain.parser.StartDayParser;
import oncall.domain.parser.WorkersParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class EmergencyWorkController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StartDayParser startDayParser;
    private final WorkersParser workersParser;

    public EmergencyWorkController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.startDayParser = new StartDayParser();
        this.workersParser = new WorkersParser();
    }

    public void start() {
        LocalDate startDate = getEmergencyWorkStartDate();
        WeekdaysWorkers weekdaysWorkers = getWeekdaysWorkers();
        HolidayWorkers holidayWorkers = getHolidayWorkers(weekdaysWorkers);
        closeConsole();

        Schedule schedule = createEmergencyWorkSchedule(weekdaysWorkers, holidayWorkers, startDate);
        showSchedule(schedule);
    }

    private Schedule createEmergencyWorkSchedule(WeekdaysWorkers weekdaysWorkers, HolidayWorkers holidayWorkers,
                                                 LocalDate startDate) {
        EmergencyScheduleGenerator emergencyScheduleGenerator = new EmergencyScheduleGenerator(weekdaysWorkers,
                holidayWorkers);
        return emergencyScheduleGenerator.generate(startDate);
    }

    private LocalDate getEmergencyWorkStartDate() {
        while (true) {
            try {
                outputView.promptForInputMonthAndDayOfWeek();
                String monthAndDayOfWeek = inputView.answer();
                return startDayParser.parse(monthAndDayOfWeek);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private WeekdaysWorkers getWeekdaysWorkers() {
        while (true) {
            try {
                outputView.promptForInputWeekdaysWorkers();
                String weekdaysWorkerNames = inputView.answer();
                return new WeekdaysWorkers(workersParser.parse(weekdaysWorkerNames));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private HolidayWorkers getHolidayWorkers(Workers weekdaysWorkers) {
        while (true) {
            try {
                outputView.promptForInputHolidayWorkers();
                String holidayWorkerNames = inputView.answer();
                weekdaysWorkers.validate(workersParser.parse(holidayWorkerNames));
                return new HolidayWorkers(workersParser.parse(holidayWorkerNames));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void closeConsole() {
        inputView.closeAnswer();
    }

    private void showSchedule(Schedule schedule) {
        outputView.showEmergencyWorkSchedule(schedule);
    }
}
