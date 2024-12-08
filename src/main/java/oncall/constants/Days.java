package oncall.constants;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public enum Days {
    MONDAY("월", 1),
    TUESDAY("화", 2),
    WEDNESDAY("수", 3),
    THURSDAY("목", 4),
    FRIDAY("금", 5),
    SATURDAY("토", 6),
    SUNDAY("일", 7);

    private final String text;
    private final int number;

    Days(final String text, final int number) {
        this.text = text;
        this.number = number;
    }

    public static LocalDate convertToDayOfWeekValue(LocalDate startDate, String input) {
        for (int i = 0; i < 7; i++) {
            LocalDate newDate = startDate.plusDays(i);
            if (newDate.getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREAN).equals(input)) {
                return newDate;
            }
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
    }
}
