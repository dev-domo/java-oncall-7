package oncall.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class StartDayParserTest {
    @Test
    void 입력_텍스트로부터_날짜_생성() {
        StartDayParser parser = new StartDayParser();
        assertThat(parser.parse("12,수")).isEqualTo(LocalDate.of(2024, 12, 4));
    }
}
