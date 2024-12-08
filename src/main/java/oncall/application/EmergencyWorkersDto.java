package oncall.application;

import java.util.List;

public class EmergencyWorkersDto {
    private final List<String> weekdaysWorkers;
    private final List<String> weekendWorkers;

    public EmergencyWorkersDto(List<String> weekdaysWorkers, List<String> weekendWorkers) {
        this.weekdaysWorkers = weekdaysWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public List<String> getWeekdaysWorkers() {
        return weekdaysWorkers;
    }

    public List<String> getWeekendWorkers() {
        return weekendWorkers;
    }
}
