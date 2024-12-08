package oncall.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;

public class IntegerUtilTest {
    @Test
    void 문자를_정수로_변환() {
        assertThat(IntegerUtil.toInt("3")).isEqualTo(3);
    }

    @Test
    void 숫자로_바꿀_수_없는_문자면_예외() {
        assertThatThrownBy(() -> IntegerUtil.toInt("삼"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
