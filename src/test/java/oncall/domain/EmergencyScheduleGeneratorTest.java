package oncall.domain;

import oncall.domain.parser.WorkersParser;
import org.junit.jupiter.api.Test;

public class EmergencyScheduleGeneratorTest {
    @Test
    void 이달의_마지막_날_구하기() {
        WorkersParser parser = new WorkersParser();
        WeekdaysWorkers weekdaysWorkers = new WeekdaysWorkers(parser.parse("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리"));
        HolidayWorkers holidayWorkers = new HolidayWorkers(parser.parse("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니"));
        EmergencyScheduleGenerator emergencyScheduleGenerator = new EmergencyScheduleGenerator(weekdaysWorkers,
                holidayWorkers);


    }
}
