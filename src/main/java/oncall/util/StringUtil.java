package oncall.util;

import oncall.constants.ExceptionMessage;

public class StringUtil {
    private static final String MONTH_AND_DAY_INPUT_REGEX = "([가-힣]+)(,[0-9]+)*";
    private static final String WORKERS_INPUT_REGEX = "([가-힣]+)(,[가-힣]+)*";
    private static final String SEPARATOR = ",";

    public static String[] toArray(String input) {
        checkValidInput(input);
        return input.split(SEPARATOR);
    }

    private static void checkValidInput(String input) {
        if (!input.matches(MONTH_AND_DAY_INPUT_REGEX) && !input.matches(WORKERS_INPUT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}
