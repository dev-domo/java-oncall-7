package oncall.domain.parser;

import java.time.LocalDate;
import oncall.constants.Days;
import oncall.util.IntegerUtil;
import oncall.util.StringUtil;

public class StartDayParser implements Parser {
    private static final int MONTH_PLACE = 0;
    private static final int DAY_PLACE = 1;
    private static final int YEAR = 2024;

    @Override
    public LocalDate parse(String input) {
        String[] splitted = StringUtil.toArray(input);
        int month = IntegerUtil.toInt(splitted[MONTH_PLACE]);
        String day = splitted[DAY_PLACE];

        return Days.convertToDayOfWeekValue(LocalDate.of(YEAR, month, 1), day);
    }
}
