package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class PublicHolidaysTest {
    @Test
    void 공휴일이면서_평일인지_판단() {
        assertThat(PublicHolidays.isDayOff(LocalDate.of(2024, 1, 1))).isTrue();
        assertThat(PublicHolidays.isDayOff(LocalDate.of(2024, 5, 5))).isFalse();
    }
}
