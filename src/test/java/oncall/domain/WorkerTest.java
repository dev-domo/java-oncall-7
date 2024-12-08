package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;

public class WorkerTest {
    @Test
    void 비상근무자_이름은_5자_이하여야_한다() {
        assertThat(new Worker("abcde")).isEqualTo(new Worker("abcde"));
    }

    @Test
    void 비상근무자_이름이_5자_초과_시_예외() {
        assertThatThrownBy(() -> new Worker("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
