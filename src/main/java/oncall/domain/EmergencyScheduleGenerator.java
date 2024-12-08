package oncall.domain;

import java.time.LocalDate;

public class EmergencyScheduleGenerator {
    private final Workers weekdaysWorkers;
    private final Workers holidayWorkers;

    public EmergencyScheduleGenerator(Workers weekdaysWorkers, Workers holidayWorkers) {
        this.weekdaysWorkers = weekdaysWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public Schedule generate(LocalDate startDate) {
        return null;
    }
}
