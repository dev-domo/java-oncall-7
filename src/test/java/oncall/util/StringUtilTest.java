package oncall.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilTest {
    @Test
    void 월_시작요일_입력을_쉼표_기준으로_분할() {
        assertThat(StringUtil.toArray("5,월")).containsExactly("5", "월");
    }

    @Test
    void 근무자_입력을_쉼표_기준으로_분할() {
        assertThat(StringUtil.toArray("승준,포비")).containsExactly("승준", "포비");
    }

    @ParameterizedTest
    @ValueSource(strings = {"월:5", "승준,,포비"})
    void 쉼표_기준으로_분할되지_않으면_예외(String input) {
        assertThatThrownBy(() -> StringUtil.toArray(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
