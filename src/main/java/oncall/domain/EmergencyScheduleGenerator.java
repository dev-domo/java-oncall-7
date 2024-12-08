package oncall.domain;

import java.time.LocalDate;
import oncall.constants.ExceptionMessage;

public class EmergencyScheduleGenerator {
    private final Workers weekdaysWorkers;
    private final Workers holidayWorkers;

    public EmergencyScheduleGenerator(Workers weekdaysWorkers, Workers holidayWorkers) {
        checkSameWorkers(weekdaysWorkers, holidayWorkers);
        this.weekdaysWorkers = weekdaysWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    private void checkSameWorkers(Workers weekdaysWorkers, Workers holidayWorkers) {
        if (weekdaysWorkers.hasSize() != holidayWorkers.hasSize()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    public Schedule generate(LocalDate startDate) {
        return null;
    }
}
