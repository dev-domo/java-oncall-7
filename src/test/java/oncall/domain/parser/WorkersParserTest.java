package oncall.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import oncall.domain.Worker;
import org.junit.jupiter.api.Test;

public class WorkersParserTest {
    @Test
    void 입력_텍스트에_따라_비상근무자들을_생성() {
        WorkersParser workersParser = new WorkersParser();
        assertThat(workersParser.parse("승준,나나,포비,준,레일"))
                .isEqualTo(List.of(
                                new Worker("승준"),
                                new Worker("나나"),
                                new Worker("포비"),
                                new Worker("준"),
                                new Worker("레일")
                        )
                );
    }
}
