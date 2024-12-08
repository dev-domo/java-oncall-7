package oncall.domain.parser;

import java.time.LocalDate;
import oncall.constants.Days;
import oncall.constants.ExceptionMessage;
import oncall.util.IntegerUtil;
import oncall.util.StringUtil;

public class StartDayParser implements Parser {
    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;
    private static final int YEAR = 2024;

    @Override
    public LocalDate parse(String input) {
        String[] splitted = StringUtil.toArray(input);
        String day = splitted[1];

        return Days.convertToDayOfWeekValue(LocalDate.of(YEAR, findMonth(splitted[0]), 1), day);
    }

    private int findMonth(String textMonth) {
        int month = IntegerUtil.toInt(textMonth);
        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return month;
    }
}
