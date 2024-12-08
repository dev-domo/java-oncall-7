package oncall.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import oncall.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StartDayParserTest {
    @Test
    void 입력_텍스트로부터_날짜_생성() {
        StartDayParser parser = new StartDayParser();
        assertThat(parser.parse("12,수")).isEqualTo(LocalDate.of(2024, 12, 4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "13"})
    void 월로_바꿀_수_없는_문자이면_예외(String month) {
        StartDayParser parser = new StartDayParser();
        assertThatThrownBy(() -> parser.parse(month + ",수"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
