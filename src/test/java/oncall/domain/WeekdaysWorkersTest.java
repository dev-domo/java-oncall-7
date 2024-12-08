package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import oncall.constants.ExceptionMessage;
import oncall.domain.parser.WorkersParser;
import org.junit.jupiter.api.Test;

public class WeekdaysWorkersTest {
    @Test
    void 평일근무자와_휴일근무자_수는_같아야_한다() {
        WorkersParser parser = new WorkersParser();
        WeekdaysWorkers weekdaysWorkers = new WeekdaysWorkers(parser.parse("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리"));
        List<Worker> holidayWorkers = parser.parse("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥");

        assertThatThrownBy(() -> weekdaysWorkers.validate(holidayWorkers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}