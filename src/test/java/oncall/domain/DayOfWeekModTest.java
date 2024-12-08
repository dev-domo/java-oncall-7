package oncall.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class DayOfWeekModTest {
    @DisplayName("요일에 맞는 나머지가 들어갔나 계산합니다")
    @Test
    void checkDayOfMod(){
        DayOfWeekMod dayOfWeekMod = new DayOfWeekMod("화");

        SoftAssertions.assertSoftly((softly)->{
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.월, 7);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.화, 1);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.수, 2);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.목, 3);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.금, 4);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.토, 5);
            softly.assertThat(dayOfWeekMod.getDayOfWeeks()).containsEntry(DayOfWeek.일, 6);
        });
    }

    @DisplayName("나머지에 맞는 요일 계산")
    @Test
    void calculateModValues(){
        DayOfWeekMod dayOfWeekMod = new DayOfWeekMod("화");
        assertThat(dayOfWeekMod.calculateModValues(2)).isEqualTo(DayOfWeek.수);
    }

    @DisplayName("쉬는날인지 계산")
    @ParameterizedTest
    @CsvSource(value = {"5:5:2:true", "5:10:5:true", "5:10:4:false"}, delimiter = ':')
    void isHolidayTest(int month, int day, int mod, boolean expected){
        DayOfWeekMod dayOfWeekMod = new DayOfWeekMod("화");

        assertThat(dayOfWeekMod.isHoliday(month, dayOfWeekMod, day, mod)).isEqualTo(expected);
    }
}