package oncall.domain.parser;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Worker;
import oncall.util.StringUtil;

public class WorkersParser implements Parser {

    @Override
    public List<Worker> parse(String names) {
        return Arrays.stream(StringUtil.toArray(names))
                .map(Worker::new)
                .toList();
    }
}
