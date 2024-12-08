package oncall.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MonthInformationTest {
    @DisplayName("달에 맞는 끝 날짜 반환")
    @Test
    void calculateEndDayTest() {
        int month = 12;
        assertThat(MonthInformation.calculateEndDay(month)).isEqualTo(31);
    }

    @DisplayName("달에 맞는 끝 날짜 반환 예외테스트")
    @Test
    void calculateEndDayExceptionTest() {
        int month = 13;
        assertThatThrownBy(() -> MonthInformation.calculateEndDay(month)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("휴일체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:5:true", "5:6:false"}, delimiter = ':')
    void checkHoliday(int month, int date, boolean expected){
        assertThat(MonthInformation.isHoliday(month, date)).isEqualTo(expected);
    }
}