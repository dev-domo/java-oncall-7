package oncall.util;

import oncall.constants.ExceptionMessage;

public class IntegerUtil {
    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}
