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
        Workers weekdaysWorkers = getWeekdaysWorkers();
        Workers holidayWorkers = getHolidayWorkers(weekdaysWorkers);

        Schedule schedule = createEmergencyWorkSchedule(weekdaysWorkers, holidayWorkers, startDate);

        closeConsole();
        showSchedule(schedule);
    }

    private Schedule createEmergencyWorkSchedule(Workers weekdaysWorkers, Workers holidayWorkers, LocalDate startDate) {
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

    private Workers getWeekdaysWorkers() {
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

    private Workers getHolidayWorkers(Workers weekdaysWorkers) {
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

    private void showSchedule(Schedule schedule) {
        outputView.showEmergencyWorkSchedule(schedule);
    }

    private void closeConsole() {
        inputView.closeAnswer();
    }
}
